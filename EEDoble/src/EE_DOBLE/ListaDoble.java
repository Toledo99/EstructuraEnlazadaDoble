/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE_DOBLE;

import java.util.Iterator;

/**
 *
 * @author huesos
 */
public class ListaDoble <T> implements ListaADT<T> {

    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    
    public ListaDoble(){
        primero=null;
        ultimo=null;
    }
    
    public Iterator<T> iterator() {
        return new IteradorDoble(primero);
    }
    
    
    public boolean estaVacia() {
        return primero==null;
    }

    public void agregaInicio(T dato){
        NodoDoble <T> nuevo = new NodoDoble(dato);
        if(estaVacia())
            ultimo=nuevo;
        else{
            primero.setAnt(nuevo);
            nuevo.setSig(primero);
            
        }
        primero =nuevo;
    }
    
    public void agregaFinal(T dato){
        NodoDoble<T> nuevo = new NodoDoble(dato);
        if(estaVacia())
            primero=nuevo;
        else{
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
        }
        ultimo=nuevo;
    }
    
    @Override
    public T quitaPrimero() {
       T resp=null;
       if(!estaVacia()){
           resp=primero.getDato();
           primero=primero.getSig();
           if(primero==null)
               ultimo=null;
           else{
               primero.getAnt().setSig(null);
               primero.setAnt(null);
           }
       }
       return resp;
    }

    @Override
    public T quitaUltimo() {
        T resp = null;
        if(!estaVacia()){
            resp=ultimo.getDato();
            ultimo=ultimo.getAnt();
            if(ultimo==null)
                primero=null;
            else{
                ultimo.getSig().setAnt(null);
                ultimo.setSig(null);
            }
        }
        return resp;
    }

    @Override
    public T quita(T dato) {
        T resp = null;
        if(!estaVacia()){
            if(dato.equals(primero.getDato()))
                resp=quitaPrimero();
            else
                if(dato.equals(ultimo.getDato()))
                    resp=quitaUltimo();
                else{
                    NodoDoble<T> act = primero.getSig();
                    while(act!= null && !dato.equals(act.getDato()))
                        act=act.getSig();
                    if(act!=null){
                        resp=act.getDato();
                        act.getAnt().setSig(act.getSig());
                        act.getSig().setAnt(act.getAnt());
                        act.setAnt(null);
                        act.setSig(null);
                    }
                }
        }
        return resp;
    }

    @Override
    public boolean contiene(T dato) {
        Iterator<T> it = iterator();
        boolean res=false;
        
        while(it.hasNext() && !res){
            if(it.next().equals(dato))
                res=true;
        }
        return res;
    }

    public boolean agregaAntesQue(T refer, T dato){
        boolean resp=false;
        if(refer!=null && dato!=null && !estaVacia()){
            if(refer.equals(primero.getDato())){
                resp=true;
                agregaInicio(dato);
            }
            else
                if(refer.equals(ultimo.getDato())){ //por eficiencia
                    resp=true;
                    NodoDoble <T> nuevo = new NodoDoble(dato);
                    nuevo.setAnt(ultimo.getAnt());
                    nuevo.setSig(ultimo);
                    ultimo.getAnt().setSig(nuevo);
                    ultimo.setAnt(nuevo);
                }
                else{
                    NodoDoble<T> act = primero.getSig();
                    while(act!=null && !act.getDato().equals(refer))
                        act=act.getSig();
                    if(act!=null){
                        resp=true;
                        NodoDoble <T> nuevo = new NodoDoble(dato);
                        nuevo.setAnt(act.getAnt());
                        nuevo.setSig(act);
                        act.getAnt().setSig(nuevo);
                        act.setAnt(nuevo);
                    }
                }
        }
        return resp;
    }
    
    public boolean estaOrdenadaCreciente(){
        boolean resp;
        if(estaVacia() || primero==ultimo)
            resp=true;
        else
            resp=estaOrdenadaCreciente(primero.getSig());
        
        return resp;
    }
    
    private boolean estaOrdenadaCreciente(NodoDoble<T> act){
        if(act==null)
            return true;
        else
            if( ((Comparable) act.getDato() ).compareTo(act.getAnt().getDato())>=0)
                return estaOrdenadaCreciente(act.getSig());
                else
                    return false;
    }
    
    public int calculaTamaño() {
        int res=0;
        
        if(!estaVacia()){
            res++;
            NodoDoble<T> aux=primero.getSig();
            while(aux!=null){
                res++;
                aux=aux.getSig();
            }
        }
        return res;
    }

    public T obtienePrimero() {
        
        if(primero==null)
            throw new EmptyCollectionException();
        return primero.getDato();
    }
    
    public T obtieneUltimo() {
        if(ultimo==null)
            throw new EmptyCollectionException();
        return ultimo.getDato();
    }
    
}
