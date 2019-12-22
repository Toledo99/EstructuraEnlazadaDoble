/**______PROBLEMA 1___
 * ___CLASE RECTANGULO____
 * DIEGO HERNÁNDEZ DELGADO
 * CLAVE ÚNICA: 176262
 * FECHA: 15/01/2019
 */
package POO;

/**
 *
 * @author huesos
 */
public class Rectangulo {
    private double lado1;
    private double lado2;
    
    public Rectangulo(){
    }
    
    public Rectangulo(double lado1, double lado2){
        this.lado1=lado1;
        this.lado2=lado2;
    }
    
    public void setLado1(double lado1){
        this.lado1=lado1;
    }
    
    public void setLado2(double lado2){
        this.lado2=lado2;
    }
    
    public double getLado1(){
        return this.lado1;
    }
    
    public double getLado2(){
        return this.lado2;
    }
    
    public boolean equals(Rectangulo otro){
        boolean resp=false;
        if(this.lado1 == otro.getLado1() && this.lado2 == otro.getLado2())
            resp=true;
        return resp;
    }
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Lado 1: "+this.lado1+"\n");
        sb.append("Lado 2: "+this.lado2+"\n");
        return sb.toString();
    }
    
    public double calculaArea(){
        double area= lado1*lado2;
        return area;
    }
    
    public double calculaPerimetro(){
        return lado1*2 + lado2*2;
    }
    
    
}
