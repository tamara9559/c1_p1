package org.example.olimpiada_bmx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimpiada_bmx.model.Competidor;

import java.io.IOException;
import java.util.List;

@WebServlet("/editarCompetidor")
public class EditarCompetidor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el índice del competidor
        String indiceStr = request.getParameter("indice");
        int indice = Integer.parseInt(indiceStr);

        // Obtener la lista de competidores de la sesión
        List<Competidor> competidores = (List<Competidor>) request.getSession().getAttribute("competidores");

        if (competidores != null && indice >= 0 && indice < competidores.size()) {
            // Obtener el competidor seleccionado
            Competidor competidor = competidores.get(indice);

            // Guardar el competidor en el request para el formulario de edición
            request.setAttribute("competidor", competidor);
            request.setAttribute("indice", indice);

            // Redirigir al formulario de edición
            request.getRequestDispatcher("formularioEditar.jsp").forward(request, response);
        } else {
            // Redirigir a la página con la lista de competidores si algo falla
            response.sendRedirect("tablaClasificacion.jsp");
        }
    }
}

