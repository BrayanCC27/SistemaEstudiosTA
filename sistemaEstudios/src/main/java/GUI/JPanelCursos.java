package GUI;

import Entidades.Curso;
import Persistencia.DAO.CursoDAO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class JPanelCursos extends javax.swing.JPanel {
    
    // Variables de instancia
    private CursoDAO cursoDao = new CursoDAO();
    private List<Curso> arrayCurso = new ArrayList<>();
    
    // Componentes de la interfaz
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea ListaCursos;
    
    public JPanelCursos() {
        initComponents();
        actualizarListaCursos();
    }
    
    private void initComponents() {
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaCursos = new javax.swing.JTextArea();
        
        jLabel28.setText("Lista de Cursos");
        jLabel29.setText("ID - NOMBRE - PROGRAMA");
        
        ListaCursos.setEditable(false);
        ListaCursos.setColumns(20);
        ListaCursos.setRows(5);
        jScrollPane3.setViewportView(ListaCursos);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel29)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }
    
    public void actualizarListaCursos() {
        ListaCursos.setText("");
        arrayCurso = cursoDao.obtenerTodos();
        for (Curso aux : arrayCurso) {
            ListaCursos.append(aux.getId() + " - " + aux.getNombre() + " - " + aux.getPrograma().getNombre() + "\n");
        }
    }
    
    // Método público para refrescar la lista desde controladores externos
    public void refrescarLista() {
        actualizarListaCursos();
    }
}