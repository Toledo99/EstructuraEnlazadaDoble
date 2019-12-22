/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_18;

import PILA.*;
        
/**
 *
 * @author huesos
 */
public class RevisorCorchetes {
    private String cadena="";
    
    public RevisorCorchetes(String cadena){
        this.cadena = cadena;
    }
    
    public boolean analizarCadena(){
        char c;
        PilaArreglo <Character> pila = new PilaArreglo<>();
        
        int i=0;
        while(i<cadena.length()){
            c=cadena.charAt(i);
            if(c == '(' ||  c == '[' || c == '{')
                pila.push(c);
            else
                if(c == ')' ||  c == ']' || c == '}')
                    if(pila.isEmpty())
                        return false; 
                    else
                        switch(c){
                            case ')':
                                if(pila.peek() == '(')
                                    pila.pop();
                                else
                                    return false;
                                break;
                                
                            case ']':
                                if(pila.peek() == '[')
                                    pila.pop();
                                else
                                    return false;
                                break;
                                
                            case '}':
                                if(pila.peek() == '{')
                                    pila.pop();
                                else
                                    return false;
                                break;
                        }      
            i++;
        }    
        if(pila.isEmpty())
            return true;
        else
            return false;

    }
    
    public static void main(String [] args){
        String c1 = "[({a+b})*5]";
        String c2 = "(a+b*5";
        String c3 = "[a+b*5]";
        String c4 = ")a+b*5";
        String c5 = "(a+b*5)";
        
        RevisorCorchetes r1 = new RevisorCorchetes(c1);
        RevisorCorchetes r2 = new RevisorCorchetes(c2);
        RevisorCorchetes r3 = new RevisorCorchetes(c3);
        RevisorCorchetes r4 = new RevisorCorchetes(c4);
        RevisorCorchetes r5 = new RevisorCorchetes(c5);
        
        System.out.println(r1.analizarCadena());
        System.out.println(r2.analizarCadena());
        System.out.println(r3.analizarCadena());
        System.out.println(r4.analizarCadena());
        System.out.println(r5.analizarCadena());
    }
}
