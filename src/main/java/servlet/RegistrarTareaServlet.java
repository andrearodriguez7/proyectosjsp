package servlet;

import DAO.ProyectoDAO;
import DAO.TareaDAO;
import entities.Proyecto;
import entities.Tarea;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrarTareaServlet", urlPatterns = {"/RegistrarTareaServlet"})
public class RegistrarTareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        List<Proyecto> proyectos = proyectoDAO.obtenerTodosLosProyectos();
        request.setAttribute("proyectos", proyectos);
        request.getRequestDispatcher("registrarTarea.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener parámetros del formulario
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            String descripcion = request.getParameter("descripcion");
            String responsable = request.getParameter("responsable");
            String estado = request.getParameter("estado");
            String fechaInicioStr = request.getParameter("fechaInicio");
            String fechaFinStr = request.getParameter("fechaFin");

            // Convertir fechas de String a LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, formatter);
            LocalDate fechaFin = LocalDate.parse(fechaFinStr, formatter);

            // Crear tarea
            Tarea tarea = new Tarea();
            tarea.setDescripcionTarea(descripcion);
            tarea.setResponsable(responsable);
            tarea.setFechaInicio(fechaInicio);
            tarea.setFechaFin(fechaFin);
            tarea.setEstado(estado);

            // Asignar proyecto a la tarea
            Proyecto proyecto = new Proyecto();
            proyecto.setId(idProyecto);
            tarea.setProyecto(proyecto);

            // Guardar en la BD
            TareaDAO tareaDAO = new TareaDAO();
            tareaDAO.guardarTarea(tarea);

            // Redirigir a la lista de tareas
            response.sendRedirect("ListarTareasServlet?idProyecto=" + idProyecto);

        } catch (Exception e) {
            response.getWriter().write("Error al registrar la tarea: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

