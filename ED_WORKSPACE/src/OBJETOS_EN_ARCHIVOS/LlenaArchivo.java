/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OBJETOS_EN_ARCHIVOS;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class LlenaArchivo {
    
    public static void main(String [] args){
        Verdura v1 = new Verdura("jitomate", "rojo");
        Verdura v2 = new Verdura("berenjena", "negra");
        Verdura v3 = new Verdura("chayote", "verde");
        
        try(FileOutputStream fileSalida = new FileOutputStream("ListaVerduras");
            ObjectOutputStream objectSalida = new ObjectOutputStream(fileSalida);){
            
            objectSalida.writeObject(v1);
            objectSalida.writeObject(v2);
            objectSalida.writeObject(v3);

            objectSalida.close();
            
        }catch(Exception e){
            System.out.println( "nError: " + e.getMessage() );
        }     
        
    }
    
}
