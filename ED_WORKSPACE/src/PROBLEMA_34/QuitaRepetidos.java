/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_34;

import COLA.ColaA;
import CONJUNTO.ConjuntoArreglo;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author huesos
 */
public class QuitaRepetidos {
 
    //Sólo si tu programantes el Conjunto porque nosotros lo
    // programamos en el orden de un arreglo, pero si no lo programamos
    // nosotros, no sabemos como recorre el conjunto y posiblemente no sea
    // en el orden que pensamos.
    public static <T> void quitaRepetidosA( ColaA <T> cola){
        if(cola == null)
            throw new NullPointerException();
        ConjuntoArreglo <T> aux = new ConjuntoArreglo();
        while(!cola.estaVacia())
            aux.agrega(cola.quita());
        Iterator <T> it = aux.iterator();
        while(it.hasNext())
            cola.agrega(it.next());
    }
    
    public static <T> void quitaRepetidosB( ColaA <T> cola){
        if(cola == null)
            throw new NullPointerException();
        ArrayList <T> a = new ArrayList();
        
        ConjuntoArreglo <T> aux = new ConjuntoArreglo();
        
        while(!cola.estaVacia()){
            T b= cola.quita();
            if(aux.contiene(b))
                a.add(b);
            aux.agrega(b);
        }
        Iterator <T> it = aux.iterator();
        while(it.hasNext())
            cola.agrega(it.next());
    }
    
}
