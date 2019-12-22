

package LISTA;

import java.util.Iterator;

public class ListaOrdenada <T extends Comparable<T>> extends Lista<T> implements ListaOrdADT<T> {
    
    public boolean agrega(T dato){//agrega ordenadamente sin repetidos
        boolean res=false;
        
        if(dato!=null){
            if(estaVacia()){
                primero=new Nodo(dato);
                ultimo=primero;
                res=true;
            }
            else{
                if(dato.compareTo(primero.getDato())<0){//dato mas chico que el primero
                    Nodo<T> nuevo=new Nodo(dato);
                    nuevo.setSig(primero);
                    primero=nuevo;
                    res=true;
                    
                }
                else{
                    if(dato.compareTo(ultimo.getDato())>0){//dato mas grande que el ultimo
                        Nodo<T> nuevo=new Nodo(dato);
                        ultimo.setSig(nuevo);
                        ultimo=nuevo;
                        res=true;
                    }
                    else{
                        Nodo<T> ant=primero;
                        Nodo<T> act=primero.getSig();
                        while(act!= null && act.getDato().compareTo(dato)<0){
                            ant=act;
                            act=act.getSig();
                        }
                        if(act!=null && !act.getDato().equals(dato)){
                            Nodo<T> nuevo=new Nodo(dato);
                            ant.setSig(nuevo);
                            nuevo.setSig(act);
                            res=true;
                        }
                    }
                }
                
            }
            
        }
        return res;         
    }
    public boolean contiene(T dato){
        boolean resp=false;
        
        if(estaVacia()){
            Nodo<T> pos=busca(dato);
            if(pos.getDato().equals(dato))
                resp=true;
            else{
                if(pos.getSig()!=null && pos.getSig().getDato().equals(dato))
                    resp=true;
            }
        }
        return resp;
    }
    private Nodo<T> busca(T dato){
        Nodo<T> ant=primero;
        Nodo<T> act=primero.getSig();
        while(act!= null && act.getDato().compareTo(dato)<0){
            ant=act;
            act=act.getSig();
        }
        return ant;
    }
    public T quita(T dato){
        T resp=null;
        if(!estaVacia()){
            if(primero.getDato().equals(dato)){
                resp=primero.getDato();
                Nodo<T> temp=primero;
                primero=primero.getSig();
                if(primero==null)
                    ultimo=null;
                temp.setSig(null);
            }
            else{
                Nodo<T> pos=busca(dato);
                if(pos.getSig()!=null){
                    if(pos.getSig().getDato().equals(dato)){
                        resp=pos.getSig().getDato();
                        if(pos.getSig()==ultimo){
                            pos.setSig(null);
                            ultimo=pos;
                        }
                        else{
                            Nodo<T> temp=pos.getSig();
                            pos.setSig(temp.getSig());
                            temp.setSig(null);
                            
                        }
                    }
                }
            }
            
        }
        return resp;
    }
    
    public boolean equals (Object otra){
        if(otra==null)
            throw new NullPointerException();
        
        boolean resp=false;
        
        if(otra instanceof ListaOrdenada){
              
            ListaOrdenada<T> otraLista = (ListaOrdenada)otra;
            Iterator it = otraLista.iterator();

            if(primero==ultimo && !it.hasNext())
                resp=true;
            
            else{
                
                Nodo<T> before= null;
                Nodo<T> actual=primero;
                
                boolean band=true;
                
                while(actual != null && it.hasNext() && band){
                    Object a= it.next();
                    if(actual.getDato().equals(a)){
                        before=actual;
                        actual=before.getSig();
                    }
                    else
                        band=false;
                }
                
                if(band==true)
                    resp=true;
            }
            
        }
        
        return resp;
    }

    public static void main(String [] args){
        
        System.out.println("Iguales:");
        ListaOrdenada<String> l1 = new ListaOrdenada();
        l1.agrega("Beto");
        l1.agrega("Juan");
        ListaOrdenada<String> l2 = new ListaOrdenada();
        l2.agrega("Beto");
        l2.agrega("Juan");
        System.out.println("\tCon datos:"+ l1.equals(l2));
        
        ListaOrdenada<String> l9 = new ListaOrdenada();
        ListaOrdenada<String> l10 = new ListaOrdenada();
        System.out.println("\tVacia:"+ l9.equals(l10));
        
        //______________________________________________
        
        System.out.println("Diferentes:");
        
        ListaOrdenada<String> l3 = new ListaOrdenada();
        l3.agrega("Beto");
        l3.agrega("Juan");
        ListaOrdenada<String> l4 = new ListaOrdenada();
        l4.agrega("Jorge");
        l4.agrega("Juan");
        System.out.println("\tCon dato diferente:"+ l3.equals(l4));
        
        
        ListaOrdenada<String> l5 = new ListaOrdenada();
        l5.agrega("Beto");
        l5.agrega("Juan");
        ListaOrdenada<String> l6 = new ListaOrdenada();
        l6.agrega("Jorge");
        System.out.println("\tCon distinto tamaño:"+ l5.equals(l6));
        
        ListaOrdenada<String> l7 = new ListaOrdenada();
        l7.agrega("Beto");
        ListaOrdenada<String> l8 = new ListaOrdenada();
        l8.agrega("Jorge");
        l8.agrega("Juan");
        System.out.println("\tCon distinto tamaño:"+ l7.equals(l8));
        
        
        ListaOrdenada<String> l11 = new ListaOrdenada();
        String l12 = "hola";
        System.out.println("\tObjeto distinto:"
                + ""+ l11.equals(l12));
    }
}
