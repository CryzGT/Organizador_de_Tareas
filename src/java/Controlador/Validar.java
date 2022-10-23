package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validar extends HttpServlet {

    UsuarioDAO udao = new UsuarioDAO();
    Usuario us = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

           System.out.println("Esto sale en pantalla\n");
        if (accion.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            us = udao.Validar(user, pass);

            if (us.getLogin() != null) {
                request.setAttribute("USUARIO", us);
                request.getRequestDispatcher("Controlador?menu=Principal&usuario=").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } if(accion.equals("Crear Cuenta")) {
            request.getRequestDispatcher("Controlador?menu=newUser").forward(request, response);
        }
        
        else {
             request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
