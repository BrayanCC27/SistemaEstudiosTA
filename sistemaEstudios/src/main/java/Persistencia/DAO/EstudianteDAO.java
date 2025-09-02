package Persistencia.DAO;

import Entidades.Estudiante;
import Entidades.Programa;
import Persistencia.ConexionH2;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstudianteDAO {
    private PersonaDAO personaDAO;
    private ProgramaDAO programaDAO;

    public EstudianteDAO() {
        
        try {
            this.programaDAO = new ProgramaDAO();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.personaDAO = new PersonaDAO();
    }

    // CREATE
    public void crear(Estudiante estudiante) {
        // First create the person record
        personaDAO.crear(estudiante);

        // Then create the student-specific information
        String sql = "INSERT INTO estudiante (id, codigo, programa_id, activo, promedio) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, estudiante.getId());
            stmt.setDouble(2, estudiante.getCodigo());
            stmt.setDouble(3, estudiante.getPrograma().getId());
            stmt.setBoolean(4, estudiante.getActivo());
            stmt.setDouble(5, estudiante.getPromedio());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear estudiante: " + e.getMessage());
        }
    }

    // READ
    public Estudiante obtenerPorId(Double id) {
        String sql = "SELECT e.*, p.nombres, p.apellidos, p.email FROM estudiante e " +
                "JOIN personas p ON e.id = p.id WHERE e.id = ?";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Programa programa = programaDAO.obtenerPorId(rs.getDouble("programa_id"));
                    return new Estudiante(
                            rs.getDouble("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("email"),
                            rs.getDouble("codigo"),
                            programa,
                            rs.getBoolean("activo"),
                            rs.getDouble("promedio")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener estudiante: " + e.getMessage());
        }

        return null;
    }

    // READ ALL
    public List<Estudiante> obtenerTodos() {
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT e.*, p.nombres, p.apellidos, p.email FROM estudiante e " +
                "JOIN personas p ON e.id = p.id";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Programa programa = programaDAO.obtenerPorId(rs.getDouble("programa_id"));
                estudiantes.add(new Estudiante(
                        rs.getDouble("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getDouble("codigo"),
                        programa,
                        rs.getBoolean("activo"),
                        rs.getDouble("promedio")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los estudiante: " + e.getMessage());
        }

        return estudiantes;
    }

    // UPDATE
    public void actualizar(Estudiante estudiante) {
        // Update the person information
        personaDAO.actualizar(estudiante);

        // Update the student-specific information
        String sql = "UPDATE estudiante SET codigo = ?, programa_id = ?, activo = ?, promedio = ? WHERE id = ?";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, estudiante.getCodigo());
            stmt.setDouble(2, estudiante.getPrograma().getId());
            stmt.setBoolean(3, estudiante.getActivo());
            stmt.setDouble(4, estudiante.getPromedio());
            stmt.setDouble(5, estudiante.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar estudiante: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminar(Double id) {
        // Delete student-specific information first
        String sql = "DELETE FROM estudiante WHERE id = ?";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, id);
            stmt.executeUpdate();

            // Then delete the person record
            personaDAO.eliminar(id);

        } catch (SQLException e) {
            System.err.println("Error al eliminar estudiante: " + e.getMessage());
        }
    }
}
