
package PROBLEMA_9;

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
    
    public String tipoTriangulo(){
        String resp="";
        if(this.lado1 == this.lado2 && this.lado2 == this.lado3)
            resp="Equilatero";
        else 
            if(this.lado1 == this.lado2 || this.lado1 == this.lado3 || this.lado3 == this.lado2)
                resp="Isóceles";
            else
                resp="Escaleno";
        return resp;
    }
    
    //Getters

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }
    
}
