/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Listas;
import Modelo.ListasDAO;
import Modelo.Tablero;
import Modelo.TableroDAO;
import java.util.ArrayList;
import java.util.List;

import Modelo.*; 
/**
 *
 * @author Sofia Paniagua
 */
//@WebServlet(name = "Controlador2", urlPatterns = {"/Controlador2"})
public class Controlador2 extends HttpServlet {


    TableroDAO tdao = new TableroDAO();
    Tablero ab = new Tablero();
    ListasDAO ldao = new ListasDAO();
    Listas lt = new Listas();
    TareaDAO tareaD = new TareaDAO();
    Tarea tarea = new Tarea();
    ListadoActividades l_actividades = new ListadoActividades();
    ListadoActividadesDAO l_actividadesD = new ListadoActividadesDAO();
    Actividad actividad = new Actividad();
    ActividadDAO actividadD = new ActividadDAO();
    
    
    public Controlador2() {
    }
    
    
    int idUser, idBoard, idListadoT, idTarea, idListadoA, idActividad;
    String nameBoard, nombreListadoT, nombreT, nombreListadoA, nombreA;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
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
                    
                    int id_tarea = Integer.parseInt(request.getParameter("txttarea"));
                    String nombre = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    String fecha_hora_creacion ; 
                    int porcentaje_avance = 0;
                    
                    l_actividades.setIdTarea(idTarea);
                    l_actividades.setNombre(nombre);
                    l_actividades.setDescripcion(descripcion);
                    l_actividades.setPorcentajeAvance(porcentaje_avance);
                               
                    l_actividadesD.agregarListadoActividades(l_actividades);
                    
                    request.getRequestDispatcher("Controlador2?menu=listado_a&accion=showLists&idTarea=" + l_actividades.getIdTarea()+"&nombreTarea=" + tarea.getNombre()).forward(request, response);
                    break;
                case "Cancelar":
                    lt.setIdTablero(idBoard);
                    request.getRequestDispatcher("Controlador2?menu=listado_a&accion=showLists&idTarea=" + l_actividades.getIdTarea()+"&nombreTarea=" + tarea.getNombre()).forward(request, response);
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
                    
                    actividad.setIdListado(id_listado);
                    actividad.setNombre(nombre);
                    actividad.setDescripcion(descripcion);
                    actividad.setFinalizada(finalizada);
                               
                    actividadD.agregarActividades(actividad);
                    
                    request.getRequestDispatcher("Controlador2?menu=actividades&accion=showLists&idListadoA=" + actividad.getIdListado()+"&nombreListadoA=" + l_actividades.getNombre()).forward(request, response);
                    break;
                case "Cancelar":
                    lt.setIdTablero(idBoard);
                    request.getRequestDispatcher("Controlador2?menu=actividades&accion=showLists&idListadoA=" + actividad.getIdListado()+"&nombreListadoA=" + l_actividades.getNombre()).forward(request, response);
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
