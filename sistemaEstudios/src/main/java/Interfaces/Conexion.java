package Interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface Conexion {
    Connection conectar() throws SQLException;
    void desconectar();
}
