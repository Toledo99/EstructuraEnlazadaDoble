
package PROBLEMA_9;


public class App {
    private final int MAX_FIG=10;
    private FigGeometrica[] arrFiguras;
    private int ocupados;
    
    //1) Definir un arreglo polimórfico de FigGeometrica:
    public App(){
        arrFiguras = new FigGeometrica [MAX_FIG];
        ocupados = 0;
    }
    
    //2) Alta figuras:
    
    //Cuadrilateros:
    public boolean altaFiguras(double base, double altura){
        boolean resp = false;
        int i = 0;
        while(i<ocupados && !(arrFiguras[i] instanceof Cuadrilatero) || ((Cuadrilatero)arrFiguras[i]).getAltura()!=altura && ((Cuadrilatero)arrFiguras[i]).getBase()!=base)
            i++;
        if(i<ocupados){
            if(base == altura){
                arrFiguras[ocupados] = new Cuadrado(base, altura);
                ocupados++;
            }
            else{
                arrFiguras[ocupados] = new Rectangulo(base, altura);
                ocupados++;
                }
            resp=true;
        }

        return resp;
    }
    
    //Triangulo:
    public boolean altaFiguras(double base, double altura, double lado1, double lado2, double lado3){
        boolean resp = false;
        int i = 0;
        while( i<ocupados && !(arrFiguras[i] instanceof Triangulo) || ((Triangulo)arrFiguras[i]).getAltura() !=altura && ((Triangulo)arrFiguras[i]).getAltura() !=altura ) 
            i++;
        if(i<ocupados){
            arrFiguras[ocupados] = new Triangulo(base, altura, lado1, lado2, lado3);
            ocupados++;
            resp=true;
        }
        return resp;
    }
    //Circulo:
    public boolean altaFiguras(double radio){
        boolean resp = false;
        int i = 0;
        while( i<ocupados && !arrFiguras[i].getClass().equals("Circulo") || ((Circulo)arrFiguras[i]).getRadio()!=radio) 
            i++;
        if(i<ocupados){
            arrFiguras[ocupados] = new Circulo(radio);
            ocupados++;
            resp=true;
        }
        return resp;
    }
    
    //3) Calcular e imprimir el área de todas las figuras almacenadas:
    public double calculaArea(){
        double suma=0;
        for(int i=0; i<ocupados; i++)
            suma+= arrFiguras[i].calculaArea();
        return suma;
    }
    
    //4)Encontrar e imprimir los datos del círculo más grande:
    public String circuloMayor(){
        double max, temp=0;
        int i, pos=0;
        String resp;
        max=-1;
        for(i=0; i<5;i++)
            if(arrFiguras[i] instanceof Circulo)
                temp = ( (Circulo) arrFiguras[i]).getRadio();
        if(max < temp){
            max=temp;
            pos=i;
        }
        if(max >0)
            resp = arrFiguras[pos].toString();
        else
            resp = null;
        
        return resp;
    }
    
    
    //5) Calcular e imprimir el total de cuadrados:
    public int totalDeCuadrados(){
        int cont=0;
        for(int i=0; i<ocupados; i++)
            if(arrFiguras[i] instanceof Cuadrado)
                cont++;
        return cont;
    }
    
    //6) Eliminar todos los triángulos equiláteros
    public int eliminaEquilatero(){
        int cont=0;
        int i=0;
        while(i<ocupados){
            if(arrFiguras[i] instanceof Triangulo && ((Triangulo)arrFiguras[i]).tipoTriangulo().equals("Equilatero")){
                arrFiguras[i]=arrFiguras[ocupados-1];
                arrFiguras[ocupados-1]=null;
                ocupados++;
                cont++;
            }
            else
                i++;
        }
        return cont;
    }
}
