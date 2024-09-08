<%@ page import="org.example.olimpiada_bmx.model.Competidor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Competidores</title>
</head>
<body>

<h1>Lista de Competidores</h1>

<table border="1">
    <thead>
    <tr>
        <th>Apellido</th>
        <th>Nombre</th>
        <th>País</th>
        <th>Ronda</th>
        <th>Puesto</th>
        <th>Acciones</th> <!-- Nueva columna para acciones -->
    </tr>
    </thead>
    <tbody>
    <%
        // Obtener la lista de competidores desde la sesión
        List<Competidor> competidores = (List<Competidor>) session.getAttribute("competidores");

        if (competidores != null && !competidores.isEmpty()) {
            for (int i = 0; i < competidores.size(); i++) {
                Competidor competidor = competidores.get(i);
    %>
    <tr>
        <td><%= competidor.getApellido().toUpperCase() %></td>
        <td><%= competidor.getNombre().toLowerCase() %></td>
        <td><%= competidor.getPais() %></td>
        <td><%= competidor.getRonda() %></td>
        <td><%= competidor.getPuesto() %></td>
        <td>
            <!-- Botón para editar -->
            <form action="editarCompetidor" method="post" style="display:inline;">
                <input type="hidden" name="indice" value="<%= i %>" />
                <input type="submit" value="Editar" />
            </form>

            <!-- Botón para eliminar -->
            <form action="eliminarCompetidor" method="post" style="display:inline;">
                <input type="hidden" name="indice" value="<%= i %>" />
                <input type="submit" value="Eliminar" />
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="6">No hay competidores registrados.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<a href="index.jsp">Volver al inicio</a>

</body>
</html>
