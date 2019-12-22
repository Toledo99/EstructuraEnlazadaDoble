
package PROBLEMA_20;
import PILA.*;

public class intABinario {
    
    public static int toBinary(int num){
        String res="";
        PilaArreglo<Integer> pila = new PilaArreglo();
        
        while(num != 0){
            pila.push(num%2);
            num/=2;   
        }
        
        while(!pila.isEmpty()){
            res+=""+pila.pop();
        }
        return Integer.parseInt(res);
    }
    
    public static void main (String [] args){
        System.out.println(""+intABinario.toBinary(36));
        System.out.println(""+intABinario.toBinary(15));
        System.out.println(""+intABinario.toBinary(150));
    }
}
