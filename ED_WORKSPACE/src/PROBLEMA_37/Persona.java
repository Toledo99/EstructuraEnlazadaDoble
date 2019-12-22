/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_37;

/**
 *
 * @author huesos
 */
public class Persona {
    private String nombre;
    private int anioNacimiento;
    
    public Persona( String nombre, int anioNacimiento){
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getAnioNacimiento(){
        return this.anioNacimiento;
    }
    
    public int calculaEdad(){
        return 2019-this.anioNacimiento;
    }
    
    public String toString(){
        return this.nombre+"-"+this.getAnioNacimiento()+"-Edad: "+this.calculaEdad()+"  ";
    }
}
