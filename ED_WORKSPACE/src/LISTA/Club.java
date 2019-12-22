/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LISTA;

import java.util.Iterator;

/**
 *
 * @author Diego Merodio
 */
public class Club {
    private String nom;
    private ListaOrdenada<Persona> socios;

    public Club(String nom) {
        this.nom = nom;
        socios=new ListaOrdenada();
    }
    public boolean altaSocio(String nom,int edad,int tel){
        return socios.agrega(new Persona(nom,edad,tel));
    }
    public String bajSocio(String nom){
        Persona p=socios.quita(new Persona(nom));
        String res;
        if(p==null){
            res="Socio no encontrado";
        }
        else{
            res=p.toString();
        }
        return res;
    }
    public String consultaSocio(String nom){
        String res="no encontrado";
        
        if(socios.estaVacia())
            res ="lista vacia";
        else{
        
            Iterator<Persona> it=socios.iterator();
            Persona p=new Persona(nom);
            boolean ya=false;

            while(it.hasNext() && !ya){
                p=it.next();
                if(p.getNom().compareTo(nom)>=0)
                    ya=true;
            }
            if(p.getNom().equals(nom))
                res=p.toString();
        }  
        
        return res;
    }
    
    
}
