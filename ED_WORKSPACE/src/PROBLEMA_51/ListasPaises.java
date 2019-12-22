

package PROBLEMA_51;

import LISTA.*;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
        
public class ListasPaises <T>{
    
    ListaOrdenada<String> listaNorte;
    ListaOrdenada<String> listaCentro;
    ListaOrdenada<String> listaSur;
    ListaOrdenada<String> listaGeneral;
    
    public ListasPaises(){
        listaNorte = new ListaOrdenada();
        listaCentro = new ListaOrdenada();
        listaSur = new ListaOrdenada();
        listaGeneral = new ListaOrdenada();
    }
    
    public boolean agregaLista(String name, String ubi){
        if(name==null || ubi==null)
            throw new NullPointerException();
        boolean res = false;
        
        if(ubi.equals("Norte")){
            listaNorte.agrega( name );
            res=true;
        }
        else
            if(ubi.equals("Centro")){
                listaCentro.agrega(name);
                res=true;
            }
            else
                if(ubi.equals("Sur")){
                    listaSur.agrega(name);
                    res=true;
                }
        
        return res;
    }
    
    public void leePaises(String nameFile){
        File file = new File(nameFile);
        Scanner lee;
        
        try{
            lee= new Scanner(file);
            String name;
            String ubi;
            
            while(lee.hasNext()){
                name=lee.next();
                ubi=lee.next();
                this.agregaLista(name, ubi);
            }
            lee.close();
        }
        catch(Exception e){
            e.getMessage();
        }
        
    }
    
    public void combinaListas(){
        Iterator<String> itNorte=listaNorte.iterator();
        Iterator<String> itSur=listaSur.iterator();
        Iterator<String> itCentro=listaCentro.iterator();
        String nor=null, sur=null, cen=null, min;
        
        if(itNorte.hasNext()){
            nor=itNorte.next();
        }
        
        if(itSur.hasNext()){
            sur=itSur.next();
        }
        
        if(itCentro.hasNext()){
            cen=itCentro.next();
        }
        
        while(nor!=null || sur!=null || cen!=null){
            min=menor(nor,sur,cen);
            listaGeneral.agrega(min);
            if(min.equals(nor)){
                if(itNorte.hasNext())
                    nor=itNorte.next();
                else
                    nor=null;
            }
            if(min.equals(sur)){
                if(itSur.hasNext())
                    sur=itSur.next();
                else
                    sur=null;
            }
            if(min.equals(cen)){
                if(itCentro.hasNext())
                    cen=itCentro.next();
                else
                    cen=null;
            }
        }
        
    }
    
    private String menor(String uno, String dos, String tres){
        String min=null;
        
        if(uno!=null && dos!=null && tres!=null){
            if(uno.compareTo(tres)<0 && uno.compareTo(dos)<0)
                min=uno;
            else
                if(dos.compareTo(tres)<0 && dos.compareTo(uno)<0)
                    min=dos;
                else
                    min=tres;
        }
        else{
            if(uno==null){
                if(dos==null){
                    if(tres!=null){
                        min=tres;
                    }
                    else
                        throw new EmptyCollectionException();
                }
                else{
                    if(tres!=null){
                        if(dos.compareTo(tres)<0){
                            min=dos;
                        }
                        else
                            min=tres;
                    }
                }
            }
            else{
                if(dos!=null){
                    if(dos.compareTo(uno)<0){
                        min=dos;
                    }
                    else
                        min=uno;
                    if(tres!=null){
                        if(min.compareTo(tres)>0)
                            min=tres;
                    }
                }
                else{
                    if(tres!=null){
                        if(tres.compareTo(uno)<0){
                            min=tres;
                        }
                        else
                            min=uno;
                    }
                    else
                        min=uno;
                }
                    
                    
            }
        }
        return min;
    }
    
    public String toString(){
        Iterator<String> it=listaGeneral.iterator();
        StringBuilder cad=new StringBuilder();
        
        while(it.hasNext()){
            cad.append("\n"+it.next().toString());
        }
        return cad.toString();
    }
    
    public static void main(String[] args){
//        Pais canada=new Pais("Canada", "Norte");
//        Pais eua=new Pais("EUA", "Norte");
//        Pais mexico=new Pais("Mexico", "Norte");
//        Pais guatemala=new Pais("Guatemala", "Centro");
//        Pais honduras=new Pais("Honduras", "Centro");
//        Pais argentina=new Pais("Argentina", "Sur");
//        Pais brasil=new Pais("Brasil", "Sur");
//        Pais Colombia=new Pais("Colombia", "Sur");
        ListasPaises list=new ListasPaises();
        
        list.agregaLista("Canada", "Norte");
        list.agregaLista("EUA", "Norte");
        list.agregaLista("Mexico", "Norte");
        list.agregaLista("Guatemala", "Centro");
        list.agregaLista("Honduras", "Centro");
        list.agregaLista("Argentina", "Sur");
        list.agregaLista("Brasil", "Sur");
        list.agregaLista("Colombia", "Sur");
        
        list.combinaListas();
        System.out.println(list.toString());
    }
    
}
