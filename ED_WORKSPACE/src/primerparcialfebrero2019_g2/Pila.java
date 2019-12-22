/**
 * Diego Hernández Delgado
 * (176262)
 * Fecha de examen: 26/27/2019
 */

package primerparcialfebrero2019_g2;

/**
 * Clase Pila que implementa la interfaz PilaADT. Es genérica.
 * El pop y el peek, en caso de que la pila esté vacía, lanzan una excepción
 * del tipo EmptyCollectionException definida para tal fin.
 * @author SGUARDATB
 * Modifiacdo ´por: Diego HD
 */
public class Pila <T> implements PilaADT <T>{
    private T colec[];
    private int tope;
    private final int MAX = 10;

    /**
     * MÉTODO "toString()" DEL PROBLEMA 2
     * @authot Diego HD
     * @return String de los elementos de la pila.
     */
    public String toString(){
        String resp="";
        for(int i =tope; i>=0; i--)
            resp+=""+colec[i]+"\n";
        return resp;
       
    }
    public Pila() {
        colec = (T[]) (new Object[MAX]);
        tope = -1;
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyCollectionException("Pila Vacía");
        else
            return colec[tope];
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyCollectionException("Pila Vacía");
        else{
            T dato = colec[tope];
            tope--;
            return dato;
        }
    }

    public void push(T dato) {
        if (colec.length == tope + 1)
            expandCapacity();
        tope++;
        colec[tope] = dato;
    }

    private void expandCapacity(){
        T nuevo[] = (T[]) (new Object[colec.length * 2]);
        int i;

        for (i = 0; i <= tope; i++)
            nuevo[i] = colec[i];
        colec = nuevo;
    }
    
    public static void main (String [] args){
        
        /**
         * PRUEBA DEL MÉTODO "toString()" DEL PROBLEMA 2:
         */
        PilaADT ej = new Pila();
        ej.push(4);
        ej.push(2);
        ej.push(9);
        ej.push(5);
        System.out.println(ej.toString());
    }
}
