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
public abstract class DePasajeros extends Camion{
    private int totalPasaj;
    
    public DePasajeros(){
    }
    
    public DePasajeros(String marca, String numMotor, String placas, double costoCamion, int totalPasaj){
        super(marca, numMotor, placas, costoCamion);
        this.totalPasaj=totalPasaj;
    }
    
    public String toString(){
        String resp = super.toString()+"Total de pasajeros: "+this.totalPasaj+"\n";
        return resp;
    }
    
    //Método propio de esta clase:
    public double calculaCostoServicio(double km){
        double resp= super.getCostoCamion()*0.0001 / this.totalPasaj * km;
        return resp;
    }
    
    //Get
    public int getTotalPasaj(){
        return this.totalPasaj;
    }
    
    //Set
    public void setTotalPasaj(int neoTotalPasaj){
        this.totalPasaj = neoTotalPasaj;
    }
}
