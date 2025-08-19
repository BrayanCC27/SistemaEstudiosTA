package Entidades;

public class Facultad {
    private Double id;
    private String nombre;
    private Persona decano;

    public Facultad(Double id, String nombre, Persona decano) {
        this.id = id;
        this.nombre = nombre;
        this.decano = decano;
    }

    public Double getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getDecano() {
        return decano;
    }
}
