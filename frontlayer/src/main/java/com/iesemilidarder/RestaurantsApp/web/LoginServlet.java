package com.iesemilidarder.RestaurantsApp.web;

import com.iesemilidarder.RestaurantsApp.core.Usuaris;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.String;


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


    private Usuaris usuari_valid(String usuari, String password) throws Exception {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@35.180.32.114:1521:XE", "usuari", "usuari");


            Statement stmt = con.createStatement();
            ResultSet rs;


            rs = stmt.executeQuery("SELECT * FROM USUARIS WHERE USU_CODI ='" + usuari + "'");

            if (rs.next()) {
                Usuaris usu = new Usuaris();
                usu.setCodi(rs.getString("USU_CODI"));
                usu.setNom(rs.getString("USU_NOM"));
                usu.setPassword(rs.getString("USU_PASSWORD"));
                usu.setEmail(rs.getString("USU_ADRECA_ELECTRONICA"));

//              String usuloc = usu.getNom();
                String usupass = usu.getPassword();

                stmt.close(); //tancam connexions
                con.close();

                if (usupass.equals(sha256(password))) {
                    return usu;

                } else {
                    throw new Exception("password ko");
                }
            } else {
                throw new Exception("No trobat");
            }

        } catch (Exception e) {
            throw e;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("usuari");
        String pass = request.getParameter("psw");

        try {
            Usuaris user = usuari_valid(name, pass);

            if (user != null) {
                request.getSession().setAttribute("usuari", user);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}