package Persistencia;

import Interfaces.Conexion;
import Utils.Configuracion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD implements Conexion {

    private Connection conexion;
    private static Conexion instancia;
    
    private ConexionBD(){
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    @Override
    public Connection conectar() throws SQLException {
        String driver = Configuracion.getDriver();
        String url = Configuracion.getUrl();
        String user = Configuracion.getUser();
        String password = Configuracion.getPassword();

        try {
            if (driver != null && !driver.isBlank()) {
                Class.forName(driver);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver JDBC: " + driver, e);
        }
        conexion = DriverManager.getConnection(url, user, password);
        return conexion;
    }

    @Override
    public void desconectar() {
        if (conexion != null) {
            try {
                if (!conexion.isClosed()) {
                    conexion.close();
                    System.out.println("Conexión a la base de datos cerrada.");
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No hay conexión activa para cerrar.");
        }
    }
}
