<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menú Principal</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/styles.css">
</head>
<body class="container mt-5">
    <h2 class="text-center">Menú Principal</h2>
    <nav class="list-group">
        <!-- Enlace a los proyectos en curso -->
        <a href="listaProyecto?estado=EN_CURSO" class="list-group-item list-group-item-action">Proyectos en Curso</a>
        
        <!-- Enlace a los proyectos completados -->
        <a href="listaProyecto?estado=COMPLETADO" class="list-group-item list-group-item-action">Proyectos Completados</a>
        
        <!-- Enlace a todos los proyectos -->
        <a href="listaProyecto" class="list-group-item list-group-item-action">Todos los Proyectos</a>
        
        <!-- Enlace para registrar un nuevo proyecto -->
        <a href="RegistrarProyectoServlet" class="list-group-item list-group-item-action">Registrar Nuevo Proyecto</a>
        
        <!-- Enlace para registrar una nueva tarea -->
        <a href="RegistrarTareaServlet" class="list-group-item list-group-item-action">Registrar Nueva Tarea</a>
    </nav>
</body>
</html>


