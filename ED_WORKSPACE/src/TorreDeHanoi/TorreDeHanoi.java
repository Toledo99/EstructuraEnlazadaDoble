/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorreDeHanoi;

/**
 *
 * @author huesos
 */
public class TorreDeHanoi {
    
    public static void impMovTorreDeHanoi(int n){
        if(n>=1)
            impMovTorreDeHanoi(n, "orig", "auxi", "dest");
    }
    
    private static void impMovTorreDeHanoi(int n, String ori, String aux, String des){
        if(n == 1)  
            System.out.println("Mover 1 disco de " + ori + " a " + des);
        else{
            impMovTorreDeHanoi(n-1, ori, des, aux);
            System.out.println("Mover 1 disco de " + ori + " a " + des);
            impMovTorreDeHanoi(n-1, aux, ori, des);
        }
            
    }
    
    public static void main (String [] args){
        TorreDeHanoi.impMovTorreDeHanoi(3);
        
    }
}
