package com.iesemilidarder.restaurants.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class showRestaurantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
        //  String surname = request.getParameter("surname");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LlegirBD bd = new LlegirBD();

        String id = request.getParameter("id");
        Restaurant res = bd.MostrarResInfo(id);
        request.setAttribute("res", res);
        request.getRequestDispatcher("MostrarRestaurants").forward(request, response);

        //  PrintWriter out = response.getWriter();
        //out.println("<h1>Test Servleeeeeeet</h1>");


    }
}

/*Request.getparameter("id)
* Restaurant rest=llegirDb.Mostrarres(id)
* ArrayList opinions=llegirdb.mostraropi(id)
* request.setatribute("restaurant", rest);
* request.setAtribute ("opi", opinions);
* request.getDispacher("OTRO.jsp").forward(request,response)
*
*
*/
