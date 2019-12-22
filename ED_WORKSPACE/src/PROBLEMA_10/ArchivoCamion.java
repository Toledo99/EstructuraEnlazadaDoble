/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author huesos
 */
public class ArchivoCamion {
    public static void main(String [] args){
        DePasajeros cam1 = new Escolar("Ferrari", "554433", "AHR-231", 80000, 40, true);
        DePasajeros cam2 = new Escolar("TresZapotes", "554433", "AHR-231", 80000, 40, false);
        
        try(FileOutputStream file = new FileOutputStream("Archivo camiones");
                ObjectOutputStream salida = new ObjectOutputStream(file)){
            salida.writeObject(cam1);
            salida.writeObject(cam2);
        }
        catch(Exception e){
            System.out.println("\nError: "+e.getMessage());
        }
    }
}
