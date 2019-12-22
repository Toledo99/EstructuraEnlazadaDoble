/**______PROBLEMA 1___
 * ___CLASE ComplejoVacacional____
 * DIEGO HERNÁNDEZ DELGADO
 * CLAVE ÚNICA: 176262
 * FECHA: 15/01/2019
 */
package POO;

public class ComplejoVacacional {
    private String nombre;
    private Rectangulo[] albercas;
    private static final int MAX_ALBERCAS=10;
    private int numAlb;
    
    public ComplejoVacacional(){
        albercas= new Rectangulo[MAX_ALBERCAS];
        numAlb=0;
    }
    
    public ComplejoVacacional(String nombre){
        this();
        this.nombre=nombre;
    }
    
    public boolean altaAlberca(double lado1, double lado2){
        boolean resp= false;
        if(numAlb<10){
            albercas[numAlb]= new Rectangulo(lado1, lado2);
            numAlb++;
            resp=true;
        }
        return resp;
    }
    
    public boolean bajaAlberca(int posicion){
        boolean resp=false;
        if(numAlb>=0 && posicion>=0 && posicion<=numAlb){
            if(posicion != numAlb-1){
                albercas[posicion]= albercas[numAlb];
                albercas[numAlb]=null;
            }else{
                albercas[posicion]=null;
            }
            numAlb--;
            resp=true;
        }
        return resp;
    }
    
    public double totalLona(){
        double suma=0;
        for(int i=0; i<numAlb; i++)
            suma+= albercas[i].calculaArea();
        return suma;
    }
    
    public double totalCerca(){
        double suma=0;
        for(int i=0; i<numAlb; i++)
            suma+= albercas[i].calculaPerimetro();
        return suma;
    }
    
    //MAIN-CLASS: EJECUTABLE-PRUEBA
    public static void main(String[]args){
         ComplejoVacacional a1=new ComplejoVacacional("Oaxtepec");
         
         a1.altaAlberca(10, 20);
         a1.altaAlberca(20, 20);
         a1.altaAlberca(30, 20);
         a1.altaAlberca(40, 20);
         a1.altaAlberca(50, 20);
         
         a1.altaAlberca(60, 20);
         a1.altaAlberca(70, 20);
         a1.altaAlberca(80, 20);
         a1.altaAlberca(90, 20);
         a1.altaAlberca(100, 20);
         
         System.out.println("Total lona: "+a1.totalLona());
         System.out.println("Total cerca: "+a1.totalCerca());
         
    }
    
}
