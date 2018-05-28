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

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuaris usercom = (Usuaris) request.getSession().getAttribute("usuari");
        String comentari = request.getParameter("comment");
        String id = request.getParameter("id");
        String num = request.getParameter("score");


        LlegirBD.add_comment(usercom.getCodi(), comentari, num, id);
        request.setAttribute("comment", comentari);
        request.getRequestDispatcher("servlet").forward(request, response);
    }

}

