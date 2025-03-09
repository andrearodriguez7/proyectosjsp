<%@ page import="java.util.List, entities.Proyecto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registrar Tarea</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Registrar Nueva Tarea</h2>

    <form action="RegistrarTareaServlet" method="post">
        <!-- Proyecto -->
        <div class="mb-3">
            <label for="idProyecto" class="form-label">Proyecto Asociado</label>
            <select name="idProyecto" id="idProyecto" class="form-select" required>
                <option value="">Seleccione un proyecto</option>
                <%
                    List<Proyecto> proyectos = (List<Proyecto>) request.getAttribute("proyectos");
                    if (proyectos != null) {
                        for (Proyecto proyecto : proyectos) {
                %>
                            <option value="<%= proyecto.getId() %>"><%= proyecto.getNombreProyecto()%></option>
                <%
                        }
                    }
                %>
            </select>
        </div>

        <!-- Descripción -->
        <div class="mb-3">
            <label for="descripcion" class="form-label">Descripción</label>
            <input type="text" name="descripcion" id="descripcion" class="form-control" required>
        </div>

        <!-- Responsable -->
        <div class="mb-3">
            <label for="responsable" class="form-label">Responsable</label>
            <input type="text" name="responsable" id="responsable" class="form-control" required>
        </div>

        <!-- Fecha Inicio -->
        <div class="mb-3">
            <label for="fechaInicio" class="form-label">Fecha de Inicio</label>
            <input type="date" name="fechaInicio" id="fechaInicio" class="form-control" required>
        </div>

        <!-- Fecha Fin -->
        <div class="mb-3">
            <label for="fechaFin" class="form-label">Fecha de Fin</label>
            <input type="date" name="fechaFin" id="fechaFin" class="form-control" required>
        </div>

        <!-- Estado -->
        <div class="mb-3">
            <label for="estado" class="form-label">Estado</label>
            <select name="estado" id="estado" class="form-select" required>
                <option value="pendiente">Pendiente</option>
                <option value="en progreso">En Progreso</option>
                <option value="completada">Completada</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Registrar Tarea</button>
    </form>
</body>
</html>




