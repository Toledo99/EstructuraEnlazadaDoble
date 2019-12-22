
package PROBLEMA_11;

import PROBLEMA_10.*;


public class EmpresaMinera {
    private String nombreEmpresa;
    private final static int MAX_CAM=10;
    private Camion[] camiones;
    private int totalCam;
    
    public EmpresaMinera(){
    }
    
    //1) Datos de todos los camiones:
    public String reporteCamiones(){
        String resp="";
        for(int i= 0; i<totalCam; i++)
            resp+= camiones[i].toString();
        return resp;
    }
    
    //2)Actualizar capacidad de transporte:
    public boolean actualizarCapacidad(String placas, double neoCapacidad){
        boolean resp=false;
        int i=0;
        while(i<totalCam && !camiones[i].getPlacas().equals(placas))
                i++;
        if(i<totalCam && camiones[i] instanceof DeVolteo){
            ((DeVolteo)camiones[i]).setCapacidadTon(neoCapacidad);
            resp=true;
        }
        return resp;
    }
    
    //3) Cantidad de camiones de pasajeros de una marca dada:
    public int cantidadDePasajerosMarca(String marca){
        int cont=0;
        
        for(int i=0; i<totalCam; i++)
            if(camiones[i] instanceof DePasajeros && camiones[i].getMarca().equals(marca))
                cont++;
        
        return cont;
    }
    
    //4)Total de toneladas cargadas simultaneamente:
    public double totalToneladas(){
        double suma=0;
        for(int i=0; i<totalCam; i++)
            if(camiones[i] instanceof DeVolteo)
                suma+= ( (DeVolteo) camiones[i]).getCapacidadTon();
        return suma;      
    }
}
