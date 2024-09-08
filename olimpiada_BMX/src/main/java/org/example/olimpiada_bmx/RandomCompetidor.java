package org.example.olimpiada_bmx;

import org.example.olimpiada_bmx.model.Competidor;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomCompetidor{

    // Lista de países con sus códigos ISO 3166-1 alpha3
    private static final List<String[]> PAISES = Arrays.asList(
            new String[]{"Estados Unidos", "USA"},
            new String[]{"Colombia", "COL"},
            new String[]{"Rusia", "RUS"},
            new String[]{"Egipto", "EGY"},
            new String[]{"Nigeria", "NGR"},
            new String[]{"Sudáfrica", "RSA"},
            new String[]{"Brasil", "BRA"},
            new String[]{"México", "MEX"},
            new String[]{"China", "CHN"},
            new String[]{"Japón", "JPN"},
            new String[]{"Corea del Sur", "KOR"},
            new String[]{"Arabia Saudita", "KSA"},
            new String[]{"Francia", "FRA"},
            new String[]{"Reino Unido", "GBR"},
            new String[]{"Alemania", "GER"},
            new String[]{"España", "ESP"},
            new String[]{"Italia", "ITA"},
            new String[]{"Australia", "AUS"},
            new String[]{"Nueva Zelanda", "NZL"},
            new String[]{"Canadá", "CAN"}
    );

    private static final Random random = new Random();

    public static Competidor generarCompetidorAleatorio() {
        // Generar nombres y apellidos aleatorios
        String[] nombres = {"Juan", "Luis", "Ana", "Carlos", "Maria", "Pedro", "Lucia", "Marta", "Jorge", "Elena"};
        String[] apellidos = {"Perez", "Gonzalez", "Rodriguez", "Lopez", "Martinez", "Garcia", "Hernandez", "Suarez"};
        String nombre = nombres[random.nextInt(nombres.length)];
        String apellido = apellidos[random.nextInt(apellidos.length)];

        // Generar una fecha de nacimiento aleatoria (entre 18 y 30 años)
        LocalDate fechaNacimiento = generarFechaNacimientoAleatoria();

        // Elegir país y código aleatorio
        String[] paisYcodigo = PAISES.get(random.nextInt(PAISES.size()));
        String nombrePais = paisYcodigo[0];
        String codigoPais = paisYcodigo[1];

        // Descripción aleatoria
        String descripcion = "Competidor de BMX con experiencia en varios campeonatos.";

        // Crear y devolver el objeto Competidor
        Competidor competidor = new Competidor(nombre, apellido, fechaNacimiento, nombrePais, codigoPais, descripcion);
        return competidor;
    }

    // Función auxiliar para generar una fecha de nacimiento aleatoria
    private static LocalDate generarFechaNacimientoAleatoria() {
        int edadAleatoria = 18 + random.nextInt(13); // Edad entre 18 y 30
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.minusYears(edadAleatoria).withDayOfYear(1 + random.nextInt(fechaActual.lengthOfYear()));
    }
}

