<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.LlegirBD" %>
<%@ page import="com.iesemilidarder.RestaurantsApp.core.Restaurant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>
<%@include file="header.jsp"%> <%--Include del header--%>


<main class="fonsPrincipal" role="main">
    <!-- Principal jumbotron -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Restaurants</h1>
            <h2>Els millors restaurants de Mallorca</h2>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">Saber-ne més &raquo;</a></p>
        </div>
    </div>

    <!-- Contenidor principal -->
    <div class="container">
        <!-- fila de columnes -->
        <div class="container">
            <h4>Llista de recomanacions:</h4>
        </div>
        <% //Codi java que ens treu els valors de la consulta amb un iterador de la arraylist
            LlegirBD llegirBd = new LlegirBD();
            List<Restaurant> ar = llegirBd.mostrarRes(request.getParameter("consulta"));
            for(Restaurant res: ar){
                out.println("<div class=\"row\">" +
//                    " <div class =\"col-md-4\">" + "<img class=\"img-fluid rounded\" src=\" " + res.getImatge() + "\">" + "</div>" +
                    "<div class=\"col-md-8\">" +
                    "<h3>" + res.getNom() + "</h3>" +
                    "<p>" + res.getAdressa() + "</p>" +
                    "<p>" + res.getLlocweb() + "</p>" +
                    "<p>" + res.getTelefon() + "</p>" +
                    "<p>" + res.getTipus() + "</p>" +
                    "<h5>" + "Nota: " + "</h5>" + "<p>" + res.getMitjana() + "</p>" +
                    "<p>" + "<a class=\"btn btn-secondary\" href=\"/servlet?id=" + res.getCodi() + "\" role=\"button\">" + "Més informació &raquo;</a>" + "</p>" +
                    //El botó anirà a la URL i mirarà que el paràmetre id sigui igual al codi del restaurant
                    "</div >" +
                    "</div >"
            );

            } %>

    </div> <!-- /contenidor principal -->

</main>

<!--Aquí he afegit una barra de sel·lecció de pàgines que ens duen cada un a un restaurant diferent -->
<div class="pagination">
    <ul class="pagination pagination-lg">
        <li class="page-item disabled">
            <a class="page-link" href="#">&laquo;</a>
        </li>
        <li class="page-item active">
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

<footer class="container">
    <p>&copy Clara Marti Alberti</p> <!--El copyright>
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
