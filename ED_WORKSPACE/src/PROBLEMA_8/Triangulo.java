
package PROBLEMA_8;

public class Triangulo implements FigGeometrica{
    private double base;
    private double altura;
    private double lado1, lado2, lado3;
    
    public Triangulo(double base, double altura, double lado1, double lado2, double lado3){
        this.base =  base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    
 
    @Override
    public double calculaArea(){
        double area = base * altura / 2;
        return area;
    }
    
    
    @Override
    public double calculaPerimetro(){
        double perimetro = lado1 + lado2 + lado3;
        return perimetro;
    }
}
