/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_35;

import COLA.ColaA;

/**
 *
 * @author huesos
 */
public class QuitaOcurrencias {

    
    public static <T> void  quitaOcurrenciasObjeto (Object obj, ColaA <T> col){
        if( obj == null || col == null)
            throw new NullPointerException();
        ColaA <T> aux = new ColaA();
        T a;
        while(!col.estaVacia()){
            a = col.quita();
            if(!a.equals(obj))
                aux.agrega(a);
        }
        
        while(!aux.estaVacia())
            col.agrega(aux.quita());
    }
    
    public static <T> void  quitaOcurrencias (Object obj, ColaA <T> col){
        if( obj == null || col == null)
            throw new NullPointerException();
        else
            quitaOcurrenciasRec(obj, col);
    }
    
    public static <T> void  quitaOcurrenciasRec (Object obj, ColaA <T> col){
        if( obj == null || col == null)
            throw new NullPointerException();
        ColaA <T> aux = new ColaA();
        //ACABARLO
    }
    
    
    public static void main (String [] args){
        ColaA col = new ColaA();
        col.agrega("A");
        col.agrega("B");
        col.agrega("A");
        col.agrega("A");
        
        QuitaOcurrencias.quitaOcurrencias("A", col);
        
        System.out.println(col.quita());
    }
}

