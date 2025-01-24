import PaqueteAdministrador.administrador;
import PaqueteCliente.cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends conexion{
    public JPanel PLogin;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JComboBox comboBox1;
    private JButton ingresarButton;

    public login() {

        JFrame menuFrame = new JFrame("Login");
        menuFrame.setContentPane(PLogin);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500, 300);
        menuFrame.setPreferredSize(new Dimension(500, 300));
        menuFrame.setLocationRelativeTo(null);
        menuFrame.pack();
        menuFrame.setVisible(true);
        comboBox1.addItem("administrador");
        comboBox1.addItem("cliente");
        comboBox1.addItem("veterinario");
        comboBox1.addItem("secretaria");


        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textField1.getText();
                String contrasenia = new String(passwordField1.getPassword());
                String rolSeleccionado = (String) comboBox1.getSelectedItem();

                if (usuario.isEmpty() || contrasenia.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
                    return;
                }

                try (Connection conn = connect()) {
                    String sql = "SELECT rol FROM usuarios WHERE usuario = ? AND contrasenia = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, usuario);
                    pstmt.setString(2, contrasenia);

                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        String rol = resultSet.getString("rol");

                        if (rol.equals(rolSeleccionado)) {
                            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso! Bienvenido " + usuario);

                            if (rol.equals("administrador")) {

                                JFrame menuFrame = new JFrame("Pantalla de Administrador");
                                menuFrame.setContentPane(new administrador().PAdministrador);
                                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                menuFrame.setSize(500, 300);
                                menuFrame.setPreferredSize(new Dimension(500, 300));
                                menuFrame.setLocationRelativeTo(null);
                                menuFrame.pack();
                                menuFrame.setVisible(true);

                            }else if (rol.equals("cliente")) {

                                JFrame menuFrame = new JFrame("Pantalla de Usuario");
                                menuFrame.setContentPane(new cliente().PCliente);
                                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                menuFrame.setSize(500, 300);
                                menuFrame.setPreferredSize(new Dimension(500, 300));
                                menuFrame.setLocationRelativeTo(null);
                                menuFrame.pack();
                                menuFrame.setVisible(true);

                            }else if (rol.equals("veterinario")) {

                                JFrame menuFrame = new JFrame("Pantalla de Usuario");
                                menuFrame.setContentPane(new veterinario().PVeterinario);
                                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                menuFrame.setSize(500, 300);
                                menuFrame.setPreferredSize(new Dimension(500, 300));
                                menuFrame.setLocationRelativeTo(null);
                                menuFrame.pack();
                                menuFrame.setVisible(true);

                            }else if (rol.equals("secretaria")) {

                                JFrame menuFrame = new JFrame("Pantalla de Usuario");
                                menuFrame.setContentPane(new secretaria().PSecretaria);
                                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                menuFrame.setSize(500, 300);
                                menuFrame.setPreferredSize(new Dimension(500, 300));
                                menuFrame.setLocationRelativeTo(null);
                                menuFrame.pack();
                                menuFrame.setVisible(true);

                            }else {
                                JOptionPane.showMessageDialog(null, "No existe ese usuario en el rol actual, prueba con otro rol");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Rol no existente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en clever cloud");
                }
            }
        });
    }
}