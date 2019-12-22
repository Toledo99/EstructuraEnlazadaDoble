/* Estructuras de Datos
* Silvia Guardati
*/
package Sudoku;
import Conjunto.ConjuntoADT;
import Conjunto.ConjuntoArreglo;
import Iterador.IteradorArreglo;

/**
 *
 * @author Alvaro Romo
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      Sudoku pru = new Sudoku();
      //pru.imprimePos();
      //ConjuntoADT<Integer> res = pru.numerosPosibles(8, 8);
      //System.out.println(res.toString());
      pru.resuelve();
      //System.out.println(pru.toString());
       // System.out.println(pru.toString());
        
        
    }

}
