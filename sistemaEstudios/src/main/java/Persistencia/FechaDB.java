package Persistencia;

import Fabrica.FabricaInterna;
import Interfaces.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FechaDB {

    private Conexion conexion;

    public FechaDB() {
        conexion = FabricaInterna.obtenerConexion();
    }

    public String obtenerFechaActualComoString() throws SQLException {
        Connection con = conexion.conectar();
        String dbProduct = con.getMetaData().getDatabaseProductName().toLowerCase();
        String query;

        if (dbProduct.contains("mysql")) {
            query = "SELECT NOW()"; 
        } else if (dbProduct.contains("oracle")) {
            query = "SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL";
        } else if (dbProduct.contains("h2")) {
            query = "SELECT FORMATDATETIME(CURRENT_TIMESTAMP(), 'yyyy-MM-dd HH:mm:ss')";
        } else {
            throw new SQLException("Base de datos no soportada: " + dbProduct);
        }

        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString(1);
            } else {
                throw new SQLException("No se pudo obtener la fecha de la base de datos");
            }
        }
    }

}
