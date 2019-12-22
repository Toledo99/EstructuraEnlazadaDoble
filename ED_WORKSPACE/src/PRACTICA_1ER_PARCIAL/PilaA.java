/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA_1ER_PARCIAL;

/**
 *
 * @author huesos
 */
public class PilaA <T> implements PilaADT <T>{
    private T [] pila;
    private int tope;
    private static final int MAX=20;
    
    public PilaA(){
        pila = (T[]) new Object [MAX];
        tope=-1;
    }
    
    @Override
    public void push(T dato) {
        if(tope+1 == pila.length)
            expande();
        tope++;
        pila[tope]=dato;
    }

    @Override
    public T pop() {
       if(isEmpty())
           throw new EmptyCollectionException();
       T resp= pila[tope];
       pila[tope]=null;
       tope--;
       return resp;
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyCollectionException();
        return pila[tope];
    }

    @Override
    public boolean isEmpty() {
        return this.tope == -1;
    }

    @Override
    public int getTope() {
        return this.tope;
    }
    
    public void expande(){
        T [] nuevo = (T[]) new Object[tope*2];
        for(int i=0; i<tope; i++)
            nuevo[i]=pila[i];
        pila=nuevo;
    }
}
