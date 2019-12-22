/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_15;

import PILA.*;
import java.util.ArrayList;
/**
 *
 * @author huesos
 */
public  class ContienePila <T>{
    
    public static <T> boolean contienePila(PilaADT <T> p1, PilaADT <T> p2){
        boolean resp=false;
        ArrayList<T> lista= new ArrayList<T>();
        PilaArreglo <T> pAux= new PilaArreglo <T>();
        
        if(p1.getTope() < p2.getTope())
            return false;
        if(p1.isEmpty() && p2.isEmpty())
            return true;
        
        int max= p1.getTope();
        
        for(int i=0; i<= max; i++)
            lista.add(p1.pop());
        
        
        while(p2.getTope() >= 0 && lista.contains(p2.peek()))
            pAux.push(p2.pop());
        
        if(p2.getTope() < 0)
            resp=true;
        
        int maxi=pAux.getTope();
        
        for(int i=0; i< maxi; i++)
            p2.push(pAux.pop());
        
        return resp;
    }
    
    public static void main (String [] args){
        PilaArreglo p1= new PilaArreglo();
        p1.push("Hola");
        p1.push("Adios");
        p1.push("Tschuss");
        
        PilaArreglo p2= new PilaArreglo();
        p2.push("Adios");
        p2.push("Hola");
        
        System.out.println(ContienePila.contienePila(p1, p2));
        
    }
}
