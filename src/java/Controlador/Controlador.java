package Controlador;

import Modelo.Listas;
import Modelo.ListasDAO;
import Modelo.Tablero;
import Modelo.TableroDAO;
import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.*; //Sofia - importar todos los modelos
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
        
        
public class Controlador extends HttpServlet {

    TableroDAO tdao = new TableroDAO();
    Tablero ab = new Tablero();
    ListasDAO ldao = new ListasDAO();
    Listas lt = new Listas();
    TareaDAO tareaD = new TareaDAO();
    Tarea tarea = new Tarea();
    
    //Controlador 2
    ListadoActividades l_actividades = new ListadoActividades();
    ListadoActividadesDAO l_actividadesD = new ListadoActividadesDAO();
    Actividad actividad = new Actividad();
    ActividadDAO actividadD = new ActividadDAO();
    
    public Controlador() {
    }
    int idUser, idBoard, idListadoT, idTarea, idListadoA, idActividad;
    String nameBoard, nombreListadoT, nombreT, nombreListadoA, nombreA;
    
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Board")) {
            switch (accion) {
                case "listBoard":
                    idUser = Integer.parseInt(request.getParameter("idUser"));
                    List listarTableros = tdao.listBoard(idUser);
                    request.setAttribute("TABLERO", listarTableros);
                    request.getRequestDispatcher("miTablero.jsp").forward(request, response);
                    break;
                case "addBoard":
                    request.getRequestDispatcher("addTablero.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    ab.setIdPropietario(idUser);
                    ab.setNombre(nombre);
                    ab.setDescripcion(descripcion);
                    tdao.addBoard(ab);
                    request.getRequestDispatcher("Controlador?menu=Board&accion=listBoard&idUser=" + ab.getIdPropietario()).forward(request, response);
                    break;
                case "Cancelar":
                    ab.setIdPropietario(idUser);
                    request.getRequestDispatcher("Controlador?menu=Board&accion=listBoard&idUser=" + ab.getIdPropietario()).forward(request, response);
                    break;
                case "Delete":
                    idBoard = Integer.parseInt(request.getParameter("idBoard"));
                    tdao.deleteBoard(idBoard);
                    ab.setIdPropietario(idUser);
                    request.getRequestDispatcher("Controlador?menu=Board&accion=listBoard&idUser=" + ab.getIdPropietario()).forward(request, response);
                    break;

                default:
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
        }
        
        if (menu.equals("Lists")) {
            switch (accion) {
                case "showLists":
                    nameBoard = request.getParameter("nameBoard");
                    idBoard = Integer.parseInt(request.getParameter("idBoard"));
                    ab.setNombre(nameBoard);
                    request.setAttribute("NAMEBOARD", ab);
                    List showList = ldao.listLists(idBoard);
                    request.setAttribute("SHOWLISTS", showList);
                    request.getRequestDispatcher("Listas.jsp").forward(request, response);
                    break;
                case "addList":
                    request.getRequestDispatcher("addLista.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    ab.setNombre(nameBoard);
                    lt.setIdTablero(idBoard);
                    lt.setNombreLista(nombre);
                    lt.setDescLista(descripcion);
                    ldao.addList(lt);
                    request.getRequestDispatcher("Controlador?menu=Lists&accion=showLists&idBoard=" + lt.getIdTablero()+"&nameBoard=" + ab.getNombre()).forward(request, response);
                    break;
                case "Cancelar":
                    lt.setIdTablero(idBoard);
                    request.getRequestDispatcher("Controlador?menu=Lists&accion=showLists&idBoard=" + lt.getIdTablero()+"&nameBoard=" + ab.getNombre()).forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        if (menu.equals("Tareas")) {
            switch (accion) {
                case "showTareas":
                    
                    nombreListadoT = request.getParameter("nameListado");
                    idListadoT = Integer.parseInt(request.getParameter("idListadoTareas"));
                    
                    lt.setNombreLista(nombreListadoT);
                    request.setAttribute("NOMBRELISTADO", lt);
                    List showList =  tareaD.listarTareas(idListadoT) ;// ldao.listLists(idBoard);
                    request.setAttribute("SHOWTAREAS", showList);
                    request.getRequestDispatcher("Tarea.jsp").forward(request, response);
                    break;
                /*case "showComentarios":
                    
                    List comentarios =  tareaD.listarComentarios(idTarea) ;// ldao.listLists(idBoard);
                    request.setAttribute("SHOWCOMENTARIOS", comentarios);
                    request.getRequestDispatcher("Tarea.jsp").forward(request, response);
                    break;*/
                case "add":
                    request.getRequestDispatcher("addTarea.jsp").forward(request, response);
                    break;
                case "edit":
                    nombreT = request.getParameter("nombreTarea");
                    idTarea = Integer.parseInt(request.getParameter("idTarea"));
                    String desc = request.getParameter("desc");
                    String fInicio = request.getParameter("fechaInicio");
                    String fFin = request.getParameter("fechaFin");
                    String est = request.getParameter("estado");                    
                    
                    request.setAttribute("nombreTarea", nombreT);                    
                    request.setAttribute("idTarea", idTarea);
                    request.setAttribute("desc", desc);
                    request.setAttribute("fechaInicio", fInicio);                    
                    request.setAttribute("fechaFin", fFin);
                    request.setAttribute("estado", est);
                    
                    request.getRequestDispatcher("editTarea.jsp").forward(request, response);
                    break;
                case "Agregar":
                    //int id_listado = 1; // Integer.parseInt(request.getParameter("txtlistado"));
                    int id_estado = 1; //Iniciada
                    int id_usuario_asignado = 1; //Admin - cambiar  
                    String estado = null;
                    String nombre = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");

                    Date fechainicio = null;
                    Date fechafin = null;
  
                    tarea.setIdListado(idListadoT);
                    tarea.setIdEstado(id_estado);
                    tarea.setIdUsuarioAsignado(id_usuario_asignado);
                    tarea.setEstado(estado);
                    tarea.setNombre(nombre);
                    tarea.setDescripcion(descripcion);
                    tarea.setFechaInicio(fechainicio);
                    tarea.setFechaFin(fechafin);
                    
                    tareaD.agregarTarea(tarea);
                    
                    request.getRequestDispatcher("Controlador?menu=Tareas&accion=showTareas&idListadoTareas=" + tarea.getIdListado()+"&nameListado=" + lt.getNombreLista()).forward(request, response);
                    break;
                    
                case "addComentario":
                    
                    String comentario = request.getParameter("txtcomentario");
                    System.out.println("comentario que trae =="  + comentario);
                    tareaD.agregarComentario(idTarea, comentario);
  
                    //request.getRequestDispatcher("Controlador?menu=Tareas&accion=showTareas&idListadoTareas=" + tarea.getIdListado()+"&nameListado=" + lt.getNombreLista()).forward(request, response);
                    //request.getRequestDispatcher("Controlador?menu=listado_a&accion=showLists&idTarea=" + idTarea+"&nombreTarea=" + tarea.getNombre()).forward(request, response);
                    request.getRequestDispatcher("Controlador?menu=listado_a&accion=showLists&idTarea=" + idTarea +"&nombreTarea=" + tarea.getNombre()).forward(request, response);
                    
                    break;                 
                    
                 case "Editar":
                
                    id_estado = 1; //Iniciada
                    id_usuario_asignado = 1; //Admin - cambiar  
                    estado =  request.getParameter("txtestado");
                    nombre = request.getParameter("txtnombre");
                    descripcion = request.getParameter("txtdescripcion");
                    String fecha_i = request.getParameter("txtfechainicio");
                    String fecha_f = request.getParameter("txtfechafin");
                    //idTarea = Integer.parseInt(request.getParameter("idTarea"));
                    
                    tarea.setIdListado(idListadoT);
                    tarea.setIdEstado(id_estado);
                    tarea.setIdUsuarioAsignado(id_usuario_asignado);
                    tarea.setEstado(estado);
                    tarea.setNombre(nombre);
                    tarea.setDescripcion(descripcion);
                    tarea.setFechaInicio(null);
                    tarea.setFechaFin(null);
                    tarea.setIdTarea(idTarea);
                    
                    tareaD.editarTarea(tarea);
                    
                    request.getRequestDispatcher("Controlador?menu=Tareas&accion=showTareas&idListadoTareas=" + tarea.getIdListado()+"&nameListado=" + lt.getNombreLista()).forward(request, response);
                    break;
                    
                case "Cancelar":
                    lt.setIdTablero(idBoard);
                    request.getRequestDispatcher("Controlador?menu=Tareas&accion=showTareas&idListadoTareas=" + tarea.getIdListado()+"&nameListado=" + lt.getNombreLista()).forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        
        //Contenido del controlador 2
         if (menu.equals("listado_a")) {
            switch (accion) {
                case "showLists":
                    nombreT = request.getParameter("nombreTarea");
                    idTarea = Integer.parseInt(request.getParameter("idTarea"));
                    
                    tarea.setNombre(nombreT);
                    request.setAttribute("NOMBRETAREA", tarea);
                    List showList =  l_actividadesD.listarListadosActividades(idTarea);// ldao.listLists(idBoard);
                    request.setAttribute("SHOWLISTS", showList);
                    request.setAttribute("idTarea", idTarea);
                    
                    List comentarios =  tareaD.listarComentarios(idTarea) ;// ldao.listLists(idBoard);
                    request.setAttribute("SHOWCOMENTARIOS", comentarios);
                                       
                    request.getRequestDispatcher("ListadosA.jsp").forward(request, response);
                    
                    
                    //request.getRequestDispatcher("Tarea.jsp").forward(request, response);

                    break;
                case "add":
                    request.getRequestDispatcher("addListadosA.jsp").forward(request, response);
                    break;
                case "edit":
                    nombreListadoA = request.getParameter("nombreListado");
                    idListadoA = Integer.parseInt(request.getParameter("idListado"));
                    String descListadoA = request.getParameter("desc");
                    
                    //Boolean finalizada = request.getParameter("finalizada").equals("1");

                    String est = request.getParameter("estado");                    
                    
                    request.setAttribute("nombreListado", nombreListadoA);                    
                    request.setAttribute("idListado", idListadoA);
                    request.setAttribute("desc", descListadoA);
                   // request.setAttribute("finalizada", finalizada);
                    
                    request.getRequestDispatcher("editListadoA.jsp").forward(request, response);
                    break;
                case "Agregar":
                    
                    //int id_tarea = Integer.parseInt(request.getParameter("txttarea"));
                    String nombre = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    String fecha_hora_creacion ; 
                    int porcentaje_avance = 0;
                    
                    l_actividades.setIdTarea(idTarea);
                    l_actividades.setNombre(nombre);
                    l_actividades.setDescripcion(descripcion);
                    l_actividades.setFechaHoraCreacion(null);
                    l_actividades.setPorcentajeAvance(porcentaje_avance);
                   
                    l_actividadesD.agregarListadoActividades(l_actividades);
                    
                    request.getRequestDispatcher("Controlador?menu=listado_a&accion=showLists&idTarea=" + l_actividades.getIdTarea()+"&nombreTarea=" + tarea.getNombre()).forward(request, response);
                    break;
                case "Editar":
                    
                    nombre = request.getParameter("txtnombre");
                    descripcion = request.getParameter("txtdescripcion");

                    l_actividades.setIdTarea(idTarea);
                    l_actividades.setNombre(nombre);
                    l_actividades.setDescripcion(descripcion);
                    l_actividades.setIdListado(idListadoA);
                               
                    l_actividadesD.editarListadoActividades(l_actividades);
                    
                    request.getRequestDispatcher("Controlador?menu=listado_a&accion=showLists&idTarea=" + l_actividades.getIdTarea()+"&nombreTarea=" + tarea.getNombre()).forward(request, response);
                    break;
                case "Cancelar":
                    lt.setIdTablero(idBoard);
                    request.getRequestDispatcher("Controlador?menu=listado_a&accion=showLists&idTarea=" + l_actividades.getIdTarea()+"&nombreTarea=" + tarea.getNombre()).forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
         
         if (menu.equals("actividades")) {
            switch (accion) {
                case "showLists":
                    nombreListadoA = request.getParameter("nombreListadoA");
                    idListadoA = Integer.parseInt(request.getParameter("idListadoA"));
                    
                    l_actividades.setNombre(nombreListadoA);
                    request.setAttribute("NOMBRELISTADOA", l_actividades);
                    List showList =  actividadD.listarActividades(idListadoA);
                    request.setAttribute("SHOWLISTS", showList);
                    request.getRequestDispatcher("Actividades.jsp").forward(request, response);
                    break;
                case "add":
                    request.getRequestDispatcher("addActividad.jsp").forward(request, response);
                    break;
                case "edit":
                    nombreA = request.getParameter("nombreActividad");
                    String descA = request.getParameter("desc");
                    idActividad = Integer.parseInt(request.getParameter("idActividad"));
                    String finalizada_A = request.getParameter("finalizada");
                    if(finalizada_A.equals("0")){
                        finalizada_A = "No finalizada";
                    }else {
                        finalizada_A = "Finalizada";
                    }
                    
                    request.setAttribute("nombreActividad", nombreA);                    
                    request.setAttribute("idActividad", idActividad);
                    request.setAttribute("desc", descA);                    
                    request.setAttribute("finalizada", finalizada_A);

                    
                    request.getRequestDispatcher("editActividad.jsp").forward(request, response);
                    break;
                case "Agregar":
                    
                    //int id_listado = 1; // Integer.parseInt(request.getParameter("txtlistado"));
                    String nombre = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    Boolean finalizada = false ;
                    
                    actividad.setIdListado(idListadoA);
                    actividad.setNombre(nombre);
                    actividad.setDescripcion(descripcion);
                    actividad.setFinalizada(finalizada);
                               
                    actividadD.agregarActividades(actividad);
                    
                    request.getRequestDispatcher("Controlador?menu=actividades&accion=showLists&idListadoA=" + actividad.getIdListado()+"&nombreListadoA=" + l_actividades.getNombre()).forward(request, response);
                    break;
            case "Editar":
                    
                     // Integer.parseInt(request.getParameter("txtlistado"));
                    nombre = request.getParameter("txtnombre");
                    descripcion = request.getParameter("txtdescripcion");
                    finalizada = request.getParameter("txtfinalizada").equals("1");
                    
                    actividad.setIdListado(idListadoA);
                    actividad.setNombre(nombre);
                    actividad.setDescripcion(descripcion);
                    actividad.setFinalizada(finalizada);
                    actividad.setIdActividad(idActividad);
                               
                    actividadD.editarActividades(actividad);
                    
                    request.getRequestDispatcher("Controlador?menu=actividades&accion=showLists&idListadoA=" + actividad.getIdListado()+"&nombreListadoA=" + l_actividades.getNombre()).forward(request, response);
                    break;
                case "Cancelar":
                    lt.setIdTablero(idBoard);
                    request.getRequestDispatcher("Controlador?menu=actividades&accion=showLists&idListadoA=" + actividad.getIdListado()+"&nombreListadoA=" + l_actividades.getNombre()).forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }        

                
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
