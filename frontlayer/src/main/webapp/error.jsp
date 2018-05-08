<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.Restaurant" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.Opinions" %>
<%@ page import="static java.awt.SystemColor.text" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
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
    <link href="css/formulari.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Restaurants</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

<%--La pàgina d'error és igual al formulari de l'inici--%>
<%
    String error = (String) request.getAttribute("error");
    out.println("Usuari i/o password incorrectes" + "</br>");
%>
<div class="container">
    <div class="jumbotron vertical-center">
        <div class="form-group">
            <h3 class="titulo">Inicia sessió</h3>
            <form class="formulari" action="loginservlet" method="post">
                <input class="form-control" type="text" placeholder="Usuari" name="usuari"/><br/><br/>
                <input class="form-control" type="password" placeholder="Password" name="psw"/><br/><br/>
                <button type="submit" class="btn btn-lg btn-success" value="login">Try Again</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
