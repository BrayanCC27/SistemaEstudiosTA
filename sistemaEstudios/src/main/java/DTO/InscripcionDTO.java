package DTO;

import Entidades.Curso;
import Entidades.Estudiante;
import Entidades.Inscripcion;

public class InscripcionDTO {

    private Integer anio;
    private Integer semestre;
    private int cursoId;
    private String cursoNombre;
    private Double estudianteId;
    private String estudianteNombres;
    private String estudianteApellidos;

    public InscripcionDTO(Integer anio, Integer semestre, int cursoId, String cursoNombre, Double estudianteId, String estudianteNombres, String estudianteApellidos) {
        this.anio = anio;
        this.semestre = semestre;
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
        this.estudianteId = estudianteId;
        this.estudianteNombres = estudianteNombres;
        this.estudianteApellidos = estudianteApellidos;
    }

    private InscripcionDTO() {
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public Double getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Double estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getEstudianteNombres() {
        return estudianteNombres;
    }

    public void setEstudianteNombres(String estudianteNombres) {
        this.estudianteNombres = estudianteNombres;
    }

    public String getEstudianteApellidos() {
        return estudianteApellidos;
    }

    public void setEstudianteApellidos(String estudianteApellidos) {
        this.estudianteApellidos = estudianteApellidos;
    }

    public static InscripcionDTO fromEntity(Inscripcion i) {
        if (i == null) {
            return null;
        }
        InscripcionDTO dto = new InscripcionDTO();
        dto.setAnio(i.getAnio());
        dto.setSemestre(i.getSemestre());
        if (i.getCurso() != null) {
            dto.setCursoId(i.getCurso().getId());
            dto.setCursoNombre(i.getCurso().getNombre());
        }
        if (i.getEstudiante() != null) {
            dto.setEstudianteId(i.getEstudiante().getId());
            dto.setEstudianteNombres(i.getEstudiante().getNombres());
            dto.setEstudianteApellidos(i.getEstudiante().getApellidos());
        }
        return dto;
    }

    public Inscripcion toEntity(Curso curso, Estudiante estudiante) {
        return new Inscripcion(curso, this.anio, this.semestre, estudiante);
    }

}
