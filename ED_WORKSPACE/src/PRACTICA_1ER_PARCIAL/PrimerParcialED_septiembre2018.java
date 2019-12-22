/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA_1ER_PARCIAL;

/**
 *
 * @author huesos
 */
public class PrimerParcialED_septiembre2018 {
    
    public static int convierteABinario(int num){
        int resp = 0;
        PilaADT<Integer> pila = new PilaA();
        while(num != 0){
            pila.push(num%2);
            num/=2;
        }
        while(!pila.isEmpty())
            resp=resp*10+pila.pop();
        
        return resp;
    }
    

    
    public static void main (String [] args){
        int num=150;
        System.out.println("Representación binaraia de " + num + " :  " + PrimerParcialED_septiembre2018.convierteABinario(num));
    }
}

