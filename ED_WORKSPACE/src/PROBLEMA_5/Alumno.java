
package PROBLEMA_5;

/**
 *
 * @author huesos
 */
public abstract class Alumno {
    private String nombre;
    private String curp;
    private String madre;
    private String padre;
    private String tutor;
    private String fecha;

    public Alumno(String nombre, String curp, String madre, String padre, String tutor, String fecha){
        this.nombre = nombre;
        this.curp = curp;
        this.madre = madre;
        this.padre = padre;
        this.tutor = tutor;
        this.fecha = fecha;
    }
    
    //SIN TUTOR
    public Alumno(String nombre, String curp, String madre, String padre, String fecha){
        this.nombre = nombre;
        this.curp = curp;
        this.madre = madre;
        this.padre = padre;
        this.fecha = fecha;
    }
    
    //TO_STRING
    public String toString(){
        String resp= "Nombre: " + this.nombre + "\n" +
                     "CURP:   " + this.curp + "\n" +
                     "Madre:  " + this.madre + "\n" +
                     "Padre:  " + this.padre + "\n" +
                     "Tutor:  " + this.tutor + "\n" +
                     "Fecha:  " + this.fecha + "\n";
        
        return resp;
    }
    
    //GETTERS
    public String getTutor(){
        return this.tutor;
    }
}
