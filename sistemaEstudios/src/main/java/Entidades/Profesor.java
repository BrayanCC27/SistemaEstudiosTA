package Entidades;

public class Profesor extends Persona {
    private String TipoContrato;

    public Profesor(Double Id, String nombres, String apellidos, String email, String TipoContrato) {
        super(Id, nombres, apellidos, email);
        this.TipoContrato = TipoContrato;
    }

    public String getTipoContrato() {
        return TipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        TipoContrato = tipoContrato;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                super.toString() +
                "TipoContrato='" + TipoContrato + '\'' +
                "} ";
    }
}
