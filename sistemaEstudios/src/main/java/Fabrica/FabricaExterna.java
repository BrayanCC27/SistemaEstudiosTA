package Fabrica;

import Controller.CursoController;
import Controller.CursoProfesorController;
import Controller.EstudianteController;
import Controller.FacultadController;
import Controller.InscripcionController;
import Controller.PersonaController;
import Controller.ProfesorController;
import Controller.ProgramaController;
import DTO.*;
import java.util.ArrayList;
import java.util.List;

public class FabricaExterna {

    private static FabricaExterna estancia;

    private FabricaExterna() {
    }

    private static synchronized void generarInstancia() {
        if (estancia == null) {
            estancia = new FabricaExterna();
        }
    }

    public static FabricaExterna obtenerEstancia() {
        if (estancia == null) {
            generarInstancia();
        }
        return estancia;
    }

    public static CursoDTO obtenerCursoDTO(int id, String nombre, double programaId, String programaNombre, boolean activo) {
        return new CursoDTO(id, nombre, programaId, programaNombre, activo);
    }

// CursoProfesorDTO
    public static CursoProfesorDTO obtenerCursoProfesorDTO(double profesorId, String profesorNombres, String profesorApellidos,
            int ano, int semestre,
            int cursoId, String cursoNombre) {
        return new CursoProfesorDTO(ano, semestre, profesorId, profesorNombres, profesorApellidos, cursoId, cursoNombre);
    }

    public static EstudianteDTO obtenerEstudianteDTO(double id, String nombres, String apellidos, String email,
            Double codigo,Boolean activo, Double promedio,
            double programaId, String programaNombre
            ) {
        return new EstudianteDTO(id, nombres, apellidos, email, codigo, activo, promedio, programaId, programaNombre);
    }

    public static FacultadDTO obtenerFacultadDTO(Double id, String nombre,
            Double decanoId, String decanoNombres, String decanoApellidos) {
        return new FacultadDTO(id, nombre, decanoId, decanoNombres, decanoApellidos);
    }

    public static InscripcionDTO obtenerInscripcionDTO(Integer cursoId, String cursoNombre,
            Integer anio, Integer semestre,
            Double estudianteId, String estudianteNombres, String estudianteApellidos) {
        return new InscripcionDTO(anio, semestre, cursoId, cursoNombre, estudianteId, estudianteNombres, estudianteApellidos);
    }

    public static PersonaDTO obtenerPersonaDTO(Double id, String nombres, String apellidos, String email) {
        return new PersonaDTO(id, nombres, apellidos, email);
    }

    public static ProfesorDTO obtenerProfesorDTO(Double id, String nombres, String apellidos, String email, String tipoContrato) {
        return new ProfesorDTO(id, nombres, apellidos, email, tipoContrato);
    }

    public static ProgramaDTO obtenerProgramaDTO(Double id, String nombre, Double duracion, String registro,
            Double facultadId, String facultadNombre) {
        return new ProgramaDTO(id, nombre, duracion, registro, facultadId, facultadNombre);
    }

    public static CursoController obtenerCursoController() {
        return new CursoController();
    }

    public static EstudianteController obtenerEstudianteController() {
        return new EstudianteController();
    }

    public static PersonaController obtenerPersonaController() {
        return new PersonaController();
    }

    public static ProfesorController obtenerProfesorController() {
        return new ProfesorController();
    }

    public static FacultadController obtenerFacultadController() {
        return new FacultadController();
    }

    public static ProgramaController obtenerProgramaController() {
        return new ProgramaController();
    }

    public static InscripcionController obtenerInscripcionController() {
        return new InscripcionController();
    }

    public static CursoProfesorController obtenerCursoProfesorController() {
        return new CursoProfesorController();
    }

    public static <T> List<T> obtenerArray() {
        return new ArrayList<>();
    }
}
