/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJERCICIO_SON_IGUALES;

import CONJUNTO.*;
import java.util.Iterator;

/**
 *
 * @author huesos
 */
public class SonIguales {
    
    public static boolean sonIguales(ConjuntoADT uno, ConjuntoADT otro){
        boolean resp=false;
        if(uno == null  || otro==null)
            throw new NullPointerException();
        if(uno.getClass().getSimpleName().equals(otro.getClass().getSimpleName()) && uno.getCardinalidad() == otro.getCardinalidad()){
            Iterator it = uno.iterator();
            resp=true;
            while(it.hasNext() && resp  )
                resp= otro.contiene(it.next());  
        }
            
        return resp;
    }
    /*
    public static boolean sonIgualesR(ConjuntoADT uno, ConjuntoADT otro){
        return sonIgualesR(ConjuntoADT uno, ConjuntoADT otro);
    }
    private static boolean sonIgualeR(ConjuntoADT uno, ConjuntoADT otro){
        if(uno== null || otro == null)
    }
    */
    
    public static boolean sonIgualesF(ConjuntoADT uno, ConjuntoADT otro){
        boolean res = false;
        if(uno != null && otro!= null && uno.getCardinalidad() == otro.getCardinalidad() && uno.diferencia(otro).getCardinalidad()==0 )
            res=true;
        return res;
    }
    
    /*
    private satic <T> boolean sonIguales(){
        T sig;
        if(it.hasNext()){
            sig=it.next();
            if( !c2.contiene(sig) )
                return false;
            else
                return 
                    sonIguales(c2, it);
        }
        esle
            return true;
    }
    */
    public static void main (String [] args){
        //Prueba que funcione
        ConjuntoArreglo uno = new ConjuntoArreglo();
        uno.agrega("Hola");
        uno.agrega("Hallo");
        uno.agrega("Hello");
        
        ConjuntoArreglo otro = new ConjuntoArreglo();
        otro.agrega("Hola");
        otro.agrega("Hello");
        otro.agrega("Hallo");
        
        System.out.println(SonIguales.sonIguales(uno, otro));
        
        
        //Prueba el false por elementos distintos:
        ConjuntoArreglo e = new ConjuntoArreglo();
        e.agrega("Hola");
        
        ConjuntoArreglo i = new ConjuntoArreglo();
        i.agrega("Bonjour");
        System.out.println(SonIguales.sonIguales(e, i));
        
        
        //Prueba false por clases distintas:
        ConjuntoArreglo h = new ConjuntoArreglo();
        h.agrega(34);
        
        ConjuntoArreglo j = new ConjuntoArreglo();
        j.agrega("Bonjour");
        System.out.println(SonIguales.sonIguales(h, j));
        
        //Prueba el null pointer exception:
        /*
        ConjuntoArreglo a = new ConjuntoArreglo();
        ConjuntoArreglo b = null;
        System.out.println(SonIguales.sonIguales(a, b));
        */
    }
}
