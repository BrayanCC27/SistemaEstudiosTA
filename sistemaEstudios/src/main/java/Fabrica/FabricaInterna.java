package Fabrica;

import Entidades.*;
import Interfaces.Conexion;
import Persistencia.ConexionH2;
import Persistencia.DAO.*;

public class FabricaInterna {

    private static FabricaInterna estancia;

    private FabricaInterna() {
    }

    private static synchronized void generarInstancia() {
        if (estancia == null) {
            estancia = new FabricaInterna();
        }
    }

    public static FabricaInterna obtenerEstancia() {
        if (estancia == null) {
            generarInstancia();
        }
        return estancia;
    }

    public static Curso obtenerCurso(int Id, String nombre, Programa programa, boolean activo) {
        return new Curso(Id, nombre, programa, activo);
    }

    public static CursoProfesor obtenerCursoProfesor(Profesor profesor, int ano, int semestre, Curso curso) {
        return new CursoProfesor(profesor, ano, semestre, curso);
    }

    public static Estudiante obtenerEstudiante(Double Id, String nombres, String apellidos, String email,
            Double codigo, Programa programa, Boolean activo, Double promedio) {
        return new Estudiante(Id, nombres, apellidos, email, codigo, programa, activo, promedio);
    }

    public static Facultad obtenerFacultad(Double id, String nombre, Persona decano) {
        return new Facultad(id, nombre, decano);
    }

    public static Inscripcion obtenerInscripcion(Curso curso, Integer anio, Integer semestre, Estudiante estudiante) {
        return new Inscripcion(curso, anio, semestre, estudiante);
    }

    public static Persona obtenerPersona(Double Id, String nombres, String apellidos, String email) {
        return new Persona(Id, nombres, apellidos, email);
    }

    public static Profesor obtenerProfesor(Double Id, String nombres, String apellidos, String email, String TipoContrato) {
        return new Profesor(Id, nombres, apellidos, email, TipoContrato);
    }

    public static Programa obtenerPrograma(Double id, String nombre, Double duracion, String registro, Facultad facultad) {
        return new Programa(id, nombre, duracion, registro, facultad);
    }

    public static CursoDAO obtenerCursoDAO() {
        return new CursoDAO();
    }

    public static EstudianteDAO obtenerEstudianteDAO() {
        return new EstudianteDAO();
    }

    public static FacultadDAO obtenerFacultadDAO() {
        return new FacultadDAO();
    }

    public static PersonaDAO obtenerPersonaDAO() {
        return new PersonaDAO();
    }

    public static ProfesorDAO obtenerProfesorDAO() {
        return new ProfesorDAO();
    }

    public static ProgramaDAO obtenerProgramaDAO() {
        return new ProgramaDAO();
    }
    
    public static Conexion obtenerConexion(){
        return ConexionH2.getInstancia();
        //TODO: generar conexion segun properties
    }
}
