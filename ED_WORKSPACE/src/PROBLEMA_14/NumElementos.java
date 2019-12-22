/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_14;

import PILA.*;
/**
 *
 * @author huesos
 */
public class NumElementos <T> {
    
    public static <T> int numElementos(PilaADT <T> pila){
        int resp=0;
        PilaArreglo <T> pAux = new PilaArreglo<>();
        while(!pila.isEmpty()){
            pAux.push(pila.pop());
            resp++;
        }
        while(!pAux.isEmpty())
            pila.push(pAux.pop());
        return resp;
    }
    
    public static void main (String [] args){
        PilaArreglo pila = new PilaArreglo();
        pila.push("horno");
        pila.push("estufa");
        pila.push("microondas");
        
        System.out.println(NumElementos.numElementos(pila));
                
    }
}
