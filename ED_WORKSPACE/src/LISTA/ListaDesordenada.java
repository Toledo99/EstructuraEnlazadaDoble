/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LISTA;

/**
 *
 * @author tonotoledo
 */
public class ListaDesordenada <T extends Comparable<T>> extends Lista<T> implements ListaDesordenadaADT<T>{
    
    
    public ListaDesordenada(){
        
    }
    
    public void agregaInicio(T dato){
        
        if(dato!=null){
            Nodo<T> nuevo=new Nodo(dato);
            if(estaVacia()){
                primero=nuevo;
                ultimo=nuevo;
            }
            else{
                nuevo.setSig(primero);
                primero=nuevo;
            }
        }
    }
    public void agregaFinal(T dato){
        if(dato!=null){
            Nodo<T> nuevo=new Nodo(dato);
            if(estaVacia()){
                primero=nuevo;
                ultimo=nuevo;
            }
            else{
                ultimo.setSig(nuevo);
                ultimo=nuevo;
            }
        }
    }
    public boolean agregaAntesQue(T refe, T dato){
        boolean res=false;
        
        if(refe!=null && dato!=null && !estaVacia()){
            Nodo<T> nuevo=new Nodo(dato);
            if(primero.getDato().equals(dato)){
                nuevo.setSig(primero);
                primero=nuevo;
            }
            res=agregaAntesQue(refe, nuevo, primero, primero.getSig());
        }
        return res;
    }
    
    private boolean agregaAntesQue(T refe, Nodo<T> nuevo, Nodo<T> ant, Nodo<T> actual){
        if(actual==null)
            return false;
        else{
            if(actual.getDato().equals(refe)){
                ant.setSig(nuevo);
                nuevo.setSig(actual);
                return true;
            }
            else
                return agregaAntesQue(refe, nuevo, actual,actual.getSig() );
        }
    }
    
    public boolean agregaDespuesQue(T refe, T dato){
        boolean res=false;
        
        if(refe!=null && dato!=null && !estaVacia()){
            Nodo<T> actual=primero;
            while(actual!=null && actual.getDato().equals(refe)){
                actual=actual.getSig();
            }
            if(actual==null){
                res=false;
            }
            else{
                Nodo<T> nuevo=new Nodo(dato);
                nuevo.setSig(actual.getSig());
                actual.setSig(nuevo);
            }
        }
        return res;
    }
    
    
    
}
