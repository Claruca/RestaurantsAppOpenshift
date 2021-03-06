<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log in</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/solar/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <#--<link rel="stylesheet" type="text/css" href="../css/loginsheet.css">-->

    <#--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">-->

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
    </div>
</nav>
<main role="main">

    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">LOGIN</h1>
            <p>Enter your credentials</p>
        </div>
    </div>

    <div class="container">

        <form style="margin-left:100px; margin-right: 500px" role="form" action="/login" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <div>
                <label for="username">Name</label>
                <input class="form-control mr-sm-2" name="username" id="username" required autofocus/>
            </div>
            <div>
                <label for="password">Password</label>
                <input class="form-control mr-sm-2" type="password" name="password" id="password" required/>
            </div>
            <div>
                <label for="remember-me">Remember me</label>
                <input type="checkbox" name="remember-me" id="remember-me"/>
            </div>
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign in</button>
        </form>
    </div>

<#if error.isPresent()>
    <p>The username or password you have entered is invalid, try again.</p>
</#if>
</main>
</body>
</html>