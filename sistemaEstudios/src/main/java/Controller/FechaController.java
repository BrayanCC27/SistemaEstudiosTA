package Controller;

import Fabrica.FabricaInterna;
import Persistencia.FechaDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FechaController {
    private static FechaController instancia;
    private FechaDB fechaDB;

    private FechaController() {
       this.fechaDB = FabricaInterna.obtenerFechaDB();
    }
    
    public static FechaController obtenerInstancia(){
        if(instancia == null){
            instancia = new FechaController();
        }
        return instancia;
    }
    
    public String obtenerFecha(){
        try {
            return fechaDB.obtenerFechaActualComoString();
        } catch (SQLException ex) {
            Logger.getLogger(FechaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
