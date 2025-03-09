package servlet;


import DAO.ProyectoDAO;
import DAO.TareaDAO;
import entities.Proyecto;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminarProyectoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rolUsuario = (String) request.getSession().getAttribute("rol"); // Verifica el rol

        if (rolUsuario == null || !rolUsuario.equals("admin")) {
            response.sendRedirect("error.jsp");
            return;
        }

        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        proyectoDAO.eliminarProyecto(idProyecto);

        response.sendRedirect("menu.jsp");
    }
}
