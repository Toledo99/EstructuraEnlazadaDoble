/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_22;

import PROBLEMA_22.PilaADT;
import PROBLEMA_22.EmptyCollectionException;
/**
 *
 * @author huesos
 */
public class PilaArreglo <T> implements PilaADT<T>{
    private T[] pila;
    private int tope1;
    private int tope2;
    private static final int MAX=5;
    
    
    //CONSTRUCTORES
    public PilaArreglo(){
        pila= (T[]) new Object[MAX];
        tope1=-1;
        tope2=MAX;
    }
    
    public PilaArreglo(int max){
        pila= (T[]) new Object[max];
        tope1=-1;
        tope2=max;
    }
    
    //MÉTODOS
    public boolean isEmpty(){
        return tope1 == -1 && tope2==MAX;
    }
    
    public boolean isEmpty(int tipo){
        boolean resp=false;
        if(tipo == 1 && tope1 == -1)
            resp=true;
        else
            if(tipo == 2 && tope2 == MAX)
                resp=true;
        return resp;
    }
    
    
    public void push (T dato, int tipo){
        
        if(this.tope1+1 == this.tope2){
            System.out.println("aaaaaa");
            this.expande();
        }
       
        if(tipo==1){
                tope1++;
                pila[tope1]=dato;
                }
            else if(tipo==2){
                tope2--;
                pila[tope2]=dato;
                }
    }
    
    
    public T pop(int tipo){
        if(isEmpty())
            throw new EmptyCollectionException();
        
        T resp=null;
        if(tipo == 1){
            resp=pila[tope1];
            pila[tope1]=null;
            tope1--;
        }else{
            resp=pila[tope2];
            pila[tope2]=null;
            tope2++;
        }
            
        return resp;
    }
    
    public T peek(int tipo){
        if(isEmpty())
            throw new EmptyCollectionException();
        if(tipo==1)
            return pila[tope1];
        else
            return pila[tope2];
    }
    
    public void multiPop(int num, int tipo){
        if(tipo==1 && this.tope1>num-1){
            for(int i=0; i<num; i++)
            pop(1);
        }else
            if(tipo == 2 && MAX-this.tope2>num-1){
                for(int i=0; i<num; i++)
                pop(2);
            }else
                throw new EmptyCollectionException();
                
        
    }
    
    public void multiPop(int num, PilaArreglo<T> pila, int tipo){
         if(tipo==1 && pila.tope1>num-1){
            for(int i=0; i<num; i++)
            pila.pop(1);
        }else
            if(tipo == 2 && MAX-pila.tope2>num-1){
                for(int i=0; i<num; i++)
                pila.pop(2);
            }else
                throw new EmptyCollectionException();
    }
    
    //MÉTODO (EXPANDE) AUXILIAR
    private void expande(){
        T [] nuevo = (T[]) new Object[pila.length*2];
        System.out.println("\nExpande\n");
        
        for(int i=0; i<=tope1; i++)
            nuevo[i] = pila[i];
        
        int i = this.MAX-1;
        int j= nuevo.length-1;
        while(i>=tope2){
            nuevo[j] = pila[i];
            i--;
            j--;
        }
        this.tope2=j+1;
        System.out.println(j);
        pila=nuevo;  
    }
    
    //GET
    public int getTope(int tipo){
        int res=0;
        if(tipo == 1)
            res= this.tope1;
        else if(tipo == 2)
            res= this.tope2;
        return res;
    }


    public static void main(String[]args){
        PilaADT pila = new PilaArreglo();
        
        pila.push("a", 1);
        pila.push("b", 1);
        pila.push("c", 1);
        
        pila.push("y", 2);
        pila.push("z", 2);
        
        
        System.out.println(pila.pop(1));
        System.out.println(pila.pop(1));
        System.out.println(pila.pop(1));
        
        System.out.println(pila.pop(2));
        System.out.println(pila.pop(2));
        
        pila.push("a", 1);
        pila.push("b", 1);
        pila.push("c", 1);
        
        pila.push("y", 2);
        pila.push("z", 2);
        System.out.println(pila.getTope(1));
        System.out.println(pila.getTope(2));
        
        pila.push("h", 1);
        
        System.out.println(pila.pop(1));
        System.out.println(pila.pop(1));
        System.out.println(pila.pop(1));
        
        System.out.println(pila.pop(2));
        System.out.println(pila.pop(2));
        System.out.println(pila.pop(1));
    }
    
}
