import Controlador.ControladorPrincipalRefactorizado;
import GUI.VentanaPrincipalRefactorizada;
import Interfaces.Conexion;
import Listas.CursosInscritos;
import Listas.CursosProfesores;
import Listas.InscripcionesPersonas;
import Persistencia.ConexionH2;
import Persistencia.SQLbase;

import java.sql.SQLException;

/**
 * Punto de entrada de la aplicación con arquitectura MVC refactorizada
 * Aplica los principios GRASP de Creator y Controller
 */
public class SistemaEstudiosRefactorizado {
    public static void main(String[] args) throws SQLException {
        // Configurar base de datos
        SQLbase sqlBase = new SQLbase();
        sqlBase.crearBD();

        Conexion db = ConexionH2.getInstancia();

        // Crear servicios (Modelo)
        CursosInscritos cursosInscritos = new CursosInscritos();
        InscripcionesPersonas inscripcionesPersonas = new InscripcionesPersonas();
        CursosProfesores cursosProfesores = new CursosProfesores();

        // Ejecutar en el hilo de eventos de Swing (buena práctica para interfaces gráficas)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear la vista principal refactorizada (Vista)
                VentanaPrincipalRefactorizada vista = new VentanaPrincipalRefactorizada();

                // Crear el controlador principal coordinador (Controlador)
                ControladorPrincipalRefactorizado controlador = new ControladorPrincipalRefactorizado(vista, cursosInscritos);

                // Mostrar la ventana principal
                vista.setVisible(true);
            }
        });
    }
}