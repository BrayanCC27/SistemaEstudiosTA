package DTO;

import Entidades.Persona;

public class PersonaDTO {

    private Double id;
    private String nombres;
    private String apellidos;
    private String email;

    public PersonaDTO(Double id, String nombres, String apellidos, String email) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    private PersonaDTO() {
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

    public static PersonaDTO toDTO(Persona p) {
        if (p == null) {
            return null;
        }
        PersonaDTO dto = new PersonaDTO();
        dto.setId(p.getId());
        dto.setNombres(p.getNombres());
        dto.setApellidos(p.getApellidos());
        dto.setEmail(p.getEmail());
        return dto;
    }

    public Persona toEntity() {
        return new Persona(this.id, this.nombres, this.apellidos, this.email);
    }

}
