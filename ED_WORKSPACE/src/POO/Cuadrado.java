/**______PROBLEMA 2___
 * ___CLASE CUADRADO____
 * DIEGO HERNÁNDEZ DELGADO
 * CLAVE ÚNICA: 176262
 * FECHA: 15/01/2019
 */
package POO;


public class Cuadrado {
    private double lado;
    
    public Cuadrado(){
    }
    
    public Cuadrado(double lado){
        this();
        this.lado=lado;
    }
    
    public void setLado(double lado){
        this.lado=lado;
    }
    
    public double getLado(){
        return this.lado;
    }
    
    public boolean equals(Cuadrado otro){
        boolean resp= false;
        if(this.lado == otro.getLado())
            resp=true;
        return resp;
    }
    
    public double calculaArea(){
        return lado*lado;
    }
    
    public double calculaPerimetro(){
        return lado*4;
    }
    
    
}
