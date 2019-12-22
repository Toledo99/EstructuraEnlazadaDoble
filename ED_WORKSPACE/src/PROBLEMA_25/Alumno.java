/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_25;

/**
 *
 * @author huesos
 */
public class Alumno {
    private int id;
    private boolean esLic;
    private boolean esIng;
    private double prom;
    
    public Alumno(int id, boolean esLic, boolean esIng, double prom){
        this.id=id;
        this.esLic = esLic;
        this.esIng = esIng;
        this.prom=prom;
    }
    
    public int getId(){
        return this.id;
    }
    
    public boolean esLic(){
        return this.esLic;
    }
    
    public boolean esIng(){
        return this.esIng;
    }
    
    public boolean equals(Alumno otro){
        return this.id == otro.getId();
    }
    
    public int getProm(){
        return this.id;
    }
    
    public void setProm(double neo){
        this.prom=neo;
    }
}
