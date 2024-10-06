package interfaz;

import calculadora1.Calculadora1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Proporciona una interfaz gráfica para el registro de nuevos usuarios en la aplicación.
 * Los usuarios ingresan un nombre de usuario, una contraseña y confirman su contraseña.
 * Las contraseñas deben coincidir para que el registro sea exitoso.
 * Los datos del usuario se guardan en un archivo de texto.
 */
public class Register implements ActionListener {
    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JFrame frame;

    /**
     * Constructor que inicializa y configura los componentes de la interfaz gráfica para el registro.
     */
    public Register() {
        frame = new JFrame("Registrar Usuario");
        usuarioField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        JButton registerButton = new JButton("Guardar");
        JButton cancelButton = new JButton("Cancelar");

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Centrar la ventana

        JLabel usuarioLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Contraseña:");
        JLabel confirmPasswordLabel = new JLabel("Confirme Contraseña:");

        usuarioLabel.setBounds(30, 20, 100, 30);
        usuarioField.setBounds(150, 20, 120, 30);
        passwordLabel.setBounds(30, 60, 100, 30);
        passwordField.setBounds(150, 60, 120, 30);
        confirmPasswordLabel.setBounds(30, 100, 150, 30);
        confirmPasswordField.setBounds(150, 100, 120, 30);
        registerButton.setBounds(30, 150, 120, 30);
        cancelButton.setBounds(160, 150, 120, 30);

        frame.add(usuarioLabel);
        frame.add(usuarioField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
        frame.add(registerButton);
        frame.add(cancelButton);

        registerButton.addActionListener(this);
        cancelButton.addActionListener(e -> frame.dispose()); // Acción para el botón de cancelar

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Método invocado cuando se hace clic en el botón "Guardar".
     * Valida que las contraseñas ingresadas coincidan. Si la validación es exitosa, 
     * guarda el nuevo usuario en un archivo de texto (en formato usuario, contraseña).
     * En caso de error al guardar los datos, se muestra un mensaje de error.
     * 
     * @param e El evento de acción asociado al botón.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = usuarioField.getText().trim();
        String contraseña = new String(passwordField.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();

        if (!contraseña.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden. Inténtalo de nuevo.");
            return;
        }

        // Guardar usuario en el archivo
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("C:\\Proyectos\\Calculadora1\\src\\data\\users.txt", true))) {
            escritor.write(usuario + "," + contraseña);
            escritor.newLine();
            escritor.flush();
            JOptionPane.showMessageDialog(frame, "Usuario registrado exitosamente.");
            frame.dispose(); // Cerrar ventana de registro
            Calculadora1.launchApp(); // Reiniciar la aplicación despues del registro
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error al registrar el usuario.");
            ex.printStackTrace();
        }
    }
}

