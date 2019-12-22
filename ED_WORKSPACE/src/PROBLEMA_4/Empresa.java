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
public class Empresa {
    
    
    private String nombreEmpresa;
    private String direccion;
    private String nombreDuenio;
    
    private Administrativo[] datosAdmin;
    private final static int MAX_ADMIN=10;
    private int numAdmin;
    
    private Operario[] datosOperarios;
    private final static int MAX_OPER=10;
    private int numOperarios;
    
    
    
    
    //1) ALTA DE EMPLEADOS:
        //ALTA ADMINISTRATIVO:
    public boolean alta(String nombreEmpleado, double sueldoBase, String departamento, String telefono){
        boolean resp=false;
        int pos= this.buscarAdministrativo(nombreEmpleado);
        if(numAdmin< MAX_ADMIN && pos == -1){
            datosAdmin[numAdmin]= new Administrativo(nombreEmpleado, sueldoBase, departamento, telefono);
            numAdmin++;
            resp=true;
        }
         return resp;   
    }
    
        //ALTA OPERARIO:
    public boolean alta(String nombreEmpleado, double sueldoBase, int horasExtra){
        boolean resp=false;
        int pos= this.buscarOperario(nombreEmpleado);
        if(numOperarios < MAX_OPER  && pos == -1){
            datosOperarios[numOperarios]= new Operario(nombreEmpleado, sueldoBase, horasExtra);
            numOperarios++;
            resp=true;
        }
            
       return resp;
    }
    

    //2)REPORTE DE EMPLEADOS ADMINISTRATIVOS:
    public String reporteAdmin(){
        String str="";
        
        for(int i=0; i<numAdmin; i++)
            str=datosAdmin[i].getNombreEmpleado()+": "+datosAdmin[i].getSueldoBase();
        
        return str;
    }
    
    
    //3)ACTUALIZACION DE SUELDO PARA ADMINISTRATIVO:
    public boolean actualizarSueldoAdmin(int claveEmpleado, double aumento){
        boolean resp=false;
        
        int pos= this.buscarOperario(claveEmpleado);
        
        if(pos > -1){
            datosAdmin[pos].setSueldoBase(datosAdmin[pos].getSueldoBase() + (datosAdmin[pos].getSueldoBase()* aumento /100));
            resp=true;
        }
        return resp;
    }
    
    
    //4)CAMBIO DE DEPARTAMENTO PARA EMPLEADOS ADMINISTRATIVOS:
    public boolean cambiaDepartamento(int claveEmpleado, String departamento){
        boolean resp=false;
        
        int pos= this.buscarAdministrativo(claveEmpleado);
        
        if(pos > -1){
            datosAdmin[pos].setDepartamento(departamento);
            resp=true;
        }
        return resp;
    }
    
    
    //5)CUÁNTO COBRARÁ UN CIERTO EMPLEADO ESTE MES:
    public double cuantoCobraOperario(int claveEmpleado, double prestac, double deduc, double precioHE){
        double sueldo;
        int pos= this.buscarOperario(claveEmpleado);
        
        if(pos>-1){
           sueldo= datosOperarios[pos].calculaSalario(prestac, deduc, precioHE);  
        }
        else
            sueldo=0;
        
        return sueldo;
    }
    
    
    //6)REPORTE DE EMPLEADOS QUE TIENEN UN SUELDO BASE MENOR A CIERTA CANTIDAD:
    public String gananMenosDe(double unSueldo){
        int cant=0;
        String str="";
        
        for(int i=0; i<numOperarios; i++)
            if(datosOperarios[i].getSueldoBase() < unSueldo){
                str+= datosOperarios[i].toString()+"\n";
                cant++;
            }
        str+="Empleados con cantidad menor a "+unSueldo+": "+cant;
        
        return str;  
    }
    
    
    //METODOS AUXILIARES:
    
    //Buscar administrativos:
    private int buscarAdministrativo(int claveEmpleado){
        int i=0;
        while(i<numAdmin && datosAdmin[i].getClaveEmpleado() != claveEmpleado)
            i++;
       
        if(i == numAdmin)
            i=-1;
        
        return i;
    }
    
    private int buscarAdministrativo(String nombreEmpleado){
        
        int i=0;
        while(i<numAdmin && !datosAdmin[i].getNombreEmpleado().equals(nombreEmpleado))
            i++;
       
        if(i == numAdmin)
            i=-1;
        
        return i;
    }
    
    //Buscar operarios:
    private  int buscarOperario(int claveEmpleado){
        int pos= -1;
        int i=0;
        while(i<numOperarios && datosOperarios[i].getClaveEmpleado() != claveEmpleado)
            i++;
       
        if(i != numOperarios)
            pos=i;
        
        return pos;
    }
    
    private int buscarOperario(String nombreEmpleado){
        int resp= -1;
        int i=0;
        while(i<numOperarios && !datosOperarios[i].getNombreEmpleado().equals(nombreEmpleado))
            i++;
       
        if(i != numOperarios)
            resp=i;
        
        return resp;
    }
}
