package GUI;

import Controlador.ControladorPersonas;
import Controlador.ControladorEstudiantes;
import Controlador.ControladorProfesores;
import Controlador.ControladorCursoProfesor;

/**
 * Ventana principal refactorizada siguiendo el patrón MVC
 * Ahora actúa como un coordinador que delega a paneles específicos
 * Aplica los principios GRASP de Bajo Acoplamiento y Alta Cohesión
 */
public class VentanaPrincipalRefactorizada extends javax.swing.JFrame {

    // Paneles específicos para cada funcionalidad
    private JPanelPersonas panelPersonas;
    private JPanelEstudiantes panelEstudiantes;
    private JPanelProfesores panelProfesores;
    private JPanelCursos panelCursos;
    private JPanelProgramas panelProgramas;
    private JPanelCursoProfesor panelCursoProfesor;
    
    // Controladores específicos
    private ControladorPersonas controladorPersonas;
    private ControladorEstudiantes controladorEstudiantes;
    private ControladorProfesores controladorProfesores;
    private ControladorCursoProfesor controladorCursoProfesor;
    
    // Componentes principales
    private javax.swing.JPanel ContenedorPrincipal;
    private javax.swing.JTabbedPane TPPrincipal;
    
    /**
     * Creates new form VentanaPrincipalRefactorizada
     */
    public VentanaPrincipalRefactorizada() {
        initComponents();
        inicializarPanelesYControladores();
    }
    
    /**
     * Inicializa los paneles específicos y sus controladores
     * Aplica el patrón Creator - VentanaPrincipal es responsable de crear sus componentes
     */
    private void inicializarPanelesYControladores() {
        // Crear paneles específicos
        panelPersonas = new JPanelPersonas();
        panelEstudiantes = new JPanelEstudiantes();
        panelProfesores = new JPanelProfesores();
        panelCursos = new JPanelCursos();
        panelProgramas = new JPanelProgramas();
        panelCursoProfesor = new JPanelCursoProfesor();
        
        // Crear controladores específicos
        controladorPersonas = new ControladorPersonas(panelPersonas);
        controladorEstudiantes = new ControladorEstudiantes(panelEstudiantes);
        controladorProfesores = new ControladorProfesores(panelProfesores);
        controladorCursoProfesor = new ControladorCursoProfesor(panelCursoProfesor);
        
        // Asignar controladores a las vistas
        panelPersonas.setControlador(controladorPersonas);
        panelEstudiantes.setControlador(controladorEstudiantes);
        panelProfesores.setControlador(controladorProfesores);
        panelCursoProfesor.setControlador(controladorCursoProfesor);
        
        // Agregar paneles al TabbedPane
        TPPrincipal.addTab("Personas", panelPersonas);
        TPPrincipal.addTab("Estudiantes", panelEstudiantes);
        TPPrincipal.addTab("Profesores", panelProfesores);
        TPPrincipal.addTab("Curso-Profesor", panelCursoProfesor);
        TPPrincipal.addTab("Programas", panelProgramas);
        TPPrincipal.addTab("Cursos", panelCursos);
    }
    
    private void initComponents() {
        ContenedorPrincipal = new javax.swing.JPanel();
        TPPrincipal = new javax.swing.JTabbedPane();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Estudios - Arquitectura MVC");
        
        ContenedorPrincipal.setBackground(new java.awt.Color(249, 248, 250));
        TPPrincipal.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        
        javax.swing.GroupLayout ContenedorPrincipalLayout = new javax.swing.GroupLayout(ContenedorPrincipal);
        ContenedorPrincipal.setLayout(ContenedorPrincipalLayout);
        ContenedorPrincipalLayout.setHorizontalGroup(
            ContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addContainerGap())
        );
        ContenedorPrincipalLayout.setVerticalGroup(
            ContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    // Métodos públicos para acceso desde el ControladorPrincipal si fuera necesario
    public JPanelPersonas getPanelPersonas() {
        return panelPersonas;
    }
    
    public JPanelEstudiantes getPanelEstudiantes() {
        return panelEstudiantes;
    }
    
    public JPanelProfesores getPanelProfesores() {
        return panelProfesores;
    }
    
    public JPanelCursos getPanelCursos() {
        return panelCursos;
    }
    
    public JPanelProgramas getPanelProgramas() {
        return panelProgramas;
    }
    
    public JPanelCursoProfesor getPanelCursoProfesor() {
        return panelCursoProfesor;
    }
    
    public ControladorPersonas getControladorPersonas() {
        return controladorPersonas;
    }
    
    public ControladorEstudiantes getControladorEstudiantes() {
        return controladorEstudiantes;
    }
    
    public ControladorProfesores getControladorProfesores() {
        return controladorProfesores;
    }
    
    public ControladorCursoProfesor getControladorCursoProfesor() {
        return controladorCursoProfesor;
    }
}