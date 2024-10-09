
package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Proporciona un botón circular personalizado, basado en la clase JButton.
 * Se personalizan los métodos de pintura, borde y verificación de clics para que el
 * botón se comporte visualmente como un círculo.
 */
public class botonCircular extends JButton {

    /**
     * Constructor que crea un botón circular con el texto especificado.
     *
     * @param texto El texto a mostrar en el botón.
     */
    public botonCircular(String texto) {
        super(texto);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    /**
     * Sobrescribe el método para pintar el componente. Dibuja el fondo del botón como un óvalo relleno (circular).
     *
     * @param g El objeto Graphics que se usa para dibujar el botón.
     */
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            // Cambia el color cuando el botón está presionado
            g.setColor(Color.LIGHT_GRAY);
        } else {
            // Usa el color de fondo predeterminado
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        super.paintComponent(g);
    }

    /**
     * Sobrescribe el método para pintar el borde del botón.
     * Dibujar el borde circular del botón.
     *
     * @param g El objeto Graphics que se usa para dibujar el borde del botón.
     */
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

     /**
     * Calcula y retorna las dimensiones preferidas para el botón, garantizando que sea circular.
     *
     * @return El tamaño preferido del botón.
     */
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        int diameter = Math.max(size.width, size.height);
        size.setSize(diameter, diameter);
        return size;
    }

    /**
     * Determina si un punto (x, y) está dentro de los límites circulares del botón.
     *
     * @param x La coordenada X del punto.
     * @param y La coordenada Y del punto.
     * @return true si el punto está dentro del área circular, de lo contrario, false.
     */
    @Override
    public boolean contains(int x, int y) {
        Ellipse2D circle = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return circle.contains(x, y);
    }
}

