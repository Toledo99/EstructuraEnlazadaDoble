/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_12;

import PILA.*;
        
/**
 *
 * @author huesos
 */
public class RevisorParentesis {
    private String cadena="";
    
    public RevisorParentesis(String cadena){
        this.cadena = cadena;
    }
    
    public boolean analizarCadena(){
        boolean resp;
        PilaArreglo <Character> pila = new PilaArreglo<Character>();
        
        int i=0;
        while(i<cadena.length()){
            if(cadena.charAt(i) == '(')
                pila.push('(');
            else
                if(cadena.charAt(i) == ')'){
                    if(pila.isEmpty())
                        return false; 
                    else
                        pila.pop();
                }  
            i++;
        }    
        
        if(pila.isEmpty())
            resp=true;
        else
            resp=false;
        
        return resp;
    }
    
    public static void main(String [] args){
        String c1 = "(a+b)*5";
        String c2 = "(a+b*5";
        String c3 = "(a+b)*5)";
        String c4 = ")a+b*5";
        String c5 = "(a+b*5)";
        
        RevisorParentesis r1 = new RevisorParentesis(c1);
        RevisorParentesis r2 = new RevisorParentesis(c2);
        RevisorParentesis r3 = new RevisorParentesis(c3);
        RevisorParentesis r4 = new RevisorParentesis(c4);
        RevisorParentesis r5 = new RevisorParentesis(c5);
        
        System.out.println(r1.analizarCadena());
        System.out.println(r2.analizarCadena());
        System.out.println(r3.analizarCadena());
        System.out.println(r4.analizarCadena());
        System.out.println(r5.analizarCadena());
    }
}
