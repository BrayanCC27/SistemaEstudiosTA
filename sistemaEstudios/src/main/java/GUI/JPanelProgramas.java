package GUI;

import Entidades.Programa;
import Persistencia.DAO.ProgramaDAO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class JPanelProgramas extends javax.swing.JPanel {
    
    // Variables de instancia
    private ProgramaDAO programaDao = new ProgramaDAO();
    private List<Programa> arrayPrograma = new ArrayList<>();
    
    // Componentes de la interfaz
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea ListaProgramas;
    
    public JPanelProgramas() {
        initComponents();
        actualizarListaProgramas();
    }
    
    private void initComponents() {
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaProgramas = new javax.swing.JTextArea();
        
        jLabel25.setText("Lista de Programas");
        jLabel26.setText("ID - NOMBRE");
        
        ListaProgramas.setEditable(false);
        ListaProgramas.setColumns(20);
        ListaProgramas.setRows(5);
        jScrollPane2.setViewportView(ListaProgramas);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(14, 14, 14)))
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }
    
    private void actualizarListaProgramas() {
        ListaProgramas.setText("");
        arrayPrograma = programaDao.obtenerTodos();
        for (Programa aux : arrayPrograma) {
            ListaProgramas.append(aux.getId() + " - " + aux.getNombre() + "\n");
        }
    }
    
    // Método público para refrescar la lista desde controladores externos
    public void refrescarLista() {
        actualizarListaProgramas();
    }
}