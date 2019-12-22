
package PROBLEMA_7;


public class Pajaro implements ObjVolador {
    
    //ATRIBUTOS
    private static int folio = 100;
    private int clave;
    private String especie;
    private String habitat;
    
    //CONSTRUCTOR
    public Pajaro(){
        this.clave = folio;
        folio++;
    }
    
    public Pajaro(String especie, String habitat){
        this();
        this.habitat=habitat;
    }
    
    //FUNCIONALIDAD OBLIGATORIA POR LA INTERFACE
    public void despegaO(){
        System.out.println("Despega PÁJARO |UP| \n ");
    }
    
    public void aterrizaO(){
        System.out.println("Aterriza PÁJARO |DOWN| \n ");
    }
    
   
    public void seDesplaza() {
        System.out.println("Se desplaza PÁJARO |WALK| \n ");
    }
    
    
    //GETTERS
    public int getClave(){
        return this.clave;
    }
    
    public String getHabitat(){
        return this.habitat;
    }
    
    public String getEspecie(){
        return this.especie;
    }
    
    //SETTERS
    public void setHabitat(String newHabitat){
        this.habitat = newHabitat;
    }
    
    //FUNCIONALIDAD MINIMA REQUERIDA
    public String toString(){
        String resp="Clave: "+ this.clave;
        return resp;
    }
}
