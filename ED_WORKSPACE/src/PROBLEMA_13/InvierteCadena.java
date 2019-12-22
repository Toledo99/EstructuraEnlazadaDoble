/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_13;

import PILA.*;
/**
 *
 * @author huesos
 */
public class InvierteCadena {
    private String cadenaInicial="";
    private String cadenaInvertida="";
    
    public InvierteCadena(String cadena){
        this.cadenaInicial=cadena;
    }
    
    public String inversion(){
        
        PilaArreglo <Character> pila = new PilaArreglo<Character>();
        for(int i=0; i<cadenaInicial.length(); i++)
            pila.push(cadenaInicial.charAt(i));
        
        for(int i=0; i<cadenaInicial.length(); i++)
            cadenaInvertida+= pila.pop();
        return cadenaInvertida;
    }
    
    public static void main (String [] args){
        InvierteCadena c1 = new InvierteCadena("abcdef");
        
        System.out.println("abcdef");
        System.out.println(c1.inversion());
    }
}
