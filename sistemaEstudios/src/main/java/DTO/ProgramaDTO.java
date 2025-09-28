package DTO;

import Entidades.Facultad;
import Entidades.Programa;

public class ProgramaDTO {

    private Double id;
    private String nombre;
    private Double duracion;
    private String registro;
    private Double facultadId;
    private String facultadNombre;

    public ProgramaDTO(Double id, String nombre, Double duracion, String registro, Double facultadId, String facultadNombre) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultadId = facultadId;
        this.facultadNombre = facultadNombre;
    }

    public ProgramaDTO() {
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

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Double getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(Double facultadId) {
        this.facultadId = facultadId;
    }

    public String getFacultadNombre() {
        return facultadNombre;
    }

    public void setFacultadNombre(String facultadNombre) {
        this.facultadNombre = facultadNombre;
    }

    public static ProgramaDTO toDTO(Programa p) {
        if (p == null) {
            return null;
        }
        ProgramaDTO dto = new ProgramaDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setDuracion(p.getDuracion());
        dto.setRegistro(p.getRegistro());
        if (p.getFacultad() != null) {
            dto.setFacultadId(p.getFacultad().getId());
            dto.setFacultadNombre(p.getFacultad().getNombre());
        }
        return dto;
    }

    public Programa toEntity(Facultad facultad) {
        return new Programa(this.id, this.nombre, this.duracion, this.registro, facultad);
    }

}
