/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_4;

/**
 *
 * @author huesos
 */
public class Empleado {
    private static int serie=100;
    private int claveEmpleado;
    private String nombreEmpleado;
    private double sueldoBase;
    
    public Empleado(){
        this.claveEmpleado=this.serie;
        this.serie++;
    }
    
    public Empleado(String nombreEmpleado, double sueldoBase){
        this();
        this.nombreEmpleado=nombreEmpleado;
        this.sueldoBase=sueldoBase;
    }
    
    //SETTERS
    public void setNombreEmpleado(String nuevoNombre){
        this.nombreEmpleado=nuevoNombre;
    }
    
    public void setSueldoBase(double nuevoSueldo){
        this.sueldoBase= nuevoSueldo; 
    }
    
    //GETTERS
    public double getClaveEmpleado(){
        return this.claveEmpleado;
    }
    
    public String getNombreEmpleado(){
        return this.nombreEmpleado;
    }
    
    public double getSueldoBase(){
        return this.sueldoBase;
    }
    
    
    
    public String toString(){
        String str="Nombre: "+this.nombreEmpleado+"\nClave: "+this.claveEmpleado+"\nSueldo base: "+this.sueldoBase+"\n";
        return str;
    }
    
    public boolean equals(Empleado otro){
        boolean resp=false;
        if(this.nombreEmpleado == otro.getNombreEmpleado())
            resp=true;
        return resp;
    }
    
    public double calculaSalario(double prestac, double deduc){
        double salario = this.sueldoBase+ (this.sueldoBase*prestac/100)-(this.sueldoBase*deduc/100);
        return salario;
    }
    
    
}
