
package PROBLEMA_9;

public class Circulo implements FigGeometrica{
    private double radio;
    
    public Circulo(double radio){
        this.radio = radio;
    }
    
    public double calculaArea(){
        double area = Math.PI * (radio*radio);
        return area;
    }
    
    public double calculaPerimetro(){
        double perimetro = Math.PI * (radio*2);
        return perimetro;
    }
    
    public double getRadio(){
        return this.radio;
    }
}
