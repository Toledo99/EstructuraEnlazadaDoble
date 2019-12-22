/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;
/**
 *
 * @author atoledog
 */
public class Binarios {

    public Binarios() {
    }
    
    
    
    public static int convertirBinario(int num){
        String res="";
        PilaA<Integer> pila=new PilaA<Integer>();
        
        while(num>0){
            pila.push(num%2);
            num/=2;
        }
        while(!pila.isEmpty()){
            res+=pila.pop();
        }
        return Integer.parseInt(res);
    }
    
    public static void main(String[] args0){
        Binarios b=new Binarios();
        
        System.out.println(convertirBinario(140));
    }
    
}
