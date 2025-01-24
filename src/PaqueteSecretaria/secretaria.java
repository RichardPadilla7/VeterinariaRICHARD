package PaqueteSecretaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class secretaria {
    public JPanel PSecretaria;
    private JButton crearReportesButton;
    private JButton verReportesButton;
    private JButton salirButton;

    public secretaria() {

        JFrame menuFrame = new JFrame("Pantalla de Usuario");
        menuFrame.setContentPane(PSecretaria);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500, 300);
        menuFrame.setPreferredSize(new Dimension(500, 300));
        menuFrame.setLocationRelativeTo(null);
        menuFrame.pack();
        menuFrame.setVisible(true);

        crearReportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
