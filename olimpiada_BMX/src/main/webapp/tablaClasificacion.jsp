<%@ page import="org.example.olimpiada_bmx.model.Competidor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Tabla de Clasificación - Competidores BMX</title>
</head>
<body>
<jsp:include page="encabezado.jsp" />

<h1>Tabla de Clasificación de Competidores de BMX</h1>

<table border="1">
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Fecha de Nacimiento</th>
        <th>País</th>
        <th>Código País</th>
        <th>Ronda</th>
        <th>Puesto</th>
        <th>Descripción</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Obtener la lista de competidores desde la sesión
        List<Competidor> competidores = (List<Competidor>) session.getAttribute("competidores");

        if (competidores != null && !competidores.isEmpty()) {
            for (Competidor competidor : competidores) {
    %>
    <tr>
        <td><%= competidor.getNombre() %></td>
        <td><%= competidor.getApellido() %></td>
        <td><%= competidor.getFechaNacimiento() %></td>
        <td><%= competidor.getPais() %></td>
        <td><%= competidor.getCodePais() %></td>
        <td><%= competidor.getRonda() %></td>
        <td><%= competidor.getPuesto() %></td>
        <td><%= competidor.getDescripcion() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="8">No hay competidores registrados.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="formulario_competidor.jsp">¿Desea inscribir otro competidor?</a>
<br>
<a href="index.jsp">Volver</a>

<jsp:include page="piePagina.jsp" />
</body>
</html>
