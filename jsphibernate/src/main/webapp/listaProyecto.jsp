<%@ page import="java.util.List, entities.Proyecto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Proyectos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Lista de Proyectos</h2>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Proyecto> proyectos = (List<Proyecto>) request.getAttribute("proyectos");
                if (proyectos != null && !proyectos.isEmpty()) {
                    for (Proyecto proyecto : proyectos) {
            %>
            <tr>
                <td><%= proyecto.getNombreProyecto() != null ? proyecto.getNombreProyecto() : "No disponible" %></td>
                <td><%= proyecto.getDescripcion() != null ? proyecto.getDescripcion() : "No disponible" %></td>
                <td><%= proyecto.getFechaInicio() != null ? proyecto.getFechaInicio() : "No disponible" %></td>
                <td><%= proyecto.getFechaFin() != null ? proyecto.getFechaFin() : "No disponible" %></td>
                <td><%= proyecto.getEstado() != null ? proyecto.getEstado() : "No disponible" %></td>
                <td>
                    <a href="/jsphibernate/listarTarea.jsp?idProyecto=<%= proyecto.getId() %>" class="btn btn-primary btn-sm">Ver Tareas</a>
                    <form action="/jsphibernate/eliminarProyecto" method="post" style="display:inline;">
                        <input type="hidden" name="idProyecto" value="<%= proyecto.getId() %>">
                        <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
                    </form>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="6" class="text-center">No hay proyectos para mostrar.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>


