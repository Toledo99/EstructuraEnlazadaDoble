
package PROBLEMA_10;

import java.io.FileInputStream;
import java.io.ObjectInputStream;



public class EmpTran {
    private String nombreEmpresa;
    private final static int MAX_CAM=10;
    private Camion[] camiones;
    private int totalCam;
    
    //CONSTRUCTOR
    public EmpTran(){
        this.camiones=new Camion[MAX_CAM];
        this.totalCam=0;
    }
    
    public boolean altaDesdeArchivo(String nomFile){
        boolean resp=false;
        try{
            FileInputStream file = new FileInputStream(nomFile);
            ObjectInputStream lee = new ObjectInputStream(file);
            
            Object obj = lee.readObject();
            int i=0;
            while( i<MAX_CAM){
                if(obj instanceof Camion){
                    camiones[i]= (Camion)obj;
                    this.totalCam++;
                    i++;
                    resp=true;
                }
                obj= lee.readObject();
            }
            lee.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return resp;
    }
    
    //1) Reporte de todos los camiones
    public String reporteCamiones(int cantPasajeros, double km){
        String res="";
        
        return res;
    }
    //1) Datos de todos los camiones:
    public String reporteCamiones(){
        String resp="";
        for(int i= 0; i<totalCam; i++)
            resp+= camiones[i].toString()+"\n";
        return resp;
    }
    
    /*
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
    */
    
    //3) Cantidad de camiones de pasajeros de una marca dada:
    public int cantidadDePasajerosMarca(String marca){
        int cont=0;
        
        for(int i=0; i<totalCam; i++)
            if(camiones[i] instanceof DePasajeros && camiones[i].getMarca().equals(marca))
                cont++;
        
        return cont;
    }
    
    public void setToalCamiones(int neo){
        this.totalCam=neo;
    }
    /*
    //4)Total de toneladas cargadas simultaneamente:
    public double totalToneladas(){
        double suma=0;
        for(int i=0; i<totalCam; i++)
            if(camiones[i] instanceof DeVolteo)
                suma+= ( (DeVolteo) camiones[i]).getCapacidadTon();
        return suma;      
    }
*/
    public static void main (String [] args){
        EmpTran c = new EmpTran();
        
        System.out.println("a: " + c.reporteCamiones());
        
        System.out.println("\nAlta desde archivo de objetos:  "+ c.altaDesdeArchivo("Archivo camiones"));
        
        System.out.println("\na: " + c.reporteCamiones());
        
        /*
        System.out.println("\nAlta desde archivo de objetos:  "+ c.altaDesdeArchivo("Archivo camiones"));
       
        System.out.println("\na: " + c.reporteCamiones());
        */
    }
}
