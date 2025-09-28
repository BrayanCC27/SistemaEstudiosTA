/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Entidades.Curso;
import Entidades.CursoProfesor;
import Entidades.Profesor;

public class CursoProfesorDTO {

    private int ano;
    private int semestre;
    private Double profesorId;
    private String profesorNombres;
    private String profesorApellidos;
    private int cursoId;
    private String cursoNombre;

    public CursoProfesorDTO(int ano, int semestre, Double profesorId, String profesorNombres, String profesorApellidos, int cursoId, String cursoNombre) {
        this.ano = ano;
        this.semestre = semestre;
        this.profesorId = profesorId;
        this.profesorNombres = profesorNombres;
        this.profesorApellidos = profesorApellidos;
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
    }

    private CursoProfesorDTO() {
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Double getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Double profesorId) {
        this.profesorId = profesorId;
    }

    public String getProfesorNombres() {
        return profesorNombres;
    }

    public void setProfesorNombres(String profesorNombres) {
        this.profesorNombres = profesorNombres;
    }

    public String getProfesorApellidos() {
        return profesorApellidos;
    }

    public void setProfesorApellidos(String profesorApellidos) {
        this.profesorApellidos = profesorApellidos;
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

    public static CursoProfesorDTO toDTO(CursoProfesor cp) {
        if (cp == null) {
            return null;
        }
        CursoProfesorDTO dto = new CursoProfesorDTO();
        dto.setAno(cp.getAno());
        dto.setSemestre(cp.getSemestre());
        if (cp.getProfesor() != null) {
            dto.setProfesorId(cp.getProfesor().getId());
            dto.setProfesorNombres(cp.getProfesor().getNombres());
            dto.setProfesorApellidos(cp.getProfesor().getApellidos());
        }
        if (cp.getCurso() != null) {
            dto.setCursoId(cp.getCurso().getId());
            dto.setCursoNombre(cp.getCurso().getNombre());
        }
        return dto;
    }

    public CursoProfesor toEntity(Profesor profesor, Curso curso) {
        return new CursoProfesor(profesor, this.ano, this.semestre, curso);
    }

}
