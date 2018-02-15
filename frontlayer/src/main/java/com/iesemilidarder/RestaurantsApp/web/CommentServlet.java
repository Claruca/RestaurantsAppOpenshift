package com.iesemilidarder.RestaurantsApp.web;

import com.iesemilidarder.RestaurantsApp.core.LlegirBD;
import com.iesemilidarder.RestaurantsApp.core.Usuaris;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//      String name = request.getParameter();
//      Usuaris usercom = new Usuaris();

        Usuaris usercom = (Usuaris) request.getSession().getAttribute("usuari");

        String comentari = request.getParameter("comment");
        String id = request.getParameter("id");
        String num = request.getParameter("score");


        LlegirBD.add_comment(usercom.getCodi(), comentari, num, id);
        request.setAttribute("comment", comentari);
        request.getRequestDispatcher("MostrarRestaurants").forward(request, response);
    }

}


//    Otro metodo static void insertarcomentari(String usuari, String comentari)

//    String query = Insert bla bla
////    try, catch
//    un altre preparemet statement
//            executeUpdate(query)