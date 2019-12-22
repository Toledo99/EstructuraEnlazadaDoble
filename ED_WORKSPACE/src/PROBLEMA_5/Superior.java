/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_5;

/**
 *
 * @author huesos
 */
public abstract class Superior extends Alumno{
    private String escuela;
    private double promedio;
    private String grado;
    private double calis;
    
    public Superior(String nombre, String curp, String madre, String padre, String tutor, String fecha,
            String escuela, double promedio, String grado, double calis){
        
        super(nombre, curp, madre, padre, tutor, fecha);
        
        this.escuela = escuela;
        this.promedio = promedio;
        this.grado = grado;
        this.calis = calis;
    }
    
    
    //TO-STRING
    public String toString(){
        String resp = super.toString() +
                        "Escuela de procedencia: " + this.escuela + "\n" +
                        "Promedio: " + this.promedio + "\n" +
                        "Grado:    " + this.grado + "\n" +
                        "Calis:    " + this.calis + "\n";
        return resp;
        
    }
    
    
    //GETTERS
    public String getEscuela(){
        return this.escuela;
    }
    
    public double getPromedio(){
        return this.promedio;
    }
}
