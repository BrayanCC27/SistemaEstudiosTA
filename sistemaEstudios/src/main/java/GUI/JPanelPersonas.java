package GUI;

import Controlador.ControladorPersonas;
import Entidades.Persona;
import Persistencia.DAO.PersonaDAO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JPanelPersonas extends javax.swing.JPanel {
    
    // Variables de instancia
    private PersonaDAO personaDao = new PersonaDAO();
    private Persona persona;
    private List<Persona> arrayPersona = new ArrayList<>();
    private ControladorPersonas controlador;
    
    // Componentes de la interfaz
    private javax.swing.JTabbedPane TPPersonas;
    private javax.swing.JPanel IncripcionPersonas;
    private javax.swing.JPanel EliminarPersonas;
    
    // Componentes para inscribir
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton BTNIncribirPersona;
    private javax.swing.JTextField IDPersona;
    private javax.swing.JTextField NombresPersona;
    private javax.swing.JTextField EmailPersona;
    private javax.swing.JTextField ApellidosPersona;
    
    // Componentes para eliminar
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ListaPersonas;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JTextField IDEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel24;
    
    public JPanelPersonas() {
        initComponents();
        // El controlador se asignará externamente
    }
    
    public void setControlador(ControladorPersonas controlador) {
        this.controlador = controlador;
    }
    
    private void initComponents() {
        TPPersonas = new javax.swing.JTabbedPane();
        IncripcionPersonas = new javax.swing.JPanel();
        EliminarPersonas = new javax.swing.JPanel();
        
        // Componentes para inscribir
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BTNIncribirPersona = new javax.swing.JButton();
        IDPersona = new javax.swing.JTextField();
        NombresPersona = new javax.swing.JTextField();
        EmailPersona = new javax.swing.JTextField();
        ApellidosPersona = new javax.swing.JTextField();
        
        // Componentes para eliminar
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaPersonas = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        IDEliminar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        
        // Configuración de componentes de inscripción
        jLabel1.setText("ID");
        jLabel2.setText("Nombres");
        jLabel3.setText("Apellidos");
        jLabel5.setText("Email");
        
        BTNIncribirPersona.setText("Inscribir");
        BTNIncribirPersona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNIncribirPersonaActionPerformed(evt);
            }
        });
        
        // Layout para inscripción
        javax.swing.GroupLayout IncripcionPersonasLayout = new javax.swing.GroupLayout(IncripcionPersonas);
        IncripcionPersonas.setLayout(IncripcionPersonasLayout);
        IncripcionPersonasLayout.setHorizontalGroup(
            IncripcionPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IncripcionPersonasLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(IncripcionPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IncripcionPersonasLayout.createSequentialGroup()
                        .addGroup(IncripcionPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IncripcionPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombresPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ApellidosPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(IncripcionPersonasLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(BTNIncribirPersona)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        IncripcionPersonasLayout.setVerticalGroup(
            IncripcionPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IncripcionPersonasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(IncripcionPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IDPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IncripcionPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NombresPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IncripcionPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ApellidosPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IncripcionPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(EmailPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BTNIncribirPersona)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        // Configuración de componentes de eliminación
        jLabel13.setText("Listado de Personas");
        jLabel24.setText("ID -- NOMBRES APELLIDOS");
        jLabel14.setText("ID");
        
        ListaPersonas.setEditable(false);
        ListaPersonas.setColumns(20);
        ListaPersonas.setRows(5);
        jScrollPane1.setViewportView(ListaPersonas);
        
        jButton1.setText("Eliminar Persona");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        // Layout para eliminación
        javax.swing.GroupLayout EliminarPersonasLayout = new javax.swing.GroupLayout(EliminarPersonas);
        EliminarPersonas.setLayout(EliminarPersonasLayout);
        EliminarPersonasLayout.setHorizontalGroup(
            EliminarPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarPersonasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addGroup(EliminarPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EliminarPersonasLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EliminarPersonasLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)))
                .addGap(62, 62, 62))
            .addGroup(EliminarPersonasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(EliminarPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EliminarPersonasLayout.setVerticalGroup(
            EliminarPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarPersonasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(2, 2, 2)
                .addGroup(EliminarPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EliminarPersonasLayout.createSequentialGroup()
                        .addGroup(EliminarPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(IDEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        // Agregar pestañas
        TPPersonas.addTab("Inscribir", IncripcionPersonas);
        TPPersonas.addTab("Eliminar", EliminarPersonas);
        TPPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPPersonasMouseClicked(evt);
            }
        });
        
        // Layout principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TPPersonas)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TPPersonas)
                .addContainerGap())
        );
    }
    
    // Métodos de eventos - ahora delegados al controlador
    private void BTNIncribirPersonaActionPerformed(ActionEvent evt) {
        if (controlador != null) {
            controlador.inscribirPersona();
        }
    }
    
    private void jButton1ActionPerformed(ActionEvent evt) {
        if (controlador != null) {
            controlador.eliminarPersona();
        }
        actualizarListaPersonas();
    }
    
    private void TPPersonasMouseClicked(java.awt.event.MouseEvent evt) {
        actualizarListaPersonas();
    }
    
    // Métodos públicos para el controlador
    public String getIDPersona() {
        return IDPersona.getText();
    }
    
    public String getNombresPersona() {
        return NombresPersona.getText();
    }
    
    public String getApellidosPersona() {
        return ApellidosPersona.getText();
    }
    
    public String getEmailPersona() {
        return EmailPersona.getText();
    }
    
    public String getIDEliminar() {
        return IDEliminar.getText();
    }
    
    public void limpiarCampos() {
        IDPersona.setText("");
        NombresPersona.setText("");
        ApellidosPersona.setText("");
        EmailPersona.setText("");
        IDEliminar.setText("");
    }
    
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }
    
    private void actualizarListaPersonas() {
        ListaPersonas.setText("");
        arrayPersona = personaDao.obtenerTodos();
        for (Persona aux : arrayPersona) {
            ListaPersonas.append(aux.getId() + " -- " + aux.getNombres() + " " + aux.getApellidos() + "\n");
        }
    }
}