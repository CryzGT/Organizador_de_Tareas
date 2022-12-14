<%-- 
    Document   : Tarea
    Created on : 14/10/2022, 06:40:35 PM
    Author     : Sofia Paniagua
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
           <title>Tareas</title>
    </head>
    
    
    <body>
         <div class="contenedor">
            <div class="card col-sm-8" id="hijo">
                <div  style="display: inline-block">
                    <ion-icon name="clipboard-outline" style="font-size: 64px;"></ion-icon>
                    <h1 style="text-align: center">Tareas del Listado: ${NOMBRELISTADO.getNombreLista()}</h1>
                </div>
            </div>
        </div>
        <div class="d-flex">
            <div class="col-sm-8" id="botonLista">
                <div>
                    <a id="botonLista" class="btn btn-outline-success" href="Controlador?menu=Tareas&accion=add">Crear Nueva Tarea
                        <ion-icon name="add-outline" style="font-size: 30px;"></ion-icon></a>              
                </div>
            </div>
        </div>
        <div class="d-flex">
            <div class="col-sm-8" id="tableLista">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Nombre</th>
                            <th>Descripci??n</th>
                            <th>Fecha Inicio</th>
                            <th>Fecha Fin</th>
                            <th>Estado</th>                            
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach  var="tarea" items="${SHOWTAREAS}">
                        <tr>
                            <td><ion-icon name="clipboard-outline" style="font-size: 35px;"></ion-icon></td>
                            <td>${tarea.getNombre()}</td>
                            <td>${tarea.getDescripcion()}</td>    
                            <td>${tarea.getFechaInicio()}</td>
                            <td>${tarea.getFechaFin()}</td>                               
                            <td>${tarea.getEstado()}</td>

                            <td>
                                     <!--Controlador?menu=Tareas&accion=showTareas&nameListado=$ {ls.getNombreLista()}&idListadoTareas=$ {ls.getIdLista()}"-->
                                <a href="Controlador?menu=listado_a&accion=showLists&idTarea=${tarea.getIdTarea()}&nombreTarea=${tarea.getNombre()}" alt="Ver Listados de Actividades">
                                    <ion-icon name="chevron-forward-circle" style="font-size: 40px;"></ion-icon></a>
                                <a href="Controlador?menu=Tareas&accion=edit&idTarea=${tarea.getIdTarea()}&nombreTarea=${tarea.getNombre()}&desc=${tarea.getDescripcion()}&fechaInicio=${tarea.getFechaInicio()}&fechaFin=${tarea.getFechaFin()}&estado=${tarea.getEstado()}" alt="Editar">
                                    <ion-icon name="pencil-outline" style="font-size: 40px;"></ion-icon></a>      
                                
                                
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
