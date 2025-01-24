package PaqueteVeterinario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class veterinario {
    public JPanel PVeterinario;
    private JButton gestiónDeCitasButton;
    private JButton diagnosticosYTratamientosButton;
    private JButton historialMédicoDeMascotasButton;
    private JButton salirButton;

    public veterinario() {

        JFrame menuFrame = new JFrame("Pantalla de Usuario");
        menuFrame.setContentPane(PVeterinario);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500, 300);
        menuFrame.setPreferredSize(new Dimension(500, 300));
        menuFrame.setLocationRelativeTo(null);
        menuFrame.pack();
        menuFrame.setVisible(true);

        gestiónDeCitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
