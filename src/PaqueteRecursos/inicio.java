package PaqueteRecursos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inicio {
    public JPanel PInicio;
    private JButton registroParaClientesNuevosButton;
    private JButton inicioDeSesiónButton;
    private JButton salirButton;

    public inicio() {

        JFrame menuFrame = new JFrame("Inicio");
        menuFrame.setContentPane(PInicio);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500, 300);
        menuFrame.setPreferredSize(new Dimension(500, 300));
        menuFrame.setLocationRelativeTo(null);
        menuFrame.pack();
        menuFrame.setVisible(true);

        registroParaClientesNuevosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame menuFrame = new JFrame("Crear Cuenta");
                menuFrame.setContentPane(new registro().PRegistro);
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setSize(500, 300);
                menuFrame.setPreferredSize(new Dimension(500, 300));
                menuFrame.setLocationRelativeTo(null);
                menuFrame.pack();
                menuFrame.setVisible(true);
            }
        });
        inicioDeSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame inicioFrame = (JFrame) SwingUtilities.getWindowAncestor(PInicio);
                if (inicioFrame != null) {
                    inicioFrame.dispose();
                }
                System.exit(0);
            }
        });
    }
}
