package org.example.olimpiada_bmx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimpiada_bmx.model.Competidor;

import java.io.IOException;
import java.util.List;

@WebServlet("/guardarEdicionCompetidor")
public class GuardarEdicion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        int indice = Integer.parseInt(request.getParameter("indice"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String pais = request.getParameter("pais");
        int ronda = Integer.parseInt(request.getParameter("ronda"));
        int puesto = Integer.parseInt(request.getParameter("puesto"));

        // Obtener la lista de competidores de la sesión
        List<Competidor> competidores = (List<Competidor>) request.getSession().getAttribute("competidores");

        if (competidores != null && indice >= 0 && indice < competidores.size()) {
            // Actualizar los datos del competidor
            Competidor competidor = competidores.get(indice);
            competidor.setNombre(nombre);
            competidor.setApellido(apellido);
            competidor.setPais(pais);
            competidor.setRonda(ronda);
            competidor.setPuesto(puesto);

            // Actualizar la lista en la sesión
            request.getSession().setAttribute("competidores", competidores);
        }

        // Redirigir a la tabla de clasificación
        response.sendRedirect("tablaClasificacion.jsp");
    }
}

