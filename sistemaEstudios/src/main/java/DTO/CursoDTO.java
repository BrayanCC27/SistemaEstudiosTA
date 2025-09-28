package DTO;

import Entidades.Curso;
import Entidades.Programa;

public class CursoDTO {

    private int id;
    private String nombre;
    private boolean activo;
    private Double programaId;
    private String programaNombre;

    public CursoDTO(int id, String nombre, Double programaId, String programaNombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
        this.programaId = programaId;
        this.programaNombre = programaNombre;
    }

    public CursoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Double getProgramaId() {
        return programaId;
    }

    public void setProgramaId(Double programaId) {
        this.programaId = programaId;
    }

    public String getProgramaNombre() {
        return programaNombre;
    }

    public void setProgramaNombre(String programaNombre) {
        this.programaNombre = programaNombre;
    }

    public static CursoDTO toDTO(Curso c) {
        if (c == null) {
            return null;
        }
        CursoDTO dto = new CursoDTO();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setActivo(c.isActivo());
        if (c.getPrograma() != null) {
            dto.setProgramaId(c.getPrograma().getId());
            dto.setProgramaNombre(c.getPrograma().getNombre());
        }
        return dto;
    }

    public Curso toEntity(Programa programa) {
        return new Curso(this.id, this.nombre, programa, this.activo);
    }

}
