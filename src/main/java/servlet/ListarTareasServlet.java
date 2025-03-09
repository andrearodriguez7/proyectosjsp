package servlet;

import DAO.TareaDAO;
import entities.Tarea;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarTareasServlet", urlPatterns = {"/ListarTareasServlet"})
public class ListarTareasServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String idProyectoStr = request.getParameter("idProyecto");

// Depuración: Verificar si se pasa el parámetro correctamente
System.out.println("Valor de idProyectoStr: " + idProyectoStr);

if (idProyectoStr == null || idProyectoStr.isEmpty()) {
    response.getWriter().write("Error: idProyecto es nulo o vacío.");
    return;
}


        try {
            int idProyecto = Integer.parseInt(idProyectoStr);
            System.out.println("ID Proyecto recibido: " + idProyecto);

            TareaDAO tareaDAO = new TareaDAO();
            List<Tarea> tareas = tareaDAO.listarTareasPorProyecto(idProyecto);

            // Depuración: Imprimir tareas obtenidas
            if (tareas == null || tareas.isEmpty()) {
                System.out.println("No hay tareas para el proyecto ID: " + idProyecto);
            } else {
                System.out.println("Tareas encontradas para el proyecto ID: " + idProyecto);
                for (Tarea tarea : tareas) {
                    System.out.println("Tarea ID: " + tarea.getId() + ", Descripción: " + tarea.getDescripcionTarea() +
                                       ", Responsable: " + tarea.getResponsable() + ", Estado: " + tarea.getEstado());
                }
            }

            // Pasar las tareas y el ID del proyecto al JSP
            request.setAttribute("tareas", tareas);
            request.setAttribute("idProyecto", idProyecto);
            request.getRequestDispatcher("listaTareas.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.getWriter().write("Error: idProyecto debe ser un número.");
        }
    }
}

