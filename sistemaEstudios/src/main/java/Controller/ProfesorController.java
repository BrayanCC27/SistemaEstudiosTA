package Controller;

import DTO.ProfesorDTO;
import Entidades.Profesor;
import Fabrica.FabricaInterna;
import Persistencia.DAO.ProfesorDAO;
import java.util.List;
import java.util.stream.Collectors;

public class ProfesorController {
    private ProfesorDAO profesorDAO;
    public static ProfesorController instancia;

    private ProfesorController() {
        this.profesorDAO = FabricaInterna.obtenerProfesorDAO();
    }
    
    public static ProfesorController obtenerInstancia() {
        if(instancia == null){
            instancia = new ProfesorController();
        }
        return instancia;
    }
    
    public void crear(ProfesorDTO profesorDTO) {
        Profesor profesor = profesorDTO.toEntity();
        profesorDAO.crear(profesor);
    }

    public ProfesorDTO obtenerPorId(double id) {
        Profesor profesor = profesorDAO.obtenerPorId(id);
        return (profesor != null) ? ProfesorDTO.toDTO(profesor) : null;
    }

    public List<ProfesorDTO> obtenerTodos() {
        return profesorDAO.obtenerTodos()
                          .stream()
                          .map(ProfesorDTO::toDTO)
                          .collect(Collectors.toList());
    }

    public void actualizar(ProfesorDTO profesorDTO) {
        Profesor profesor = profesorDTO.toEntity();
        profesorDAO.actualizar(profesor);
    }

    public void eliminar(double id) {
        profesorDAO.eliminar(id);
    }
}

