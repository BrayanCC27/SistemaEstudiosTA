package Controller;

import DTO.CursoDTO;
import Entidades.Curso;
import Entidades.Programa;
import Fabrica.FabricaInterna;
import Interfaces.Observador;
import Persistencia.DAO.CursoDAO;
import Persistencia.DAO.ProgramaDAO;
import java.util.List;
import java.util.stream.Collectors;

public class CursoController {
    private CursoDAO cursoDAO;
    private ProgramaDAO programaDAO;
    public static CursoController instancia;

    private CursoController() {
       this.cursoDAO = FabricaInterna.obtenerCursoDAO();
       this.programaDAO = FabricaInterna.obtenerProgramaDAO();
    }
    
    public static CursoController obtenerInstancia(){
        if(instancia == null){
            instancia = new CursoController();
        }
        return instancia;
    }
    
    public void crear(CursoDTO cursoDTO) {
        Programa programa = programaDAO.obtenerPorId(cursoDTO.getProgramaId());
        Curso curso = cursoDTO.toEntity(programa);
        cursoDAO.crear(curso);
    }

    public CursoDTO obtenerPorId(Integer id) {
        Curso curso = cursoDAO.obtenerPorId(id);
        return (curso != null) ? CursoDTO.toDTO(curso) : null;
    }

    public List<CursoDTO> obtenerTodos() {
        return cursoDAO.obtenerTodos()
                       .stream()
                       .map(CursoDTO::toDTO)
                       .collect(Collectors.toList());
    }

    public void actualizar(CursoDTO cursoDTO) {
        Programa programa = programaDAO.obtenerPorId(cursoDTO.getProgramaId());
        Curso curso = cursoDTO.toEntity(programa);
        cursoDAO.actualizar(curso);
    }

    public void eliminar(Integer id) {
        cursoDAO.eliminar(id);
    }
    
    public void añadirObservador(Observador o){
        cursoDAO.addObservador(o);
    }
}
