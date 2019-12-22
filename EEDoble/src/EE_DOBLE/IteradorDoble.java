/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE_DOBLE;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tonotoledo
 */
public class IteradorDoble <T> implements Iterator{
    private NodoDoble<T> actual;
    
    public IteradorDoble(NodoDoble<T> apun){
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
