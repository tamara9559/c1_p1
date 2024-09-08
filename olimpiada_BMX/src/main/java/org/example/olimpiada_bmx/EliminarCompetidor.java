package org.example.olimpiada_bmx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimpiada_bmx.model.Competidor;

import java.io.IOException;
import java.util.List;

@WebServlet("/eliminarCompetidor")
public class EliminarCompetidor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el índice del competidor desde el formulario
        String indiceStr = request.getParameter("indice");
        int indice = Integer.parseInt(indiceStr);

        // Obtener la lista de competidores de la sesión
        List<Competidor> competidores = (List<Competidor>) request.getSession().getAttribute("competidores");

        if (competidores != null && indice >= 0 && indice < competidores.size()) {
            // Eliminar el competidor en el índice dado
            competidores.remove(indice);
            // Actualizar la lista en la sesión
            request.getSession().setAttribute("competidores", competidores);
        }

        // Redirigir a la página con la lista de competidores actualizada
        response.sendRedirect("tablaClasificacion.jsp");
    }
}
