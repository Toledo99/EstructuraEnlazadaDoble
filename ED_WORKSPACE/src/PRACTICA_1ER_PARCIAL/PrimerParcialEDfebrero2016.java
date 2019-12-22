
package PRACTICA_1ER_PARCIAL;

public class PrimerParcialEDfebrero2016 {
    
    public static boolean esPalindromo( String cadena ){
        boolean resp = false;
        
        PilaADT pila = new PilaA();
        
        for(int i=0; i<cadena.length () ; i++)
            pila.push((Character)cadena.charAt(i));
        
        int j=0;
        
            while( !pila.isEmpty()  && pila.pop().equals((Character)cadena.charAt(j)) )
                j++;
            
            if(j == cadena.length())
                resp=true;
        
        return resp;
    }
    
    public static void main (String [] args){
        String cadena1 = "NEUQUEN";
        String cadena2 = "HALAMADRID";
        
        System.out.println( cadena1 + " es palíndromo: " + PrimerParcialEDfebrero2016.esPalindromo(cadena1)+"\n");
        
        System.out.println( cadena2 + " es palíndromo: " + PrimerParcialEDfebrero2016.esPalindromo(cadena2)+"\n");
        
    }
}
