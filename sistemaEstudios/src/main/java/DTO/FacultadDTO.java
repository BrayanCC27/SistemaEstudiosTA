package DTO;

import Entidades.Facultad;
import Entidades.Persona;

public class FacultadDTO {

    private Double id;
    private String nombre;
    private Double decanoId;
    private String decanoNombres;
    private String decanoApellidos;

    public FacultadDTO(Double id, String nombre, Double decanoId, String decanoNombres, String decanoApellidos) {
        this.id = id;
        this.nombre = nombre;
        this.decanoId = decanoId;
        this.decanoNombres = decanoNombres;
        this.decanoApellidos = decanoApellidos;
    }

    private FacultadDTO() {
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDecanoId() {
        return decanoId;
    }

    public void setDecanoId(Double decanoId) {
        this.decanoId = decanoId;
    }

    public String getDecanoNombres() {
        return decanoNombres;
    }

    public void setDecanoNombres(String decanoNombres) {
        this.decanoNombres = decanoNombres;
    }

    public String getDecanoApellidos() {
        return decanoApellidos;
    }

    public void setDecanoApellidos(String decanoApellidos) {
        this.decanoApellidos = decanoApellidos;
    }

    public static FacultadDTO toDTO(Facultad f) {
        if (f == null) {
            return null;
        }
        FacultadDTO dto = new FacultadDTO();
        dto.setId(f.getId());
        dto.setNombre(f.getNombre());
        if (f.getDecano() != null) {
            dto.setDecanoId(f.getDecano().getId());
            dto.setDecanoNombres(f.getDecano().getNombres());
            dto.setDecanoApellidos(f.getDecano().getApellidos());
        }
        return dto;
    }

    public Facultad toEntity(Persona decano) {
        return new Facultad(this.id, this.nombre, decano);
    }

}
