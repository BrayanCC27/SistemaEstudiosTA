package Entidades;

public class Estudiante extends Persona {
    private Double codigo;
    private Programa programa;
    private Boolean activo;
    private Double promedio;

    public Estudiante(Double Id, String nombres, String apellidos, String email, Double codigo, Programa programa, Boolean activo, Double promedio) {
        super(Id, nombres, apellidos, email);
        this.codigo = codigo;
        this.programa = programa;
        this.activo = activo;
        this.promedio = promedio;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                super.toString() +
                "codigo=" + codigo +
                ", programa=" + programa +
                ", activo=" + activo +
                ", promedio=" + promedio +
                "} ";
    }
}
