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
public class Administrativo extends Empleado{
    private String departamento;
    private String telefono;
    
    public Administrativo(){    
    }
    
    public Administrativo(String nombreEmpleado, double sueldoBase, String departamento, String telefono){
        super(nombreEmpleado, sueldoBase);
        this.departamento=departamento;
        this.telefono=telefono;
    }
    //String str="Nombre: "+this.nombreEmpleado+"\nClave: "+this.claveEmpleado+"\nSueldo base: "+this.sueldoBase+"\n";
        //return str;
    public String toString(){
        String str = super.toString()+ "\nDepartamento: "+this.departamento+"\nTelefono: "+this.telefono;
        return str;
    }
    
    
    public void setDepartamento(String depa){
        this.departamento=departamento;
    }
    
}
