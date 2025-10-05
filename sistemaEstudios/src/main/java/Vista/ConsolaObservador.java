package Vista;

import Interfaces.Observador;
import Interfaces.VistaGenerica;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsolaObservador implements Observador, VistaGenerica {

    private JFrame frame;
    private JTextArea areaTexto;

    public ConsolaObservador() {
        // No hace nada especial aquí
    }

    @Override
    public void iniciar() {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Consola del Observer");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            areaTexto = new JTextArea();
            areaTexto.setEditable(false);
            areaTexto.setBackground(Color.BLACK);
            areaTexto.setForeground(Color.GREEN);
            areaTexto.setFont(new Font("Consolas", Font.PLAIN, 14));

            JScrollPane scrollPane = new JScrollPane(areaTexto);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);

            // Mensaje inicial
            areaTexto.append("=== Consola del Observer iniciada ===\n");
        });
    }

    @Override
    public void actualizar(String mensaje) {
        if (areaTexto != null) {
            SwingUtilities.invokeLater(() -> {
                areaTexto.append("[Observer] " + mensaje + "\n");
                areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
            });
        } else {
            Logger.getLogger(ConsolaObservador.class.getName())
                  .log(Level.WARNING, "La consola aún no está inicializada.");
        }
    }
}
