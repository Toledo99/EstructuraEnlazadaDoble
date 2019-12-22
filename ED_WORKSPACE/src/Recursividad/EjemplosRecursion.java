/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividad;

/**
 *
 * @author huesos
 */
public class EjemplosRecursion {
    
    //Opción 1:
    public static void impArreDesdeAtras(int [] arr, int tot){
        if(tot > 0){
            System.out.println(arr[tot-1]+" ");
            impArreDesdeAtras(arr, tot-1);
        }
    }
    
    public static void impArrEnOrden(int [] arr, int tot){
        if(tot > 0){
            impArrEnOrden(arr, tot-1);
            System.out.println(arr[tot-1]+" ");
        }
    }
    
    
    //Opción 2:
    public static void impArr(int [] arr, int tot, int ind){
        if(ind < tot){
            System.out.println(arr[ind]+"");
            impArr(arr, tot, ind+1);
        }   
    }
    
    private static void impArr(int[] arr, int tot){
        impArr(arr, tot, 0);
    }
    
    
    public static String fibonacci(int n){
        if(n<0)
            return "-1";
        else
            if(n==0)
                return " 1";
            else
                return ""+fibonacci(n-1)+" "+n;
    }
    
    
    
    //Main:
    public static void main(String [] args){
        int [] arr = { 2, 9, 6, 7, 8};
        
        //Prueba opción 1:        
        EjemplosRecursion.impArreDesdeAtras(arr, 5);
        System.out.println("\n");
        EjemplosRecursion.impArrEnOrden(arr, 5);
        System.out.println("\n");
        
        //Prueba opción 2:
        EjemplosRecursion.impArr(arr, 5);
        
        //Prueba fibonacci:
        System.out.println("F: "+EjemplosRecursion.fibonacci(5));
    }
}
