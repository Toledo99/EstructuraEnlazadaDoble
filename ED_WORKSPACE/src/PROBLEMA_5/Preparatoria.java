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
public class Preparatoria extends Superior {
    
    private int area;
    
    public Preparatoria(String nombre, String curp, String madre, String padre, String tutor, String fecha,
            String escuela, double promedio, String grado, double calis, int area){
    
        super(nombre, curp, madre, padre, tutor, fecha, escuela, promedio, grado, calis);
        
        this.area = area;
    }
    
    //TO_STRING
    public String toString(){
        String resp= super.toString() + "Area:  " + this.area + "\n";
        return resp;
    }
    
    //GETTERS
    public int getArea(){
        return this.area;
    }
}
