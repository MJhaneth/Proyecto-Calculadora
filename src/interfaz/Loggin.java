package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Proporciona la interfaz gráfica para el inicio de sesión de usuarios.
 * Permite al usuario acceder ingresando su nombre de usuario y contraseña.
 * También ofrece opciones para registrarse o cancelar el inicio de sesión.
 * 
 * Implementa ActionListener para manejar eventos de los botones.
 */
public class Loggin implements ActionListener {
    
    /**
     * Ventana principal de interfaz gráfica.
     */
    JFrame frame = new JFrame("Iniciar Sesión");
    
    /**
     * Etiquetas y campos de texto utilizados en la interfaz gráfica.
     */
    JLabel iniciarSesion = new JLabel("INICIAR SESION");
    JLabel usuarioLabel = new JLabel("Usuario: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField usuarioField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    
    /**
     * Botones utilizados en la interfaz.
     */
    JButton registrarseButton = new JButton("Registrarse");
    JButton accederButton = new JButton("Acceder");
    JButton cancelarButton = new JButton("Cancelar"); 

    /**
     * HashMap que almacena los usuarios y sus contraseñas.
     * Simula una base de datos.
     */
    HashMap<String, String> usersDB = new HashMap<>();
    
    /**
     * Constructor que carga los usuarios desde el archivo de texto y
     * inicializa los componentes de la interfaz gráfica.
     */
    public Loggin() {
        loadUsers();
        initComponents(); 
    }

    /**
     * Inicializa los componentes de la interfaz gráfica y los posiciona en la ventana.
     * Este método también configura las acciones de los botones para responder a eventos.
     */
    private void initComponents() {
        // Configuración de componentes gráficos
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciarSesion.setBounds(150, 20, 150, 30);
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 20));
        
        usuarioLabel.setBounds(50, 70, 100, 30);
        usuarioField.setBounds(150, 70, 200, 30);

        passwordLabel.setBounds(50, 120, 100, 30);
        passwordField.setBounds(150, 120, 200, 30);

        registrarseButton.setBounds(50, 180, 120, 30);
        accederButton.setBounds(200, 180, 120, 30);
        cancelarButton.setBounds(125, 220, 120, 30); 
        
        //Asignar los ActionListeners a los botones
        registrarseButton.addActionListener(this);
        accederButton.addActionListener(this);
        cancelarButton.addActionListener(e -> frame.dispose()); 
        
        //Anadir componentes a la ventana      
        frame.add(iniciarSesion);
        frame.add(usuarioLabel);
        frame.add(usuarioField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(registrarseButton);
        frame.add(accederButton);
        frame.add(cancelarButton); 
        
        frame.setVisible(true);
    }
    
    /**
     * Carga los usuarios desde el archivo de texto 'users.txt' y los almacena en el HashMap.
     * El archivo debe estar ubicado en la ruta especificada.
     * 
     * Cada línea del archivo contiene un usuario y su contraseña separados por una coma.
     * Si el archivo no existe o no se puede leer, se maneja la excepción IOException.
     */
    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Proyectos\\Calculadora1\\src\\data\\users.txt"))) {
            String line;
            usersDB.clear();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    usersDB.put(parts[0], parts[1]);
                }  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método que responde a los eventos de los botones de la interfaz.
     * Se encarga de validar las credenciales de acceso del usuario.
     * 
     * @param e El evento generado por el botón presionado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accederButton) {
            String user = usuarioField.getText().trim();
            String pass = new String(passwordField.getPassword()).trim();

            //Validar exitencia, contraseña y inicio de sesion exitoso del usuario
            if (!usersDB.containsKey(user)) {
                JOptionPane.showMessageDialog(frame, "El usuario no existe.");
            } else if (!usersDB.get(user).equals(pass)) {
                JOptionPane.showMessageDialog(frame, "Error en la contraseña del usuario.");
            } else {
                JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso");
                frame.dispose(); // Cerrar la ventana de Loggin
                try {
                    new Ventana(user); // Abrir la ventana de Register
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        // Redirige al usuario a la ventana de Register de nuevos usuarios.

        else if (e.getSource() == registrarseButton) {
            frame.dispose(); // Cierra la ventana de inicio de sesión actual
            new Register(); // Abre una nueva ventana para el Register de usuarios
        }
    }
    
    /**
     * Este método que recarga los usuarios desde el archivo de texto.
     */
    public void refreshUsers() {
        loadUsers();
    }
    
    /**
     * Cambia la visibilidad de la ventana de inicio de sesión.
     * 
     * @param visible true para mostrar la ventana, false para ocultarla.
     */
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
