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
import Persistencia.SQLbase;
import Vista.ConsolaObservador;
import Vista.ConsolaPrincipal;
import Vista.VentanaPrincipal;
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

    public static CursoProfesorDTO obtenerCursoProfesorDTO(double profesorId, String profesorNombres, String profesorApellidos,
            int ano, int semestre,
            int cursoId, String cursoNombre) {
        return new CursoProfesorDTO(ano, semestre, profesorId, profesorNombres, profesorApellidos, cursoId, cursoNombre);
    }
    
    public static CursoProfesorDTO obtenerCursoProfesorDTO(double profesorId, 
            int cursoId, int ano, int semestre) {
        return new CursoProfesorDTO(ano, semestre, profesorId, "", "", cursoId, "");
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
        return CursoController.obtenerInstancia();
    }

    public static EstudianteController obtenerEstudianteController() {
        return EstudianteController.obtenerInstancia();
    }

    public static PersonaController obtenerPersonaController() {
        return PersonaController.obtenerInstancia();
    }

    public static ProfesorController obtenerProfesorController() {
        return ProfesorController.obtenerInstancia();
    }

    public static FacultadController obtenerFacultadController() {
        return FacultadController.obtenerInstancia();
    }

    public static ProgramaController obtenerProgramaController() {
        return ProgramaController.obtenerInstancia();
    }

    public static InscripcionController obtenerInscripcionController() {
        return InscripcionController.obtenerInstancia();
    }

    public static CursoProfesorController obtenerCursoProfesorController() {
        return CursoProfesorController.obtenerInstancia();
    }

    public static <T> List<T> obtenerArray() {
        return new ArrayList<>();
    }
    
    public static SQLbase obtenerSQLbase(){
        return new SQLbase();
    }
    
    public static ConsolaPrincipal ObtenerConsolaPrincipal(){
        return new ConsolaPrincipal();
    }
    
    public static ConsolaObservador ObtenerConsolaObservador(){
        return new ConsolaObservador();
    }
    
    public static VentanaPrincipal ObtenerVistaGUI(){
        return new VentanaPrincipal();
    }
   
}
