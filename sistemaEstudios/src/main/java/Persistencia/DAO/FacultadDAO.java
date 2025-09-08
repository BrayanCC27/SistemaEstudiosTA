package Persistencia.DAO;

import Entidades.Facultad;
import Entidades.Persona;
import Persistencia.ConexionH2;
import Persistencia.DAO.PersonaDAO;

import java.sql.*;
import java.util.*;

public class FacultadDAO {
    private PersonaDAO personaDAO = new PersonaDAO();

    // CREATE
    public void crear(Facultad facultad) {
        String sql = "INSERT INTO facultad (id, nombre, decano_id) VALUES (?, ?, ?)";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, facultad.getId());
            stmt.setString(2, facultad.getNombre());
            stmt.setDouble(3, facultad.getDecano() != null ? facultad.getDecano().getId() : null);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear facultad: " + e.getMessage());
        }
    }

    // READ
    public Facultad obtenerPorId(Double id) {
        String sql = "SELECT * FROM facultad WHERE id = ?";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Double decanoId = rs.getDouble("decano_id");
                    Persona decano = null;
                    if (!rs.wasNull()) {
                        decano = personaDAO.obtenerPorId(decanoId);
                    }

                    return new Facultad(
                            rs.getDouble("id"),
                            rs.getString("nombre"),
                            decano
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener facultad: " + e.getMessage());
        }

        return null;
    }

    // READ ALL
    public List<Facultad> obtenerTodos() {
        List<Facultad> facultades = new ArrayList<>();
        String sql = "SELECT * FROM facultad";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Double decanoId = rs.getDouble("decano_id");
                Persona decano = null;
                if (!rs.wasNull()) {
                    decano = personaDAO.obtenerPorId(decanoId);
                }

                facultades.add(new Facultad(
                        rs.getDouble("id"),
                        rs.getString("nombre"),
                        decano
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todas las facultades: " + e.getMessage());
        }

        return facultades;
    }

    // UPDATE
    public void actualizar(Facultad facultad) {
        String sql = "UPDATE facultad SET nombre = ?, decano_id = ? WHERE id = ?";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, facultad.getNombre());

            if (facultad.getDecano() != null) {
                stmt.setDouble(2, facultad.getDecano().getId());
            } else {
                stmt.setNull(2, Types.DOUBLE);
            }

            stmt.setDouble(3, facultad.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar facultad: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminar(Double id) {
        String sql = "DELETE FROM facultad WHERE id = ?";

        try (Connection conn = ConexionH2.getInstancia().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar facultad: " + e.getMessage());
        }
    }
}