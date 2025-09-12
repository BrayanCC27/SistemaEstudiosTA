package GUI;

import Controlador.ControladorCursoProfesor;
import Entidades.Curso;
import Entidades.CursoProfesor;
import Entidades.Profesor;
import Persistencia.DAO.CursoDAO;
import Persistencia.DAO.ProfesorDAO;
import Listas.CursosProfesores;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class JPanelCursoProfesor extends javax.swing.JPanel {
    
    // Variables de instancia
    private ControladorCursoProfesor controlador;
    private ProfesorDAO profesorDao = new ProfesorDAO();
    private CursoDAO cursoDao = new CursoDAO();
    private CursosProfesores cursoProfesoresDao = new CursosProfesores();
    private List<Profesor> arrayProfesor = new ArrayList<>();
    private List<Curso> arrayCurso = new ArrayList<>();
    private List<CursoProfesor> arrayCursoProfesor = new ArrayList<>();
    
    // Componentes de la interfaz
    private javax.swing.JTabbedPane TPCursoProfesor;
    private javax.swing.JPanel InscribirCursoProfesor;
    private javax.swing.JPanel EliminarCursoProfesor;
    
    // Componentes para inscribir
    private javax.swing.JLabel jLabel15;
    private javax.swing.JComboBox<String> CBProfesores;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JTextField anoCursoProfesor;
    private javax.swing.JComboBox<String> semestreCursoProfesor;
    private javax.swing.JComboBox<String> CBCursos;
    private javax.swing.JButton BTNInscribirCursoProfesor;
    
    // Componentes para eliminar/mostrar
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea ListaCursosProfesor;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    
    public JPanelCursoProfesor() {
        initComponents();
        actualizarComboBoxes();
        actualizarListaCursosProfesor();
    }
    
    public void setControlador(ControladorCursoProfesor controlador) {
        this.controlador = controlador;
    }
    
    private void initComponents() {
        TPCursoProfesor = new javax.swing.JTabbedPane();
        InscribirCursoProfesor = new javax.swing.JPanel();
        EliminarCursoProfesor = new javax.swing.JPanel();
        
        // Componentes para inscribir
        jLabel15 = new javax.swing.JLabel();
        CBProfesores = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        anoCursoProfesor = new javax.swing.JTextField();
        semestreCursoProfesor = new javax.swing.JComboBox<>();
        CBCursos = new javax.swing.JComboBox<>();
        BTNInscribirCursoProfesor = new javax.swing.JButton();
        
        // Componentes para eliminar
        jScrollPane4 = new javax.swing.JScrollPane();
        ListaCursosProfesor = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        
        // Configurar componentes de inscripción
        jLabel15.setText("Profesor");
        jLabel30.setText("Año");
        jLabel31.setText("Semestre");
        jLabel32.setText("Curso");
        
        CBProfesores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        
        anoCursoProfesor.setText("2025");
        anoCursoProfesor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Evento para año
            }
        });
        
        semestreCursoProfesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        CBCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        
        BTNInscribirCursoProfesor.setText("Inscribir");
        BTNInscribirCursoProfesor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNInscribirCursoProfesorActionPerformed(evt);
            }
        });
        
        // Layout para inscribir
        javax.swing.GroupLayout InscribirCursoProfesorLayout = new javax.swing.GroupLayout(InscribirCursoProfesor);
        InscribirCursoProfesor.setLayout(InscribirCursoProfesorLayout);
        InscribirCursoProfesorLayout.setHorizontalGroup(
            InscribirCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InscribirCursoProfesorLayout.createSequentialGroup()
                .addGroup(InscribirCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InscribirCursoProfesorLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(InscribirCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel30)
                            .addComponent(jLabel15)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(InscribirCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CBProfesores, 0, 175, Short.MAX_VALUE)
                            .addComponent(anoCursoProfesor)
                            .addComponent(semestreCursoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBCursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(InscribirCursoProfesorLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(BTNInscribirCursoProfesor)))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        InscribirCursoProfesorLayout.setVerticalGroup(
            InscribirCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InscribirCursoProfesorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(InscribirCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(CBProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InscribirCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(anoCursoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InscribirCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(semestreCursoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InscribirCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(CBCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(BTNInscribirCursoProfesor)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        
        // Configurar componentes de eliminación/visualización
        jLabel33.setText("Lista de Cursos Profesor");
        jLabel34.setText("CURSO - PROFESOR - PERIODO");
        
        ListaCursosProfesor.setEditable(false);
        ListaCursosProfesor.setColumns(20);
        ListaCursosProfesor.setRows(5);
        jScrollPane4.setViewportView(ListaCursosProfesor);
        
        // Layout para eliminar
        javax.swing.GroupLayout EliminarCursoProfesorLayout = new javax.swing.GroupLayout(EliminarCursoProfesor);
        EliminarCursoProfesor.setLayout(EliminarCursoProfesorLayout);
        EliminarCursoProfesorLayout.setHorizontalGroup(
            EliminarCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarCursoProfesorLayout.createSequentialGroup()
                .addGroup(EliminarCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EliminarCursoProfesorLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EliminarCursoProfesorLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel34)))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EliminarCursoProfesorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(246, 246, 246))
        );
        EliminarCursoProfesorLayout.setVerticalGroup(
            EliminarCursoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarCursoProfesorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        
        // Agregar pestañas
        TPCursoProfesor.addTab("Inscribir", InscribirCursoProfesor);
        TPCursoProfesor.addTab("Ver Lista", EliminarCursoProfesor);
        TPCursoProfesor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                TPCursoProfesorMouseClicked(evt);
            }
        });
        
        // Layout principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TPCursoProfesor)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TPCursoProfesor)
                .addContainerGap())
        );
    }
    
    // Eventos
    private void BTNInscribirCursoProfesorActionPerformed(ActionEvent evt) {
        if (controlador != null) {
            controlador.inscribirCursoProfesor();
        }
    }
    
    private void TPCursoProfesorMouseClicked(MouseEvent evt) {
        actualizarComboBoxes();
        actualizarListaCursosProfesor();
    }
    
    // Métodos públicos para el controlador
    public int getProfesorSeleccionado() {
        return CBProfesores.getSelectedIndex();
    }
    
    public String getAno() {
        return anoCursoProfesor.getText();
    }
    
    public String getSemestre() {
        return (String) semestreCursoProfesor.getSelectedItem();
    }
    
    public int getCursoSeleccionado() {
        return CBCursos.getSelectedIndex();
    }
    
    public List<Profesor> getArrayProfesor() {
        return arrayProfesor;
    }
    
    public List<Curso> getArrayCurso() {
        return arrayCurso;
    }
    
    public void limpiarCampos() {
        CBProfesores.setSelectedIndex(0);
        CBCursos.setSelectedIndex(0);
        anoCursoProfesor.setText("2025");
        semestreCursoProfesor.setSelectedIndex(0);
    }
    
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }
    
    private void actualizarComboBoxes() {
        actualizarComboBoxProfesores();
        actualizarComboBoxCursos();
    }
    
    private void actualizarComboBoxCursos() {
        CBCursos.removeAllItems();
        CBCursos.addItem("Seleccione...");
        arrayCurso = cursoDao.obtenerTodos();
        for (Curso aux : arrayCurso) {
            CBCursos.addItem(aux.getNombre());
        }
    }
    
    private void actualizarComboBoxProfesores() {
        CBProfesores.removeAllItems();
        CBProfesores.addItem("Seleccione...");
        arrayProfesor = profesorDao.obtenerTodos();
        for (Profesor aux : arrayProfesor) {
            CBProfesores.addItem(aux.getNombres() + " " + aux.getApellidos());
        }
    }
    
    public void actualizarListaCursosProfesor() {
        ListaCursosProfesor.setText("");
        arrayCursoProfesor = cursoProfesoresDao.getListado();
        for (CursoProfesor aux : arrayCursoProfesor) {
            ListaCursosProfesor.append(aux.getCurso().getNombre() + " - " + 
                                     aux.getProfesor().getNombres() + " " + aux.getProfesor().getApellidos() + 
                                     " - " + aux.getAno() + "/" + aux.getSemestre() + "\n");
        }
    }
}