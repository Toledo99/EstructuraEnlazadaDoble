/**
 * Diego Hernández Delgado
 * (176262)
 * Fecha de examen: 26/27/2019
 */
package primerparcialfebrero2019_g2;

/**
 * Interfaz para definir el comportamiento de una Pila.
 * @author SGUARDATB
 * Modificado por: Diego HD
 */
public interface PilaADT <T>{
    public T pop();
    public T peek();
    public boolean isEmpty();
    public void push(T dato);
    
    //MÉTODO AGREGADO --> PROBLEMA 2:
    public String toString();
}
