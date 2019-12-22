
package PROBLEMA_9;

public abstract class Cuadrilatero implements FigGeometrica{
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
    
    //Getters
    public double getBase(){
        return this.base;
    }
    
    public double getAltura(){
        return this.altura;
    }
}
