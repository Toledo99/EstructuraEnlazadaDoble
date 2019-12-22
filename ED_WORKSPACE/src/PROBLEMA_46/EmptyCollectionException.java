
package PROBLEMA_46;

import PILA.*;


public class EmptyCollectionException extends RuntimeException{
    
    public EmptyCollectionException(){
        super("Colleción vacía.");
    }
    
    public EmptyCollectionException(String mensaje){
        super(mensaje);
    }
    
}
