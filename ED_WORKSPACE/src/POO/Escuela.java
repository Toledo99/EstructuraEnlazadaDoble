/**______PROBLEMA 1___
 * ___CLASE ESCUELA____
 * DIEGO HERNÁNDEZ DELGADO
 * CLAVE ÚNICA: 176262
 * FECHA: 17/01/2019
 */

package POO;
import java.util.ArrayList;

public class Escuela {
  private String nombreEsc;
  private String direccion;
  private int cantAlumnos;
  private Alumno[] arrAlumnos;
  private static final int MAX_ALUMNOS=5;
  
  public Escuela(){
    arrAlumnos = new Alumno[MAX_ALUMNOS];
    cantAlumnos=0;
  }
  
  public Escuela(String nombreEsc, String direccion){
    this();
    this.nombreEsc=nombreEsc;
    this.direccion=direccion;
  }
  
  public boolean altaAlumno(String nombreAlumno){
    boolean resp=false;
    if(cantAlumnos<this.arrAlumnos.length){
      arrAlumnos[cantAlumnos]=new Alumno(nombreAlumno);
      cantAlumnos++;
    }
    
    return resp;
  }
  
  public boolean altaAlumnoConCalif(String nombreAlumno, double a, double b, double c){
    boolean resp=false;
    if(cantAlumnos<this.arrAlumnos.length ){ //programar una búsqueda secuencial privada y reutilizar el código
      arrAlumnos[cantAlumnos]=new Alumno(nombreAlumno);
      arrAlumnos[cantAlumnos].altaCalificacion(a);
      arrAlumnos[cantAlumnos].altaCalificacion(b);
      arrAlumnos[cantAlumnos].altaCalificacion(c);
      cantAlumnos++;
    }
    
    return resp;
  }
  
  public String datosAlumno(int claveUnica){
    String resp= "No se encontró alumno";
    int i=0;
    while(i<cantAlumnos && arrAlumnos[i].getClaveUnica() != claveUnica)
      i++;
    if(i<cantAlumnos)
      resp=arrAlumnos[i].toString();
    
    return resp;
  }
  
  private String escuelaToString(){
    StringBuilder sb= new StringBuilder();
    for(int i=0; i<cantAlumnos; i++)
      sb.append(this.arrAlumnos[i].getNombreAlum()+": "+this.arrAlumnos[i].calculaPromedio()+"\n");
    
    return sb.toString();
  }
  
  public String alumnoMayorAprobadas(){
    String resp="";
    int mayor=0;
    int max=0;
    
    for(int i =0; i<cantAlumnos; i++){
      if(arrAlumnos[i].numAprobadas()>max){
        mayor=i;
        max=arrAlumnos[i].numAprobadas();
      }
    }
    if(max>0)
        resp = arrAlumnos[mayor].getNombreAlum();
    else
        resp="Nadie aprobó.";
    return resp;
  }
  
  public  ArrayList alumnoMayorAprobadas2(){
    ArrayList <String> mayores= new ArrayList();
    int max=1;
    
    for(int i =0; i<cantAlumnos; i++){
      
      if(arrAlumnos[i].numAprobadas()==max){
        mayores.add(arrAlumnos[i].getNombreAlum());
      }else
        if(arrAlumnos[i].numAprobadas()>max){
          max=arrAlumnos[i].numAprobadas();
          mayores.clear();
          mayores.add(arrAlumnos[i].getNombreAlum());
      } 
    }
    
    return mayores;
  }
  
  //MAIN-CLASS: EJECUTABLE-PRUEBA
  public static void main (String[]args){
      Escuela itam= new Escuela("ITAM", "Rio Hondo");
      
      itam.altaAlumnoConCalif("Diego", 8.0, 6.5, 5.5);
      itam.altaAlumnoConCalif("Renata", 6.0, 9.5, 5.5);
      itam.altaAlumnoConCalif("Juan", 6.0, 5.5, 5.5);
      
      System.out.println(itam.datosAlumno(100));
      System.out.println(itam.escuelaToString());
      
      System.out.println("\nAlumno con mayor materias aprobadas:"+itam.alumnoMayorAprobadas());
      System.out.println("\nAlumnos con mayor materias aprobadas:"+itam.alumnoMayorAprobadas2());
  }
}
