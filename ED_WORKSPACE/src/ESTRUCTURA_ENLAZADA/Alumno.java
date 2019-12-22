/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESTRUCTURA_ENLAZADA;

import PROBLEMA_25.*;

/**
 *
 * @author huesos
 */
public class Alumno {
    private String name;
    private double prom;
    
    public Alumno(String name, double prom){
        this.name=name;
        this.prom=prom;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String neoName){
        this.name=neoName;
    }
    public double getProm(){
        return this.prom;
    }
    
    public void setProm(double neo){
        this.prom=neo;
    }
}
