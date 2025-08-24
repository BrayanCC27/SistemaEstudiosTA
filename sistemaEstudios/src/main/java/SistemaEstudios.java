import Persistencia.SQLbase;

public class SistemaEstudios {
    public static void main(String[] args) {
        SQLbase sqlBase = new SQLbase();
        sqlBase.crearBD();
    }
}
