
package PROBLEMA_10;


public abstract class Camion implements java.io.Serializable{
    private String marca;
    private String numMotor;
    private String placas;
    private double costoCamion;
    
    public Camion(){
    }
    
    public Camion(String marca, String numMotor, String placas, double costoCamion){
        this.marca = marca;
        this.numMotor = numMotor;
        this.placas = placas;
        this.costoCamion=costoCamion;
    }
    
    public String toString(){
        String resp= "Marca: "+this.marca+"\n #Motor: "+this.numMotor+"\nPlacas: "+this.placas+"\n";
        return resp;
    }
    
    public boolean equals(Camion otro){
        boolean resp=false;
        if(this.placas.equals(otro.placas))
            resp=true;
        return resp;
    }
    
    //Getters
    public String getMarca(){
        return this.marca;
    }
    public String getNumMotor(){
        return this.numMotor;
    }
    public String getPlacas(){
        return this.placas;
    }
    public double getCostoCamion(){
        return this.getCostoCamion();
    }
    
    //Setters
    public void setMarca(String neoMarca){
        this.marca = neoMarca;
    }
    public void setNumMotor(String neoNumMotor){
        this.numMotor = neoNumMotor;
    }
    public void setPlacas(String neoPlacas){
        this.placas = neoPlacas;
    }
    public void setPlacas(double costoCamion){
        this.costoCamion=costoCamion;
    }
    
}
