
package PROBLEMA_22;

import PILA.*;


public interface PilaADT <T> {
    
    public void push(T dato, int tipo);
    public T pop(int tipo);
    public T peek(int tipo);
    public boolean isEmpty();
    public int getTope(int tipo);
    
}
