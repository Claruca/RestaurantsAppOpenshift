<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.LlegirBD" %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.Restaurant" %>
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
                <a class="nav-link" href="test">Enllaç 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="test">Enllaç 2</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <!-- Aquí tenim el formulari de cerca amb la variable consulta del LlegirBD-->
            <input class="form-control mr-sm-2" name="consulta" type="text" placeholder="Italià, Japo,..."
                   aria-label="Cercar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cercar</button>
        </form>
    </div>
</nav>

<main class="fonsPrincipal" role="main">
    <!-- Principal jumbotron -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Restaurants</h1>
            <h2>Els millors restaurants de Mallorca</h2>
            <p><a class="btn btn-primary btn-lg" href="showRestaurantServlet" role="button">Saber-ne més &raquo;</a></p>
        </div>
    </div>

    <!-- Contanidor principal -->
    <div class="container">
        <!-- fila de columnes -->
        <div class="container">
            <h4>Llista de recomanacions:</h4>
        </div>
        <% //Codi java que ens treu els valors de la consulta amb un iterador de la arraylist
            LlegirBD llegirBd = new LlegirBD();
            ArrayList ar = llegirBd.MostrarRes(request.getParameter("consulta"));
            Iterator itr = ar.iterator();
            while (itr.hasNext()) {
                Restaurant res = (Restaurant) itr.next();
                out.println("<div class=\"row\">" +
                        " <div class =\"col-md-4\">" + "<img class=\"img-fluid rounded\" src=\" " + res.getImatge() + "\">" + "</div>" +
                        "<div class=\"col-md-8\">" +
                        "<h3>" + res.getNom() + "</h3>" +
                        "<p>" + res.getAdressa() + "</p>" +
                        "<p>" + res.getLlocweb() + "</p>" +
                        "<p>" + res.getTelefon() + "</p>" +
                        "<p>" + res.getTipus() + "</p>" +
                        "<p>" + res.getMitjana() + "</p>" +

                        "</div >" +
                        "</div >"
                );
            } %>

    </div> <!-- /contenidor principal -->

</main>

<!--Aquí he afegit una barra de sel·lecció de pàgines que ens duen a la mateixa -->
<div class="pagination">
    <ul class="pagination pagination-lg">
        <li class="page-item disabled">
            <a class="page-link" href="#">&laquo;</a>
        </li>
        <li class="page-item active">
            <a class="page-link" href="#">1</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">2</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">3</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">4</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">5</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">&raquo;</a>
        </li>
    </ul>
</div>

<footer class="container">
    <p>&reg; Clara Marti Alberti</p> <!--El copyright>
</footer>

<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
</footer>
</body>
</html>
