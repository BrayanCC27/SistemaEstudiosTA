package Controlador;

import GUI.JPanelProfesores;
import Entidades.Profesor;
import Persistencia.DAO.ProfesorDAO;
import javax.swing.JOptionPane;

public class ControladorProfesores {
    
    private JPanelProfesores vista;
    private ProfesorDAO profesorDAO;
    
    public ControladorProfesores(JPanelProfesores vista) {
        this.vista = vista;
        this.profesorDAO = new ProfesorDAO();
    }
    
    /**
     * Maneja la inscripción de un nuevo profesor
     * Aplica el patrón Information Expert - el controlador conoce qué validaciones aplicar
     */
    public void inscribirProfesor() {
        try {
            // Obtener datos de la vista
            String idStr = vista.getIDProfesor();
            String nombres = vista.getNombresProfesor();
            String apellidos = vista.getApellidosProfesor();
            String email = vista.getEmailProfesor();
            String tipoContrato = vista.getTipoContrato();
            
            // Validaciones básicas
            if (idStr.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || 
                email.isEmpty() || tipoContrato.isEmpty()) {
                vista.mostrarMensaje("Todos los campos son obligatorios", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Conversiones
            Double id = Double.valueOf(idStr);
            
            // Validación de email básica
            if (!email.contains("@")) {
                vista.mostrarMensaje("El email no tiene un formato válido", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validación de tipo de contrato
            if (!tipoContrato.equals("Nomina") && !tipoContrato.equals("Prestacion de Servicios")) {
                vista.mostrarMensaje("Seleccione un tipo de contrato válido", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Crear y guardar profesor
            Profesor profesor = new Profesor(id, nombres, apellidos, email, tipoContrato);
            profesorDAO.crear(profesor);
            
            // Mostrar éxito
            vista.mostrarMensaje("Profesor inscrito exitosamente", 
                               "Éxito", 
                               JOptionPane.INFORMATION_MESSAGE);
            
            // Limpiar campos
            vista.limpiarCampos();
            
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("El ID debe ser un número válido", 
                               "Error de formato", 
                               JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            vista.mostrarMensaje("Error al inscribir profesor: " + e.getMessage(), 
                               "Error", 
                               JOptionPane.ERROR_MESSAGE);
        }
    }
}