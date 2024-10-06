
package interfaz;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.File;

/**
 * Representa una interfaz gráfica de usuario para una calculadora.
 * Esta clase permite realizar operaciones matemáticas básicas, mostrar y gestionar
 * operaciones previamente realizadas, y guardar los resultados en un archivo de texto.
 */
public class Ventana implements ActionListener{
    
    private String usuario;
    private ArrayList<String> operaciones;
    
    private int indiceSeleccionado= -1;
    JFrame frame = new JFrame();
    JTextField entrada = new JTextField();
    Archivos documento = new Archivos("C:\\Proyectos\\Calculadora1\\src\\data\\actividades.txt");
    
    //Definicion de los botones
    JButton igual = new JButton("=");
    JButton sumar = new botonCircular("+"); 
    JButton restar = new botonCircular("-"); 
    JButton multiplicar = new botonCircular("x"); 
    JButton dividir = new botonCircular("/");
    JButton porcentaje = new JButton("%");
    JButton punto = new JButton(".");
    JButton num0 = new JButton("0");
    JButton num1 = new JButton("1");
    JButton num2 = new JButton("2");
    JButton num3 = new JButton("3");
    JButton num4 = new JButton("4");
    JButton num5 = new JButton("5");
    JButton num6 = new JButton("6");
    JButton num7 = new JButton("7");
    JButton num8 = new JButton("8");
    JButton num9 = new JButton("9");
    JButton eliminarTodo = new JButton("AC");
    JButton eliminar = new JButton("C");
    JButton mostrarOperacionesButton = new JButton("Resultados");
    
    /**
     * Constructor de la clase Ventana.
     * 
     * @param usuario El nombre del usuario actual.
     * @throws IOException Si ocurre un error durante la creación o acceso al archivo de operaciones.
     */
    public Ventana(String usuario) throws IOException{
        this.usuario = usuario; 
        this.operaciones = new ArrayList<>();
        iniciar(usuario); 
        cargarOperacionesDesdeArchivo();
    }

    /**
     * Inicia la interfaz gráfica de la calculadora y configura sus componentes.
     * 
     * @param usuario Nombre del usuario para mostrar en la ventana.
     * @throws IOException Si ocurre un error al crear el archivo de datos.
     */
    private void iniciar(String usuario) throws IOException {
        
        this.documento.create("C:\\Proyectos\\Calculadora1\\src\\data\\data.txt");
        //this.documento.create("..\\data\\data.txt");
        
        //Configuración del JFrame
        frame.setSize(310, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setTitle("TECH GO - Usuario: \\" + usuario);
        frame.getContentPane().setBackground(new Color(0, 38, 77));
        frame.setVisible(true);
        
        Color buttonBackgroundDark = new Color(64, 72, 87);
        Color buttonBackgroundRed = new Color(235, 73, 86);
        Color buttonTextWhite = Color.WHITE;
        Color buttontexoper = new Color(51, 153, 102);
        Color buttonOperationColor = new Color(0, 0, 102);
        mostrarOperacionesButton.addActionListener(e -> mostrarOperaciones());
        mostrarOperacionesButton.setBounds(125, 100, 150, 25);
        frame.add(mostrarOperacionesButton);

        eliminarTodo.setText("AC");
        eliminar.setText("C");
        
        sumar.setSize(50,50);
        restar.setSize(50,50);
        multiplicar.setSize(50,50);
        dividir.setSize(50,50);
        porcentaje.setSize(50,50);
        punto.setSize(50,50);
        igual.setSize(50,115);
        num0.setSize(50,50);
        num1.setSize(50,50);
        num2.setSize(50,50);
        num3.setSize(50,50);
        num4.setSize(50,50);
        num5.setSize(50,50);
        num6.setSize(50,50);
        num7.setSize(50,50);
        num8.setSize(50,50);
        num9.setSize(50,50);
        
        sumar.setBackground(buttonOperationColor);
        restar.setBackground(buttonOperationColor);
        multiplicar.setBackground(buttonOperationColor);
        dividir.setBackground(buttonOperationColor);
        igual.setBackground(buttonBackgroundRed);

        sumar.setForeground(buttontexoper);
        restar.setForeground(buttontexoper);
        multiplicar.setForeground(buttontexoper);
        dividir.setForeground(buttontexoper);
        igual.setForeground(buttonTextWhite);
        
        entrada.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton[] botones={ sumar,restar,multiplicar,dividir,porcentaje,punto,
            igual,num0,num1,num2,num3,num4,num5,num6,num7,num8,num9};
        Font fuente = new Font("Arial",Font.PLAIN, 18);
        for(JButton boton : botones){
            boton.setFont(fuente);
        }
        
        sumar.setLocation(155, 135);
        restar.setLocation(220,135);
        multiplicar.setLocation(220, 200);
        dividir.setLocation(220, 265);
        porcentaje.setLocation(155,395);
        punto.setLocation(90,395);
        igual.setLocation(220, 330);
        num0.setLocation(25,395);
        num1.setLocation(25,330);
        num2.setLocation(90,330);
        num3.setLocation(155,330);
        num4.setLocation(25,265);
        num5.setLocation(90,265);
        num6.setLocation(155,265);
        num7.setLocation(25,200);
        num8.setLocation(90,200);
        num9.setLocation(155,200);
        
        
        //Añadiendo botones al JFrame
        frame.add(sumar);
        frame.add(restar);
        frame.add(multiplicar);
        frame.add(dividir);
        frame.add(porcentaje);
        frame.add(punto);
        frame.add(igual);
        frame.add(num0);
        frame.add(num1);
        frame.add(num2);
        frame.add(num3);
        frame.add(num4);
        frame.add(num5);
        frame.add(num6);
        frame.add(num7);
        frame.add(num8);
        frame.add(num9);
        
        entrada.setSize(248,60);
        entrada.setLocation(25, 25);
        frame.add(entrada);
     
        eliminarTodo.setSize(50,50);
        eliminarTodo.setLocation(25,135);
        frame.add(eliminarTodo);
        eliminar.setSize(50,50);
        eliminar.setLocation(90,135);
        frame.add(eliminar);
        
        eliminarTodo.addActionListener(this);
        eliminar.addActionListener(this);
        sumar.addActionListener(this);
        restar.addActionListener(this);
        multiplicar.addActionListener(this);
        dividir.addActionListener(this);
        porcentaje.addActionListener(this);
        punto.addActionListener(this);
        igual.addActionListener(this);
        num0.addActionListener(this);
        num1.addActionListener(this);
        num2.addActionListener(this);
        num3.addActionListener(this);
        num4.addActionListener(this);
        num5.addActionListener(this);
        num6.addActionListener(this);
        num7.addActionListener(this);
        num8.addActionListener(this);
        num9.addActionListener(this);

        
    }

     /**
     * Método que responde a los eventos de los botones de la calculadora.
     * 
     * @param e Evento que indica qué botón fue presionado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.sumar) {
            this.entrada.setText(this.entrada.getText()+"+");
        }
        if (e.getSource() == this.restar) {
            this.entrada.setText(this.entrada.getText()+"-");
        }
        if (e.getSource() == this.multiplicar) {
            this.entrada.setText(this.entrada.getText()+"*");
        }
        if (e.getSource() == this.dividir) {
            this.entrada.setText(this.entrada.getText()+"/");
        }
        if (e.getSource() == this.porcentaje) {
            this.entrada.setText(this.entrada.getText()+"%");
        }
        if (e.getSource() == this.punto) {
            this.entrada.setText(this.entrada.getText()+".");
        }
        if (e.getSource() == this.num0) {
        this.entrada.setText(this.entrada.getText() + "0");
        } 
        if (e.getSource() == this.num1) {
            this.entrada.setText(this.entrada.getText() + "1");
        } 
        if (e.getSource() == this.num2) {
            this.entrada.setText(this.entrada.getText() + "2");
        } 
        if (e.getSource() == this.num3) {
            this.entrada.setText(this.entrada.getText() + "3");
        } 
        if (e.getSource() == this.num4) {
            this.entrada.setText(this.entrada.getText() + "4");
        } 
        if (e.getSource() == this.num5) {
            this.entrada.setText(this.entrada.getText() + "5");
        } 
        if (e.getSource() == this.num6) {
            this.entrada.setText(this.entrada.getText() + "6");
        } 
        if (e.getSource() == this.num7) {
            this.entrada.setText(this.entrada.getText() + "7");
        } 
        if (e.getSource() == this.num8) {
            this.entrada.setText(this.entrada.getText() + "8");
        } 
        if (e.getSource() == this.num9) {
            this.entrada.setText(this.entrada.getText() + "9");
        }
        if (e.getSource() == this.igual) {
            this.calcular();  

        }
        if (e.getSource() == this.eliminarTodo) {
            this.entrada.setText("");
        }
        if (e.getSource() == this.eliminar) {
            String currentText = this.entrada.getText();
            if(currentText.length()>0){
                this.entrada.setText(currentText.substring(0,currentText.length
                ()-1));
            }  
        }
       
     }

     /**
     * Carga las operaciones realizadas desde un archivo de texto y las almacena en una lista.
     */
    private void cargarOperacionesDesdeArchivo() {
        String rutaArchivo = "C:\\Proyectos\\Calculadora1\\src\\data\\" + usuario + "_actividades.txt";
        operaciones.clear(); 
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                operaciones.add(linea);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al cargar las operaciones.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     /**
     * Guarda las operaciones realizadas en un archivo de texto.
     */
    private void guardarOperacionesEnArchivo() {
        String rutaArchivo = "C:\\Proyectos\\Calculadora1\\src\\data\\" + usuario + "_actividades.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String operacion : operaciones) {
                writer.write(operacion);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
     /**
     * Modifica una operación ya registrada.
     * 
     * @param indice Indice de la operación a modificar.
     * @param nuevaOperacion Nueva operación que reemplazará a la anterior.
     */
    public void modificarOperacion(int indice, String nuevaOperacion) {
        if (indice >= 0 && indice < operaciones.size()) {
            operaciones.set(indice, nuevaOperacion); // Modifica la operación
            
            registrarActividad(nuevaOperacion); 
        } else {
            JOptionPane.showMessageDialog(frame, "Índice fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     /**
     * Muestra una ventana con todas las operaciones realizadas.
     */
    private void mostrarOperaciones() {
        JList<String> listaOperaciones = new JList<>(operaciones.toArray(new String[0]));
        listaOperaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaOperaciones);

        JButton modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(e -> {
            int indiceSeleccionado = listaOperaciones.getSelectedIndex();
            if (indiceSeleccionado != -1) {
                String operacionSeleccionada = operaciones.get(indiceSeleccionado);
                entrada.setText(operacionSeleccionada.split("=")[0].trim());
                JOptionPane.showMessageDialog(frame, "Realize nueva operación o modifique", "Modificar Operación", JOptionPane.INFORMATION_MESSAGE);
                this.indiceSeleccionado = indiceSeleccionado;
            } else {
                JOptionPane.showMessageDialog(frame, "Por favor, selecciona una operación para modificar.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton nuevoButton = new JButton("Nuevo");
        nuevoButton.addActionListener(e -> {
        // Ruta para el nuevo archivo.
        String nuevoArchivo = "C:\\Proyectos\\Calculadora1\\src\\data\\" + usuario + "_nueva_actividad_" + System.currentTimeMillis() + ".txt";

        // Crear el nuevo archivo
        try {
            File nuevoFile = new File(nuevoArchivo);
            nuevoFile.createNewFile();

            // Guardar las operaciones actuales en el nuevo archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nuevoFile))) {
                for (String operacion : operaciones) {
                    writer.write(operacion);
                    writer.newLine();
                }
            }

            // Limpiar el archivo actual
            String rutaArchivoActual = "C:\\Proyectos\\Calculadora1\\src\\data\\" + usuario + "_actividades.txt";
            new BufferedWriter(new FileWriter(rutaArchivoActual)).close(); // Esto vacía el archivo

            
            JOptionPane.showMessageDialog(frame, "Nuevo archivo creado: " + nuevoArchivo , "Archivo Creado", JOptionPane.INFORMATION_MESSAGE);

            cargarOperacionesDesdeArchivo(); 
            listaOperaciones.setListData(operaciones.toArray(new String[0])); 

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error al crear el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    });

        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(e -> {
            int indiceSeleccionado = listaOperaciones.getSelectedIndex();
            if (indiceSeleccionado != -1) {
                operaciones.remove(indiceSeleccionado);

                guardarOperacionesEnArchivo(); 
                listaOperaciones.setListData(operaciones.toArray(new String[0])); 
                JOptionPane.showMessageDialog(frame, "Por favor, selecciona una operación para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Botón "Actualizar"
        JButton actualizarButton = new JButton("Actualizar");
        actualizarButton.addActionListener(e -> {
            cargarOperacionesDesdeArchivo(); 
            listaOperaciones.setListData(operaciones.toArray(new String[0]));

        });

        // Crear un panel para mostrar la lista y los botones
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(modificarButton);
        buttonPanel.add(nuevoButton);
        buttonPanel.add(eliminarButton);
        buttonPanel.add(actualizarButton); 

        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        JDialog dialog = new JDialog(frame, "Operaciones Realizadas", Dialog.ModalityType.MODELESS);
        dialog.setContentPane(panel);
        dialog.setSize(400, 300);
        int x = frame.getX() + frame.getWidth();
        int y = frame.getY(); 
        dialog.setLocation(x, y);
        dialog.setVisible(true);
    }

    /**
     * Evalúa y calcula el resultado de la operación introducida en el campo de texto.
     */
    public void calcular() {
        String expresion = this.entrada.getText();
        Expression e = new ExpressionBuilder(expresion).build();

        // Evaluar la expresión
        double resultado;
        try {
            resultado = e.evaluate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error en la expresión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si hay una operación seleccionada para modificar
        if (this.indiceSeleccionado >= 0) {
            // Modificar la operación existente
            if (indiceSeleccionado < operaciones.size()) {
                String operacionModificada = expresion + " = " + resultado;
                operaciones.set(indiceSeleccionado, operacionModificada);
                JOptionPane.showMessageDialog(frame, "Operación modificada: " + operacionModificada, "Operación Modificada", JOptionPane.INFORMATION_MESSAGE);
                registrarActividad(operacionModificada); 
                this.indiceSeleccionado = -1; 
            }
        } else {
            // Registrar la nueva operación
            String operacionNueva = expresion + " = " + resultado;
            operaciones.add(operacionNueva);
            registrarActividad(operacionNueva); 
        }

        // Mostrar el resultado en el campo de entrada
        this.entrada.setText(resultado + "");

        guardarOperacionesEnArchivo();
    }


    /**
     * Registra cada operación realizada en un archivo de texto.
     * 
     * @param registro El registro de la operación realizada.
     */
    private void registrarActividad(String registro) {
        String user = this.usuario; // Usa el nombre del usuario

        // Define la ruta del archivo usando el nombre del usuario
        String rutaArchivo = "C:\\Proyectos\\Calculadora1\\src\\data\\" + user + "_actividades.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write("Usuario: " + user + " realizó la operación: " + registro);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
   } 
}