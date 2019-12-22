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
public class Secundaria extends Superior{
    
    private String actividad;
    
    
    public Secundaria(String nombre, String curp, String madre, String padre, String tutor, String fecha,
            String escuela, double promedio, String grado, double calis, String actividad){
    
        super(nombre, curp, madre, padre, tutor, fecha, escuela, promedio, grado, calis);
        
        this.actividad = actividad;
    }
    
    
    //TO_STRING
    public String toString(){
        String resp = super.toString() + "Actividad:  " + this.actividad + "\n";
        return resp;
    }

}