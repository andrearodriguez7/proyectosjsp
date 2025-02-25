# proyectosjsp

Se pide desarrollar una página web con jsp e hibernate para la persistencia de datos.

Se crearán estas tablas:

proyectos: id (clave primaria), nombre_proyecto, descripcion, fecha_inicio, fecha_fin, estado (en curso o completado).
tareas: id (clave primaria), id_proyecto (clave foránea de proyectos), descripcion_tarea, responsable, fecha_inicio, fecha_fin, estado (pendiente, en progreso o completada).


Los servlets a desarrollar serán:

Mostrar la lista de proyectos (filtrado por estado).
Mostrar un formulario para registrar nuevos proyectos.
Mostrar la lista de tareas de un proyecto específico
Mostrar un formulario para agregar nuevas tareas a un proyecto
Eliminar tareas (esta tarea solo puede llevarse a cabo por un admin)
Eliminar proyectos (esta tarea solo puede llevarse a cabo por un admin)
