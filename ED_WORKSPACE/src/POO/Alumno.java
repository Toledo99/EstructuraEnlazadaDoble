/**______PROBLEMA 1___
 * ___CLASE ALUMNO____
 * DIEGO HERNÁNDEZ DELGADO
 * CLAVE ÚNICA: 176262
 * FECHA: 17/01/2019
 */
package POO;


public class Alumno {
  private static int folio=100;
  private int claveUnica;
  private String nombreAlum;
  private double[] calificaciones;
  private static final int MAX_CALIF=3;
  private int cantCalif;
  
  public Alumno(){
    claveUnica= folio;
    folio++;
  }
  
  public Alumno(String nombreAlum){
    this();
    this.claveUnica=claveUnica;
    this.nombreAlum=nombreAlum;
    this.cantCalif=0;
    calificaciones= new double[MAX_CALIF];
  }
  
  public boolean altaCalificacion(double calif){
    boolean resp=false;
    if(cantCalif<this.calificaciones.length){
      this.calificaciones[cantCalif]=calif;
      this.cantCalif++;
      resp=true;
    }
    return resp;
  }
  
  public String getNombreAlum(){
    return this.nombreAlum;
  }
  
  public int getClaveUnica(){
    return this.claveUnica;
  }
  
  public boolean equals(Alumno otro){
    boolean resp=false;
    if(this.nombreAlum.equals(otro.getNombreAlum()))
      resp=true;
    return resp;
  }
  
  public String toString(){
    StringBuilder sb= new StringBuilder();
    sb.append("Nombre alumno: "+this.nombreAlum+"\n");
    sb.append("Clave única:   "+this.claveUnica+"\n");
    sb.append("Calificaciones:");
    for(int i=0; i<cantCalif; i++){
      sb.append(calificaciones[i]+"   ");
    }
    sb.append("\n");
    return sb.toString();
  }
  
  public double calculaPromedio(){
    double suma=0, prom=0;
    for(int i=0; i<this.cantCalif; i++)
      suma+=calificaciones[i];
    
    prom=suma/this.cantCalif;
    return prom;
  }
  
  public int numAprobadas(){
    int numAprobadas=0;
    for (int i=0; i< cantCalif; i++)
      if(calificaciones[i]>=6)
        numAprobadas++;
    return numAprobadas;
  }
}
