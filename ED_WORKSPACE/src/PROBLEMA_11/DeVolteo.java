/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_11;

import PROBLEMA_10.*;

/**
 *
 * @author huesos
 */
public class DeVolteo extends Camion{
    private double capacidadTon;
    
    public DeVolteo(){
        
    }
    
    public DeVolteo(String marca, String numMotor, String placas, double capacidadTon){
        super(marca, numMotor, placas);
        this.capacidadTon=capacidadTon;
    }
    
    public String toString(){
        String resp= super.toString()+"Capacidad: "+this.capacidadTon+" ton\n";
        return resp;
    }
    
    //Get
    public double getCapacidadTon(){
        return this.capacidadTon;
    }
    
    public void setCapacidadTon(double neoCapacidadTon){
        this.capacidadTon = neoCapacidadTon;
    }
}
