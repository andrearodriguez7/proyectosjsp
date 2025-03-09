<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Proyecto</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2>Registrar Nuevo Proyecto</h2>
    <form action="/jsphibernate/RegistrarProyectoServlet" method="post">
    <div class="form-group">
        <label for="nombre">Nombre del Proyecto:</label>
        <input type="text" class="form-control" id="nombre" name="nombre" required>
    </div>
    <div class="form-group">
        <label for="descripcion">Descripción:</label>
        <textarea class="form-control" id="descripcion" name="descripcion" required></textarea>
    </div>
    <div class="form-group">
        <label for="fechaInicio">Fecha de Inicio:</label>
        <input type="date" class="form-control" id="fechaInicio" name="fechaInicio" required>
    </div>
    <div class="form-group">
        <label for="fechaFin">Fecha de Fin:</label>
        <input type="date" class="form-control" id="fechaFin" name="fechaFin" required>
    </div>
    <div class="form-group">
        <label for="estado">Estado:</label>
        <select class="form-control" id="estado" name="estado" required>
            <option value="EN_CURSO">En curso</option>
            <option value="COMPLETADO">Completado</option>
            <option value="PENDIENTE">Pendiente</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary mt-3">Registrar Proyecto</button>
</form>


    <a href="index.jsp" class="btn btn-secondary mt-3">Volver al Menú</a>
</body>
</html>

