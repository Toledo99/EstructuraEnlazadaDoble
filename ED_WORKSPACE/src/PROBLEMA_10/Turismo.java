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
public class Turismo extends DePasajeros{
    private boolean asientoCama;
    private boolean serviBar;
    
    public Turismo(){
    }
    
    public Turismo(String marca, String numMotor, String placas, double costoCamion, int totalPasaj, boolean asientoCama, boolean serviBar ){
        super(marca, numMotor, placas, costoCamion, totalPasaj );
        this.asientoCama=asientoCama;
        this.serviBar=serviBar;
    }
    
    public String toString(){
        String res= super.toString() + "\nAsiento cama: "+this.asientoCama+"\nServi bar: "+this.serviBar+"\n";
        return res;
    }
    
    
    
    public double calculaCosto(double km){
        double res= super.calculaCostoServicio(km);
        if(this.serviBar)
            res+= res*0.5;
        if(this.asientoCama)
            res+= res*0.5;
         
        return res;
        
    }
    
}
