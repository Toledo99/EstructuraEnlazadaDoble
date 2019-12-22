/* Estructuras de Datos
* Silvia Guardati
*/

package EE_DOBLE;


/**
 * @author Alvaro Romo
 */
public class EmptyCollectionException extends RuntimeException {

    public EmptyCollectionException(){
        super("Colleción vacía.");
    }
    
    public EmptyCollectionException(String mensaje){
        super(mensaje);
    }

}
