package Persistencia.DAO;

import Entidades.Profesor;
import Persistencia.ConexionH2;

import java.sql.*;
import java.util.*;

public class ProfesorDAO {
    private PersonaDAO personaDAO = new PersonaDAO();

    // CREATE
    public void crear(Profesor profesor) {
        // First create the person record
        personaDAO.crear(profesor);

        // Then create the professor-specific information
        String sql = "INSERT INTO profesor (id, tipo_contrato) VALUES (?, ?)";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, profesor.getId());
            stmt.setString(2, profesor.getTipoContrato());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear profesor: " + e.getMessage());
        }
    }

    // READ
    public Profesor obtenerPorId(Double id) {
        String sql = "SELECT p.*, per.nombres, per.apellidos, per.email FROM profesor p " +
                "JOIN personas per ON p.id = per.id WHERE p.id = ?";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Profesor(
                            rs.getDouble("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("email"),
                            rs.getString("tipo_contrato")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener profesor: " + e.getMessage());
        }

        return null;
    }

    // READ ALL
    public List<Profesor> obtenerTodos() {
        List<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT p.*, per.nombres, per.apellidos, per.email FROM profesor p " +
                "JOIN personas per ON p.id = per.id";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                profesores.add(new Profesor(
                        rs.getDouble("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("tipo_contrato")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los profesor: " + e.getMessage());
        }

        return profesores;
    }

    // UPDATE
    public void actualizar(Profesor profesor) {
        // Update the person information
        personaDAO.actualizar(profesor);

        // Update the professor-specific information
        String sql = "UPDATE profesor SET tipo_contrato = ? WHERE id = ?";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, profesor.getTipoContrato());
            stmt.setDouble(2, profesor.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar profesor: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminar(Double id) {
        // Delete professor-specific information first
        String sql = "DELETE FROM profesor WHERE id = ?";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, id);
            stmt.executeUpdate();

            // Then delete the person record
            personaDAO.eliminar(id);

        } catch (SQLException e) {
            System.err.println("Error al eliminar profesor: " + e.getMessage());
        }
    }
}