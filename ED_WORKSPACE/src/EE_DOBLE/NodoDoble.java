/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE_DOBLE;

/**
 *
 * @author huesos
 */
public class NodoDoble <T>{
    private T dato;
    private NodoDoble <T> ant;
    private NodoDoble <T> sig;
    
    public NodoDoble(){
        this.ant=null;
        this.sig=null;
        this.dato=null;
    }
    public NodoDoble(T dato){
        this.ant=null;
        this.sig=null;
        this.dato=dato;
    }
    
    public T getDato(){
        return this.dato;
    }
    
    public NodoDoble <T> getAnt(){
        return this.ant;
    }
    public NodoDoble <T> getSig(){
        return this.sig;
    }
    
    public void setDato(T dato){
        this.dato=dato;
    }
    
    public void setAnt(NodoDoble <T> ant){
        this.ant=ant;
    }
    
    public void setSig(NodoDoble <T> sig){
        this.sig=sig;
    }
    
    public String toString(){
        return this.dato.toString();
    }
}
