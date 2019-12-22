/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_25;

import CONJUNTO.*;
import java.util.Iterator;
/**
 *
 * @author huesos
 */
public class Escuela {
   private String nombre;
   private String direccion;
   private ConjuntoArreglo<Alumno> conjLic;
   private ConjuntoArreglo<Alumno> conjIng;
   
   public Escuela(){
       conjLic = new ConjuntoArreglo<Alumno>();
       conjIng = new ConjuntoArreglo<Alumno>();
   }
   
   public Escuela(String nombre, String direccion){
       this.nombre = nombre;
       this.direccion=direccion;
       conjLic = new ConjuntoArreglo<Alumno>();
       conjIng = new ConjuntoArreglo<Alumno>();
   }
   
   //1) Alta alumno
    public boolean alta(int id, boolean esLic, boolean esIng, double prom){
        boolean resp=false;
        if(esLic || esIng){
            
            Alumno al= new Alumno(id, esLic, esIng, prom);

            if( esLic && !conjLic.contiene(al) ){
                    conjLic.agrega(al);
                    resp=true;
            }
            if( esIng && !conjIng.contiene(al) ){
                    conjIng.agrega(al);
                    resp=true;
            }
        }
        return resp;    
    }
   
    //2) Baja alumno
    public boolean baja(int id, boolean esLic, boolean esIng, double prom){
        boolean resp=false;
        
        if(id > 0){
            Alumno al = new Alumno(id, esLic, esIng, prom);
            if(conjLic.contiene(al)){
                conjLic.quita(al);
                resp=true;
            }
            if(conjIng.contiene(al)){
                conjIng.quita(al);
                resp=true;
            }      
        }
        
        return resp;
    }
    
    //3)Reporte TODOS los alumnos:
    public String reporteAlumnos(){
        ConjuntoArreglo<Alumno> alumnado = (ConjuntoArreglo<Alumno>)conjLic.union(conjIng);
        return toStringA(alumnado);
    }
    
    //Método auxiliar toString
    public String toStringA(ConjuntoArreglo<Alumno> conjunto){
        String res = "" ;
        Iterator it = conjunto.iterator();
        while(it.hasNext())
            res+= ((Alumno)it.next()).getId() +" ";
        return res;    
    }
    
    //4)Reporte alumnos que esudian ambos
    public String reporteAmbas(){
        ConjuntoArreglo<Alumno> alumnado = (ConjuntoArreglo<Alumno>)conjLic.interseccion(conjIng);
        return toStringA(alumnado);
    }
    
    //5)Reporte alumnos que esudian ambos
    public String reporteSoloUna(){
        ConjuntoArreglo<Alumno> alumnadoA = (ConjuntoArreglo<Alumno>)conjLic.diferencia(conjIng);
        ConjuntoArreglo<Alumno> alumnadoB = (ConjuntoArreglo<Alumno>)conjIng.diferencia(conjLic);
        return toStringA(alumnadoA) + toStringA(alumnadoB);
    }
    
    /*
    //6)Promedio de todos los ingenieros
    public double promIng(){
        double suma=0;
        Iterator it = conjIng.iterator();
        while(it.hasNext())
            suma+=
    }
    */
    
}
