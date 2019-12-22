/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_33;

import COLA.ColaA;
import PILA.PilaArreglo;

/**
 *
 * @author huesos
 */
public class Invierte {
    
    public static <T> void invierteA(ColaA <T> cola){
        PilaArreglo <T> aux = new PilaArreglo();
        
        while( !cola.estaVacia())
            aux.push(cola.quita());
        while( !aux.isEmpty())
            cola.agrega(aux.pop());
    }
    
    public static <T> void invierteB (ColaA <T> cola){
        if( !cola.estaVacia()){
            T aux = cola.quita();
            invierteB(cola);
            cola.agrega(aux);
        }
    }
        
}
