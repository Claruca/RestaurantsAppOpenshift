package com.iesemilidarder.RestaurantsApp.web;

import com.iesemilidarder.RestaurantsApp.core.LlegirBD;
import com.iesemilidarder.RestaurantsApp.core.Restaurant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ShowRestaurantServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LlegirBD bd = new LlegirBD();
        //Nova instància de la classe LlegirBD per poder agafar el paràmetre de la sessió i definir l'atribut

        String id = request.getParameter("id");
        Restaurant res = bd.MostrarResInfo(id);
        request.setAttribute("res", res);
        request.getRequestDispatcher("MostrarRestaurants").forward(request, response);
    }
}
