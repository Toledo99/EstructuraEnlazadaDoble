
package PROBLEMA_8;

public abstract class Cuadrilatero {
    private double base;
    private double altura;
    
    public Cuadrilatero(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    public double calculaArea(){
        double area = base * altura;
        return area;
    }
    
    public double calculaPerimetro(){
        double perimetro = (base*2) + (altura*2);
        return perimetro;
    }
    
}
