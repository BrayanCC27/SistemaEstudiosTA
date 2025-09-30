package Controller;

import DTO.PersonaDTO;
import Entidades.Persona;
import Fabrica.FabricaInterna;
import Persistencia.DAO.PersonaDAO;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaController {
    private PersonaDAO personaDAO;
    public static PersonaController instancia;

    private PersonaController() {
        this.personaDAO = FabricaInterna.obtenerPersonaDAO();
    }
    
    public static PersonaController obtenerInstancia() {
        if(instancia == null){
            instancia = new PersonaController();
        }
        return instancia;
    }
    
    public void crear(PersonaDTO personaDTO) {
        Persona persona = personaDTO.toEntity();
        personaDAO.crear(persona);
    }

    public PersonaDTO obtenerPorId(double id) {
        Persona persona = personaDAO.obtenerPorId(id);
        return (persona != null) ? PersonaDTO.toDTO(persona) : null;
    }

    public List<PersonaDTO> obtenerTodos() {
        return personaDAO.obtenerTodos()
                         .stream()
                         .map(PersonaDTO::toDTO)
                         .collect(Collectors.toList());
    }

    public void actualizar(PersonaDTO personaDTO) {
        Persona persona = personaDTO.toEntity();
        personaDAO.actualizar(persona);
    }

    public void eliminar(double id) {
        personaDAO.eliminar(id);
    }
}

