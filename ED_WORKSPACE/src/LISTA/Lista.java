/* Estructuras de Datos
* Silvia Guardati
*/

package LISTA;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author Alvaro Romo
 */
public abstract class Lista<T> implements ListaADT<T> {
    
    protected Nodo<T> primero;
    protected Nodo<T> ultimo;
    
    public Lista(){
        primero = null;
        ultimo = null;
    }
    
    public Iterator<T> iterator(){
        return new IteradorEE(primero);
    }
    
    public boolean estaVacia(){
        return primero == null;
    }
    
    public T quitaPrimero(){
        if(estaVacia())
            throw new NullPointerException();
        Nodo<T> ap = primero.getSig();
        primero = primero.getSig();
        if(primero == null){ // lista con un solo elemento
            ultimo = null;
        }
        else
            ap.setSig(null);
        
        return ap.getDato();
    }
    
    public String toString(){
        return toString(new StringBuilder(), this.primero);
    }
    
    private String toString(StringBuilder cad, Nodo<T> ap){
        if(ap == null)
            return cad.toString();
        else {
            cad.append(ap.getDato().toString()+"  ");
            return toString(cad, ap.getSig());
        }        
    }
    
    public T quitaUltimo(){
        if(estaVacia())
            throw new EmptyCollectionException();
        Nodo<T> act, ant;
        ant = null;
        act = primero;
        while(act.getSig()!= null){
            ant = act;
            act = act.getSig();
        }
        if(ant != null){
            ant.setSig(null);
        }
        else {
            primero = null;
        }
        return act.getDato();     
    }
    
    public boolean contiene(T dato){
        boolean resp;
        Nodo<T> ap;
        ap = primero;
        while(ap != null && !ap.getDato().equals(dato)){
            ap = ap.getSig();
        }
        resp = ap != null;
        return resp;
    }
    public T obtieneUltimo(){
        T res=null;
        if(!estaVacia())
            res=ultimo.getDato();
        return res;
    }
    public T obtienePrimero(){
        T res=null;
        if(!estaVacia())
            res=primero.getDato();
        return res;
    }
    public int calculaTamaño(){
        if(!estaVacia()){
            int cont=0;
            Nodo<T> ant=primero;
            
            while(ant!=null){
                cont++;
                ant=ant.getSig();
            }
            return cont;
        }
        else
            return 0;
    }
    public T quita(T dato){
        if(!estaVacia()){
            if(primero.getDato().equals(dato))
                return quitaPrimero();
            else{
                Nodo<T> act,ant;
                ant=primero;
                act=primero.getSig();
                while(act!=null && !act.getDato().equals(dato)){
                    ant=act;
                    act=act.getSig();
                }
                if(act==null)
                    throw new NoSuchElementException();
                else{
                    T res=act.getDato();
                    ant.setSig(act.getSig());
                    act.setSig(null);
                    return res;
                }     
            }   
        }
        throw new EmptyCollectionException();
        
    }

}
