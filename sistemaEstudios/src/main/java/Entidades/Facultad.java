package Entidades;

public class  Facultad {
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

    public void setId(Double id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDecano(Persona decano) {
        this.decano = decano;
    }

    @Override
    public String toString() {
        return "Facultad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", decano=" + decano +
                '}';
    }
}
