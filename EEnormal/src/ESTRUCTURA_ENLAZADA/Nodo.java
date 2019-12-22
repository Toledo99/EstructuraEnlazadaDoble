/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESTRUCTURA_ENLAZADA;

/**
 *
 * @author huesos
 */
public class Nodo<T>  {
    private T dato;
    private Nodo<T> sig;
    
    public Nodo(){
        this.dato=null;
        this.sig=null;
    }
    public Nodo(T dato){
        this.dato= dato;
        this.sig=null;
    }
    
    public T getDato(){
        return this.dato;
    }
    
    public Nodo<T> getSig(){
        return this.sig;
    }
    
    public void setDato(T dato){
        this.dato=dato;
    }
    public void setSig(Nodo<T> sig){
        this.sig= sig;
    }
    
    
    public String toString(){
        return this.dato.toString();    
    }
}
