
package PROBLEMA_6;


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
    
    //SOBRESCRITURA DEL METODO OBLIGATORIO (ABSTRACTO)
    public double calculaSalario(double prestac, double deduc){
        double salario = this.sueldoBase+ (this.sueldoBase*prestac/100)-(this.sueldoBase*deduc/100);

        return salario;
    }
}
