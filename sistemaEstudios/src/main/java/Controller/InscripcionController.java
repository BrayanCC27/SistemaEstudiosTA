package Controller;

import DTO.InscripcionDTO;
import Entidades.Curso;
import Entidades.Estudiante;
import Entidades.Inscripcion;
import Fabrica.FabricaInterna;
import Listas.CursosInscritos;
import Persistencia.DAO.CursoDAO;
import Persistencia.DAO.EstudianteDAO;
import java.util.List;
import java.util.stream.Collectors;

public class InscripcionController {

    private CursosInscritos cursosInscritos;
    private CursoDAO cursoDAO;
    private EstudianteDAO estudianteDAO;
    public static InscripcionController instancia;

    private InscripcionController() {
        this.cursosInscritos = FabricaInterna.obtenerCursosInscritos();
        this.cursoDAO = FabricaInterna.obtenerCursoDAO();
        this.estudianteDAO = FabricaInterna.obtenerEstudianteDAO();
    }

    public static InscripcionController obtenerInstancia() {
        if(instancia == null){
            instancia = new InscripcionController();
        }
        return instancia;
    }

    public InscripcionController(CursosInscritos cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public void inscribirCurso(InscripcionDTO inscripcionDTO) {
        cursosInscritos.inscribirCurso(armarObjeto(inscripcionDTO));
    }

    public void eliminar(InscripcionDTO inscripcionDTO) {
        cursosInscritos.eliminar(armarObjeto(inscripcionDTO));
    }

    public void actualizar(InscripcionDTO inscripcionDTO) {
        cursosInscritos.actualizar(armarObjeto(inscripcionDTO));
    }

    public List<InscripcionDTO> getListado() {
        return cursosInscritos.getListado()
                .stream()
                .map(InscripcionDTO::toDTO)
                .collect(Collectors.toList());
    }

    private Inscripcion armarObjeto(InscripcionDTO inscripcionDTO) {
        Curso curso = cursoDAO.obtenerPorId(inscripcionDTO.getCursoId());
        Estudiante estudiante = estudianteDAO.obtenerPorId(inscripcionDTO.getEstudianteId());
        Inscripcion inscripcion = inscripcionDTO.toEntity(curso, estudiante);
        return inscripcion;
    }
}
