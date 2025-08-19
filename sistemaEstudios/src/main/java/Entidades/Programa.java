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

    public void setId(Double id) {
        Id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return "Programa{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                ", registro=" + registro +
                ", facultad=" + facultad +
                '}';
    }
}
