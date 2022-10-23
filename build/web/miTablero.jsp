<%-- 
    Document   : miTablero
    Created on : Sep 12, 2022, 3:13:27 PM
    Author     : Anderson
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <link href="css/Estilo.css" rel="stylesheet" type="text/css"/>
        <title>Mis Tableros</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-8" id="hijo">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Fecha</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <c:forEach  var="um" items="${TABLERO}">
                        <tr>
                            <td>${um.getIdTablero()}</td>
                            <td>${um.getNombre()}</td>
                            <td>${um.getDescripcion()}</td>
                            <td>${um.getFechaCreacion()}</td>
                            <td>${um.isPublico()}</td>          
                            <td>                          
                                <a href="Controlador?menu=Lists&accion=showLists&nameBoard=${um.getNombre()}&idBoard=${um.getIdTablero()}">
                                    <ion-icon name="clipboard-outline" style="font-size: 30px;"></ion-icon></a>
                                <a href="Controlador?menu=Board&accion=editBoard&nameBoard=${um.getNombre()}&idBoard=${um.getIdTablero()}">
                                    <ion-icon name="pencil-outline" style="font-size: 30px;"></ion-icon></a>
                                <a href="Controlador?menu=Etiqueta&accion=addEtiqueta&nameBoard=${um.getNombre()}&idBoard=${um.getIdTablero()}">
                                    <ion-icon name="bookmarks-outline" style="font-size: 30px;"></ion-icon></a>
                                <a href="Controlador2?menu=EditarUsuario&accion=Editar&idU=${um.getIdTablero()}">
                                    <ion-icon name="share-social-outline" style="font-size: 30px;"></ion-icon></a>         
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>


        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>


