package Controlador;

import GUI.VentanaPrincipalRefactorizada;
import Interfaces.Servicios;

/**
 * Controlador Principal refactorizado que coordina todos los controladores específicos
 * Aplica el patrón Controller de GRASP como coordinador general
 * Sigue el principio de Responsabilidad Única: solo coordina, no maneja lógica específica
 */
public class ControladorPrincipalRefactorizado {

    private VentanaPrincipalRefactorizada vista;
    private Servicios servicios;
    
    // Controladores específicos (delegación de responsabilidades)
    private ControladorPersonas controladorPersonas;
    private ControladorEstudiantes controladorEstudiantes;
    private ControladorProfesores controladorProfesores;
    private ControladorCursoProfesor controladorCursoProfesor;

    public ControladorPrincipalRefactorizado(VentanaPrincipalRefactorizada vista, Servicios servicios) {
        this.vista = vista;
        this.servicios = servicios;
        
        // Obtener referencias a los controladores específicos ya creados por la vista
        this.controladorPersonas = vista.getControladorPersonas();
        this.controladorEstudiantes = vista.getControladorEstudiantes();
        this.controladorProfesores = vista.getControladorProfesores();
        this.controladorCursoProfesor = vista.getControladorCursoProfesor();
        
        // Aquí se podrían configurar comunicaciones entre controladores si fuera necesario
        // Por ejemplo, si un controlador necesita notificar a otro sobre cambios
    }
    
    /**
     * Método para operaciones que requieran coordinación entre múltiples controladores
     */
    public void coordinarOperacionCompleja() {
        // Ejemplo de una operación que requiere múltiples controladores
        // Por ejemplo, si al eliminar una persona también se deben eliminar sus estudiantes asociados
    }
    
    /**
     * Método para manejar eventos globales de la aplicación
     */
    public void manejarEventoGlobal(String tipoEvento) {
        switch (tipoEvento) {
            case "ACTUALIZAR_DATOS":
                // Podría notificar a todos los controladores para que actualicen sus datos
                break;
            case "GUARDAR_CAMBIOS":
                // Podría coordinar el guardado de cambios en todos los módulos
                break;
            default:
                System.out.println("Evento no reconocido: " + tipoEvento);
        }
    }
    
    // Getters para acceso a controladores específicos si fuera necesario
    public ControladorPersonas getControladorPersonas() {
        return controladorPersonas;
    }
    
    public ControladorEstudiantes getControladorEstudiantes() {
        return controladorEstudiantes;
    }
    
    public ControladorProfesores getControladorProfesores() {
        return controladorProfesores;
    }
    
    public ControladorCursoProfesor getControladorCursoProfesor() {
        return controladorCursoProfesor;
    }
}