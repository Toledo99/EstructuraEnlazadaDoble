/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_38;

/**
 *
 * @author huesos
 */
public class Archivo {
    
    private double tamanio;
    private String nombre;
    private String duenio;
    private String fecha;
    
    public Archivo(double tamanio, String nombre, String duenio, String fecha){
        this.tamanio = tamanio;
        this.nombre = nombre;
        this.duenio = duenio;
        this.fecha = fecha;
    }
    
    public double getTamanio(){
        return this.tamanio;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getDuenio(){
        return this.duenio;
    }
    
    public String getFecha(){
        return this.fecha;
    }
    
    public boolean equals(Archivo otro){
        return this.tamanio == otro.getTamanio() && this.nombre.equals(otro.getNombre()) && this.duenio.equals(otro.getDuenio()) && this.fecha.equals(otro.getFecha()) ;    
    }
    
    public int compareTo(Archivo otro){
        int resp;
        if(this.tamanio > otro.getTamanio())
            resp=1;
        else
            if(this.tamanio < otro.getTamanio())
                resp= -1;
            else
                resp= 0;
        return resp;
    }
    
    @Override
    public String toString(){
        return this.nombre+"\n Duenio: "+this.duenio+"\n Fecha: "+this.fecha+"\n Tamanio: "+this.tamanio;
    }
    
}
