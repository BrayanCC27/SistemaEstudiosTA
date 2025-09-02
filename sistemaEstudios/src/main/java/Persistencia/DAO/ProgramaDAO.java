package Persistencia.DAO;

import Entidades.Facultad;
import Entidades.Programa;
import Persistencia.ConexionH2;

import java.sql.*;
import java.util.*;

public class ProgramaDAO {
    private FacultadDAO facultadDAO;
    private Connection conection;

    public ProgramaDAO() throws SQLException {
        this.conection = ConexionH2.getInstancia().conectar();
        this.facultadDAO = new FacultadDAO();
    }

    // CREATE
    public void crear(Programa programa) {
        String sql = "INSERT INTO programa (id, nombre, duracion, registro, facultad_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conection.prepareStatement(sql)) {

            stmt.setDouble(1, programa.getId());
            stmt.setString(2, programa.getNombre());
            stmt.setDouble(3, programa.getDuracion());
            stmt.setString(4, String.valueOf(new java.sql.Date(programa.getRegistro().getTime())));
            stmt.setDouble(5, programa.getFacultad().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear programa: " + e.getMessage());
        }
    }

    // READ
    public Programa obtenerPorId(Double id) {
        String sql = "SELECT * FROM programa WHERE id = ?";

        try (PreparedStatement stmt = conection.prepareStatement(sql)) {

            stmt.setDouble(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Facultad facultad = facultadDAO.obtenerPorId(rs.getDouble("facultad_id"));

                    return new Programa(
                            rs.getDouble("id"),
                            rs.getString("nombre"),
                            rs.getDouble("duracion"),
                            rs.getDate("registro"),
                            facultad
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener programa: " + e.getMessage());
        }

        return null;
    }

    // READ ALL
    public List<Programa> obtenerTodos() {
        List<Programa> programas = new ArrayList<>();
        String sql = "SELECT * FROM programa";

        try (Statement stmt = conection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Facultad facultad = facultadDAO.obtenerPorId(rs.getDouble("facultad_id"));

                programas.add(new Programa(
                        rs.getDouble("id"),
                        rs.getString("nombre"),
                        rs.getDouble("duracion"),
                        rs.getDate("registro"),
                        facultad
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los programas: " + e.getMessage());
        }

        return programas;
    }

    // UPDATE
    public void actualizar(Programa programa) {
        String sql = "UPDATE programa SET nombre = ?, duracion = ?, registro = ?, facultad_id = ? WHERE id = ?";

        try (PreparedStatement stmt = conection.prepareStatement(sql)) {

            stmt.setString(1, programa.getNombre());
            stmt.setDouble(2, programa.getDuracion());
            stmt.setString(3, String.valueOf(new java.sql.Date(programa.getRegistro().getTime())));
            stmt.setDouble(4, programa.getFacultad().getId());
            stmt.setDouble(5, programa.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar programa: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminar(Double id) {
        String sql = "DELETE FROM programa WHERE id = ?";

        try (PreparedStatement stmt = conection.prepareStatement(sql)) {

            stmt.setDouble(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar programa: " + e.getMessage());
        }
    }
}