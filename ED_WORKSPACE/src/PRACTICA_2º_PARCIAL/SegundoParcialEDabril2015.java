/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA_2º_PARCIAL;

import CONJUNTO.*;
import java.util.Iterator;

/**
 *
 * @author huesos
 */
public class SegundoParcialEDabril2015 {
    
    
    // 1.- SON_IGUALES:
    //Método para el usuario:
    public static boolean sonIguales(int [][] arre1, int [][] arre2){
        boolean band=true;
        if(arre1 == null || arre2 == null)
            throw new RuntimeException("Error: parámetro nulo.");
        
        
        if(arre1.length != arre2.length || arre1[0].length != arre2[0].length)
            return false;
        else
            return sonIguales(arre1,arre2, 0, 0);
       
    }
    //Método interno, propiamente recursivo:
    private static boolean sonIguales(int [][]arre1, int [][]arre2, int i, int j ){
        if(i == arre1.length)
            return true;
        if(j == arre1[0].length)
            return sonIguales(arre1, arre2, i+1, 0);
        else    
            if(arre1[i][j] == arre2[i][j])
                return sonIguales(arre1, arre2, i, j+1);
            else
                return false;
        
    }
        
    // 2.- NO_HAY_VECINOS_VACIOS:
    public static <T> boolean noHayVecinosVacios(ColaA cola){
        if( cola == null || cola.estaVacia())
            throw new RuntimeException("Está vacía.");
        else{
            ColaA aux= new ColaA();
            T a=null;
            return noHayVecinosVacios(cola, aux, a);
        }
    }
    
    private static <T> boolean noHayVecinosVacios(ColaA cola, ColaA aux, T a){
        a= (T) cola.quita();
        aux.agrega(a);
        
        if(cola.estaVacia()){
            regresa(cola,aux);
            return true;
        }
        else
            if(! cola.consultaPrimero().equals(a))
                return noHayVecinosVacios(cola, aux, a);
            else {
                saca(cola, aux);
                regresa(cola, aux);
                return false; 
            }
                   
    }
    
    private static void regresa(ColaA cola, ColaA aux){
        if(cola == null || aux == null)
            throw new RuntimeException("Error: null");
           
        if( !aux.estaVacia()){
            cola.agrega(aux.quita());
            regresa(cola, aux);
        }
    }
    
    private static void saca (ColaA cola, ColaA aux){
        if(cola == null || aux == null)
            throw new RuntimeException("Error: null");
           
        if( !cola.estaVacia()){
            aux.agrega(cola.quita());
            saca(cola, aux);
        }
    }
    
    // 3.- MAS DE N AUTOS CON 5 VELOCIDADES:
    public static boolean analizaDeportivos(ConjuntoADT<Auto> cA, int n){
        if(cA == null)
            throw new RuntimeException("Parametro nulo.");
        
        if(cA.getCardinalidad() < n)
            return false;
        else{
            Iterator<Auto> it = cA.iterator();
            return analizaDeportivos(cA, n, it);
        }
            
        
    }
    
    private static boolean analizaDeportivos(ConjuntoADT<Auto> cA, int n, Iterator<Auto> it){
        if(n == 0)
            return true;
        else{
            if(it.hasNext()){
                Auto au = it.next();
                if( au.getVelocidades() >= 5 )
                    return analizaDeportivos(cA, n-1, it); 
                else
                   return analizaDeportivos(cA, n, it); 
            }
            else 
                return false;
        }
    }
    
    
    public static void main ( String [] args ) {
        
        //PRUEBA EJERCICIO 1:
        int [][] a = { {1,2, 3}, {4,5,6}};
        int [][] b = { {1,2, 3}, {4,5,6}};
        
        int [][] c = { {1,2, 3}, {3,5,6}};
        int [][] d = { {1,2, 3}, {0,5,0}};
        
        int [][] e = { {1,2}, {5,6}};
        int [][] f = { {1,1, 3}, {0,5,6}};
        
        int [][] n=null;
        int [][] m={{1,2}};
        
        System.out.println("    1.- Si son iguales: "+ sonIguales(a,b));
        System.out.println("    2.- Si tienen elementos distintos: "+ sonIguales(c,d));
        System.out.println("    3.- Si son de diferente tamaño: "+ sonIguales(e,f)+"\n");
        //System.out.println("4.- Si uno es nulo: "+ sonIguales(n,m));
        
        //PRUEBA EJERCICIO 2:
        ColaA col1 = new ColaA();
        col1.agrega("A");
        col1.agrega("B");
        col1.agrega("B");
        col1.agrega("A");
        
        ColaA col2 = new ColaA();
        col2.agrega("A");
        col2.agrega("B");
        col2.agrega("C");
        col2.agrega("D");
        
        System.out.println(col1.toStringComoFila());
        System.out.println("¿No hay repetidos en col1? -->  "+SegundoParcialEDabril2015.noHayVecinosVacios(col1));
        System.out.println(col1.toStringComoFila()+"\n");
        
        System.out.println(col2.toStringComoFila());
        System.out.println("¿No hay repetidos en col2? -->  "+SegundoParcialEDabril2015.noHayVecinosVacios(col2));
        System.out.println(col2.toStringComoFila()+"\n");
    
        //PRUEBA EJERCICIO 3:
        ConjuntoADT cA = new ConjuntoArreglo<Auto>();
        cA.agrega( new Auto(1) );
        cA.agrega( new Auto(5) );
        cA.agrega( new Auto(2) );
        cA.agrega( new Auto(8) );
        cA.agrega( new Auto(10) );
        System.out.println("¿Tiene 3 o más carros mayores a 5 velocidades? --> "+SegundoParcialEDabril2015.analizaDeportivos(cA, 3));
        System.out.println("¿Tiene 4 o más carros mayores a 5 velocidades? --> "+SegundoParcialEDabril2015.analizaDeportivos(cA, 4));
        
    }
    
}
