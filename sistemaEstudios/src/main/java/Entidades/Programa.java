package Entidades;

import java.util.Date;

public class Programa {
    private Double Id;
    private String nombre;
    private Double duracion;
    private Date registro;
    private Facultad facultad;

    public Programa(Double id, String nombre, Double duracion, Date registro, Facultad facultad) {
        this.Id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
    }

    public Double getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getDuracion() {
        return duracion;
    }

    public Date getRegistro() {
        return registro;
    }

    public Facultad getFacultad() {
        return facultad;
    }
}
