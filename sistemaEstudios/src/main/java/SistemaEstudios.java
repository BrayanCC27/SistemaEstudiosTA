import Interfaces.VistaGenerica;
import Utils.Configuracion;
import java.sql.SQLException;


public class SistemaEstudios {
    public static void main(String[] args) throws SQLException {
        
         try {
            String claseVista = Configuracion.getVista();

            if (claseVista == null || claseVista.isBlank()) {
                throw new IllegalArgumentException("No se configuró la vista en config.properties");
            }

            // Cargar clase en tiempo de ejecución
            Class<?> clazz = Class.forName(claseVista);

            // Instanciar asegurando que implemente VistaGenerica
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
