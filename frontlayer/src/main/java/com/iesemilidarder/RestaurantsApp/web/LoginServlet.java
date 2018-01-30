package com.iesemilidarder.RestaurantsApp.web;

import com.iesemilidarder.RestaurantsApp.core.Usuaris;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginServlet extends HttpServlet {

    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    private boolean usuari_valid(String usuari, String password) {

        boolean resultat = false;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();
            ResultSet rs;
            Usuaris usu = new Usuaris();
            rs = stmt.executeQuery("SELECT * FROM USUARIS WHERE USU_NOM ='" + usuari + "'");
            if (rs.next()) {

                usu.setNom(rs.getString("USU_NOM"));
                usu.setPassword(rs.getString("USU_PASSWORD"));
                usu.setCodi(rs.getString("USU_CODI"));

                String usuloc = usu.getNom();
                String usupass = usu.getPassword();
                stmt.close(); //tancam connexions
                con.close();

                if (usuari.equals(usuloc)&& usupass.equals(sha256(password))) {
                    resultat = true;
                } else {
                    System.out.println("Usuari no existeix");
                }
            }
        } catch (Exception e) {
            System.out.println((e.toString()));
        }
        return resultat;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("usuari");
        String pass = request.getParameter("psw");
        HttpSession session = request.getSession();
        session.setAttribute("usuari", "");

        if (usuari_valid(nom, pass)) {
            System.out.println("Correcte");

        } else {
            System.out.println("Error");
        }


       /* String pass = request.getParameter("psw");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        RequestDispatcher rd = null;
        request.setAttribute(nom, "usuari");

        if (nom.equals("usuari") && pass.equals(sha256("psw"))) {
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else {
            out.println("<b>Invalid Login Info.</b><br>");
            rd = request.getRequestDispatcher("/loginPage.html");
            rd.include(request, response);
        }
        out.close();
*/

    }


}

