package Controller;

import DTO.CursoProfesorDTO;
import Entidades.Curso;
import Entidades.CursoProfesor;
import Entidades.Profesor;
import Fabrica.FabricaInterna;
import Listas.CursosProfesores;
import Persistencia.DAO.CursoDAO;
import Persistencia.DAO.ProfesorDAO;
import java.util.List;
import java.util.stream.Collectors;

public class CursoProfesorController {

    private CursosProfesores cursosProfesores;
    private ProfesorDAO profesorDAO;
    private CursoDAO cursoDAO;

    public CursoProfesorController() {
        this.cursosProfesores = FabricaInterna.obtenerCursosProfesores();
        this.profesorDAO = FabricaInterna.obtenerProfesorDAO();
        this.cursoDAO = FabricaInterna.obtenerCursoDAO();
    }

    public CursoProfesorController(CursosProfesores cursosProfesores) {
        this.cursosProfesores = cursosProfesores;
    }

    public void inscribir(CursoProfesorDTO cursoProfesorDTO) {
        cursosProfesores.inscribir(armarObjeto(cursoProfesorDTO));
    }

    public void eliminar(CursoProfesorDTO cursoProfesorDTO) {
        cursosProfesores.eliminar(armarObjeto(cursoProfesorDTO));
    }

    public void actualizar(CursoProfesorDTO cursoProfesorDTO) {
        cursosProfesores.actualizar(armarObjeto(cursoProfesorDTO));
    }

    public List<CursoProfesorDTO> getListado() {
        return cursosProfesores.getListado()
                               .stream()
                               .map(CursoProfesorDTO::toDTO)
                               .collect(Collectors.toList());
    }
    
    private CursoProfesor armarObjeto(CursoProfesorDTO cursoProfesorDTO){
        Profesor profesor = profesorDAO.obtenerPorId(cursoProfesorDTO.getProfesorId());
        Curso curso = cursoDAO.obtenerPorId(cursoProfesorDTO.getCursoId());
        CursoProfesor cursoProfesor = cursoProfesorDTO.toEntity(profesor, curso);
        return cursoProfesor;
    }
}
