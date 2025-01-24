package PaqueteCliente;

// rICHARD pADILLA - 2
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PaqueteRecursos.conexion;

public class agendarCitas extends conexion{
    public JPanel PAgendar;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField8;
    public JTextField textField9;
    public JButton agendarCitaButton;
    public JButton regresarButton;
    public JTextArea textArea1;
    public JCheckBox chequeoGeneralCheckBox;
    public JCheckBox vacunacionCheckBox;
    public JCheckBox cirugiaCheckBox;
    public JCheckBox aseoCheckBox;
    public JCheckBox machoCheckBox;
    public JCheckBox hembraCheckBox;
    private JButton subirFotoButton;
    private JLabel fotoLabel;

    public agendarCitas() {

        String cedulaCLiente = textField1.getText();
        String tipoMascota = textField2.getText();
        String nombreMascota = textField3.getText();
        String sexoMascota = "";
        String tipoServicio = "";
        String motivaCita = textField8.getText();
        double costo = textField9.getColumns();
        String observaciones = textArea1.getText();




        ButtonGroup grupoServicio = new ButtonGroup();
        grupoServicio.add(cirugiaCheckBox);
        grupoServicio.add(aseoCheckBox);
        grupoServicio.add(chequeoGeneralCheckBox);
        grupoServicio.add(vacunacionCheckBox);

        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(machoCheckBox);
        grupoGenero.add(hembraCheckBox);


        agendarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String servicio = "";

                if (cirugiaCheckBox.isSelected()) {
                    servicio = "cirugia";
                } else if (aseoCheckBox.isSelected()) {
                    servicio = "aseo";
                } else if (chequeoGeneralCheckBox.isSelected()) {
                    servicio = "chequeo genero";
                } else if (vacunacionCheckBox.isSelected()) {
                    servicio = "vacunacion";
                }

                String genero = "";

                if (machoCheckBox.isSelected()) {
                    genero = "macho";
                } else if (hembraCheckBox.isSelected()) {
                    genero = "hembra";
                }

                if (servicio.isEmpty() || genero.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
                    return;
                }

                try (Connection conn = connect()) {
                    String sql = "INSERT INTO agendar_citas (usuario, contrasenia, rol) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, cedulaCLiente);
                    pstmt.setString(2, tipoMascota);
                    pstmt.setString(3, nombreMascota);
                    pstmt.setString(4, sexoMascota);
                    pstmt.setString(7, tipoServicio);
                    pstmt.setString(8, motivaCita);
                    pstmt.setDouble(9, costo);
                    pstmt.setString(10, observaciones);


                    pstmt.execute();
                    JOptionPane.showMessageDialog(null, "Agenda Registrada!");

                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField8.setText("");
                    textField9.setText("");
                    textArea1.setText("");
                    grupoGenero.clearSelection();
                    grupoServicio.clearSelection();


                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }

            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cliente();
            }
        });

        subirFotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int result = fileChooser.showOpenDialog(null);

                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                        Image image = imageIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                        fotoLabel.setIcon(new ImageIcon(image));
                    }
                }
        });
    }
}
