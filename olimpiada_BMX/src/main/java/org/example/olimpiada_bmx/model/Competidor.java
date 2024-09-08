package org.example.olimpiada_bmx.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Competidor {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String pais;
    private String codePais;
    private int ronda = 0;
    private int puesto;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodePais() {
        return codePais;
    }

    public void setCodePais(String codePais) {
        this.codePais = codePais;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Competidor(String nombre, String apellido, LocalDate fechaNacimiento, String pais, String codePais, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.codePais = codePais;
        this.descripcion = descripcion;
    }

    public Competidor(String nombre, String apellido, LocalDate fechaNacimiento, String pais, String codePais, int ronda, int puesto, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.codePais = codePais;
        this.ronda = ronda;
        this.puesto = puesto;
        this.descripcion = descripcion;
    }

    public boolean esValidoParaCompetir() {
        int edad = Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
        return edad >= 18 && edad <= 30;
    }


}
