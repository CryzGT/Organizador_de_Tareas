<%-- 
    Document   : ListadosA
    Created on : 14/10/2022, 08:03:04 PM
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
        <title>Listados Actividades</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="card col-sm-12" id="hijo">
                <div  style="display: inline-block">
                    <ion-icon name="clipboard-outline" style="font-size: 64px;"></ion-icon>
                    <h1 style="text-align: center">Listado de Actividades de la Tarea: ${NOMBRETAREA.getNombre()}</h1>
                </div>
            </div>
        </div>
        <div class="d-flex">
            <div class="col-sm-12" id="botonLista">
                <div>
                    <a id="botonLista" class="btn btn-outline-success" href="Controlador?menu=listado_a&accion=add">Crear Nuevo Listado 
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
                            <th>Descripción</th>
                            <th>Porcentaje de Avance</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach  var="ls" items="${SHOWLISTS}">
                        <tr>
                            <td><ion-icon name="clipboard-outline" style="font-size: 35px;"></ion-icon></td>
                            <td>${ls.getNombre()}</td>
                            <td>${ls.getDescripcion()}</td>
                            <td>${ls.getPorcentajeAvance()}</td>        
                            <td>              
                                <a href="Controlador?menu=actividades&accion=showLists&idListadoA=${ls.getIdListado()}&nombreListadoA=${ls.getNombre()}">
                                    <ion-icon name="chevron-forward-circle" style="font-size: 40px;"></ion-icon></a>
                                <a href="Controlador?menu=listado_a&accion=edit&idListado=${ls.getIdListado()}&nombreListado=${ls.getNombre()}&desc=${ls.getDescripcion()}&finalizada=${ls.getPorcentajeAvance()}" alt="Editar">
                                    <ion-icon name="pencil-outline" style="font-size: 40px;"></ion-icon></a>      
                                
                                <!-- <a href="Controlador2?menu=EditarUsuario&accion=Editar&idU=$ {um.getIdTablero()}">
                                    <ion-icon name="chevron-forward-circle" style="font-size: 40px;"></ion-icon></a>
                                    <a href="Controlador2?menu=EditarUsuario&accion=Editar&idU=$ {um.getIdTablero()}">
                                    <ion-icon name="trash" style="font-size: 40px;"></ion-icon></a>-->
                        </tr>
                    </c:forEach>
                </table>
            </div>
            
            <div class="col-sm-3" id="tableLista">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th colspan="2" style="text-align: center;">Comentarios de la Tarea
                            </th>
                        </tr>
                    </thead>
                    <c:forEach  var="com" items="${SHOWCOMENTARIOS}">
                        <tr>
                            <td><ion-icon name="chatbox-ellipses-outline"></ion-icon></td>
                            <td>${com.getDetalle()}</td>
                         </tr>
                    </c:forEach>
                         
                        <tr>
                            <td colspan="2">
                                <form action="Controlador?menu=Tareas&idTarea=${idTarea}" method="POST">
                                    <div class="form-group">
                                        <label>Nuevo comentario</label>
                                        <input class="form-control" type="text" name="txtcomentario" placeholder="Ingrese nuevo comentario">
                                    </div>  
                                    <input type="submit" name="accion" value="addComentario"  class="btn btn-info">
                                </form>
                                
                            </td>
                            <!--<td>
                                <a id="botonLista" class="btn" href="Controlador?menu=Tareas&accion=addComentario&idTarea=${idTarea}">
                            <ion-icon name="add-outline" style="font-size: 30px;"></ion-icon></a>
                            </td> -->
                        </tr>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>


