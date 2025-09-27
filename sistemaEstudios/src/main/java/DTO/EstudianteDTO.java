package DTO;

import Entidades.Estudiante;
import Entidades.Programa;

public class EstudianteDTO {

    private Double id;
    private String nombres;
    private String apellidos;
    private String email;
    private Double codigo;
    private Boolean activo;
    private Double promedio;
    private Double programaId;
    private String programaNombre;

    public EstudianteDTO(Double id, String nombres, String apellidos, String email, Double codigo, Boolean activo, Double promedio, Double programaId, String programaNombre) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.codigo = codigo;
        this.activo = activo;
        this.promedio = promedio;
        this.programaId = programaId;
        this.programaNombre = programaNombre;
    }

    private EstudianteDTO() {
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

    public static EstudianteDTO fromEntity(Estudiante e) {
        if (e == null) {
            return null;
        }
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(e.getId());
        dto.setNombres(e.getNombres());
        dto.setApellidos(e.getApellidos());
        dto.setEmail(e.getEmail());
        dto.setCodigo(e.getCodigo());
        dto.setActivo(e.getActivo());
        dto.setPromedio(e.getPromedio());
        if (e.getPrograma() != null) {
            dto.setProgramaId(e.getPrograma().getId());
            dto.setProgramaNombre(e.getPrograma().getNombre());
        }
        return dto;
    }

    public Estudiante toEntity(Programa programa) {
        return new Estudiante(this.id, this.nombres, this.apellidos, this.email,
                this.codigo, programa, this.activo, this.promedio);
    }

}
