
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atoledog
 */
public class PilaA<T> implements PilaADT<T>{
    
    private T[] pila;
    private int tope;
    private final int MAX=20;

    public PilaA() {
        pila=(T[])new Object[MAX];
        tope=-1;
    }
    
    public PilaA(int max){
        pila=(T[])new Object[max];
        tope=-1;
    }
    
    public boolean isEmpty(){
        return tope==-1;
    }
    
    public void push(T dato){
        if(tope+1==pila.length)
            expande();
        tope++;
        pila[tope]=dato;
    }
    
    private void expande(){
        T[] nuevo=(T[])new Object[pila.length*2];
        for(int i=0; i<=tope; i++)
            nuevo[i]=pila[i];
        pila=nuevo;
    }
    
    public T pop(){
        if(isEmpty())
            throw new EmptyCollectionException();
        T resul;
        resul=pila[tope];
        pila[tope]=null;
        tope--;
        return resul;
    }
    
    public T peek(){
        if(isEmpty())
            throw new EmptyCollectionException();
        return pila[tope];
    }
    
    public void multipop(int n){
        if(isEmpty())
            throw new EmptyCollectionException();
        int i=0;
        
        while(!isEmpty() && i<n){
            pop();
            i++;
        }
    }
    
    public String toString(){
        StringBuilder cad=new StringBuilder();
        
        for(int i=0; i<pila.length; i++){
            cad.append("\n"+pila[i]);
        }
        return cad.toString();
    }
}
