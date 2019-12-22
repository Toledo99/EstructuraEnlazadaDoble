
package OBJETOS_EN_ARCHIVOS;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class LeeArchivo {
    
    public static void main (String [] args){
        int numVerduras=0;
        Verdura [] listaVerduras = new Verdura [5];
        Object obj;
        
        try(FileInputStream fileEntrada = new FileInputStream("ListaVerduras");
            ObjectInputStream objectEntrada = new ObjectInputStream(fileEntrada);){
            
            obj=objectEntrada.readObject();
            
            int i = 0;
            while(obj != null && i< listaVerduras.length){
                if(obj instanceof Verdura){
                    listaVerduras[i] = (Verdura)obj;
                    numVerduras++;
                    i++;
                }
                obj= objectEntrada.readObject();
            }
            objectEntrada.close();
            
        }catch(Exception e){
            System.out.println( "\nError: " + e.getMessage() );
        }
        
        for(int i =0; i<numVerduras; i++)
            System.out.println(listaVerduras[i].toString());
    }
}
