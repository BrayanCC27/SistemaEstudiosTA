package Controller;

import DTO.FacultadDTO;
import Entidades.Facultad;
import Entidades.Persona;
import Fabrica.FabricaInterna;
import Persistencia.DAO.FacultadDAO;
import Persistencia.DAO.PersonaDAO;
import java.util.List;
import java.util.stream.Collectors;

public class FacultadController {
    private FacultadDAO facultadDAO;
    private PersonaDAO personaDAO;

    public FacultadController() {
        this.facultadDAO = FabricaInterna.obtenerFacultadDAO();
        this.personaDAO = FabricaInterna.obtenerPersonaDAO();
    }

    public void crear(FacultadDTO facultadDTO) {
        Persona persona = personaDAO.obtenerPorId(facultadDTO.getDecanoId());
        Facultad facultad = facultadDTO.toEntity(persona);
        facultadDAO.crear(facultad);
    }

    public FacultadDTO obtenerPorId(double id) {
        Facultad facultad = facultadDAO.obtenerPorId(id);
        return (facultad != null) ? FacultadDTO.toDTO(facultad) : null;
    }

    public List<FacultadDTO> obtenerTodos() {
        return facultadDAO.obtenerTodos()
                          .stream()
                          .map(FacultadDTO::toDTO)
                          .collect(Collectors.toList());
    }

    public void actualizar(FacultadDTO facultadDTO) {
        Persona persona = personaDAO.obtenerPorId(facultadDTO.getDecanoId());
        Facultad facultad = facultadDTO.toEntity(persona);
        facultadDAO.actualizar(facultad);
    }

    public void eliminar(double id) {
        facultadDAO.eliminar(id);
    }
}
