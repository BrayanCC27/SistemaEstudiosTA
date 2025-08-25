package Listas;

import Entidades.Curso;
import Entidades.Estudiante;
import Entidades.Inscripcion;
import Interfaces.Servicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursosInscritos implements Servicios {
    private List<Inscripcion> listado;
    private Connection connection;

    public CursosInscritos(Connection connection) {
        this.connection = connection;
        this.listado = new ArrayList<>();
        cargarDatos();
    }

    public void inscribirCurso(Inscripcion inscripcion) {
        try {
            String sql = "INSERT INTO Inscripcion (estudianteID, cursoID, año, semestre) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, inscripcion.getEstudiante().getId().longValue());
            stmt.setInt(2, inscripcion.getCurso().getId());
            stmt.setInt(3, inscripcion.getAnio());
            stmt.setInt(4, inscripcion.getSemestre());
            stmt.executeUpdate();
            stmt.close();
            listado.add(inscripcion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Inscripcion inscripcion) {
        try {
            String sql = "DELETE FROM Inscripcion WHERE estudianteID = ? AND cursoID = ? AND año = ? AND semestre = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, inscripcion.getEstudiante().getId().longValue());
            stmt.setInt(2, inscripcion.getCurso().getId());
            stmt.setInt(3, inscripcion.getAnio());
            stmt.setInt(4, inscripcion.getSemestre());
            stmt.executeUpdate();
            stmt.close();
            listado.remove(inscripcion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Inscripcion inscripcion) {
        eliminar(inscripcion);
        inscribirCurso(inscripcion);
    }

    public void guardarInformacion(Inscripcion inscripcion) {
        actualizar(inscripcion);
    }

    public void cargarDatos() {
        listado.clear();
        try {
            String sql = "SELECT i.estudianteID, i.cursoID, i.año, i.semestre, " +
                    "c.nombre as curso_nombre, c.activo, c.programa_id, " +
                    "p.nombres, p.apellidos, p.email, e.codigo, e.promedio " +
                    "FROM Inscripcion i " +
                    "INNER JOIN Curso c ON i.cursoID = c.ID " +
                    "INNER JOIN Persona p ON i.estudianteID = p.ID " +
                    "INNER JOIN Estudiante e ON i.estudianteID = e.ID";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Crear objetos Estudiante y Curso
                Estudiante estudiante = new Estudiante(
                        (double) rs.getLong("estudianteID"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        (double) rs.getLong("codigo"),
                        null, // Se puede cargar el programa después
                        rs.getBoolean("activo"),
                        rs.getDouble("promedio")
                );

                Curso curso = new Curso(
                        (int) rs.getLong("cursoID"),
                        rs.getString("curso_nombre"),
                        null, // Se puede cargar el programa después
                        rs.getBoolean("activo")
                );

                Inscripcion inscripcion = new Inscripcion(
                        curso,
                        rs.getInt("año"),
                        rs.getInt("semestre"),
                        estudiante
                );

                listado.add(inscripcion);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "CursosInscritos{listado=" + listado + "}";
    }

    public List<Inscripcion> getListado() {
        return listado;
    }

    // Implementación de la interfaz Servicios
    @Override
    public String imprimirPosicion(String posicion) {
        try {
            int pos = Integer.parseInt(posicion);
            if (pos >= 0 && pos < listado.size()) {
                return listado.get(pos).toString();
            } else {
                return "Posición inválida";
            }
        } catch (NumberFormatException e) {
            return "Formato de posición inválido";
        }
    }

    @Override
    public Integer cantidadActual() {
        return listado.size();
    }

    @Override
    public List<String> imprimirListado() {
        List<String> resultado = new ArrayList<>();
        for (Inscripcion inscripcion : listado) {
            resultado.add(inscripcion.toString());
        }
        return resultado;
    }
}
