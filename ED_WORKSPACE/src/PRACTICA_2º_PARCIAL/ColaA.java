/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA_2º_PARCIAL;

import COLA.*;
import PILA.EmptyCollectionException;
import java.util.ArrayList;

/**
 *
 * @author huesos
 */
public class ColaA <T> implements ColaADT <T> {
    private T[] cola;
    private int frente;
    private int fin;
    private final int MAX = 20;
    
    public ColaA(){
        cola = (T[]) new Object[MAX];
        frente = -1;
        fin = -1;
    }
    
    public ColaA(int max){
        cola = (T[]) new Object[max];
        frente = -1;
        fin = -1;
    }
    
    public boolean estaVacia(){
        return frente == -1;
    }
    
    public T consultaPrimero(){
        if(estaVacia())
            throw new NullPointerException();
        return cola[frente];
    }
    
    public void agrega(T dato){
        
        if( (fin+1) % cola.length == frente )  // es lo mismo que:" if(frente==0 && fin==cola-length-1 || (fin+1==frente)
                expande();
        
        if(frente == -1)
            frente = 0;
        
        fin = (fin+1) % cola.length;
        cola[fin] = dato;
    }
    
    
    private void expande(){
        T[] nuevo = (T[]) new Object [cola.length * 2];
        int n = cola.length;
        for(int i=0; i<n ; i++){
            nuevo[i] = cola[ (frente+1)%n ] ;
        }
        cola = nuevo;
        frente = 0;
        fin = n-1;
    }
    
    public T quita(){
        if(estaVacia())
            throw new EmptyCollectionException();
        T res = cola[frente];
        cola[frente]=null;
        
        if(frente == fin){
            frente=-1;
            fin=-1;
        }
        else
            frente = (frente+1) % cola.length;
        return res;
    }

   
    public int cuentaElementos() {
        if(estaVacia())
           return 0;
        else
            if(frente <= fin)
                return fin - frente +1 ; 
            else
                return cola.length-frente+fin+1;
    }

  
    public T consultaUltimo() {
        if(estaVacia())
            throw new NullPointerException();
        else
            return cola[fin];
    }

    
    public ArrayList<T> multiQuita(int n) {
        if(estaVacia())
            throw new NullPointerException();
        ArrayList <T> aux;
        if(cuentaElementos() >= n){
            aux = new ArrayList();
            for(int i=0; i<n; i++)
                aux.add(quita());
        }else
            aux=null;
        
        return aux;
    }
    
    //EXAMEN: NO HAY VECINOS IGUALES
    public boolean noHayVecinosIguales(){
        
        if(estaVacia())
            throw new EmptyCollectionException("Error: esta vacía.");
       
        boolean res=true;
        if(frente!=fin){
            int inicio = frente;
            res= noHayVecinosIguales(inicio, inicio+1);
        }
        return res;
        
    }
    
    private boolean noHayVecinosIguales(int num1, int num2){
        if(num2%cola.length == fin+1){
            return true;
        }
        if(cola[num1].equals(cola[num2]))
            return false;
        else
            return noHayVecinosIguales(num1+1, num2+1); 
    }           
    
    public String toStringComoArreglo(){
        String res = "";
        
        for(int i=0; i<cola.length; i++)
            res += cola[i];
        
        return res;
    }
    
    public String toStringComoFila(){
        String res = "";
        for(int i = 0; i< this.cuentaElementos(); i++)
            res += cola[ (frente+i)%cola.length];
        return res;
    }
    
    public static void main (String [] args){
        
        ColaA col = new ColaA();
        col.agrega("A"); //0
        col.agrega("B"); //1
        col.agrega("C"); //2
        col.agrega("D"); //3
       
        /*
        System.out.println(col.consultaPrimero());
        System.out.println(col.consultaUltimo());
        
        
        ColaA c = new ColaA();
        c.agrega(1);
        c.agrega(2);
        c.agrega(3);
        */
        
        System.out.println(col.noHayVecinosIguales());
    }
}
