package Controller;

import DTO.ProgramaDTO;
import Entidades.Facultad;
import Entidades.Programa;
import Fabrica.FabricaInterna;
import Persistencia.DAO.FacultadDAO;
import Persistencia.DAO.ProgramaDAO;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramaController {
    private ProgramaDAO programaDAO;
    private FacultadDAO facultadDAO;
    public static ProgramaController instancia;
    
    private ProgramaController() {
        this.programaDAO = FabricaInterna.obtenerProgramaDAO();
        this.facultadDAO = FabricaInterna.obtenerFacultadDAO();
    }
    
    public static ProgramaController obtenerInstancia() {
        if(instancia == null){
            instancia = new ProgramaController();
        }
        return instancia;
    }
    
    public void crear(ProgramaDTO programaDTO) {
        Facultad facultad = facultadDAO.obtenerPorId(programaDTO.getFacultadId());
        Programa programa = programaDTO.toEntity(facultad);
        programaDAO.crear(programa);
    }

    public ProgramaDTO obtenerPorId(double id) {
        Programa programa = programaDAO.obtenerPorId(id);
        return (programa != null) ? ProgramaDTO.toDTO(programa) : null;
    }

    public List<ProgramaDTO> obtenerTodos() {
        return programaDAO.obtenerTodos()
                          .stream()
                          .map(ProgramaDTO::toDTO)
                          .collect(Collectors.toList());
    }

    public void actualizar(ProgramaDTO programaDTO) {
        Facultad facultad = facultadDAO.obtenerPorId(programaDTO.getFacultadId());
        Programa programa = programaDTO.toEntity(facultad);
        programaDAO.actualizar(programa);
    }

    public void eliminar(double id) {
        programaDAO.eliminar(id);
    }
}
