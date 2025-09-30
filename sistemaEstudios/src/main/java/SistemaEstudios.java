
import Fabrica.FabricaExterna;
import Interfaces.VistaGenerica;
import Persistencia.SQLbase;
import Utils.Configuracion;
import java.sql.SQLException;

public class SistemaEstudios {

    public static void main(String[] args) throws SQLException {

        SQLbase sqlbase = FabricaExterna.obtenerSQLbase();
        sqlbase.crearBD();
        try {
            String claseVista = Configuracion.getVista();

            if (claseVista == null || claseVista.isBlank()) {
                throw new IllegalArgumentException("No se configuró la vista en config.properties");
            }


            Class<?> clazz = Class.forName(claseVista);
            Object instancia = clazz.getDeclaredConstructor().newInstance();

            if (instancia instanceof VistaGenerica) {
                VistaGenerica vista = (VistaGenerica) instancia;
                vista.iniciar();
            } else {
                throw new IllegalArgumentException("La clase " + claseVista + " no implementa VistaGenerica");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al iniciar la aplicación.");
        }
    }
}
