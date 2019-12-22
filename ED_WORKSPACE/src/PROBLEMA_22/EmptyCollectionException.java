
package PROBLEMA_22;



public class EmptyCollectionException extends RuntimeException{
    
    public EmptyCollectionException(){
        super("Colleción vacía.");
    }
    
    public EmptyCollectionException(String mensaje){
        super(mensaje);
    }
    
}
