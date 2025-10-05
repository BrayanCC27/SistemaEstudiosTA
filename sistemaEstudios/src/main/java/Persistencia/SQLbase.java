package Persistencia;

import Fabrica.FabricaInterna;
import Interfaces.Conexion;
import Utils.Configuracion;
import Utils.LectorTxt;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLbase {

    private Conexion conexion;

    public SQLbase() {
        conexion = FabricaInterna.obtenerConexion();
    }

    public void crearBD() {
        String sql = "";
        try {
            sql = LectorTxt.leerArchivoComoString(Configuracion.getSchema());
        } catch (IOException ex) {
            Logger.getLogger(SQLbase.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (Connection con = conexion.conectar(); Statement stmt = con.createStatement()) {
            String[] queries = sql.split("separador");

            for (String query : queries) {
                query = query.trim();
                if (!query.isEmpty()) {
                    stmt.execute(query);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
