/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_10;

/**
 *
 * @author huesos
 */
public class Escolar extends DePasajeros{
    private boolean lugarProyecto;
    
    public Escolar(){
        
    }
    
    public Escolar(String marca, String numMotor, String placas, double costoCamion, int totalPasaj, boolean lugarProyecto){
        super(marca, numMotor, placas, costoCamion, totalPasaj );
        this.lugarProyecto=lugarProyecto;
    }
    
    public double calculaCostoServicio(double a){
        double resp= super.getCostoCamion()*0.0001 / super.getTotalPasaj()*250;
        return resp;
    }
    
    //Get 
    public boolean getLugarProyecto(){
        return this.lugarProyecto;
    }
}
