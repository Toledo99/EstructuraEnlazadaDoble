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
public class Operario extends Empleado{
    private int horasExtra;
    
    public Operario(){
        
    }
    
    public Operario(String nombreEmpleado, double sueldoBase, int horasExtra){
        super(nombreEmpleado, sueldoBase);
        this.horasExtra=horasExtra;
    }
    
    public String toString(){
        String str= super.toString()+"\nHoras extra: "+ this.horasExtra;
        return str;
    }
    
    /*
    public double calculaSalario(double prestac, double deduc){
        double salario = this.sueldoBase+ (this.sueldoBase*prestac/100)-(this.sueldoBase*deduc/100);
        return salario;
    }
    */
    public double calculaSalario(double prestac, double deduc, double precioHE){
        double salario = super.calculaSalario(prestac, deduc)+(this.horasExtra*precioHE);
        return salario;
    }
}
