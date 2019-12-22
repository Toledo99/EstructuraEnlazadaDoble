/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_37;

import COLA.ColaA;
import PILA.PilaArreglo;

/**
 *
 * @author huesos
 */
public class ColaAvion {
    
    
    public static void ordenaPorEdad(ColaA <Persona> fila){
        if(fila == null)
            throw new NullPointerException();
        System.out.println(fila.toStringComoFila());
        PilaArreglo<Persona> aux = new PilaArreglo();
        
        while(!fila.estaVacia()){
            if(aux.isEmpty())   
                aux.push(fila.quita());
            else
                if(aux.peek().calculaEdad() < fila.consultaPrimero().calculaEdad())
                    aux.push(fila.quita());
                else
                    fila.agrega(aux.pop()); 
        }   
        
        while(!aux.isEmpty()){
            fila.agrega(aux.pop());
        }
        System.out.println(fila.toStringComoFila());
    }
    
    //MAIN QUE PRUEBA EL METODO
    public static void main ( String [] args ){
        ColaA <Persona> fila = new ColaA<> ();
        fila.agrega ( new Persona("Dani", 1999) );
        fila.agrega ( new Persona("Diego", 1950) );
        fila.agrega ( new Persona("Alvaro", 1830) );
        fila.agrega ( new Persona("Pedro", 1990) );
        fila.agrega ( new Persona("Silvia", 2010) );
       
        ColaAvion.ordenaPorEdad(fila);

    }
}
