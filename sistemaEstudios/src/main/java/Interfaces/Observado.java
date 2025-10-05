package Interfaces;

public interface Observado {
    public void addObservador(Observador o);
    public void eliminarObservador(Observador o);
    public void notificar(String mensaje);
}
