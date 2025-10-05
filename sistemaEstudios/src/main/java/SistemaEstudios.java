
import Controller.CursoController;
import Fabrica.FabricaExterna;
import Interfaces.Observador;
import Interfaces.VistaGenerica;
import Persistencia.SQLbase;
import java.sql.SQLException;

public class SistemaEstudios {

    public static void main(String[] args) throws SQLException {

        SQLbase sqlbase = FabricaExterna.obtenerSQLbase();
        sqlbase.crearBD();

        VistaGenerica gui = FabricaExterna.ObtenerVistaGUI();
        VistaGenerica consolaPrincipal = FabricaExterna.ObtenerConsolaPrincipal();
        VistaGenerica consolaObservador = FabricaExterna.ObtenerConsolaObservador();

        Observador observador = (Observador) consolaObservador;
        CursoController cursoCon = FabricaExterna.obtenerCursoController();
        cursoCon.añadirObservador(observador);
        
        consolaObservador.iniciar();
        gui.iniciar();
        consolaPrincipal.iniciar();
    }
}
