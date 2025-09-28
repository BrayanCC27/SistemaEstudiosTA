package Controller;

import DTO.EstudianteDTO;
import Entidades.Estudiante;
import Entidades.Programa;
import Fabrica.FabricaInterna;
import Persistencia.DAO.EstudianteDAO;
import Persistencia.DAO.ProgramaDAO;
import java.util.List;
import java.util.stream.Collectors;

public class EstudianteController {
    private EstudianteDAO estudianteDAO;
    private ProgramaDAO programaDAO;

    public EstudianteController() {
        this.estudianteDAO = FabricaInterna.obtenerEstudianteDAO();
        this.estudianteDAO = FabricaInterna.obtenerEstudianteDAO();
    }

    public void crear(EstudianteDTO estudianteDTO) {
        Programa programa = programaDAO.obtenerPorId(estudianteDTO.getProgramaId());
        Estudiante estudiante = estudianteDTO.toEntity(programa);
        estudianteDAO.crear(estudiante);
    }

    public EstudianteDTO obtenerPorId(double id) {
        Estudiante estudiante = estudianteDAO.obtenerPorId(id);
        return (estudiante != null) ? EstudianteDTO.toDTO(estudiante) : null;
    }

    public List<EstudianteDTO> obtenerTodos() {
        return estudianteDAO.obtenerTodos()
                            .stream()
                            .map(EstudianteDTO::toDTO)
                            .collect(Collectors.toList());
    }

    public void actualizar(EstudianteDTO estudianteDTO) {
        Programa programa = programaDAO.obtenerPorId(estudianteDTO.getProgramaId());
        Estudiante estudiante = estudianteDTO.toEntity(programa);
        estudianteDAO.actualizar(estudiante);
    }

    public void eliminar(double id) {
        estudianteDAO.eliminar(id);
    }
}
