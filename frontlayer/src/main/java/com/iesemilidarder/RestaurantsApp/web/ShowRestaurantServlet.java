package com.iesemilidarder.RestaurantsApp.web;

import com.iesemilidarder.RestaurantsApp.core.LlegirBD;
import com.iesemilidarder.RestaurantsApp.core.Restaurant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowRestaurantServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Nova instància de la classe LlegirBD per poder agafar el paràmetre de la sessió i definir l'atribut
        LlegirBD bd = new LlegirBD();
        String id = request.getParameter("id");
        Restaurant res = bd.mostrarResInfo(id);
        request.setAttribute("res", res);
        request.getRequestDispatcher("mostrarRestaurants").forward(request, response);
    }
}


