<%@ page import="com.iesemilidarder.RestaurantsApp.core.Restaurant " %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.Opinions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@include file="header.jsp" %>

<body class="fonsPrincipal">
<div class="container">
<%
    Restaurant res = (Restaurant) request.getAttribute("res");

    if (res != null) {
        out.println("<div class=\"row\">" +
                "<div class=\"container\"><div class =\"col-md-6\">" + "<img class=\"img-fluid rounded\" src=\" " + res.getImatge() + "\">" + "</div>" +
                "<div class=\"col-md-6 mt-3\">" +
                "<h3>" + res.getNom() + "</h3>" +
                "<p>" + res.getCodi() + "</p>" +
                "<p>" + res.getAdressa() + "</p>" +
                "<p>" + res.getLlocweb() + "</p>" +
                "<p>" + res.getTelefon() + "</p>" +
                "<p>" + res.getTipus() + "</p>" +
                "<h5>" + "Nota: " + "</h5>" + "<p>" + res.getMitjana() + "</p>" +
                "<p>" + res.getLatitud() + "</p>" +
                "<p>" + res.getLongitud() + "</p>" +
                "</div >" + "</div>" + "</div>");

//        out.println("<h3 class=\"espai\">" + "Opinons restaurants:  " + "</h3>");


        out.println("<div class=\"taula\">" + "<h3 class=\"espai\">" + "Opinons restaurants:  " + "</h3>"
                + "<table class=\"table table-striped table-sm\" mr-auto>" +
                "<thead>" +
                "<tr class=\"table-success\">" +
                "        <th scope=\"col\">Codi observació </th>\n" +
                "        <th scope=\"col\">Observació </th>\n" +
                "        <th scope=\"col\">Puntuació </th>\n" +
                "        <th scope=\"col\">Opinió revisada </th>\n" +
                "</tr>" +
                "<tbody class=\"fonstaula\">\n");

        //Treim les opinions de l'array amb un foreach
        for (Opinions opin : res.getOpinions()) {
            out.println(
                    "<tr>" +
                            "       <td>" + opin.getOpicodi() + "</td>" +
                            "        <td>" + opin.getObservacio() + "</td>" +
                            "        <td>" + opin.getPuntuacio() + "</td>" +
                            "        <td>" + opin.getOpirevisada() + "</td>" +
                            "</tr>"
            );
        }


        out.println("</tbody>" + "</table>" + "</div>");

    }
%>
<%

    if (session.getAttribute("usuari") != null) {

        out.println("<div class=\"form-group\">\n" +
                "    <h3>Afegeix un comentari</h3>\n" +
                "    <form action=\"commentservlet\" method=\"post\">\n" +
                "        <textarea class=\"form-control\" type=\"text\" placeholder=\"Comentari\" name=\"comment\"/></textarea></br>\n" +
                "        <select class=\"form-control\" type=\"text\" placeholder=\"puntuacio\" name=\"score\"/>" +
                "      <option>1</option>\n" +
                "      <option>2</option>\n" +
                "      <option>3</option>\n" +
                "      <option>4</option>\n" +
                "      <option>5</option>" +
                "      <option>6</option>\n" +
                "      <option>7</option>\n" +
                "      <option>8</option>\n" +
                "      <option>9</option>\n" +
                "      <option>10</option>\n" +
                "       </select><br/>\n" +
                "        <input type=\"hidden\" name=\"id\" value=" + res.getCodi() + "><br/>" +
                "        <button type=\"submit\" class=\"btn btn-success\" value=\"Comment\">Afegeix un comentari</button>\n" +
                "    </form>\n" +
                "</div>");
    }
%>
</div>


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
