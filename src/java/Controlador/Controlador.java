
package Controlador;

import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String accion=request.getParameter("accion");
            switch (accion){
                case "Principal":
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                default:
                 request.getRequestDispatcher("Principal.jsp").forward(request, response);   

//throw new AssertionError();
            }
        
        }
    }

 


