package Persistencia.DAO;

import Entidades.Curso;
import Entidades.Programa;
import Fabrica.FabricaInterna;
import Interfaces.Conexion;
import java.sql.*;
import java.util.*;

public class CursoDAO {

    private ProgramaDAO programaDAO;
    private Conexion conexion;

    public CursoDAO() {
        programaDAO = FabricaInterna.obtenerProgramaDAO();
        conexion = FabricaInterna.obtenerConexion();
    }

    public void crear(Curso curso) {
        String sql = "INSERT INTO Curso (id, nombre, programa_id, activo) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, curso.getId());
            stmt.setString(2, curso.getNombre());
            stmt.setDouble(3, curso.getPrograma().getId());
            stmt.setBoolean(4, curso.isActivo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear curso: " + e.getMessage());
        }
    }

    // READ
    public Curso obtenerPorId(Integer id) {
        String sql = "SELECT * FROM Curso WHERE id = ?";

        try (Connection conn = conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Programa programa = programaDAO.obtenerPorId(rs.getDouble("programa_id"));

                    return new Curso(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            programa,
                            rs.getBoolean("activo")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener curso: " + e.getMessage());
        }

        return null;
    }

    // READ ALL
    public List<Curso> obtenerTodos() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Curso";

        try (Connection conn = conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Programa programa = programaDAO.obtenerPorId(rs.getDouble("programa_id"));

                cursos.add(new Curso(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        programa,
                        rs.getBoolean("activo")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los curso: " + e.getMessage());
        }

        return cursos;
    }

    // UPDATE
    public void actualizar(Curso curso) {
        String sql = "UPDATE curso SET nombre = ?, programa_id = ?, activo = ? WHERE id = ?";

        try (Connection conn = conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNombre());
            stmt.setDouble(2, curso.getPrograma().getId());
            stmt.setBoolean(3, curso.isActivo());
            stmt.setInt(4, curso.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar curso: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminar(Integer id) {
        String sql = "DELETE FROM curso WHERE id = ?";

        try (Connection conn = conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar curso: " + e.getMessage());
        }
    }
}
