package Persistencia.DAO;

import Entidades.Persona;
import Fabrica.FabricaInterna;
import Interfaces.Conexion;

import java.sql.*;
import java.util.*;

public class PersonaDAO {
    private Conexion conexion;
    
    public PersonaDAO() {
        conexion = FabricaInterna.obtenerConexion();
    }


    public void crear(Persona persona) {
        String sql = "INSERT INTO Persona (id, nombres, apellidos, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, persona.getId());
            stmt.setString(2, persona.getNombres());
            stmt.setString(3, persona.getApellidos());
            stmt.setString(4, persona.getEmail());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear persona: " + e.getMessage());
        }
    }

    // READ
    public Persona obtenerPorId(Double id) {
        String sql = "SELECT * FROM Persona WHERE id = ?";

        try (Connection conn = conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Persona(
                            rs.getDouble("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("email")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener persona: " + e.getMessage());
        }

        return null;
    }

    // READ ALL
    public List<Persona> obtenerTodos() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM Persona";

        try (Connection conn = conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                personas.add(new Persona(
                        rs.getDouble("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todas las persona: " + e.getMessage());
        }

        return personas;
    }

    // UPDATE
    public void actualizar(Persona persona) {
        String sql = "UPDATE Persona SET nombres = ?, apellidos = ?, email = ? WHERE id = ?";

        try (Connection conn = conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, persona.getNombres());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getEmail());
            stmt.setDouble(4, persona.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar persona: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminar(Double id) {
        String sql = "DELETE FROM Persona WHERE id = ?";

        try (Connection conn = conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar persona: " + e.getMessage());
        }
    }
}