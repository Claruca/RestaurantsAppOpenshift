<%@ page import="com.iesemilidarder.RestaurantsApp.core.Restaurant " %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.Opinions" %>
<%@ page import="static java.awt.SystemColor.text" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="Header.jsp" %>
<%

    Restaurant res = (Restaurant) request.getAttribute("res");

    if (res != null) {
        out.println("<div class=\"row\">" +
                " <div class =\"col-md-4\">" + "<img class=\"img-fluid rounded\" src=\" " + res.getImatge() + "\">" + "</div>" +
                "<div class=\"col-md-8\">" +
                "<h3>" + res.getNom() + "</h3>" +
                "<p>" + res.getCodi() + "</p>" +
                "<p>" + res.getAdressa() + "</p>" +
                "<p>" + res.getLlocweb() + "</p>" +
                "<p>" + res.getTelefon() + "</p>" +
                "<p>" + res.getTipus() + "</p>" +
                "<h5>" + "Nota: " + "</h5>" + "<p>" + res.getMitjana() + "</p>" +
                "<p>" + res.getLatitud() + "</p>" +
                "<p>" + res.getLongitud() + "</p>" +
                "</div >" + "<div>");


        out.println("<h3 class=\"espai\">" + "Opinons restaurants:  " + "</h3>");


//Treim les opinions de l'array amb un foreach

        for (Opinions opin : res.getOpinions()) {
            out.println("<div class =\"opis\">" + "<h5>" + "Codi observació: " + "</h5>" + "<p>" + opin.getOpicodi() + "</p>" +
                    "<h5>" + "Observació: " + "</h5>" + "<p>" + opin.getObservacio() + "</p>" +
                    "<h5>" + "Puntuació: " + "</h5>" + "<p>" + opin.getPuntuacio() + "</p>" +
                    "<h5>" + "Opinió revisada: " + "</h5>" + "<p>" + opin.getOpirevisada() + "</p>" + "</div>"
            );
        }

    }
%>
<%
    Restaurant resta = (Restaurant) request.getAttribute("res");
    if (session.getAttribute("usuari") != null) {

        out.println("<div class=\"form-group\">\n" +
                "    <h3>Afegeix un comentari</h3>\n" +
                "    <form action=\"commentservlet\" method=\"post\">\n" +
                "        <input class=\"form-control\" type=\"text\" placeholder=\"Comentari\" name=\"comment\"/><br/>\n" +
                "        <input class=\"form-control\" type=\"text\" placeholder=\"puntuacio\" name=\"score\"/><br/><br/>\n" +
//                "        <input type=\"hidden\" name=\"id\" value="+resta.getCodi()+"><br/>" +
                "        <button type=\"submit\" class=\"btn btn-success\" value=\"Comment\">Afegeix un comentari</button>\n" +
                "    </form>\n" +
                "</div>");
    }
%>

<div class="pagination">
    <ul class="pagination pagination-lg">
        <li class="page-item disabled">
            <a class="page-link" href="#">&laquo;</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="/servlet?id=1">1</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="/servlet?id=2">2</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="/servlet?id=3">3</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="/servlet?id=4">4</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="/servlet?id=5">5</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">&raquo;</a>
        </li>
    </ul>
</div>

</body>
</html>
