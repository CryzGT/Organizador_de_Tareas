<%-- 
    Document   : editTarea
    Created on : 22/10/2022, 11:25:16 AM
    Author     : Sofia Paniagua
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
        <link href="css/Estilo.css" rel="stylesheet" type="text/css"/>
        <title>Editar Tarea</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="card col-sm-8" id="hijo">
                <div  style="display: inline-block">
                    <ion-icon name="clipboard-outline" style="font-size: 64px;"></ion-icon>
                        <h1 style="text-align: center">Editar Tarea: ${nombreTarea}</h1>
                </div>
            </div>
        </div>
        <div class="d-flex" >
            <div class="card col-sm-8" id="hijo">
                <div class="card-body">
                    <form action="Controlador?menu=Tareas" method="POST">
                        <!--<div class="form-group">
                            <label>Listado</label>
                            <input class="form-control" type="text" name="txtlistado" placeholder="Nombre Listado ....">
                        </div>-->
                        <div class="form-group">
                            <label>Estado</label>
                            <input class="form-control" readonly type="text" name="txtestado" value="${estado}">
                        </div>                        
                        <div class="form-group">
                            <label>Nombre</label>
                            <input class="form-control" type="text" name="txtnombre" value="${nombreTarea}">
                        </div>
                        <div class="form-group">
                            <label>Descripción</label>
                            <input class="form-control" type="text" name="txtdescripcion" value="${desc}">
                        </div>
                        <div class="form-group">
                            <label>Fecha Inicio</label>
                            <input class="form-control"  type="date" name="txtfechainicio" value="${fechaInicio}">
                        </div>                        
                        <div class="form-group">
                            <label>Fecha Fin</label>
                            <input class="form-control"  type="date" name="txtfechafin" value="${fechaFin}">
                        </div>


                            <!--<input type="submit" name="accion=Editar&idTarea=$ {idTarea}"  class="btn btn-info">-->
                        <input type="submit" name="accion" value="Editar"  class="btn btn-info">
                        <input type="submit" name="accion" value="Cancelar"  class="btn btn-warning" >
                    </form>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
