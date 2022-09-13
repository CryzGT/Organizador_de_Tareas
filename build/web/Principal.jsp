<%-- 
    Document   : Principal
    Created on : Sep 11, 2022, 8:28:55 PM
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <title>Organizador</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg" style="background-color: #e3f2fd;">
            <div class="collapse navbar-collapse" id="navbarNav">

                <ul class="navbar-nav" style="text-align: center;">
                    <ion-icon name="home" style="font-size: 64px;"></ion-icon>

                    <li class="nav-item">
                        <a style="margin-left: 100px;" class="btn btn-outline-dark" href="Controlador?menu=Tablero&accion=listarTableros" target="myframe">Mi Tablero</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px;" class="btn btn-outline-dark" href="Controlador?menu=&accion=" target="myframe">Crear Nuevo Tablero</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px;" class="btn btn-outline-dark" href="Controlador?menu=&accion=" target="myframe">Invitaciones</a>
                    </li>
                </ul>
            </div>
            <ion-icon name="person-outline" style="font-size: 64px;"></ion-icon>
            <div >
                <div  style="margin-right: 40px;" class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${USUARIO.getNombre()}
                    </button>
                    <div class="dropdown-menu text-center" >
                        <a class="dropdown-item" href="#">${USUARIO.getLogin()}</a>
                        <div class="dropdown-divider" ></div>

                        <form action="Validar" method="post">
                            <button name="accion" value="salir" class="dropdown-item" href="#" >Salir</button>
                        </form>
                    </div>
                </div>           
            </div>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form> 
        </nav>
        <div class="m-4" style="height: 600px;">
            <iframe name="myframe" style="height: 100%; width: 100%; border: none" ></iframe>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

    </body>
</html>
