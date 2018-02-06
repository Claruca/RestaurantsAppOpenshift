
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.LlegirBD" %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.Restaurant" %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.Usuaris" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html lang="ca">
<head>
    <title>Restaurants</title>
    <!-- Required meta tags -->
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

<!-- Barra de navegació -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="index.jsp"> Restaurants</a>
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
                <a class="nav-link" href="servlet">Enllaç 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="servlet">Enllaç 2</a>
            </li>
        </ul>
        <%
            Usuaris usuari = (Usuaris) session.getAttribute("usuari");
            if (usuari != null) {
                out.println("<p>" + usuari.getCodi() + "</p>" + "</br>" +
                        "<p>" + usuari.getEmail() + "</p>");
            }
        %>
        <form action="logout" method="post">
            <button type="submit" class="btn btn-success" value="logout">Logout</button>
        </form>


        <form class="form-inline my-2 my-lg-0" method="get" action="index.jsp">
            <!-- Aquí tenim el formulari de cerca amb la variable consulta del LlegirBD-->
            <input class="form-control mr-sm-2" name="consulta" type="text" placeholder="Italià, Japo,..."
                   aria-label="Cercar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cercar</button>
        </form>
    </div>
</nav>