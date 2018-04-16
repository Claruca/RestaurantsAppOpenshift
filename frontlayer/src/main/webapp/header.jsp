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

    <img src="https://png.icons8.com/color/50/000000/broccoli.png" style="border: none; margin:auto">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp"> Restaurants</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                    aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <%--Icones principals--%>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">

            <ul class="nav navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Inici <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="servlet">Enllaç 1</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="servlet">Enllaç 2</a>
                </li>

                <%--Agafa la sessió de l'usuari i imprimeix nom i email--%>
                <%
                    Usuaris usuari = (Usuaris) session.getAttribute("usuari");
                    if (usuari != null) {
                        out.println("<li class=\"nav-item\">" + "Benvingut:&nbsp;" + usuari.getCodi() + "</li>"
                                + "<li class=\"nav-item\">" + "Usuari: " + usuari.getEmail() + "</li>");

//                 <div class="well">Basic Well</div>
//                "<div class=\"well\">"
                    }
                %>
                <%--Mostra el botó diferent depenent si hi ha sessió d'usuari o no --%>
                <% if (session.getAttribute("usuari") != null) {
                    out.println("<form action=\"logout\" method=\"post\">\n" +
                            "            <button type=\"submit\" class=\"btn btn-success btn-block\" value=\"logout\">Logout</button>\n" +
                            "        </form>");
                } else {
                    out.println("<form action=\"loginPage.html\" method=\"post\">\n" +
                            "            <button type=\"submit\" class=\"btn btn-success btn-block\" value=\"login\">Login</button>\n" +
                            "        </form>");

                }

                %>

            </ul>


            <%--<form action="logout" method="post">--%>
            <%--<button type="submit" class="btn btn-success" value="logout">Logout</button>--%>
            <%--</form>--%>


            <form class="navbar-form navbar-left inline" method="get" action="index.jsp">
                <div class="input-group">
                    <!-- Aquí tenim el formulari de cerca amb la variable consulta del LlegirBD-->
                    <input class="form-control" name="consulta" type="text" placeholder="Italià, Japo,..."
                           aria-label="Cercar">
                    <div class="input-group-btn">
                        <button class="btn btn-outline-success" type="submit">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</nav>
