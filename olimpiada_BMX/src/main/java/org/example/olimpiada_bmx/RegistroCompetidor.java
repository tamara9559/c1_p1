package org.example.olimpiada_bmx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimpiada_bmx.model.Competidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/registro")
public class RegistroCompetidor extends HttpServlet {

    private static final Map<String, String> CODIGOS_PAISES = new HashMap<>();

    static {
        CODIGOS_PAISES.put("Estados Unidos", "USA");
        CODIGOS_PAISES.put("Colombia", "COL");
        CODIGOS_PAISES.put("Rusia", "RUS");
        CODIGOS_PAISES.put("Egipto", "EGY");
        CODIGOS_PAISES.put("Nigeria", "NGR");
        CODIGOS_PAISES.put("Sudáfrica", "RSA");
        CODIGOS_PAISES.put("Brasil", "BRA");
        CODIGOS_PAISES.put("México", "MEX");
        CODIGOS_PAISES.put("China", "CHN");
        CODIGOS_PAISES.put("Japón", "JPN");
        CODIGOS_PAISES.put("Corea del Sur", "KOR");
        CODIGOS_PAISES.put("Arabia Saudita", "KSA");
        CODIGOS_PAISES.put("Francia", "FRA");
        CODIGOS_PAISES.put("Reino Unido", "GBR");
        CODIGOS_PAISES.put("Alemania", "GER");
        CODIGOS_PAISES.put("España", "ESP");
        CODIGOS_PAISES.put("Italia", "ITA");
        CODIGOS_PAISES.put("Australia", "AUS");
        CODIGOS_PAISES.put("Nueva Zelanda", "NZL");
        CODIGOS_PAISES.put("Marruecos", "MAR");
        CODIGOS_PAISES.put("Canadá", "CAN");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaStr = request.getParameter("fecha");
        String nombrePais = request.getParameter("pais");
        String descripcion = request.getParameter("descripcion");

        // Validaciones
        if (nombre == null || apellido == null || fechaStr == null || nombrePais == null || descripcion == null) {
            request.setAttribute("error", "Por favor, completa todos los campos.");
            request.getRequestDispatcher("formulario_competidor.jsp").forward(request, response);
            return;
        }

        // Validar nombre y apellido
        if (nombre.length() > 40 || apellido.length() > 40) {
            request.setAttribute("error", "El nombre o apellido no pueden tener más de 40 caracteres.");
            request.getRequestDispatcher("formulario_competidor.jsp").forward(request, response);
            return;
        }

        // Convertir la fecha
        LocalDate fechaNacimiento;
        try {
            fechaNacimiento = LocalDate.parse(fechaStr);
        } catch (Exception e) {
            request.setAttribute("error", "Formato de fecha inválido.");
            request.getRequestDispatcher("formulario_competidor.jsp").forward(request, response);
            return;
        }

        // Validar la edad
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if (edad < 18 || edad > 30) {
            request.setAttribute("error", "El competidor debe tener entre 18 y 30 años.");
            request.getRequestDispatcher("formulario_competidor.jsp").forward(request, response);
            return;
        }

        // Validar país y obtener su código
        String codigoPais = CODIGOS_PAISES.getOrDefault(nombrePais, "N/A");
        if ("N/A".equals(codigoPais)) {
            request.setAttribute("error", "País seleccionado no válido.");
            request.getRequestDispatcher("formulario_competidor.jsp").forward(request, response);
            return;
        }

        // Validar la descripción
        if (descripcion.length() > 200) {
            request.setAttribute("error", "La descripción no puede tener más de 200 caracteres.");
            request.getRequestDispatcher("formulario_competidor.jsp").forward(request, response);
            return;
        }

        // Inicializar ronda y puesto
        int rondaInicial = 0;
        int puestoInicial = 0;

        // Crear un nuevo competidor
        Competidor competidor = new Competidor(nombre, apellido, fechaNacimiento, nombrePais, codigoPais, puestoInicial, rondaInicial, descripcion);

        // Obtener la lista de competidores desde la sesión
        List<Competidor> competidores = (List<Competidor>) request.getSession().getAttribute("competidores");
        if (competidores == null) {
            competidores = new ArrayList<>();
        }

        // Agregar el nuevo competidor a la lista
        competidores.add(competidor);

        // Guardar la lista actualizada en la sesión
        request.getSession().setAttribute("competidores", competidores);

        // Redirigir a la tabla de clasificación
        request.getRequestDispatcher("tablaClasificacion.jsp").forward(request, response);
    }
}
