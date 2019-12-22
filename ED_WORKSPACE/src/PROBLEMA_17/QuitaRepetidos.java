/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_17;

import PILA.*;
/**
 *
 * @author huesos
 */
public class QuitaRepetidos <T>{
    
    public static <T> void quitaRepetidos(PilaADT <T> pila){
        if( pila!= null && !pila.isEmpty()){
            int max = pila.getTope();

            PilaArreglo<T> pAux = new PilaArreglo<T>();

            while(!pila.isEmpty()){
               if(pAux.isEmpty() || !pAux.peek().equals(pila.peek())) 
                   pAux.push(pila.pop());
               else
                   pila.pop(); 
            }

            while(!pAux.isEmpty()){
                System.out.println(pAux.peek());
                pila.push(pAux.pop());
            }
        }
    }
    
    public static void main (String [] args){
        PilaArreglo pila = new PilaArreglo();
        pila.push("a");
        pila.push("b");
        pila.push("b");
        pila.push("c");
        
        QuitaRepetidos.quitaRepetidos(pila);
        
        
    }
}
