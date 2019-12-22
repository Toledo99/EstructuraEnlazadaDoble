
package PROBLEMA_38;

import COLA.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Impresora {
    private String marca;
    private ColaA<Archivo> pendientes;
    
    public Impresora(String marca){
        this.marca = marca;
        this.pendientes = new ColaA<Archivo>();
    }
    
    // 1.- Leer de un archivo de objetos los distintos archivos (Documentos o Fotos) y agregarlos a la cola:
    public boolean leerArchivoDeObjetos(String fileName){
        boolean res=false;
        try(FileInputStream fileEntrada = new FileInputStream(fileName); 
                ObjectInputStream objectEntrada = new ObjectInputStream(fileEntrada)){
            Object obj = objectEntrada.read();
            int i=0;
            while(obj!=null){
                if(obj instanceof Archivo)
                    pendientes.agrega((Archivo)obj);
            }  
            objectEntrada.close();
            res=true;
        }catch(Exception e){
            e.getMessage();
        }
        return res;
    }
    
    // 2.- Agregar archivo a la cola:
    public boolean agregarALaCola(Archivo file){
        if(file == null)
            throw new NullPointerException("Error: Parametro nulo");
        
        pendientes.agrega(file);
        return true;
    }
    
    // 3.- Imprimir el siguiente archivo de la cola:
    public void imprimeArchivo(){
        if(pendientes.estaVacia())
            throw new NullPointerException("No hay archivos pendientes.");
        System.out.println(pendientes.quita().toString());
    }
    // 4.- Eliminar todas las Fotos de la cola de impresión:
    public int quitaTodasLasFotos(){
        int n = pendientes.cuentaElementos();
        int contElim = 0;
        if(n > 0){
            Archivo dato = null;
            for(int i=0; i<n; i++){
                dato=pendientes.quita();
                if( dato instanceof Documento)
                    pendientes.agrega(dato);
                else
                    contElim++;
            }
        }
        return contElim;
    }
    
    // 5.- Eliminar todos los documentos cuyo tamanio sea mayor a 500 (KB):
    public int quitaMayoresA500(){
        int n = pendientes.cuentaElementos();
        int contElim = 0;
        if(n > 0){
            Archivo dato = null;
            for(int i=0; i<n; i++){
                dato=pendientes.quita();
                if( dato instanceof Foto || dato.getTamanio() < 500)
                    pendientes.agrega(dato);
                else
                    contElim++;
            }
        }
        return contElim;
    } 
    
    // MAIN.- Prueba de los métodos:
    public static void main (String [] args){
        
        
        // 0.- Crear archivo de Archivos:
        Archivo d1 = new Documento(42.5, "Tarea", "Mónica", "22/03/2010", "iCorei7");
        Archivo d2 = new Documento(600, "Examen", "Silvestre", "ayer", "ADM");
        Archivo d3 = new Documento(50, "Articulo", "Tona", "hoy", "iCorei3");
        Archivo f1 = new Foto(1000, "Viaje a Cancún", "Andrea", "antier", 5000);
        Archivo f2 = new Foto(350, "Profile picture", "Alejandro", "antier", 1080 );
        Archivo f3 = new Foto(350, "Pasaporte", "Fernanda", "15/02/1996", 4000 );
        
                
        try(FileOutputStream file = new FileOutputStream("ArchivoDeArchivos");
                ObjectOutputStream salida = new ObjectOutputStream(file)){
            salida.writeObject(d1);
            salida.writeObject(f1);
            salida.writeObject(d2);
            salida.writeObject(f2);
            salida.writeObject(d3);
            salida.writeObject(f3);
        }
        catch(Exception e){
            System.out.println("\nError: "+e.getMessage());
        }
        
        // 0.0.- Crear impresora:
        Impresora printer = new Impresora("Epson");
        
        // 1.- Leer archivo y agregar a la cola:
        //System.out.println("1.- Leer de archivo y añadir a la cola: "+printer.leerArchivoDeObjetos("ArchivoDeArchivos"));
        //Como no jala, no sé porqué:
        printer.agregarALaCola(d1);
        printer.agregarALaCola(f1);
        printer.agregarALaCola(d2);
        printer.agregarALaCola(f2);
        printer.agregarALaCola(d3);
        printer.agregarALaCola(f3);
        
        // 2.- Agregar nuevo archivo a la cola:
        Documento otro = new Documento(6000, "Poema", "Rubén Darío", "nunca", "el corazón");
        System.out.println("\n2.- Agragar un nuevo archivo a la cola: "+printer.agregarALaCola(otro));
        
        // 3.- Imprimir el siguiente archivo de la cola:
        System.out.println("\n3.- Imprimir:");
        printer.imprimeArchivo();
        
        // 4.- Eliminar todas las fotos de la cola:
        System.out.println("\n4.- Cantidad de fotos elimindads: "+printer.quitaTodasLasFotos());
        
        // 5.- Eliminar Documentos mayores a 500 KB:
        System.out.println("\n5.- Cantidad de documentos eliminados >500 eliminados: "+printer.quitaMayoresA500());
    }
    
}
