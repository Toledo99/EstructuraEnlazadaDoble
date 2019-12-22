/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_32;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author huesos
 */
public class CuentaPalabras {
    
    
    
    public static int cuentaPalabras(String nameFile){
        try(Scanner file = new Scanner(new File (nameFile)) ){
            return cuentaPalabras(file, 0);
        }catch(Exception e){
           return -1; 
        }
           
    }
    
    private static int cuentaPalabras(Scanner file, int tot){
        if(file.hasNext()){
            System.out.println( file.next() ); //Iterador
            return cuentaPalabras(file, tot+1);
        }
        else
            return tot;
    }
    
    public static void main (String [] args){
        System.out.println("# de palabras en el archivo " + ": " +  CuentaPalabras.cuentaPalabras("text.txt"));
    }
}
