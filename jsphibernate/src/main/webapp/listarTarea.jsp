<%@page import="java.util.ArrayList"%>
<%@page import="DAO.TareaDAO"%>
<%@page import="Util.HibernateUtil"%>
<%@page import="java.util.List"%>
<%@page import="entities.Tarea" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Obtener los parámetros de la URL
    String idProyectoStr = request.getParameter("id");
    String nombreProyecto = request.getParameter("nombre");
    String descripcionProyecto = request.getParameter("descripcion");
    String estadoProyecto = request.getParameter("estado");

    // Inicializar idProyecto en 0
    int idProyecto = 0;

    // Lista para almacenar las tareas
    List<Tarea> tareas = new ArrayList<>();

    // Verificar si idProyectoStr no está vacío antes de convertirlo
    if (idProyectoStr != null && !idProyectoStr.trim().isEmpty()) {
        try {
            idProyecto = Integer.parseInt(idProyectoStr.trim());

            // Obtener las tareas del proyecto desde el DAO
            TareaDAO tareaDAO = new TareaDAO();  // Instanciamos TareaDAO sin pasarle la SessionFactory
            tareas = tareaDAO.listarTareasPorProyecto(idProyecto);  // Llamamos al método para obtener las tareas

            // Depuración en consola
            System.out.println("Proyecto ID: " + idProyecto);
            System.out.println("Nombre Proyecto: " + nombreProyecto);
            System.out.println("Descripción Proyecto: " + descripcionProyecto);
            System.out.println("Estado Proyecto: " + estadoProyecto);
            System.out.println("Tareas encontradas: " + tareas.size());

        } catch (NumberFormatException e) {
            System.out.println("Error: ID del proyecto no es un número válido.");
            e.printStackTrace();
        }
    } else {
        System.out.println("Error: ID del proyecto no recibido en la URL.");
    }

    // Enviar atributos al request para JSTL
    request.setAttribute("nombreProyecto", nombreProyecto);
    request.setAttribute("descripcionProyecto", descripcionProyecto);
    request.setAttribute("estadoProyecto", estadoProyecto);
    request.setAttribute("tareas", tareas);
%>

<html>
<head>
    <title>Lista de Tareas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Lista de Tareas</h2>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Descripción</th>
                <th>Responsable</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (tareas != null && !tareas.isEmpty()) {
                    for (Tarea tarea : tareas) {
            %>
                <tr>
                    <td><%= tarea.getDescripcionTarea() %></td>
                    <td><%= tarea.getResponsable() %></td>
                    <td><%= tarea.getFechaInicio() %></td>
                    <td><%= tarea.getFechaFin() != null ? tarea.getFechaFin() : "No definida" %></td>
                    <td><%= tarea.getEstado() %></td>
                    <td>
                        <form action="eliminarTarea" method="post" style="display:inline;">
                            <input type="hidden" name="idTarea" value="<%= tarea.getId() %>">
                            <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
                        </form>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="6" class="text-center">No hay tareas disponibles.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <!-- Botón para añadir tarea -->
    <%
        if (idProyecto != 0) {  // Verificamos si el idProyecto tiene valor
    %>
        <a href="registrarTarea.jsp?id=<%= idProyecto %>&nombre=<%= nombreProyecto %>&descripcion=<%= descripcionProyecto %>&estado=<%= estadoProyecto %>" class="btn btn-success">Añadir Tarea</a>
    <%
        }
    %>
</body>
</html>


