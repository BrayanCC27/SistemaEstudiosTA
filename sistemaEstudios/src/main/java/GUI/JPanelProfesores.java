package GUI;

import Controlador.ControladorProfesores;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelProfesores extends javax.swing.JPanel {
    
    // Variables de instancia
    private ControladorProfesores controlador;
    
    // Componentes de la interfaz
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JTextField IDProfesor;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JTextField NombresProfesor;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JTextField ApellidosProfesor;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JTextField EmailProfesor;
    private javax.swing.JButton BTNIncribirProfesor;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JComboBox<String> TipoContrato;
    
    public JPanelProfesores() {
        initComponents();
    }
    
    public void setControlador(ControladorProfesores controlador) {
        this.controlador = controlador;
    }
    
    private void initComponents() {
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        IDProfesor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        NombresProfesor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        ApellidosProfesor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        EmailProfesor = new javax.swing.JTextField();
        BTNIncribirProfesor = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        TipoContrato = new javax.swing.JComboBox<>();
        
        jLabel8.setText("Inscribir Profesor");
        jLabel19.setText("ID");
        jLabel20.setText("Nombres");
        jLabel21.setText("Apellidos");
        jLabel22.setText("Email");
        jLabel23.setText("Tipo de contrato");
        
        BTNIncribirProfesor.setText("Inscribir");
        BTNIncribirProfesor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNIncribirProfesorActionPerformed(evt);
            }
        });
        
        TipoContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nomina", "Prestacion de Servicios" }));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IDProfesor)
                            .addComponent(NombresProfesor)
                            .addComponent(ApellidosProfesor)
                            .addComponent(EmailProfesor)
                            .addComponent(TipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BTNIncribirProfesor)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(51, 51, 51)))))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(IDProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(NombresProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(ApellidosProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(EmailProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(TipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BTNIncribirProfesor)
                .addContainerGap(311, Short.MAX_VALUE))
        );
    }
    
    // Evento delegado al controlador
    private void BTNIncribirProfesorActionPerformed(ActionEvent evt) {
        if (controlador != null) {
            controlador.inscribirProfesor();
        }
    }
    
    // Métodos públicos para el controlador
    public String getIDProfesor() {
        return IDProfesor.getText();
    }
    
    public String getNombresProfesor() {
        return NombresProfesor.getText();
    }
    
    public String getApellidosProfesor() {
        return ApellidosProfesor.getText();
    }
    
    public String getEmailProfesor() {
        return EmailProfesor.getText();
    }
    
    public String getTipoContrato() {
        return (String) TipoContrato.getSelectedItem();
    }
    
    public void limpiarCampos() {
        IDProfesor.setText("");
        NombresProfesor.setText("");
        ApellidosProfesor.setText("");
        EmailProfesor.setText("");
        TipoContrato.setSelectedIndex(0);
    }
    
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }
}