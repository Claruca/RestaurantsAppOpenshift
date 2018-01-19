<%@ page import="com.iesemilidarder.restaurants.web.Restaurant" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iesemilidarder.restaurants.web.Opinions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mes Info Restaurants</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap CSS -->
    <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.css" media="screen">
    <link rel="stylesheet" href="https://bootswatch.com/_assets/css/custom.min.css">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<h1>Més informació sobre els restaurants:</h1>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="index.jsp">Restaurants</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse" id="navbarsExampleDefault">

        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Inici <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Enllaç 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Enllaç 2</a>
            </li>
        </ul>
    </div>
</nav>
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

        out.println("<h2>" + "Opinons restaurants " + "</h2>");

        for (Opinions opin : res.getOpinions()) {
            out.println("<div>" + "<p>" + opin.getOpicodi() + "</p>" +
                    "<h5>" + "Observació: " + "</h5>" + "<p>" + opin.getObservacio() + "</p>" +
                    "<p>" + opin.getPuntuacio() + "</p>" +
                    "<p>" + opin.getOpirevisada() + "</p>" + "</div>"
            );
        }

    }
%>

</body>
</html>
