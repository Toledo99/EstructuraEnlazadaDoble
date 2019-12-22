/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_16;

import PILA.*;
import java.util.ArrayList;
/**
 *
 * @author huesos
 * @param <T>
 */
public class InviertePila <T>{
    
    /*
    public static <T> void inviertePila(PilaADT <T> pila){
        
        PilaArreglo <T> pAux= new PilaArreglo();
        
        int max=pila.getTope();
        
        for(int i=0; i<=max; i++){
            pAux.push(pila.peek());
            pila.pop();
        }
        pila=pAux;
    }
    */
    
    public static <T> void inviertePila(PilaADT <T> pila){
        
        if(pila!= null && !pila.isEmpty()){
            ArrayList<T> lista = new ArrayList<T>();

            int max=pila.getTope();

            for(int i=0; i<=max; i++)
                lista.add(pila.pop());

            for(int i=max; i>=0; i--)
                pila.push(lista.get(i));
        }
    }
    

    public static void main (String [] args){
        PilaArreglo pila = new PilaArreglo();
        pila.push("1");
        pila.push("2");
        pila.push("3");
        
        InviertePila.inviertePila(pila);
        
        for(int i=0; i<3; i++)
            System.out.println(pila.pop());
    }
}
