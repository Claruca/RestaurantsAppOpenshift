package com.iesemilidarder.RestaurantsApp.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
        //  String surname = request.getParameter("surname");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer a = (Integer) request.getSession().getAttribute("pepito");

        if (a == null) {

            a = 1;
        } else {
            a += 1;
        }
        request.getSession().setAttribute("pepito", a);

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>Test Servleeeeeeet</h1>");
        //out.println("<h1>Hello "+request.getParameter("nom")+"</h1>");
        out.println("<h1>" + a + "</h1>");








/*
 // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Test Servleeeeeeet</h1>");




        if (request.getSession().getAttribute("user") != null) {

            ArrayList Restaurant = new ArrayList();
            Restaurant.add(new Restaurant());
            request.setAttribute("restaurants", Restaurant);
            request.getDispatcher("mostrar.jsp").forward(request, response)
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

 */

// Exemple de sessió amb un objecte String



    }
}
