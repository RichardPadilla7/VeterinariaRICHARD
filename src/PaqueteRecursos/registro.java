import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registro extends conexion {
    public JPanel PRegistro;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton registrarmeButton;
    private JButton regresarAlInicioButton;

    public registro() {
        registrarmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCliente = textField1.getText();
                String contraCliente = passwordField1.getText();
                String rolCliente;
                rolCliente = "cliente";

                if (nombreCliente.isEmpty() || contraCliente.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
                    return;
                }

                try (Connection conn = connect()) {
                    String sql = "INSERT INTO usuarios (usuario, contrasenia, rol) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, nombreCliente);
                    pstmt.setString(2, contraCliente);
                    pstmt.setString(3, rolCliente);
                    pstmt.execute();
                    JOptionPane.showMessageDialog(null, "Registro de usuario exitoso");
                    textField1.setText("");
                    passwordField1.setText("");
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
    }
}
