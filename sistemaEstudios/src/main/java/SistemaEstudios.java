import Entidades.Persona;
import GUI.VentanaPrincipal;
import Listas.CursosInscritos;
import Listas.CursosProfesores;
import Listas.InscripcionesPersonas;
import Persistencia.ConexionH2;
import Persistencia.SQLbase;
import com.sun.jdi.connect.spi.Connection;

import java.sql.SQLException;
import java.util.List;

public class SistemaEstudios {
    public static void main(String[] args) throws SQLException {
        SQLbase sqlBase = new SQLbase();
//        sqlBase.crearBD();

        ConexionH2 db = ConexionH2.getInstancia();

        CursosInscritos cursosInscritos = new CursosInscritos(db.conectar());
        InscripcionesPersonas inscripcionesPersonas = new InscripcionesPersonas(db.conectar());
        CursosProfesores cursosProfesores = new CursosProfesores(db.conectar());

        cursosInscritos.imprimirPosicion("2");
        cursosInscritos.cantidadActual();

        System.out.println("\n=== CURSOS CON PROFESORES ASIGNADOS ===");
        System.out.println("Cantidad total: " + cursosProfesores.cantidadActual());
        List<String> cursosProf = cursosProfesores.imprimirListado();
        for (int i = 0; i < cursosProf.size(); i++) {
            System.out.println("[" + i + "] " + cursosProf.get(i));
        }

        System.out.println("\n=== INSCRIPCIONES DE ESTUDIANTES ===");
        System.out.println("Cantidad total: " + cursosInscritos.cantidadActual());
        List<String> inscripciones = cursosInscritos.imprimirListado();
        for (int i = 0; i < inscripciones.size(); i++) {
            System.out.println("[" + i + "] " + inscripciones.get(i));
        }

        System.out.println("Cursos inscritos en la posición 3: " + cursosInscritos.imprimirPosicion("3"));
        System.out.println("Cantidad actual de cursos inscritos: " + cursosInscritos.cantidadActual());

        System.out.println("\n=== PRUEBAS DE SERVICIOS ===");
        if (cursosProfesores.cantidadActual() > 0) {
            System.out.println("Primer curso-profesor: " + cursosProfesores.imprimirPosicion("0"));
        }
        if (cursosInscritos.cantidadActual() > 0) {
            System.out.println("Primera inscripción: " + cursosInscritos.imprimirPosicion("0"));
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}
