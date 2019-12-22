/* Estructuras de Datos
* Silvia Guardati
*/
package Sudoku;
import Conjunto.ConjuntoADT;
import Conjunto.ConjuntoArreglo;
import Iterador.IteradorArreglo;
import java.util.Iterator;


/**
 * @author Alvaro Romo
 */
public class Sudoku {
    
    private int[][] tablero = new int[9][9];
    private ConjuntoADT<Integer> numeros;
            
    public Sudoku(){
        numeros = new ConjuntoArreglo();
        numeros.agrega(1);
        numeros.agrega(2);
        numeros.agrega(3);
        numeros.agrega(4);
        numeros.agrega(5);
        numeros.agrega(6);
        numeros.agrega(7);
        numeros.agrega(8);
        numeros.agrega(9);
        tablero =new int[][] {
                   {1,0,0,0,0,0,0,0,0},
                   {0,0,3,0,0,0,0,0,9},
                   {0,0,0,0,0,0,8,0,0},
                   {0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,7,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0},
                                           };
       
       /*tablero =new int[][] { 
                   {0,4,6,8,5,7,0,1,0},
                   {1,8,9,6,4,3,0,7,5},
                   {5,7,3,2,0,1,4,0,6},
                   {4,1,8,3,2,0,5,6,0},
                   {6,3,7,4,0,5,0,2,9},
                   {9,5,2,0,7,6,0,0,0},
                   {7,6,4,5,3,2,8,9,1},
                   {3,2,1,9,0,8,7,0,0},
                   {8,9,5,7,1,4,0,3,0},
                                       };*/
       
      /* tablero =new int[][] { 
                   {0,0,2,6,0,4,0,9,3},
                   {0,6,0,0,2,0,4,0,0},
                   {5,0,4,0,0,7,0,0,0},
                   {2,0,3,0,0,0,0,0,0},
                   {0,0,8,0,0,0,6,0,0},
                   {0,0,0,0,0,0,1,0,8},
                   {0,0,0,3,0,0,7,0,5},
                   {0,0,7,0,4,0,0,2,0},
                   {8,2,0,9,0,6,3,0,0},
                                       };*/
       
        
        
        
    }
    
    
    
    public boolean estaLleno(){ //nos dice si el tablero esta lleno, es decir si ya se resolvio
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++){
                if(tablero[i][j] == 0)
                    return false;
            }
        return true;
    }
    
    public ConjuntoADT<Integer> numerosPosibles(int i, int j){ // i y j es la posicion
        ConjuntoADT<Integer> verticales = new ConjuntoArreglo();
        ConjuntoADT<Integer> horizontales = new ConjuntoArreglo();
        ConjuntoADT<Integer> cuadrante = new ConjuntoArreglo();
        
        
        for(int k = 0; k < 9; k++){
            verticales.agrega(tablero[k][j]);
            horizontales.agrega(tablero[i][k]);
        }
        
        
        if(i <=2){
            for(int k = 0; k < 3; k++){ // primera seccion, primeros 3 cuadrantes de arriba
                if(j <=2){
                    for(int l = 0; l < 3; l++)
                        cuadrante.agrega(tablero[k][l]);
                }
                else{
                    if(j <= 5){
                        for(int l = 3; l < 6; l++)
                        cuadrante.agrega(tablero[k][l]);
                    }
                    else
                        for(int l = 6; l < 9; l++)
                            cuadrante.agrega(tablero[k][l]);
                }   
        }
    }
        else{
            if(i <= 5){ // segundos 3 cuadrantes de arriba a abajo
                for(int k = 3; k < 6; k++){
                if(j <=2){
                    for(int l = 0; l < 3; l++)
                        cuadrante.agrega(tablero[k][l]);
                }
                else{
                    if(j <= 5){
                        for(int l = 3; l < 6; l++)
                            cuadrante.agrega(tablero[k][l]);
                    }
                    else
                        for(int l = 6; l < 9; l++)
                            cuadrante.agrega(tablero[k][l]);
                }
            }
        }
           else {
               
                // terceros 3 cuadrantes de arriba a abajo
            for(int k = 6; k < 9; k++){
                if(j <=2){
                    for(int l = 0; l < 3; l++)
                        cuadrante.agrega(tablero[k][l]);
                }
                else{
                    if(j <= 5){
                        for(int l = 3; l < 6; l++)
                            cuadrante.agrega(tablero[k][l]);
                    }
                    else
                        for(int l = 6; l < 9; l++)
                            cuadrante.agrega(tablero[k][l]);
                }
            }
                
        }
        
    }
        
        
        ConjuntoADT<Integer> dif = verticales.union(horizontales).union(cuadrante);
        ConjuntoADT<Integer> res = numeros.diferencia(dif);
        return res;   
    }
    
    //public void resuelve(){
        //resuelve(tablero);
    //}
    public void resuelve(){
        boolean lleno;
        lleno = estaLleno();
        System.out.println("lleno: "+lleno);
        System.out.println(this.toString());
        //System.out.println(lleno);
        if(lleno){
            System.out.println("Se resolvió con éxito!");
            System.out.println(this.toString());
            
        }
        
        else {
            //System.out.println("entro");
            // encontrar primera posicion vacia
            int[] pos = posicionVacia();
            
            
            
            // Este conunto tiene los numeros posibles para dicha posicion
            ConjuntoADT<Integer> posibles = numerosPosibles(pos[0],pos[1]); 
            
            Iterator<Integer> it = posibles.iterator();
            
            Integer sig;
            //System.out.println(posibles.toString());
            while(it.hasNext() && !lleno){
                sig = it.next(); // probar con este numero
                tablero[pos[0]][pos[1]] = sig;
                resuelve();
                                    
            }
            if(!lleno)
                tablero[pos[0]][pos[1]] = 0;

  
        }
            
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        for(int i = 0; i < 9 ; i++){
            for(int j = 0; j < 9; j++){
                cad.append(tablero[i][j]+" ");
            }
            cad.append("\n");
        }
        return cad.toString();
        
    }
    public int[] posicionVacia(){
        return posicionVacia(tablero);
    }
    
    private int[] posicionVacia(int[][] tablero){
        int[] pos = new int[2];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(tablero[i][j] == 0){
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        if(pos == null)
            throw new NullPointerException();
        return pos;
    }
    public void imprimePos(){
        int[] pos = posicionVacia();
        System.out.println("i: "+pos[0]+ " j: "+pos[1]);
    }
        
}
    


