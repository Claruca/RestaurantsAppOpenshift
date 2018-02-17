<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/solar/bootstrap.min.css">

<#--https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css-->


    <title>${title!""}</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">Restaurantes</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01"
    ">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="#">Otros</a>
        </li>
    </ul>
    </div>
</nav>

<div class="jumbotron" role="main">
    <div class="row featurette">
        <div class="col-md-7">
            <h1 class="display-3"><#if name??>
                Benvinguts al  ${name!"yuhu"}
            </#if></h1>
            <hr class="my-4">
            <a class="btn btn-info" href="#" role="button"><span class="text-muted">Més informació</span></a>
        </div>
        <div class="col-md-5">
            <img src="http://lorempixel.com/500/150"/>
        </div>
    </div>
</div>
<#--<main role="main" class="container">-->
<#--<div class="row featurette">-->
<#--<div class="col-md-7">-->
<#--<h1><#if name??>-->
<#--<h1>Benvinguts al  ${name!"yuhu"}</h1>-->
<#--</#if></h1>-->
<#--<h2 class="featurette-heading">${subtitle!""}-->
<#--<br/><span class="text-muted">Més informació</span>-->
<#--</h2>-->
<#--</div>-->
<#--<div class="col-md-5">-->
<#--<img src="http://lorempixel.com/500/150"/>-->
<#--</div>-->
<#--</div>-->

<#--La variable posts a la que hacemos referencia en el Launcher tendrá la info de la BD-->
<#if list??>
<div class="row center mt-2">
    <#list list as item> <#-- Llamamos a los posts item y los listamos-->
        <div class="col-md-3">
            <div class="media mt-5 ml-5">
                <img class="align-self-start mr-5 rounded-circle"
                     src="${item.imatge!""}"
                <#--src="http://lorempixel.com/80/80"-->
                     alt="Random Image" width="120" height="120">
                <div class="media-body">
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