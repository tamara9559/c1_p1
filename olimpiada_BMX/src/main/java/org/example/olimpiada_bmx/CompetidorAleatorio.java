package org.example.olimpiada_bmx;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimpiada_bmx.model.Competidor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/competidorAleatorio")
public class CompetidorAleatorio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para generar un competidor aleatorio
        Competidor competidorAleatorio = RandomCompetidor.generarCompetidorAleatorio();

        // Obtener la lista de competidores desde la sesión
        List<Competidor> competidores = (List<Competidor>) request.getSession().getAttribute("competidores");
        if (competidores == null) {
            competidores = new ArrayList<>();
        }

        // Añadir el competidor aleatorio a la lista
        competidores.add(competidorAleatorio);

        // Guardar la lista actualizada en la sesión
        request.getSession().setAttribute("competidores", competidores);

        // Redirigir a la tabla de clasificación
        request.getRequestDispatcher("tablaClasificacion.jsp").forward(request, response);
    }
}

