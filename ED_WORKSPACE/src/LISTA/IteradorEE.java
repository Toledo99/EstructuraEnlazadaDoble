/* Estructuras de Datos
* Silvia Guardati
*/

package LISTA;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alvaro Romo
 */
public class IteradorEE <T> implements Iterator<T> {
    
    private Nodo<T> actual;
    
    public IteradorEE(Nodo<T> apun){
        actual = apun;
    }
    
    public boolean hasNext(){
        return actual != null;
    }
    
    public T next(){
        if(hasNext()){
            T resul;
            resul = actual.getDato();
            actual = actual.getSig();
            return resul;
        }
        else {
            throw new NoSuchElementException();
        }
    }

}
