package Entidades;

public class Programa {
    private Double id;
    private String nombre;
    private Double duracion;
    private String registro;
    private Facultad facultad;

    public Programa(Double id, String nombre, Double duracion, String registro, Facultad facultad) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
    }

    public Double getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getDuracion() {
        return duracion;
    }

    public String getRegistro() {
        return registro;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return "Programa{" +
                "Id=" + id +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                ", registro=" + registro +
                ", facultad=" + facultad +
                '}';
    }
}
