package com.iesemilidarder.RestaurantsApp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class showRestaurantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
        //  String surname = request.getParameter("surname");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String a = (String)request.getSession().getAttribute("hola");
       if (a==null){
           a = "inicio sesion";
       }
       else{
           a += " Otro ";
       }

        request.getSession().setAttribute("hola", a);

        //response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("Hello World"+ a);


    }

}