
package PROBLEMA_6;


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
    //SOBRESCRITURA DEL METODO OBLIGATORIO (ABSTRACTO)
    
    public double calculaSalario(double prestac, double deduc){
        double salario = this.sueldoBase+ (this.sueldoBase*prestac/100)-(this.sueldoBase*deduc/100);

        return salario;
    }
    
    public double calculaSalaRio(double prestac, double deduc, double precioHE){
        double salario = this.sueldoBase+ (this.sueldoBase*prestac/100)-(this.sueldoBase*deduc/100)+(this.horasExtra*precioHE);
        return salario;
    }
}
