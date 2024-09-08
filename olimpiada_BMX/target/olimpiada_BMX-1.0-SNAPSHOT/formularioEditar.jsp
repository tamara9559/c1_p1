<%@ page import="org.example.olimpiada_bmx.model.Competidor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Competidor</title>
</head>
<body>
<jsp:include page="encabezado.jsp" />

<h1>Editar Competidor</h1>

<%
    Competidor competidor = (Competidor) request.getAttribute("competidor");
    int indice = (Integer) request.getAttribute("indice");
%>

<form action="guardarEdicionCompetidor" method="post">
    <input type="hidden" name="indice" value="<%= indice %>" />

    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" value="<%= competidor.getNombre() %>" required , id="nombre" /><br/>

    <label for="apellido">Apellido:</label>
    <input type="text" name="apellido" value="<%= competidor.getApellido() %>" required , id="apellido" /><br/>

    <label for="pais">País:</label>
    <input type="text" name="pais" value="<%= competidor.getPais() %>" required , id="pais" /><br/>

    <label for="ronda">Ronda:</label>
    <input type="number" name="ronda" value="<%= competidor.getRonda() %>" required , id="ronda"/><br/>

    <label for="puesto">Puesto:</label>
    <input type="number" name="puesto" value="<%= competidor.getPuesto() %>" required , id="puesto"/><br/>

    <input type="submit" value="Guardar cambios" />
</form>

<a href="tablaClasificacion.jsp">Cancelar</a>


<jsp:include page="piePagina.jsp" />
</body>
</html>
