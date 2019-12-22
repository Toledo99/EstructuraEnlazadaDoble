/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESTRUCTURA_ENLAZADA;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author huesos
 */
public class IteradorEE <T> implements Iterator<T> {
    private Nodo<T> actual;
    
    public IteradorEE(Nodo<T> apun){
        actual = apun;
    }
    
    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if(hasNext()){
            T res;
            res = actual.getDato();
            actual.getSig();
            return res;
        }
        else
            throw new NoSuchElementException();
    }
    
}
