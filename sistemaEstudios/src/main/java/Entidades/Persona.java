package Entidades;

public class Persona {
    private Double Id;
    private String nombres;
    private String apellidos;
    private String email;

    public Persona(Double Id, String nombres, String apellidos, String email) {
        this.Id = Id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public String toString() {
        return nombres + " " + apellidos;
    }

    public Double getId() {
        return Id;
    }

    public void setId(Double id) {
        Id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
