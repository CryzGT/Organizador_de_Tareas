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

public class Controlador extends HttpServlet {

    TableroDAO tdao = new TableroDAO();
    Tablero ab = new Tablero();
    ListasDAO ldao = new ListasDAO();
    Listas lt = new Listas();

    public Controlador() {
    }
    int idUser, idBoard;
    String nameBoard;

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
