/* Estructuras de Datos
* Silvia Guardati
*/

package LISTA;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alvaro Romo
 */
public class EE<T> implements Iterable<T> {
    
    private Nodo<T> primero;
    
    public EE(){
        primero = null;
    }
    
    public boolean estaVacia(){
        return primero == null;
    }
    
    public void agregaInicio(T dato){
        Nodo<T> nuevo = new Nodo(dato);
        nuevo.setSig(primero);
        primero = nuevo;
    }
    
    public void agregaFinal(T dato){
        Nodo<T> nuevo = new Nodo(dato);
        if(estaVacia())
            primero = nuevo;
        else {
            Nodo<T> aux;
            aux = primero;
            while(aux.getSig() != null)
                aux = aux.getSig();
            aux.setSig(nuevo);
        }
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
    
    public boolean buscaDato(T dato){
        boolean resp;
        Nodo<T> ap;
        ap = primero;
        while(ap != null && !ap.getDato().equals(dato)){
            ap = ap.getSig();
        }
        resp = ap != null;
        return resp;
    }
    
    public T quitaPrimero(){
        if(estaVacia()){
            throw new EmptyCollectionException();
        }
        T res = primero.getDato(); 
        Nodo<T> ap = primero;
        primero = primero.getSig();
        ap.setSig(null);
        return res;
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
    
    public Iterator<T> iterator(){
        return new IteradorEE(primero);
    }
    
    public T quitaDato(T dato){
        if(!estaVacia()){
            if(primero.getDato().equals(dato))
                return quitaPrimero();
            else {
                Nodo<T> act, ant;
                ant = primero;
                act = primero.getSig();
                while(act != null && !act.getDato().equals(dato)){
                    ant = act;
                    act = act.getSig();
                }
                if(act == null){
                    throw new NoSuchElementException();
                }
                else{
                    T resul = act.getDato();
                    ant.setSig(act.getSig());
                    act.setSig(null);
                    return resul;
                }
            }
        }
        else 
            throw new NoSuchElementException();
    }
    
    public boolean eliminaAnteriorA(T dato){
        if(!estaVacia()){
            if(primero.getDato().equals(dato) || primero.getSig() == null)
                return false; // porque no hay anterior a primero
            else {
                Nodo<T> ant, act, act2;
                ant = primero;
                act = primero.getSig();
                //act2 = act.getSig();
                if(act.getDato().equals(dato)){ // segundo dato
                    primero = act;
                    ant.setSig(null);
                    //System.out.println("hola");
                    return true;
                }
                if(act.getSig() == null)
                    return false;
                else{
                    act2 = act.getSig();
                    while(!act2.getDato().equals(dato)){
                    ant = act;
                    act = act2;
                    act2 = act2.getSig();
                }
                if(act2 == null){ // no esta el elemento
                    return false;
                }
                else {
                    //T resul = act.getDato();
                    ant.setSig(act2);
                    act.setSig(null);
                    return true;
                }
                       
               }
                  
            }
        }
        else {
            return false;
        }
    }
    
    public boolean eliminaSiguienteDe(T dato){
        if(!estaVacia()){
            Nodo<T> ant, act;
            ant = primero;
            act = primero.getSig();
            
            while(ant != null && !ant.getDato().equals(dato) && act != null){
                ant = act;
                act = act.getSig();
            }
            if(ant == null || act == null) // que no lo encuentre o sea el ultimo
                return false;
            else {
                ant.setSig(act.getSig());
                act.setSig(null);
               return true;
            }
        }
        else
            return false;
    }
    //Ejercicio 42
    public boolean insertaAntesQue(T refer, T nuevo){
        if(estaVacia() || refer == null)
            throw new NoSuchElementException();
        else {
            if(primero.getDato().equals(refer)){
                agregaInicio(nuevo);
                return true;
            }
            else {
                    Nodo<T> nue = new Nodo(nuevo);
                    Nodo<T> ant = primero;
                    Nodo<T> act = primero.getSig();
                    while(act != null && !act.getDato().equals(refer)){
                        ant = act;
                        act = act.getSig();
                    }
                    if(act == null)
                        return false;
                    else {
                        ant.setSig(nue);
                        nue.setSig(act);
                        return true;
                    
                }
            }      
        }
    }
    //Ejercicio 43
    public int eliminaTodosRepetidosOrdenado(){
        if(!estaVacia() && primero.getSig()!= null){
            int cont = 0;
            Nodo<T> ant = primero;
            Nodo<T> act = primero.getSig();
            while(act != null){
                if(ant.getDato().equals(act.getDato())){
                    ant.setSig(act.getSig());
                    act.setSig(null);
                    act = ant.getSig();
                    cont++;
                }
                else{
                    ant = act;
                    act = act.getSig();
                }
            }
            return cont;
            
        }
        else
            throw new NoSuchElementException();
        
    }
    
    //Ejercicio 44
    public int eliminaTodosRepetidosDesordenados(){
        if(!estaVacia() && primero.getSig() != null){
            int cont = 0;
            Nodo<T> ant = primero;
            Nodo<T> act ;
            while(ant != null){
                act = ant.getSig();
                T dato = ant.getDato();
                Nodo<T> aux = eliminaTodosRepetidosDesordenados(dato, ant);
                while(aux != null){
                    act = aux.getSig();
                    
                    aux.setSig(aux.getSig().getSig());
                    act.setSig(null);
                    cont++;
                    aux = eliminaTodosRepetidosDesordenados(dato, ant);
                }
                ant = ant.getSig();
                
            }
            return cont;
        }
        else
            throw new NoSuchElementException();
    }
    
    private Nodo<T> eliminaTodosRepetidosDesordenados(T dato, Nodo<T> ant){
        Nodo<T> act = ant.getSig();
        Nodo<T> res = null;
        while(act != null && res == null){
            if(act.getDato().equals(dato)){
                res = ant;
            }
            ant = act;
            act = act.getSig();
        }
        return res;
    }
    
    //Ejercicio 45
    public void intercalaNodos(EE otra){
        if(!estaVacia() && !otra.estaVacia()){
            int n1 = this.numeroDeNodos();
            int n2 = otra.numeroDeNodos();
            Nodo<T> ant = primero;
            Nodo<T> ant2 = otra.primero;
            Nodo<T> aux, aux2;
            aux = null;
            aux2 =null;        
            while(ant!= null && ant2 != null){
                aux = ant.getSig();
                aux2 = ant2;
                ant2 = ant2.getSig();
                ant.setSig(aux2);
                aux2.setSig(aux);
                
                ant = aux;
            }
            if(aux == null)
                aux2.setSig(ant2);
            
            
            
        }
    }
    
    public int numeroDeNodos(){
        if(!estaVacia()){
            int cont = 0;
            Nodo<T> ant = primero;
           
            while(ant != null){
                cont++;
                ant = ant.getSig();
            }
            return cont;
            
        }
        else
            return 0;
    }
    
    public T consultaPrimero(){
        T res = null;
        if(!estaVacia())
            res = primero.getDato();
        return res;
    }
    
    
    

}
