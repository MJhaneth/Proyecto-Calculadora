
package interfaz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Proporciona la creación y modificación de archivos de texto.
 */
public class Archivos  {
    private String nombre;
    private File archivo;
    
    /**
     * Constructor que inicializa el nombre del archivo.
     * 
     * @param nombre Nombre del archivo
     */
    public Archivos(String nombre)  {
        this.nombre=nombre;      
    }
    
    /**
     * Crea un archivo en la ruta especificada.
     * 
     * @param ruta Ubicación del nuevo archivo
     * @throws IOException Si ocurre un error al crear el archivo
     */
    public void  create( String ruta) throws IOException  {
        this.archivo = new File(ruta);
        this.archivo.createNewFile();        
    }
    
    /**
     * Devuelve el nombre del archivo.
     * 
     * @return Nombre del archivo
     */
    public String getNombre(){
    return this.nombre;
    }
    
    /**
     * Añade una línea de texto al archivo.
     * 
     * @param linea Línea de texto a añadir
     * @return true si se añadió correctamente, false en caso de error
     */
    public  boolean registrar(String linea){
        try {
            if(archivo.exists()){
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(linea);
                pw.flush();
                pw.close();
                return  true;
            }
        } catch (IOException ex) {
            System.out.println("error de archivo: "+ex);
               
        }
        return false;
    }
    
    /**
     * Elimina y recrea el archivo para limpiarlo.
     * 
     * @return true si se limpia correctamente, false en caso error
     */
    public boolean limpiarArchivo(){
        try {
            String directorio = archivo.getParent();
            archivo.delete();
            new FileWriter(directorio+"/datos.txt",true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Asigna un nuevo nombre para el archivo.
     * 
     * @param nombre Nuevo nombre del archivo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   /**
    * Devuelve el archivo.
    * 
    * @return El archivo 
    */
    public File getArchivo() {
        return archivo;
    }

    /** Asigna el archivo.
     * 
     * @param archivo Nuevo archivo
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
}
