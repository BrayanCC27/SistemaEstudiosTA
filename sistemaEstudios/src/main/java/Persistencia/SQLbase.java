package Persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLbase {
    private Connection con;

    public SQLbase() {
        try {
            this.con = ConexionH2.getInstancia().conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearBD() {
        String sql = """
            -- Tabla Persona
            CREATE TABLE IF NOT EXISTS Persona (
                ID BIGINT PRIMARY KEY,
                nombres VARCHAR(100),
                apellidos VARCHAR(100),
                email VARCHAR(150)
            );

            -- Tabla Profesor
            CREATE TABLE IF NOT EXISTS Profesor (
                ID BIGINT PRIMARY KEY,
                tipo_contrato VARCHAR(50),
                FOREIGN KEY (ID) REFERENCES Persona(ID) ON DELETE CASCADE
            );

            -- Tabla Facultad
            CREATE TABLE IF NOT EXISTS Facultad (
                ID BIGINT PRIMARY KEY,
                nombre VARCHAR(100),
                decano_id BIGINT,
                FOREIGN KEY (decano_id) REFERENCES Persona(ID) ON DELETE CASCADE
            );

            -- Tabla Programa
            CREATE TABLE IF NOT EXISTS Programa (
                ID BIGINT PRIMARY KEY,
                nombre VARCHAR(100),
                duracion INT,
                registro VARCHAR(50),
                facultad_id BIGINT,
                FOREIGN KEY (facultad_id) REFERENCES Facultad(ID) ON DELETE CASCADE
            );

            -- Tabla Curso
            CREATE TABLE IF NOT EXISTS Curso (
                ID BIGINT PRIMARY KEY,
                nombre VARCHAR(100),
                programa_id BIGINT NOT NULL,
                activo BOOLEAN,
                FOREIGN KEY (programa_id) REFERENCES Programa(ID) ON DELETE CASCADE
            );

            -- Tabla Estudiante
            CREATE TABLE IF NOT EXISTS Estudiante (
                ID BIGINT PRIMARY KEY,
                codigo BIGINT UNIQUE,
                programa_id BIGINT NOT NULL,
                activo BOOLEAN,
                promedio DOUBLE,
                FOREIGN KEY (ID) REFERENCES Persona(ID) ON DELETE CASCADE,
                FOREIGN KEY (programa_id) REFERENCES Programa(ID) ON DELETE CASCADE
            );

            -- Tabla Inscripcion
            CREATE TABLE IF NOT EXISTS Inscripcion (
                estudianteID BIGINT,
                cursoID BIGINT,
                año INT,
                semestre INT,
                PRIMARY KEY (estudianteID, cursoID, año, semestre),
                FOREIGN KEY (estudianteID) REFERENCES Estudiante(ID) ON DELETE CASCADE,
                FOREIGN KEY (cursoID) REFERENCES Curso(ID) ON DELETE CASCADE
            );

            -- Tabla CursoProfesor
            CREATE TABLE IF NOT EXISTS CursoProfesor (
                cursoID BIGINT,
                profesorID BIGINT,
                año INT,
                semestre INT,
                PRIMARY KEY (profesorID, cursoID, año, semestre),
                FOREIGN KEY (cursoID) REFERENCES Curso(ID) ON DELETE CASCADE,
                FOREIGN KEY (profesorID) REFERENCES Profesor(ID) ON DELETE CASCADE
            );

            -- Inserción de datos
            INSERT INTO Persona (ID, nombres, apellidos, email) VALUES
                (1, 'Decano1', 'Apellido1', 'decano1@uni.edu'),
                (2, 'Decano2', 'Apellido2', 'decano2@uni.edu'),
                (3, 'Decano3', 'Apellido3', 'decano3@uni.edu'),
                (4, 'Decano4', 'Apellido4', 'decano4@uni.edu'),
                (5, 'Decano5', 'Apellido5', 'decano5@uni.edu'),
                (6, 'Profesor1', 'Apellido6', 'prof1@uni.edu'),
                (7, 'Profesor2', 'Apellido7', 'prof2@uni.edu'),
                (8, 'Profesor3', 'Apellido8', 'prof3@uni.edu'),
                (9, 'Profesor4', 'Apellido9', 'prof4@uni.edu'),
                (10, 'Profesor5', 'Apellido10', 'prof5@uni.edu'),
                (11, 'Estudiante1', 'Apellido11', 'est1@uni.edu'),
                (12, 'Estudiante2', 'Apellido12', 'est2@uni.edu'),
                (13, 'Estudiante3', 'Apellido13', 'est3@uni.edu'),
                (14, 'Estudiante4', 'Apellido14', 'est4@uni.edu'),
                (15, 'Estudiante5', 'Apellido15', 'est5@uni.edu');

            INSERT INTO Profesor (ID, tipo_contrato) VALUES
                (6, 'Tiempo Completo'),
                (7, 'Cátedra'),
                (8, 'Tiempo Parcial'),
                (9, 'Cátedra'),
                (10, 'Tiempo Completo');

            INSERT INTO Facultad (ID, nombre, decano_id) VALUES
                (1, 'Facultad Ingeniería', 1),
                (2, 'Facultad Ciencias', 2),
                (3, 'Facultad Humanidades', 3),
                (4, 'Facultad Medicina', 4),
                (5, 'Facultad Economía', 5);

            INSERT INTO Programa (ID, nombre, duracion, registro, facultad_id) VALUES
                (1, 'Ing. Sistemas', 10, 'R001', 1),
                (2, 'Biología', 8, 'R002', 2),
                (3, 'Psicología', 8, 'R003', 3),
                (4, 'Medicina', 12, 'R004', 4),
                (5, 'Economía', 8, 'R005', 5);

            INSERT INTO Curso (ID, nombre, programa_id, activo) VALUES
                (1, 'Algoritmos', 1, TRUE),
                (2, 'Genética', 2, TRUE),
                (3, 'Neuropsicología', 3, TRUE),
                (4, 'Anatomía', 4, TRUE),
                (5, 'Microeconomía', 5, TRUE);

            INSERT INTO Estudiante (ID, codigo, programa_id, activo, promedio) VALUES
                (11, 2023101, 1, TRUE, 4.5),
                (12, 2023102, 2, TRUE, 4.3),
                (13, 2023103, 3, TRUE, 3.9),
                (14, 2023104, 4, TRUE, 4.8),
                (15, 2023105, 5, TRUE, 4.1);

            INSERT INTO Inscripcion (estudianteID, cursoID, año, semestre) VALUES
                (11, 1, 2024, 1),
                (12, 2, 2024, 1),
                (13, 3, 2024, 1),
                (14, 4, 2024, 1),
                (15, 5, 2024, 1);

            INSERT INTO CursoProfesor (cursoID, profesorID, año, semestre) VALUES
                (1, 6, 2024, 1),
                (2, 7, 2024, 1),
                (3, 8, 2024, 1),
                (4, 9, 2024, 1),
                (5, 10, 2024, 1);
        """;

        try (Statement stmt = con.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
