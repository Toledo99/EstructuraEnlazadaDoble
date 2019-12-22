/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParaJUnit;

/**
 *
 * @author huesos
 */
public class Rectangulo {
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura){
        this.base = base;
        this. altura = altura;
    }
    
    public double calculaArea(){
        double area=base*altura;
        return area;
    }
    
    public double calculaPerimetro(){
        double perimetro = base*2+altura*2;
        return perimetro;
    }
}
