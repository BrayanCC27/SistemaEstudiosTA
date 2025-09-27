package Fabrica;

public class FabricaExterna {
    private static FabricaExterna estancia;
    
    private FabricaExterna(){
    }
    
    private static synchronized void generarInstancia(){
        if(estancia == null){
            estancia = new FabricaExterna();
        }
    }     

    public static FabricaExterna obtenerEstancia(){
        if(estancia == null){
            generarInstancia();
        }
        return estancia;
    }
    
}
