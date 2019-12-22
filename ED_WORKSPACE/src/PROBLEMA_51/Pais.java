/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_51;

/**
 *
 * @author huesos
 */
public class Pais {
    private String nombre;
    private String ubicacion;
    
    public Pais(){
    }
    
    public Pais(String nombre, String ubicacion){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getUbicacion(){
        return this.ubicacion;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append( this.nombre );
        sb.append(" ");
        sb.append(this.ubicacion);
        sb.append("\n");
        return sb.toString();
    }
    
    public boolean equals(Pais otro){
        return this.nombre.equals(otro.nombre) && this.ubicacion.equals(otro.ubicacion);
    }
    
    /*
    public int compareTo(Pais otro){
        int res;
        
        if(this.nombre.compareTo(otro.nombre) <0)
            res=-1;
        else
            if(this.nombre.compareTo(otro.nombre) >0)
                res=1;
            else
                res=0;
        return res;
    }
*/
}
