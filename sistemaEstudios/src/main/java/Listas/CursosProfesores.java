package Listas;

import Entidades.Curso;
import Entidades.CursoProfesor;
import Entidades.Profesor;
import Interfaces.Conexion;
import Interfaces.Servicios;
import Persistencia.ConexionH2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursosProfesores implements Servicios {
    private List<CursoProfesor> listado;
    private Conexion conexion;
    private Connection conn;

    public CursosProfesores() {
        this.conexion = ConexionH2.getInstancia();
        try {
            this.conn = conexion.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(CursosProfesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.listado = new ArrayList<>();
        cargarDatos();
    }

    public void inscribir(CursoProfesor cursoProfesor) {
        try {
            String sql = "INSERT INTO CursoProfesor (cursoID, profesorID, año, semestre) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cursoProfesor.getCurso().getId());
            stmt.setLong(2, cursoProfesor.getProfesor().getId().longValue());
            stmt.setInt(3, cursoProfesor.getAno());
            stmt.setInt(4, cursoProfesor.getSemestre());
            stmt.executeUpdate();
            stmt.close();
            listado.add(cursoProfesor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(CursoProfesor cursoProfesor) {
        try {
            String sql = "DELETE FROM CursoProfesor WHERE cursoID = ? AND profesorID = ? AND año = ? AND semestre = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cursoProfesor.getCurso().getId());
            stmt.setLong(2, cursoProfesor.getProfesor().getId().longValue());
            stmt.setInt(3, cursoProfesor.getAno());
            stmt.setInt(4, cursoProfesor.getSemestre());
            stmt.executeUpdate();
            stmt.close();
            listado.remove(cursoProfesor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(CursoProfesor cursoProfesor) {
        eliminar(cursoProfesor);
        inscribir(cursoProfesor);
    }

    public void guardarInformacion(CursoProfesor cursoProfesor) {
        actualizar(cursoProfesor);
    }

    public void cargarDatos() {
        listado.clear();
        try {
            String sql = "SELECT cp.cursoID, cp.profesorID, cp.año, cp.semestre, " +
                    "c.nombre as curso_nombre, c.activo, c.programa_id, " +
                    "p.nombres, p.apellidos, p.email, pr.tipo_contrato " +
                    "FROM CursoProfesor cp " +
                    "INNER JOIN Curso c ON cp.cursoID = c.ID " +
                    "INNER JOIN Persona p ON cp.profesorID = p.ID " +
                    "INNER JOIN Profesor pr ON cp.profesorID = pr.ID";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Crear objetos Profesor y Curso
                Profesor profesor = new Profesor(
                        (double) rs.getLong("profesorID"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("tipo_contrato")
                );

                Curso curso = new Curso(
                        (int) rs.getLong("cursoID"),
                        rs.getString("curso_nombre"),
                        null, // Se puede cargar el programa después
                        rs.getBoolean("activo")
                );

                CursoProfesor cp = new CursoProfesor(
                        profesor,
                        rs.getInt("año"),
                        rs.getInt("semestre"),
                        curso
                );

                listado.add(cp);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "CursosProfesores{listado=" + listado + "}";
    }

    public List<CursoProfesor> getListado() {
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
        for (CursoProfesor cp : listado) {
            resultado.add(cp.toString());
        }
        return resultado;
    }
}
