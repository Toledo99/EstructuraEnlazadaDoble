
package PROBLEMA_38;


public class Foto extends Archivo{
    
    private double resolucion;
    
    public Foto(double tamanio, String nombre, String duenio, String fecha, double resolucion) {
        super(tamanio, nombre, duenio, fecha);
        this.resolucion = resolucion;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\n Resolución: "+this.resolucion;
    }
}
