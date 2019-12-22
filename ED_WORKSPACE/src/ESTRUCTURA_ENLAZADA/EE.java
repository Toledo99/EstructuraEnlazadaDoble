
package ESTRUCTURA_ENLAZADA;

//Estructura Enlazada

import PILA.EmptyCollectionException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EE <T>{ 
    
    private Nodo<T> primero;
    
    public EE(){
        primero=null;
    }
    
    public boolean estaVacia(){
        return primero==null;
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
        else{
            Nodo<T> aux = primero;
            while(aux.getSig() != null)
                aux=aux.getSig();
            aux.setSig(nuevo);
        }
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return toString(sb, this.primero);
    }
    
    
    private String toString(StringBuilder sb, Nodo<T> ap){
        if(ap == null)
            return sb.toString();
        else{
            sb.append(ap.getDato()).append(" ");
            return toString(sb, ap.getSig());
        }
    }
    
    
    public boolean buscaDato(T dato){ //Más bien existeDato
        Nodo <T> ap = primero;
        while( ap!=null && !ap.getDato().equals(dato))
            ap= ap.getSig();
        return ap!=null;
    }
    
    public T quitaPrimero(){
        if(estaVacia())
            throw new NullPointerException("Colecció vacía");
        T res = primero.getDato();
        Nodo <T> ap = primero;
        primero = primero.getSig();
        ap.setSig(null);
        return res;
    }
    
    public T quitaUltimo(){
        if(estaVacia())
            throw new NullPointerException("Colección vacía");
        Nodo<T> act, ant;
        ant=null;
        act=primero;
        while(act.getSig() != null){
            ant = act;
            act = act.getSig();
        }
        if(ant != null)
            ant.setSig(null);
        else
            primero=null;
        return act.getDato();
    }
    
    public Iterator<T> iterator(){
        return new IteradorEE(primero);
    }
    
    public T quitaDato(T dato){
        if(!estaVacia() ){
            if(primero.getDato().equals(dato))
                return quitaPrimero();
            else{
                Nodo<T> act, ant;
                ant=primero;
                act=primero.getSig();
                while(act!=null && !act.getDato().equals(dato)){
                    ant=act;
                    act=act.getSig();
                }
                if(act== null)
                    throw new RuntimeException("nop");
                else{
                    T res= act.getDato();
                    ant.setSig(act.getSig());
                    act.setSig(null);
                    return res;
                }
            }
           
        }
        else
            throw new RuntimeException("nop");
    }
      
    public T getPrimerDato(){
        if(estaVacia())
            throw new NullPointerException();
        return primero.getDato();
    }
    //PROBLEMA_41
    public boolean eliminaSiguienteDe(T info){
        if(info == null)
            throw new RuntimeException();
        
        boolean res =false;
        
        if(!estaVacia()){
            Nodo <T> act, sig;
            act=primero;
            
            while(act!=null && !act.getDato().equals(info))
                act=act.getSig();
            
            if(act != null && act.getSig() != null){
                sig=act.getSig();
                act.setSig(sig.getSig());
                sig.setSig(null);
                res=true;
            }     
        }  
        return res;
    }
    
    //PROBLEMA_40
    public boolean eliminaAnteriorA(T info){
        if(info == null)
            throw new RuntimeException();
        
        boolean res = false;
        
        
        if(!estaVacia() && !primero.equals(info)){
            Nodo <T> first, anterior, act;
            first=primero;
            //preAnterior=primero;
            //anterior=primero.getSig();
            //act=anterior.getSig();
            if(first.getSig() != null){ //Si hay más de un nodo
                if(first.getSig().getDato().equals(info)) //if(anterior.getDato().equals(info))
                 {
                    System.out.println("a");
                    quitaPrimero();
                    res=true;
                }   
                else{
                    System.out.println("b");
                    while(first.getSig().getSig()!= null && !first.getSig().getSig().getDato().equals(info))//while(act!=null && !act.getDato().equals(info))
                    {
                        first = first.getSig();
                        //anterior = act;
                        //act = act.getSig();
                    }
                    if(first.getSig().getSig()!= null){
                        Nodo<T> auxRompe = first.getSig();
                        first.setSig(first.getSig().getSig());
                        //anterior.setSig(null);
                        //anterior.setDato(null);
                        auxRompe.setSig(null);
                        res=true;
                    }   
                }
            }
        }
        return res;
    }
    
    //PROBLEMA_42
    public boolean insertaAntesQue(T ref, T neo){
        if(ref == null && neo == null)
            throw new NullPointerException();
        
        boolean res = false;
        
        if(!estaVacia() && primero.getDato() != null){ 
            
            if(primero.getDato().equals(ref)){
                Nodo<T> neoNodo = new Nodo<T>();
                neoNodo.setDato(neo);
                neoNodo.setDato(neo);
                neoNodo.setSig(primero);
                primero=neoNodo;
                res=true;
            }
            else{
                Nodo<T> aux =primero;
                Nodo<T> aux2 = primero.getSig();
           
                while( aux2!= null && aux2.getDato()!= null && !aux2.getDato().equals(ref) ){
                    aux=aux2;
                    aux2=aux.getSig();
                }
                if(aux!=null && aux.getDato() != null){
                    Nodo<T> neoNodo = new Nodo<T>();
                    neoNodo.setDato(neo);
                    neoNodo.setSig(aux2);
                    aux.setSig(neoNodo);
                    res=true;
                }
            }
                
        }
        
        return res;   
    }
    
    //PROBLEMA_43
    public int eliminaTodosRepetidosOrdenado(){
        if(!estaVacia() && primero.getSig()!=null){
            int cont=0;
            Nodo<T> ant= primero;
            Nodo<T> act=primero.getSig();
            while(act!=null){
                if(ant.getDato().equals(act.getDato())){
                    ant.setSig(act.getSig());
                    act.setSig(null);
                    act=ant.getSig();
                    cont++;
                }
                else{
                    ant=act;
                    act=act.getSig();
                }
            }
            return cont;
        }
        else
            throw new EmptyCollectionException();
    }
    
    //PROBLEMA_44 (Toño)
    public int eliminaTodosRepetidosDesordenado(){
        return 0;
    }
    
    //PROBLEMA_45
    public void merge(EE<T> objEE){
        if(objEE == null)
            throw new NullPointerException();
        if(this.primero!=null && objEE.primero!=null){
            Nodo<T> act=primero;
            Nodo<T> sig=primero.getSig();
            Nodo<T> act2=objEE.primero;
            Nodo<T> sig2=objEE.primero.getSig();
            
            while(act!=null && act2!=null && sig!=null && sig2!=null){
                
                act.setSig(act2);
                act2.setSig(sig);
                
                act=sig;
                sig=sig.getSig();
                act2=sig2;
                sig2=sig2.getSig();
            }
            if( sig == null ){
                act.setSig(act2);
                System.out.println("aaa");
            }
            else
                if( sig2 == null){
                    act2.setSig(sig);
                    act.setSig(act2);
                    System.out.println("bb");
                }
        }
    }
    
   
            
    //MAIN QUE PRUEBA LA CLASE:
    public static void main (String [] args){
        /*
        EE<String> nom = new EE();
        if(nom.estaVacia())
            System.out.println("Vacía");
        else
            System.out.println("Sí hay elementos");
        
        nom.agregaInicio("Juan");
        nom.agregaInicio("María");
        nom.agregaFinal("Pedro");
        System.out.println("  "+nom.toString());
        System.out.println(nom.insertaAntesQue("Juan", "Beto"));
        System.out.println("  "+nom.toString());
        
        //System.out.println(nom.eliminaAnteriorA("Pedro"));
        //System.out.println("  "+nom.toString());
        /*
        nom.agregaFinal("Lucas");
        System.out.println("  "+nom.toString());
        
        if(!nom.estaVacia())
            System.out.println("  "+nom.quitaPrimero());
        if(!nom.estaVacia())
            System.out.println("  "+nom.quitaUltimo());
        
        System.out.println("  "+nom);
        
        if(nom.buscaDato("Luis"))
            System.out.println("Sí");
        else
            System.out.println("No");
        
        if(nom.buscaDato("Pedro"))
            System.out.println("Sí");
        else
            System.out.println("No");

        
        EE<String> nom2= new EE();
        nom2.agregaFinal("AAA");
        nom2.agregaFinal("BBB");
        /*nom2.agregaFinal("CCC");
        nom2.agregaFinal("DDD");
        nom2.agregaFinal("EEE");
        
        nom.merge(nom2);
        
        System.out.println("\n"+nom.toString());
        */
                
        EE<Alumno> alumno = new EE();
        
        alumno.agregaFinal(new Alumno("Diego", 9.0));
        alumno.agregaFinal(new Alumno("Toño", 9.0));
        alumno.agregaFinal(new Alumno("Pepe", 9.5));
        alumno.agregaFinal(new Alumno("Juana", 7.0));
        alumno.agregaFinal(new Alumno("Andrea", 8.0));
        alumno.agregaFinal(new Alumno("Fernanda", 10.0));
        
        double suma=0;
        int cont=0;
        Iterator it =  alumno.iterator();
        Alumno a;
        while(it.hasNext()){
            System.out.println("eee");
            a=(Alumno)it.next();
            suma+= a.getProm();
            cont++;
        }
        
        double prom = suma/cont;
        
        System.out.println("Prom: "+prom);
        
        
    }
}
