/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dyck;
import PILA.*;
/**
 *
 * @author tonotoledo
 */
public class EjercicioComoCalcu {
    
    public static boolean pertenece(String cad){
        boolean res=false;
        if(cad!=null){
            res=pertenece(cad, 0, cad.length(), new PilaArreglo());
        }
        return res;
    }
    
    private static boolean pertenece(String cad, int i, int size, PilaADT p){
        if(i==size){
            if(p.isEmpty()){
                return true;
            }
            else
                return false;
        }
        else{
            char act=cad.charAt(i);
            if(act=='(' || act=='{' || act=='['){
                p.push(act);
            }
            else{
                if(act=='}' || act==']' || act==')'){
                    if(!p.isEmpty()){
                        switch(act){
                            case ')':
                                if((char)p.pop()!='(')
                                    return false;
                            break;
                            case ']':
                                if((char)p.pop()!='[')
                                    return false;
                            break;
                            case '}':
                                if((char)p.pop()!='{')
                                    return false;
                            break;        
                        }
                    }
                }
            }
            
            return pertenece(cad, i+1, size, p);
        }
        
    }
    
    public static void main(String[] args){
        String cad= "(^[]{}{}{}{}{}";
        
        System.out.println(pertenece(cad));
    }
    
}
