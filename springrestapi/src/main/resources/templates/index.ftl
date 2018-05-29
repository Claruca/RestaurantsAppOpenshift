<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="https://bootswatch.com/4/solar/bootstrap.min.css">


    <!--Bootstrap basico-->
<#--  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
        integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">-->
<#--<link rel="stylesheet" href="../css/loginsheet.css">-->

<#--https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css-->


    <title>${title!""}</title>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-primary">
    <a class="navbar-brand" href="/">Restaurants</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="/rest/api/v1/restaurants">RestApi</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="/ajax.html">Version Ajax</a>
            <#--<li class="nav-item">-->
            <#--<a class="nav-link disabled" href="/login">Login</a>-->
            <#--</li>-->
            <li class="nav-item">
            <#--<@security.authorize ifAnyGranted="ROLE_ADMIN">
            Your role is "ROLE_USER" <br/>
        </@security.authorize>-->
            </li>
        </ul>
    </div>
</nav>

<div class="jumbotron" role="main">
    <div class="row featurette">
        <div class="col-md-7">
            <h1 class="display-3"><#if name??>
            ${name!"yuhu"} de Mallorca
            </#if></h1>
            <hr class="my-4">
            <a class="btn btn-outline-success" href="#" role="button"><span class="text-muted">Més informació</span></a>
        </div>
        <div class="col-md-5">
            <img src="https://www.w3schools.com/bootstrap/sanfran.jpg"
                 alt="imagen" class="rounded-circle pt-4" height="80%" width="auto"/>
        </div>
    </div>
</div>

<#--La variable posts a la que hacemos referencia en el Launcher tendrá la info de la BD-->
<div class="container mx-auto">
<#if list??>
    <div class="row center mt-2">
        <#list list as item> <#-- Llamamos a los posts item y los listamos-->
            <div class="col-md-5 text-center border border-white rounded m-2" style="width: 500px; min-width: 400px">
                <div class="media mt-5 ml-5 mx-auto">
                    <div class="media-body" style="font-family: monospace; font-size: 1.5rem">
                        <img src="${item.imatge!""}" alt="imagen" class="w-50 p-3 rounded-circle w-25"/>
                        <h5 class="mt-0">Nom ${item.nom!""}</h5>
                        <p>Direcció: ${item.adressa!""}</p>
                        <p>URL: ${item.llocweb!""}</p>
                        <p>Telèfon: ${item.telefon!""}</p>
                        <p>${item.tipus!""}</p>
                        <p>Nota: ${item.mitjana!""}</p>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</#if>
</div>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
        integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
        crossorigin="anonymous"></script>
</body>
</html>