
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atoledog
 */
public class InvierteCad<T> {
    private String cadInicial;
    private String cadInvertida;

    public InvierteCad(String cadInicial) {
        this.cadInicial = cadInicial;
    }
    
    public String invierte(){
        StringBuilder cad=new StringBuilder();
        PilaA<Character> pila= new PilaA();
        
        for(int i=0; i<cadInicial.length(); i++){
            pila.push(cadInicial.charAt(i));
        }
        for(int j=0; j<cadInicial.length(); j++){
            cad.append(pila.pop());
        }
        return cad.toString();
    }
    
    public static int cuantos(PilaA p){
        int i=0;
        Object[] a=new Object[100];
        
        while(!p.isEmpty()){
            a[i]=p.pop();
            i++;
        }
        if(i!=0)
            for(int j=i-1; j>=0;j--)
                p.push(a[j]);
        return i;
    }
    
    public static <T> int revisaCuantosElementos(PilaADT<T> pila){
        int res=0;
        PilaA<T> aux=new PilaA();
        
        if(!pila.isEmpty()){
            while(!pila.isEmpty()){
                aux.push(pila.pop());
                res++;
            }
            while(!aux.isEmpty()){
                pila.push(aux.pop());
            }
        }
        return res;  
    }
    
    public static <T> PilaADT invierteGenerica(PilaADT<T> pila){
        ArrayList<T> list=new ArrayList<T>();
        
        if(pila!=null && !pila.isEmpty()){
            while(!pila.isEmpty()){
                list.add(pila.pop());
            }
            for(int i=0;i<list.size(); i++)
                pila.push(list.get(i));
        }
        return pila;
    }
    
    public static <T> void invierteGenerica2(PilaADT<T> pila){
        PilaA<T> aux=new PilaA<T>();
        
        while(!pila.isEmpty()){
            aux.push(pila.pop());
        }
        pila=aux;
    }
    
    public static <T> PilaADT retirarRepetidos(PilaADT<T> pila){
        ArrayList<T> list=new ArrayList<T>();
        
        if(pila!=null && !pila.isEmpty()){
            while(!pila.isEmpty()){
                list.add(pila.pop());
            }
            for(int i=0;i<list.size(); i--){
                if(pila.peek()!=list.get(i))
                    pila.push(list.get(i));
            }
        }
        return pila;
    }
    
    
    public static void main (String[] args){
        InvierteCad i=new InvierteCad("Toño Toledo");
        PilaA p=new PilaA();
        p.push("Hola");
        p.push("Que");
        p.push("Tal");
        
        System.out.println(i.invierte());
        System.out.println(InvierteCad.cuantos(p));
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
    }
}
