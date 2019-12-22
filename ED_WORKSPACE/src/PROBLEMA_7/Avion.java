
package PROBLEMA_7;

public class Avion implements ObjVolador{
    
    //ATRIBUTOS
    private static int folio = 100;
    private int clave;
    
    private int numPasajeros;
    private String tipo;
    private String marca;
    
    //CONSTRUCTOR
    public Avion(){
        this.clave = folio;
        folio++;
    }
    
    public Avion(String tipo, String marca){
        this();
        this.tipo = tipo;
        this.marca= marca;
    }
    
    public Avion(String tipo, int numPasajeros){
        this();
        this.tipo = tipo;
        this.numPasajeros = numPasajeros;
    }
    
    //FUNCIONALIDAD OBLIGATORIA POR INTERFACE
    public void despegaO(){
        System.out.println("Despega AVIÓN |UP| \n ");
    }
    
    public void aterrizaO(){
        System.out.println("Aterriza AVIÓN |DOWN| \n ");
    }
    
   
    public void seDesplaza() {
        System.out.println("Se desplaza AVIÓN |WALK| \n ");
    }
    
    //GETTERS
    public int getClave(){
        return this.clave;
    }
    
    public int getNumPasajeros(){
        return this.numPasajeros;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    public String getMarca(){
        return this.marca;
    }
    
    //FUNCIONALIDAD MINIMA REQUERIDA
    public String toString(){
        String resp="Numero de pasajeros: " + this.numPasajeros + "\n";
        return resp;
    }
    
}
