<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>inicio</title>
</head>
<body>
<jsp:include page="encabezado.jsp" />

<h1>Bienvenido </h1>
<h3>que desea hacer?</h3>

<ul>
    <li><a href="formulario_competidor.jsp">¿registrar un competidor?</a></li>
    <li><a href="tablaClasificacion.jsp">ver la tabla de competidores registrados</a></li>
    <li><a href="competidoresClasificacion.jsp">ver los competidores y sus puntuaciones</a></li>


</ul>


<jsp:include page="piePagina.jsp" />
</body>
</html>