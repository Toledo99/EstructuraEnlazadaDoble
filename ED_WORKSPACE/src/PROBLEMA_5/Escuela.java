
package PROBLEMA_5;


public class Escuela {
    
    private Kinder[] alumnosKinder;
    private Primaria[] alumnosPrimaria;
    private Secundaria[] alumnosSecundaria;
    private Preparatoria[] alumnosPrepa;
    
    private final int MAX_KINDER = 5;
    private final int MAX_PRIMARIA = 5;
    private final int MAX_SECUNDARIA = 5;
    private final int MAX_PREPA = 5;
    
    private int numKinder;
    private int numPrimaria;
    private int numSecundaria;
    private int numPrepa;
    
    
    public Escuela(){
        
        this.alumnosKinder = new Kinder[MAX_KINDER];
        this.numKinder = 0;
        
        this.alumnosPrimaria = new Primaria[MAX_PRIMARIA];
        this.numPrimaria = 0;
    
        this.alumnosSecundaria = new Secundaria[MAX_KINDER];
        this.numSecundaria = 0;
        
        this.alumnosPrepa = new Preparatoria[MAX_PREPA];
        this.numPrepa = 0;
        
    }
    
//a) ALMACENAR DATOS ALUMNOS:
    
    //ALTA - KINDER:
    public boolean altaAlumno(String nombre, String curp, String madre, String padre, String tutor, String fecha){
        boolean resp = false;
        
        if( this.buscaKinder(curp) < 0){
            resp = true;
            alumnosKinder[numKinder] = new Kinder(nombre, curp,  madre,  padre,  tutor,  fecha);
            numKinder++;
        }
        
        return resp;
    }
    
    //ALTA - PRIMARIA
    public boolean altaAlumno(String nombre, String curp, String madre, String padre, String tutor, String fecha, String escuela, double promedio, String grado, double calis){
        boolean resp = false;
        
        if( this.buscaKinder(curp) < 0){
            resp = true;
            alumnosPrimaria[numPrimaria] = new Primaria(nombre, curp,  madre,  padre,  tutor,  fecha, escuela, promedio, grado, calis);
            numPrimaria++;
        }
        
        return resp;
    }
    
    //ALTA - SECUNDARIA
    public boolean altaAlumno(String nombre, String curp, String madre, String padre, String tutor, String fecha, String escuela, double promedio, String grado, double calis, String actividad){
        boolean resp = false;
        
        if( this.buscaKinder(curp) < 0){
            resp = true;
            alumnosSecundaria[numSecundaria] = new Secundaria(nombre, curp,  madre,  padre,  tutor,  fecha, escuela, promedio, grado, calis, actividad);
            numSecundaria++;
        }
        
        return resp;
    }
    
    //ALTA - PREPA
    public boolean altaAlumno(String nombre, String curp, String madre, String padre, String tutor, String fecha, String escuela, double promedio, String grado, double calis, int area){
        boolean resp = false;
        
        if( this.buscaKinder(curp) < 0){
            resp = true;
            alumnosPrepa[numPrepa] = new Preparatoria(nombre, curp,  madre,  padre,  tutor,  fecha, escuela, promedio, grado, calis, area);
            numPrepa++;
        }
        
        return resp;
    }
    
//B) REPORTE DE TODA LA ESCUELA
    /*
    public Primaria[] ordenaPrimaria(){
        
    }
    */
    
//C) ALUMNOS DE PRIMARIA CON LA MISMA ESCUELA DE PROCEDENCIA
    public int mismaProcPrimaria(String escuelaProc){
        int tot = 0;
        
        for(int i=0; i<numPrimaria; i++)
            if(alumnosPrimaria[i].getEscuela().equals(escuelaProc))
                tot++;
        
        return tot;
    }
   
//D) REPORTE ALUMNOS DE SECUNDARIA ARRIBA DE NUEVE Y CON TUTOR
    public String nueveYTutorSecundaria (){
        String resp="";
        
        for(int i=0; i<numSecundaria; i++)
            if(alumnosSecundaria[i].getPromedio() > 9 && !alumnosSecundaria[i].getTutor().equals(null))
                resp+= alumnosSecundaria[i].toString() + "\n";
        return resp;
    }
    
//E) REPORTE ALUMNOS DE SECUNDARIA ARRIBA DE NUEVE Y CON TUTOR
    public String nueveYArea1Prepa (){
        String resp="";
        
        for(int i=0; i<numPrepa; i++)
            if(alumnosPrepa[i].getPromedio() < 9 && alumnosPrepa[i].getArea() == 1)
                resp+= alumnosPrepa[i].toString() + "\n";
        return resp;
    }
    
//F) DAR DATOS DE UN ALUMNO DEL COLEGIO
    public String datosAlumno(String curp){
        String resp="No existe dicho alumno.";
        
        int pos = this.buscaKinder(curp);
        if(pos > 0)
            resp= alumnosKinder[pos].toString();
        else{
            pos= this.buscaPrimaria(curp);
            if(pos > 0)
                resp= alumnosPrimaria[pos].toString();
            else{
                pos = this.buscaSecundaria(curp);
                if(pos > 0)
                    resp= alumnosSecundaria[pos].toString();
                else{
                    pos = this.buscaPrepa(curp);
                    if(pos > 0)
                    resp= alumnosPrepa[pos].toString();
                }
                    
            }
                
        }
       return resp;     
    }
    
    
//BUSQUEDA DE ALUMNOS:
    
    //BUSQUEDA KINDER
    public int buscaKinder(String curp){
        
        int i=0;
        
        while(i<numKinder && ! alumnosKinder[i].equals(curp))
            i++;
        
        if(i == numKinder)
            i=-1;
        
        return i;
    }
    
    //BUSQUEDA PRIMARIA
    public int buscaPrimaria(String curp){
        
        int i=0;
        
        while(i<numPrimaria && ! alumnosPrimaria[i].equals(curp))
            i++;
        
        if(i == numPrimaria)
            i=-1;
        
        return i;
    }
    
    //BUSQUEDA SECUNDARIA
    public int buscaSecundaria(String curp){
        
        int i=0;
        
        while(i<numSecundaria && ! alumnosSecundaria[i].equals(curp))
            i++;
        
        if(i == numSecundaria)
            i=-1;
        
        return i;
    }
    
    
    
    //BUSQUEDA PREPARATORIA
    public int buscaPrepa(String curp){
        
        int i=0;
        
        while(i<numPrepa && ! alumnosPrepa[i].equals(curp))
            i++;
        
        if(i == numPrepa)
            i=-1;
        
        return i;
    }
}

