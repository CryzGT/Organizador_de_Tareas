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
                case "add":
                    request.getRequestDispatcher("addTarea.jsp").forward(request, response);
                    break;
                case "Agregar":
                    //int id_listado = 1; // Integer.parseInt(request.getParameter("txtlistado"));
                    int id_estado = 1; //Iniciada
                    int id_usuario_asignado = 1; //Admin - cambiar  
                    String estado = null;
                    String nombre = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    String fecha_i = request.getParameter("txtfechainicio");
                    String fecha_f = request.getParameter("txtfechafin");
                    
                    tarea.setIdListado(idListadoT);
                    tarea.setIdEstado(id_estado);
                    tarea.setIdUsuarioAsignado(id_usuario_asignado);
                    tarea.setEstado(estado);
                    tarea.setNombre(nombre);
                    tarea.setDescripcion(descripcion);
                    tarea.setFechaInicio(null);
                    tarea.setFechaFin(null);
                    
                    tareaD.agregarTarea(tarea);
                    
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
                    request.getRequestDispatcher("ListadosA.jsp").forward(request, response);
                    break;
                case "add":
                    request.getRequestDispatcher("addListadosA.jsp").forward(request, response);
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
                case "Agregar":
                    
                    int id_listado = 1; // Integer.parseInt(request.getParameter("txtlistado"));
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
