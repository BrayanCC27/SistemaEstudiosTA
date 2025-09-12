package GUI;

import Controlador.ControladorEstudiantes;
import Entidades.Estudiante;
import Entidades.Programa;
import Persistencia.DAO.EstudianteDAO;
import Persistencia.DAO.ProgramaDAO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JPanelEstudiantes extends javax.swing.JPanel {
    
    // Variables de instancia
    private EstudianteDAO estudianteDao = new EstudianteDAO();
    private ProgramaDAO programaDao = new ProgramaDAO();
    private Estudiante estudiante;
    private Programa programa;
    private List<Estudiante> arrayEstudiante = new ArrayList<>();
    private ControladorEstudiantes controlador;
    
    // Componentes de la interfaz
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField IDEstudiante;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JTextField NombresEstudiante;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JTextField ApellidosEstudiante;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JTextField EmailEstudiante;
    private javax.swing.JButton BTNIncribirEstudiante;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JCheckBox CBActivo;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JTextField Promedio;
    private javax.swing.JTextField IDPrograma;
    private javax.swing.JTextField Codigo;
    private javax.swing.JLabel jLabel27;
    
    public JPanelEstudiantes() {
        initComponents();
    }
    
    public void setControlador(ControladorEstudiantes controlador) {
        this.controlador = controlador;
    }
    
    private void initComponents() {
        jLabel7 = new javax.swing.JLabel();
        IDEstudiante = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NombresEstudiante = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ApellidosEstudiante = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        EmailEstudiante = new javax.swing.JTextField();
        BTNIncribirEstudiante = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        CBActivo = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        Promedio = new javax.swing.JTextField();
        IDPrograma = new javax.swing.JTextField();
        Codigo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        
        jLabel7.setText("Inscribir Estudiante");
        jLabel9.setText("ID");
        jLabel10.setText("Nombres");
        jLabel11.setText("Apellidos");
        jLabel12.setText("Email");
        jLabel16.setText("Programa");
        jLabel17.setText("Activo");
        jLabel18.setText("Promedio");
        jLabel27.setText("Codigo");
        
        BTNIncribirEstudiante.setText("Inscribir");
        BTNIncribirEstudiante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNIncribirEstudianteActionPerformed(evt);
            }
        });
        
        CBActivo.setSelected(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(CBActivo))
                            .addComponent(IDEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(NombresEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(ApellidosEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(EmailEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(Promedio, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(IDPrograma)
                            .addComponent(Codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(BTNIncribirEstudiante))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(IDEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(NombresEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ApellidosEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(EmailEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(IDPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(CBActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(Promedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BTNIncribirEstudiante)
                .addContainerGap(222, Short.MAX_VALUE))
        );
    }
    
    // Evento delegado al controlador
    private void BTNIncribirEstudianteActionPerformed(ActionEvent evt) {
        if (controlador != null) {
            controlador.inscribirEstudiante();
        }
    }
    
    // Métodos públicos para el controlador
    public String getIDEstudiante() {
        return IDEstudiante.getText();
    }
    
    public String getNombresEstudiante() {
        return NombresEstudiante.getText();
    }
    
    public String getApellidosEstudiante() {
        return ApellidosEstudiante.getText();
    }
    
    public String getEmailEstudiante() {
        return EmailEstudiante.getText();
    }
    
    public String getCodigo() {
        return Codigo.getText();
    }
    
    public String getIDPrograma() {
        return IDPrograma.getText();
    }
    
    public boolean isActivo() {
        return CBActivo.isSelected();
    }
    
    public String getPromedio() {
        return Promedio.getText();
    }
    
    public void limpiarCampos() {
        IDEstudiante.setText("");
        NombresEstudiante.setText("");
        ApellidosEstudiante.setText("");
        EmailEstudiante.setText("");
        Codigo.setText("");
        IDPrograma.setText("");
        Promedio.setText("");
        CBActivo.setSelected(true);
    }
    
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }
}