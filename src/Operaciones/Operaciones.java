
package Operaciones;

/**
 * Proporciona métodos básicos para operaciones aritméticas.
 */
public class Operaciones {
    
    /**
     * Suma dos números
     * 
     * @param a Primer número
     * @param b Segundo número
     * @return Suma de a y b
     */
    public int sumar(int a , int b){
        return a + b;
    }
    
    /**
     * Resta dos números
     * 
     * @param a Primer número
     * @param b Segundo número
     * @return Diferencia entre a y b 
     */
    public int restar(int a , int b){
        return a - b;
    }
    
    /**
     * Multiplica dos números
     * 
     * @param a Primer número
     * @param b Segundo número
     * @return Producto de a y b
     */
    public int multiplicar(int a , int b){
        return a * b;
    }
    
    /**
     * Divide un número por otro
     * 
     * @param a Dividendo
     * @param b Divisor
     * @return Cociente de a y b
     * @throws IllegalArgumentException si b es cero
     */
    public int dividir(int a , int b){
        if (b == 0) {
            throw new IllegalArgumentException("División por cero no es permitida.");
        }
        return (int) a / b;
    }
    
    /**
     * Calcular el porcentaje de un número
     * @param b Número para calcular el porcentaje
     * @return Porcentaje de b
     */
    public double porcentaje(int b){
        b=b/100;
        return b;
    }
    
}
