package servlet;

import DAO.ProyectoDAO;
import entities.Proyecto;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrarProyectoServlet", urlPatterns = {"/RegistrarProyectoServlet"})
public class RegistrarProyectoServlet extends HttpServlet {

    // Método para manejar solicitudes POST (cuando se envía el formulario)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        LocalDate fechaInicio = LocalDate.parse(request.getParameter("fechaInicio"));
        LocalDate fechaFin = LocalDate.parse(request.getParameter("fechaFin"));
        String estado = request.getParameter("estado");  // Estado recibido como String

        // Crear un nuevo proyecto
        Proyecto proyecto = new Proyecto();
        proyecto.setNombreProyecto(nombre);
        proyecto.setDescripcion(descripcion);
        proyecto.setFechaInicio(fechaInicio);
        proyecto.setFechaFin(fechaFin);
        proyecto.setEstado(estado);  // Establecer el estado como String

        // Guardar el proyecto en la base de datos
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        proyectoDAO.guardarProyecto(proyecto);

        // Redirigir a la página del menú
        response.sendRedirect("index.jsp");
    }

    // Método para manejar solicitudes GET (cuando se accede directamente al servlet)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si se hace una solicitud GET, simplemente redirigir al formulario de registro de proyecto
        request.getRequestDispatcher("/registrarProyecto.jsp").forward(request, response);
    }
}
