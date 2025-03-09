package servlet;

import DAO.ProyectoDAO;
import entities.Proyecto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarProyectoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el estado del parámetro (si se ha enviado)
        String estado = request.getParameter("estado");

        List<Proyecto> proyectos;

        if (estado != null && !estado.isEmpty()) {
            // Si se ha pasado un estado, filtrar los proyectos por estado
            proyectos = ProyectoDAO.obtenerProyectosPorEstado(estado);
        } else {
            // Si no se pasa estado, obtener todos los proyectos
            proyectos = ProyectoDAO.obtenerTodosProyectos();
        }

        // Pasar la lista de proyectos a la JSP
        request.setAttribute("proyectos", proyectos);

        // Redirigir a la JSP de lista de proyectos
        request.getRequestDispatcher("/listaProyecto.jsp").forward(request, response);
    }
}
