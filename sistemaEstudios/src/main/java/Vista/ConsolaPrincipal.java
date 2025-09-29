package Vista;

import Controller.*;
import DTO.*;
import Fabrica.FabricaExterna;
import Interfaces.VistaGenerica;

import java.util.List;
import java.util.Scanner;

public class ConsolaPrincipal implements VistaGenerica {

    private static final Scanner scanner = new Scanner(System.in);

    // Controllers
    private final PersonaController personaCon = FabricaExterna.obtenerPersonaController();
    private final EstudianteController estudianteCon = FabricaExterna.obtenerEstudianteController();
    private final ProfesorController profesorCon = FabricaExterna.obtenerProfesorController();
    private final ProgramaController programaCon = FabricaExterna.obtenerProgramaController();
    private final CursoController cursoCon = FabricaExterna.obtenerCursoController();
    private final CursoProfesorController cursoProfesorCon = FabricaExterna.obtenerCursoProfesorController();

    public void iniciar() {
        boolean running = true;
        while (running) {
            printMainMenu();
            int opt = readInt("Seleccione una opción: ");
            switch (opt) {
                case 1 -> manejarPersonas();
                case 2 -> manejarEstudiantes();
                case 3 -> manejarProfesores();
                case 4 -> listarProgramas();
                case 5 -> listarCursos();
                case 6 -> listarCursosProfesor();
                case 0 -> running = false;
                default -> System.out.println("Opción inválida.");
            }
        }
        System.out.println("Saliendo. Hasta luego.");
        scanner.close();
    }

    private void printMainMenu() {
        System.out.println("\n=== Sistema de Estudios (Consola) ===");
        System.out.println("1) Personas (inscribir / eliminar / listar)");
        System.out.println("2) Estudiantes (inscribir / listar)");
        System.out.println("3) Profesores (inscribir / listar)");
        System.out.println("4) Programas (listar)");
        System.out.println("5) Cursos (listar)");
        System.out.println("6) Cursos-Profesor (listar)");
        System.out.println("0) Salir");
    }

    // Personas
    private void manejarPersonas() {
        System.out.println("\n--- Personas ---");
        System.out.println("1) Inscribir persona");
        System.out.println("2) Eliminar persona");
        System.out.println("3) Listar personas");
        System.out.println("0) Volver");
        int opt = readInt("Opción: ");
        switch (opt) {
            case 1 -> inscribirPersona();
            case 2 -> eliminarPersona();
            case 3 -> listarPersonas();
            case 0 -> {}
            default -> System.out.println("Opción inválida.");
        }
    }

    private void inscribirPersona() {
        System.out.println("-- Inscribir Persona --");
        double id = readDouble("ID (numérico): ");
        String nombres = readLine("Nombres: ");
        String apellidos = readLine("Apellidos: ");
        String email = readLine("Email: ");

        PersonaDTO persona = FabricaExterna.obtenerPersonaDTO(id, nombres, apellidos, email);
        personaCon.crear(persona);
        System.out.println("Persona registrada.");
    }

    private void eliminarPersona() {
        System.out.println("-- Eliminar Persona --");
        double id = readDouble("ID de la persona a eliminar: ");
        personaCon.eliminar(id);
        System.out.println("Operación de eliminación solicitada.");
    }

    private void listarPersonas() {
        System.out.println("-- Listado de Personas --");
        List<PersonaDTO> lista = personaCon.obtenerTodos();
        if (lista == null || lista.isEmpty()) {
            System.out.println("(no hay personas registradas)");
            return;
        }
        for (PersonaDTO p : lista) {
            System.out.printf("%s -- %s %s\n", p.getId(), p.getNombres(), p.getApellidos());
        }
    }

    // Estudiantes
    private void manejarEstudiantes() {
        System.out.println("\n--- Estudiantes ---");
        System.out.println("1) Inscribir estudiante");
        System.out.println("2) Listar estudiantes");
        System.out.println("0) Volver");
        int opt = readInt("Opción: ");
        switch (opt) {
            case 1 -> inscribirEstudiante();
            case 2 -> listarEstudiantes();
            case 0 -> {}
            default -> System.out.println("Opción inválida.");
        }
    }

    private void inscribirEstudiante() {
        System.out.println("-- Inscribir Estudiante --");
        double id = readDouble("ID (numérico): ");
        String nombres = readLine("Nombres: ");
        String apellidos = readLine("Apellidos: ");
        String email = readLine("Email: ");
        double codigo = readDouble("Código (numérico): ");
        double idPrograma = readDouble("ID Programa (numérico): ");
        boolean activo = readYesNo("Activo? (s/n): ");
        double promedio = readDouble("Promedio (numérico): ");

        EstudianteDTO est = FabricaExterna.obtenerEstudianteDTO(id, nombres, apellidos, email, codigo, activo, promedio, idPrograma, "");
        estudianteCon.crear(est);
        System.out.println("Estudiante registrado.");
    }

    private void listarEstudiantes() {
        System.out.println("-- Listado de Estudiantes --");
        List<EstudianteDTO> lista = estudianteCon.obtenerTodos();
        if (lista == null || lista.isEmpty()) {
            System.out.println("(no hay estudiantes registrados)");
            return;
        }
        for (EstudianteDTO e : lista) {
            System.out.printf("%s -- %s %s -- ProgramaID: %s\n", e.getId(), e.getNombres(), e.getApellidos(), e.getProgramaId());
        }
    }

    // Profesores
    private void manejarProfesores() {
        System.out.println("\n--- Profesores ---");
        System.out.println("1) Inscribir profesor");
        System.out.println("2) Listar profesores");
        System.out.println("0) Volver");
        int opt = readInt("Opción: ");
        switch (opt) {
            case 1 -> inscribirProfesor();
            case 2 -> listarProfesores();
            case 0 -> {}
            default -> System.out.println("Opción inválida.");
        }
    }

    private void inscribirProfesor() {
        System.out.println("-- Inscribir Profesor --");
        double id = readDouble("ID (numérico): ");
        String nombres = readLine("Nombres: ");
        String apellidos = readLine("Apellidos: ");
        String email = readLine("Email: ");
        String tipoContrato = readLine("Tipo de contrato (Nomina / Prestacion de Servicios): ");

        ProfesorDTO prof = FabricaExterna.obtenerProfesorDTO(id, nombres, apellidos, email, tipoContrato);
        profesorCon.crear(prof);
        System.out.println("Profesor registrado.");
    }

    private void listarProfesores() {
        System.out.println("-- Listado de Profesores --");
        List<ProfesorDTO> lista = profesorCon.obtenerTodos();
        if (lista == null || lista.isEmpty()) {
            System.out.println("(no hay profesores registrados)");
            return;
        }
        for (ProfesorDTO p : lista) {
            System.out.printf("%s -- %s %s -- %s\n", p.getId(), p.getNombres(), p.getApellidos(), p.getTipoContrato());
        }
    }

    // Programas y Cursos (listados)
    private void listarProgramas() {
        System.out.println("-- Listado de Programas --");
        List<ProgramaDTO> lista = programaCon.obtenerTodos();
        if (lista == null || lista.isEmpty()) {
            System.out.println("(no hay programas)");
            return;
        }
        for (ProgramaDTO p : lista) {
            System.out.printf("%s -- %s\n", p.getId(), p.getNombre());
        }
    }

    private void listarCursos() {
        System.out.println("-- Listado de Cursos --");
        List<CursoDTO> lista = cursoCon.obtenerTodos();
        if (lista == null || lista.isEmpty()) {
            System.out.println("(no hay cursos)");
            return;
        }
        for (CursoDTO c : lista) {
            System.out.printf("%s -- %s -- Programa: %s\n", c.getId(), c.getNombre(), c.getProgramaNombre());
        }
    }

    private void listarCursosProfesor() {
        System.out.println("-- Listado Cursos-Profesor --");
        List<CursoProfesorDTO> lista = cursoProfesorCon.getListado();
        if (lista == null || lista.isEmpty()) {
            System.out.println("(no hay asignaciones curso-profesor)");
            return;
        }
        for (CursoProfesorDTO cp : lista) {
            System.out.printf("%s -- %s -- %d-%s\n", cp.getCursoNombre(), cp.getProfesorNombres(), cp.getAno(), cp.getSemestre());
        }
    }

    // Helpers de lectura
    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                String s = readLine(prompt);
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Valor numérico inválido, intente de nuevo.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                String s = readLine(prompt);
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Valor numérico inválido, intente de nuevo.");
            }
        }
    }

    private static boolean readYesNo(String prompt) {
        while (true) {
            String s = readLine(prompt).toLowerCase();
            if (s.equals("s") || s.equals("si") || s.equals("y") || s.equals("yes")) return true;
            if (s.equals("n") || s.equals("no")) return false;
            System.out.println("Respuesta inválida. Responda s/n.");
        }
    }

}
