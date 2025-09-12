package Controlador;

import Entidades.Curso;
import GUI.JPanelCursoProfesor;
import Entidades.CursoProfesor;
import Entidades.Profesor;
import Listas.CursosProfesores;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Controlador específico para el manejo de asignaciones Curso-Profesor
 * Aplica el patrón Controller de GRASP
 */
public class ControladorCursoProfesor {
    
    private JPanelCursoProfesor vista;
    private CursosProfesores cursoProfesoresService;
    
    public ControladorCursoProfesor(JPanelCursoProfesor vista) {
        this.vista = vista;
        this.cursoProfesoresService = new CursosProfesores();
    }
    
    /**
     * Maneja la inscripción de un curso a un profesor
     * Aplica el patrón Information Expert - el controlador conoce qué validaciones aplicar
     */
    public void inscribirCursoProfesor() {
        try {
            // Obtener datos de la vista
            int profesorIndex = vista.getProfesorSeleccionado();
            String anoStr = vista.getAno();
            String semestreStr = vista.getSemestre();
            int cursoIndex = vista.getCursoSeleccionado();
            
            // Validaciones básicas
            if (profesorIndex <= 0) {
                vista.mostrarMensaje("Debe seleccionar un profesor", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (cursoIndex <= 0) {
                vista.mostrarMensaje("Debe seleccionar un curso", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (anoStr.isEmpty() || semestreStr.isEmpty()) {
                vista.mostrarMensaje("El año y semestre son obligatorios", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Conversiones
            int ano = Integer.parseInt(anoStr);
            int semestre = Integer.parseInt(semestreStr);
            
            // Validación de año
            if (ano < 2020 || ano > 2030) {
                vista.mostrarMensaje("El año debe estar entre 2020 y 2030", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validación de semestre
            if (semestre < 1 || semestre > 2) {
                vista.mostrarMensaje("El semestre debe ser 1 o 2", 
                                   "Error de validación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Obtener objetos desde los arrays de la vista (ajustando índices)
            List<Profesor> profesores = vista.getArrayProfesor();
            List<Curso> cursos = vista.getArrayCurso();
            
            if (profesorIndex - 1 >= profesores.size() || cursoIndex - 1 >= cursos.size()) {
                vista.mostrarMensaje("Selección inválida de profesor o curso", 
                                   "Error", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Profesor profesorSeleccionado = profesores.get(profesorIndex - 1); // -1 porque el primer item es "Seleccione..."
            Curso cursoSeleccionado = cursos.get(cursoIndex - 1); // -1 porque el primer item es "Seleccione..."
            
            // Verificar si ya existe esta asignación
            if (existeAsignacion(profesorSeleccionado, cursoSeleccionado, ano, semestre)) {
                vista.mostrarMensaje("Esta asignación de curso-profesor ya existe para el periodo especificado", 
                                   "Error de duplicación", 
                                   JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Crear y guardar la asignación
            CursoProfesor cursoProfesor = new CursoProfesor(profesorSeleccionado, ano, semestre, cursoSeleccionado);
            cursoProfesoresService.inscribir(cursoProfesor);
            
            // Mostrar éxito
            vista.mostrarMensaje("Curso asignado al profesor exitosamente", 
                               "Éxito", 
                               JOptionPane.INFORMATION_MESSAGE);
            
            // Actualizar lista y limpiar campos
            vista.actualizarListaCursosProfesor();
            vista.limpiarCampos();
            
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("El año debe ser un número válido", 
                               "Error de formato", 
                               JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            vista.mostrarMensaje("Error al asignar curso al profesor: " + e.getMessage(), 
                               "Error", 
                               JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Verifica si ya existe una asignación para evitar duplicados
     */
    private boolean existeAsignacion(Profesor profesor, Curso curso, int ano, int semestre) {
        try {
            // Obtener la lista actual de asignaciones del servicio
            List<CursoProfesor> asignacionesExistentes = cursoProfesoresService.getListado();
            
            // Verificar si ya existe una asignación con los mismos datos
            for (CursoProfesor asignacion : asignacionesExistentes) {
                if (asignacion.getProfesor().getId().equals(profesor.getId()) &&
                    asignacion.getCurso().getId() == curso.getId() &&
                    asignacion.getAno() == ano &&
                    asignacion.getSemestre() == semestre) {
                    return true; // Ya existe esta asignación
                }
            }
            
            return false; // No existe duplicado
        } catch (Exception e) {
            // En caso de error, permitir la creación para no bloquear el proceso
            System.err.println("Error al verificar asignación existente: " + e.getMessage());
            return false;
        }
    }
}