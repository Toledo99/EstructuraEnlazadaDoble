/* Estructuras de Datos
* Silvia Guardati
*/

package LISTA;

/**
 * @author Alvaro Romo
 */
public class Nodo<T> {
    
    private T dato;
    private Nodo<T> sig;
    
    public Nodo(){
        sig = null;
    }
    
    public Nodo(T dato){
        this.dato = dato;
        sig = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSig() {
        return sig;
    }

    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }
    
    public String toString(){
        return dato.toString();
    }

}
