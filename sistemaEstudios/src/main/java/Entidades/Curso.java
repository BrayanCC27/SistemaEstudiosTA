package Entidades;

public class Curso {
    private int Id;
    private String nombre;
    private Programa programa;
    private boolean activo;
    public Curso(int Id, String nombre, Programa programa, boolean activo) {
        this.Id = Id;
        this.nombre = nombre;
        this.programa = programa;
        this.activo = activo;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public Programa getPrograma() {
        return programa;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", programa=" + programa +
                ", activo=" + activo +
                '}';
    }
}
