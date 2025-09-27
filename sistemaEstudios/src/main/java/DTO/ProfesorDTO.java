package DTO;

import Entidades.Profesor;

public class ProfesorDTO {

    private Double id;
    private String nombres;
    private String apellidos;
    private String email;
    private String tipoContrato;

    public ProfesorDTO(Double id, String nombres, String apellidos, String email, String tipoContrato) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.tipoContrato = tipoContrato;
    }

    private ProfesorDTO() {
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public static ProfesorDTO fromEntity(Profesor p) {
        if (p == null) {
            return null;
        }
        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(p.getId());
        dto.setNombres(p.getNombres());
        dto.setApellidos(p.getApellidos());
        dto.setEmail(p.getEmail());
        dto.setTipoContrato(p.getTipoContrato());
        return dto;
    }

    public Profesor toEntity() {
        return new Profesor(this.id, this.nombres, this.apellidos, this.email, this.tipoContrato);
    }

}
