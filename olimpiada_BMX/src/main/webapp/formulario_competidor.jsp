<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Formulario de inscripción</title>
</head>
<body>
<jsp:include page="encabezado.jsp" />

<h1>Formulario para inscribir los competidores.</h1>

<form action="registro" method="post">
    <div>
        <label for="nombre">Nombre:</label>
        <div><input type="text" name="nombre" id="nombre" maxlength="40" required></div>
    </div>
    <div>
        <label for="apellido">Apellido:</label>
        <div><input type="text" name="apellido" id="apellido" maxlength="40" required></div>
    </div>
    <div>
        <label for="fecha">Fecha de nacimiento:</label>
        <div><input type="date" name="fecha" id="fecha" required></div>
    </div>
    <div>
        <label for="pais">País:</label>
        <div>
            <select name="pais" id="pais" required>
                <option value="">-- Seleccionar --</option>
                <option>Estados Unidos</option>
                <option>Colombia</option>
                <option>Rusia</option>
                <option>Egipto</option>
                <option>Nigeria</option>
                <option>Sudáfrica</option>
                <option>Brasil</option>
                <option>México</option>
                <option>China</option>
                <option>Japón</option>
                <option>Corea del Sur</option>
                <option>Arabia Saudita</option>
                <option>Francia</option>
                <option>Reino Unido</option>
                <option>Alemania</option>
                <option>España</option>
                <option>Italia</option>
                <option>Australia</option>
                <option>Nueva Zelanda</option>
                <option>Marruecos</option>
                <option>Canadá</option>
            </select>
        </div>
    </div>
    <div>
        <textarea name="descripcion" rows="10" cols="50" placeholder="descripcion"></textarea>
    </div>
    <input type="submit" value="Registrar" />
</form>

<form action="competidorAleatorio" method="post">
    <input type="submit" value="Crear competidor aleatorio" />
</form>


<jsp:include page="piePagina.jsp" />
</body>
</html>
