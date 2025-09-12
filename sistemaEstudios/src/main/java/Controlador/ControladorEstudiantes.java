package Controlador;

import GUI.JPanelEstudiantes;
import Entidades.Estudiante;
import Entidades.Programa;
import Persistencia.DAO.EstudianteDAO;
import Persistencia.DAO.ProgramaDAO;
import javax.swing.JOptionPane;

/**
 * Controlador específico para el manejo de Estudiantes
 * Aplica el patrón Controller de GRASP
 */
public class ControladorEstudiantes {
    
    private JPanelEstudiantes vista;
    private EstudianteDAO estudianteDAO;
    private ProgramaDAO programaDAO;
    
    public ControladorEstudiantes(JPanelEstudiantes vista) {
        this.vista = vista;
        this.estudianteDAO = new EstudianteDAO();
        this.programaDAO = new ProgramaDAO();
    }
    
    /**
     * Maneja la inscripción de un nuevo estudiante
     * Aplica el patrón Information Expert - el controlador conoce qué validaciones aplicar
     */
    public void inscribirEstudiante() {
        try {
            // Obtener datos de la vista
            String idStr = vista.getIDEstudiante();
            String nombres = vista.getNombresEstudiante();
            String apellidos = vista.getApellidosEstudiante();
            String email = vista.getEmailEstudiante();
            String codigoStr = vista.getCodigo();
            String idProgramaStr = vista.getIDPrograma();
            boolean activo = vista.isActivo();
            String promedioStr = vista.getPromedio();
            
            // Validaciones básicas
            if (idStr.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || 
                email.isEmpty() || codigoStr.isEmpty() || idProgramaStr.isEmpty() || promedioStr.isEmpty()) {
                vista.mostrarMensaje("Todos los campos son obligatorios", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Conversiones
            Double id = Double.valueOf(idStr);
            Double codigo = Double.valueOf(codigoStr);
            Double idPrograma = Double.valueOf(idProgramaStr);
            Double promedio = Double.valueOf(promedioStr);
            
            // Validación de email básica
            if (!email.contains("@")) {
                vista.mostrarMensaje("El email no tiene un formato válido", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validación de promedio
            if (promedio < 0.0 || promedio > 5.0) {
                vista.mostrarMensaje("El promedio debe estar entre 0.0 y 5.0", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Obtener programa
            Programa programa = programaDAO.obtenerPorId(idPrograma);
            if (programa == null) {
                vista.mostrarMensaje("No se encontró un programa con el ID especificado", 
                                   "Error", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Crear y guardar estudiante
            Estudiante estudiante = new Estudiante(id, nombres, apellidos, email, codigo, programa, activo, promedio);
            estudianteDAO.crear(estudiante);
            
            // Mostrar éxito
            vista.mostrarMensaje("Estudiante inscrito exitosamente", 
                               "Éxito", 
                               JOptionPane.INFORMATION_MESSAGE);
            
            // Limpiar campos
            vista.limpiarCampos();
            
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Los campos numéricos deben tener un formato válido", 
                               "Error de formato", 
                               JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            vista.mostrarMensaje("Error al inscribir estudiante: " + e.getMessage(), 
                               "Error", 
                               JOptionPane.ERROR_MESSAGE);
        }
    }
}