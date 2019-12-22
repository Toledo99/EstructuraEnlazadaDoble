
package PROBLEMA_7;

public class AppVoladores {
    
    //ATRIBUTOS
    public Pajaro [] arrPajaros;
    public Avion [] arrAviones;
    
    public final int MAX_PAJAROS = 5;
    public final int MAX_AVIONES = 5;
    
    public int numPajaros;
    public int numAviones;
    
    //A)
    //CONSTRUCTOR
    public AppVoladores(){
        arrPajaros = new Pajaro[MAX_PAJAROS];
        numPajaros = 0;
        
        arrAviones = new Avion[MAX_AVIONES];
        numAviones = 0;
    }
    
    //ALTAS
    public boolean altaPajaros(String especie, String habitat){
        boolean resp=false;
        int i =0;
        while(i<numPajaros && !arrPajaros[i].getEspecie().equals(especie))
            i++;
        if(i < numPajaros){
            arrPajaros[numPajaros] = new Pajaro(especie, habitat);
            numPajaros++;
            resp=true;   
        }
        return resp;
    }
    
    public boolean altaAviones(String especie, String habitat){
        boolean resp=false;
        int i =0;
        while(i<numPajaros && !arrPajaros[i].getEspecie().equals(especie))
            i++;
        if(i < numPajaros){
            arrPajaros[numPajaros] = new Pajaro(especie, habitat);
            numPajaros++;
            resp=true;   
        }
        return resp;
    }
    
    
    //B) DATOS DEL PÁJARO
    public String datosDelPajaro(int clave){
        String resp="NO se encuentra ese pájaro.";
        
        int pos = this.posPajaro(clave);
        
        if(pos > 0 && pos<numPajaros)
            resp=arrPajaros[pos].toString();
        
        return resp;
    }
    
    //C) CANTIDAD DE PASAJEROS
    public String cantidadPasajeros(int clave){
        String resp = "No se encontró ese avión.";
        
        int pos = this.posAvion(clave);
        
        if(pos > 0 && pos<numAviones && arrAviones[pos].getTipo().equals("pasajeros"))
            resp="Cantidad de pasajeros del avión " + arrAviones[pos].getClave() + "es de: " + arrAviones[pos].getClave()+ " pasajeros.";
        
        return resp;
    }
    
    //D) ACTUALIZAR HABITAT
    public boolean actualizarHabitat(int clave, String newHabitat){
       boolean resp= false;
        
        int pos = this.posPajaro(clave);
        
        if(pos > 0 && pos<numPajaros){
           resp=true;
           arrPajaros[pos].setHabitat(newHabitat);
        }   
        return resp;   
    }
    
    //BUSCAR PAJARO POR CLAVE
    public int posPajaro(int clave){
        int i =0;
        while(i<numPajaros && arrPajaros[i].getClave() != clave)
            i++;
        if(i == numPajaros)
            i=-1;
        return i;  
    }
    //BUSCAR AVION POR CLAVE
    public int posAvion(int clave){
        int i =0;
        while(i<numAviones && arrAviones[i].getClave() != clave)
            i++;
        if(i == numAviones)
            i=-1;
        return i;  
    }
    
    //EJECUTABLE
    public static void main(String [] args){
        
    }
    
}
