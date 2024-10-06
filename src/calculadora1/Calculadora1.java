
package calculadora1;

import interfaz.Loggin;
import interfaz.Ventana;
import java.io.IOException;

/**
 * Inicia la aplicación de la calculadora mostrando la ventana principal
 * después de que el usuario haya iniciado sesión.
 */
public class Calculadora1 {
    
    /**
     * Variable para almacenar el usuario que ha iniciado sesión.
     */
    private String usuario; 
    
    /**
     * Constructor de la clase Calculadora1.
     * 
     * @param user Nombre del usuario que a iniciado sesión
     */
    public Calculadora1(String user) {
        this.usuario = user;  
        try {
            new Ventana(usuario); 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
    
    /**
     * Método principal que ejecuta la aplicación.
     * 
     * @param args Parámetros pasados por la línea de comandos (sin usar)
     */
    public static void main(String[] args) {
        launchApp();
    }
    
    /**
     * Inicia la aplicación y muestra la ventana de inicio de sesión.
     */
    public static void launchApp() {
        Loggin login = new Loggin();
        login.setVisible(true);
    }
}
