package Controlador;

import GUI.JPanelPersonas;
import Entidades.Persona;
import Persistencia.DAO.PersonaDAO;
import javax.swing.JOptionPane;

/**
 * Controlador específico para el manejo de Personas
 * Aplica el patrón Controller de GRASP
 */
public class ControladorPersonas {
    
    private JPanelPersonas vista;
    private PersonaDAO personaDAO;
    
    public ControladorPersonas(JPanelPersonas vista) {
        this.vista = vista;
        this.personaDAO = new PersonaDAO();
        // Aquí se podrían inicializar los listeners específicos
    }
    
    /**
     * Maneja la inscripción de una nueva persona
     * Aplica el patrón Information Expert - el controlador conoce qué validaciones aplicar
     */
    public void inscribirPersona() {
        try {
            // Obtener datos de la vista
            String idStr = vista.getIDPersona();
            String nombres = vista.getNombresPersona();
            String apellidos = vista.getApellidosPersona();
            String email = vista.getEmailPersona();
            
            // Validaciones
            if (idStr.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || email.isEmpty()) {
                vista.mostrarMensaje("Todos los campos son obligatorios", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Double id = Double.valueOf(idStr);
            
            // Validación de email básica
            if (!email.contains("@")) {
                vista.mostrarMensaje("El email no tiene un formato válido", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Crear y guardar persona
            Persona persona = new Persona(id, nombres, apellidos, email);
            personaDAO.crear(persona);
            
            // Mostrar éxito
            vista.mostrarMensaje("Persona inscrita exitosamente", 
                               "Éxito", 
                               JOptionPane.INFORMATION_MESSAGE);
            
            // Limpiar campos
            vista.limpiarCampos();
            
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("El ID debe ser un número válido", 
                               "Error de formato", 
                               JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            vista.mostrarMensaje("Error al inscribir persona: " + e.getMessage(), 
                               "Error", 
                               JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Maneja la eliminación de una persona
     */
    public void eliminarPersona() {
        try {
            String idStr = vista.getIDEliminar();
            
            if (idStr.isEmpty()) {
                vista.mostrarMensaje("Debe ingresar un ID para eliminar", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Double id = Double.valueOf(idStr);
            
            // Confirmar eliminación
            int confirmacion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de eliminar la persona con ID: " + id + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
            );
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                personaDAO.eliminar(id);
                vista.mostrarMensaje("Persona eliminada exitosamente", 
                                   "Éxito", 
                                   JOptionPane.INFORMATION_MESSAGE);
                vista.limpiarCampos();
            }
            
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("El ID debe ser un número válido", 
                               "Error de formato", 
                               JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            vista.mostrarMensaje("Error al eliminar persona: " + e.getMessage(), 
                               "Error", 
                               JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Actualiza la lista de personas en la vista
     */
    public void actualizarListaPersonas() {
        // Este método será implementado cuando conectemos la vista con su respectiva funcionalidad
        // Por ahora, la vista maneja esto internamente
    }
}