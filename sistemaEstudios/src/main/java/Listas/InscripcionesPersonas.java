package Listas;

import Entidades.Estudiante;
import Entidades.Persona;
import Entidades.Profesor;
import Interfaces.Conexion;
import Persistencia.ConexionH2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InscripcionesPersonas {
    private List<Persona> listado;
    private Conexion conexion;
    private Connection conn;

    public InscripcionesPersonas() {
        this.conexion = ConexionH2.getInstancia();
        try {
            this.conn = conexion.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionesPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.listado = new ArrayList<>();
        cargarDatos();
    }

    public void inscribir(Persona persona) {
        try {
            // Primero insertar en tabla Persona
            String sqlPersona = "INSERT INTO Persona (ID, nombres, apellidos, email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtPersona = conn.prepareStatement(sqlPersona);
            stmtPersona.setLong(1, persona.getId().longValue());
            stmtPersona.setString(2, persona.getNombres());
            stmtPersona.setString(3, persona.getApellidos());
            stmtPersona.setString(4, persona.getEmail());
            stmtPersona.executeUpdate();
            stmtPersona.close();

            // Luego insertar en tabla específica
            if (persona instanceof Estudiante) {
                Estudiante est = (Estudiante) persona;
                String sqlEst = "INSERT INTO Estudiante (ID, codigo, programa_id, activo, promedio) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmtEst = conn.prepareStatement(sqlEst);
                stmtEst.setLong(1, est.getId().longValue());
                stmtEst.setLong(2, est.getCodigo().longValue());
                stmtEst.setLong(3, est.getPrograma() != null ? est.getPrograma().getId().longValue() : 0);
                stmtEst.setBoolean(4, est.getActivo());
                stmtEst.setDouble(5, est.getPromedio());
                stmtEst.executeUpdate();
                stmtEst.close();
            } else if (persona instanceof Profesor) {
                Profesor prof = (Profesor) persona;
                String sqlProf = "INSERT INTO Profesor (ID, tipo_contrato) VALUES (?, ?)";
                PreparedStatement stmtProf = conn.prepareStatement(sqlProf);
                stmtProf.setLong(1, prof.getId().longValue());
                stmtProf.setString(2, prof.getTipoContrato());
                stmtProf.executeUpdate();
                stmtProf.close();
            }
            listado.add(persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Persona persona) {
        try {
            // La eliminación en CASCADE se encarga del resto
            String sql = "DELETE FROM Persona WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, persona.getId().longValue());
            stmt.executeUpdate();
            stmt.close();
            listado.remove(persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Persona persona) {
        try {
            // Actualizar tabla Persona
            String sqlPersona = "UPDATE Persona SET nombres = ?, apellidos = ?, email = ? WHERE ID = ?";
            PreparedStatement stmtPersona = conn.prepareStatement(sqlPersona);
            stmtPersona.setString(1, persona.getNombres());
            stmtPersona.setString(2, persona.getApellidos());
            stmtPersona.setString(3, persona.getEmail());
            stmtPersona.setLong(4, persona.getId().longValue());
            stmtPersona.executeUpdate();
            stmtPersona.close();

            // Actualizar tabla específica
            if (persona instanceof Estudiante) {
                Estudiante est = (Estudiante) persona;
                String sqlEst = "UPDATE Estudiante SET codigo = ?, programa_id = ?, activo = ?, promedio = ? WHERE ID = ?";
                PreparedStatement stmtEst = conn.prepareStatement(sqlEst);
                stmtEst.setLong(1, est.getCodigo().longValue());
                stmtEst.setLong(2, est.getPrograma() != null ? est.getPrograma().getId().longValue() : 0);
                stmtEst.setBoolean(3, est.getActivo());
                stmtEst.setDouble(4, est.getPromedio());
                stmtEst.setLong(5, est.getId().longValue());
                stmtEst.executeUpdate();
                stmtEst.close();
            } else if (persona instanceof Profesor) {
                Profesor prof = (Profesor) persona;
                String sqlProf = "UPDATE Profesor SET tipo_contrato = ? WHERE ID = ?";
                PreparedStatement stmtProf = conn.prepareStatement(sqlProf);
                stmtProf.setString(1, prof.getTipoContrato());
                stmtProf.setLong(2, prof.getId().longValue());
                stmtProf.executeUpdate();
                stmtProf.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guardarInformacion(Persona persona) {
        actualizar(persona);
    }

    public void cargarDatos() {
        listado.clear();
        // Cargar estudiantes con JOIN
        try {
            String sql = "SELECT p.ID, p.nombres, p.apellidos, p.email, e.codigo, e.programa_id, e.activo, e.promedio " +
                    "FROM Persona p INNER JOIN Estudiante e ON p.ID = e.ID";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Estudiante est = new Estudiante(
                        (double) rs.getLong("ID"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        (double) rs.getLong("codigo"),
                        null, // Se puede cargar después con el programa_id
                        rs.getBoolean("activo"),
                        rs.getDouble("promedio")
                );
                listado.add(est);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Cargar profesores con JOIN
        try {
            String sql = "SELECT p.ID, p.nombres, p.apellidos, p.email, pr.tipo_contrato " +
                    "FROM Persona p INNER JOIN Profesor pr ON p.ID = pr.ID";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Profesor prof = new Profesor(
                        (double) rs.getLong("ID"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("tipo_contrato")
                );
                listado.add(prof);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persona> getListado() {
        return listado;
    }
}
