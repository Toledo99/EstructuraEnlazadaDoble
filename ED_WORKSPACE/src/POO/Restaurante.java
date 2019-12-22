/**______PROBLEMA 2___
 * ___CLASE RESTAURANTE____
 * DIEGO HERNÁNDEZ DELGADO
 * CLAVE ÚNICA: 176262
 * FECHA: 15/01/2019
 */
package POO;

public class Restaurante {
    private String nombre;
    private String direccion;
    private Cuadrado[] mesas;
    private static final int MAX_MESAS=25;
    private int numMesas;
    
    public Restaurante(){
        mesas=new Cuadrado[MAX_MESAS];
        numMesas=0;
    }
    
    public Restaurante(String nombre, String direccion){
        this();
        this.nombre=nombre;
        this.direccion=direccion;
    }
    
    public boolean altaMesa(double lado){
        boolean resp=false;
        if(numMesas<MAX_MESAS){
            mesas[numMesas]=new Cuadrado(lado);
            numMesas++;
            resp=true;
        }
        return resp;
    }
    
    public boolean bajaMesa(int posicion){
        boolean resp= false;
        if(numMesas>0 && posicion<25 && posicion >=0){
            if(posicion == numMesas-1)
                mesas[posicion]=null;
            else{
                mesas[posicion]=mesas[mesas.length-1];
                mesas[mesas.length-1]=null;
            }   
            numMesas--;
            resp=true;
        }
        return resp;
    }
    
    public double totalTela(){
        double suma=0;
        for(int i=0; i<numMesas; i++)
            suma+= mesas[i].calculaArea();
        return suma;
    }
    
    public double totalPuntilla(){
        double suma=0;
        for(int i=0; i<numMesas; i++)
            suma+=mesas[i].calculaPerimetro();
        return suma;
    }
    
    public String toStringMesas(){
        String str="";
        for(int i=0; i< numMesas; i++){
            str+=mesas[i].getLado()+" ";
        }
        return str;
    }
    
    //MAIN_CLASS: EJECUTABLE_PRUEBA
    public static void main(String[]args){
        Restaurante r1=new Restaurante("El gallo de oro", "Carretera a Cuernavaca");
        
        System.out.println("Alta 1: "+ r1.altaMesa(1.5)); 
        r1.altaMesa(2.5);
        r1.altaMesa(3.5);
        r1.altaMesa(4.5);
        r1.altaMesa(5.5);
        
        r1.altaMesa(6.5);
        r1.altaMesa(7.5);
        r1.altaMesa(8.5);
        r1.altaMesa(9.5);
        r1.altaMesa(10.5);
        
        r1.altaMesa(11.5);
        r1.altaMesa(12.5);
        r1.altaMesa(13.5);
        r1.altaMesa(14.5);
        r1.altaMesa(15.5);
        
        r1.altaMesa(16.5);
        r1.altaMesa(17.5);
        r1.altaMesa(18.5);
        r1.altaMesa(19.5);
        r1.altaMesa(20.5);
        
        r1.altaMesa(21.5);
        r1.altaMesa(22.5);
        r1.altaMesa(23.5);
        r1.altaMesa(24.5);
        System.out.println("Alta 25: "+ r1.altaMesa(25.5)); 
        System.out.println("Baja 2: "+ r1.bajaMesa(1)); 
        
        System.out.println("Total de tela: "+r1.totalTela());
        System.out.println("Total puntilla: "+r1.totalPuntilla());
        
        System.out.println(r1.toStringMesas());
    }
}
