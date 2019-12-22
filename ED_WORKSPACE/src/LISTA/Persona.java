/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LISTA;

/**
 *
 * @author Diego Merodio
 */
public class Persona implements Comparable<Persona> {
    private String nom;
    private int edad;
    private int tel;

    public Persona() {
    }

    public Persona(String nom, int edad, int tel) {
        this.nom = nom;
        this.edad = edad;
        this.tel = tel;
    }
    

    public Persona(String nom) {
        this.nom = nom;
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
    
    public String toString(){
        StringBuilder cad=new StringBuilder();
        
        cad.append("\nNombre: "+this.nom);
        cad.append("\nEdad: "+this.edad);
        cad.append("\ntel: "+this.tel);
        
        return cad.toString();
    }
    public int compareTo(Persona otro){
       return nom.compareTo(otro.nom);
    }
    public boolean equals(Object otro){
        if(otro instanceof Persona){
            return nom.equals(((Persona)otro).nom);
        }
        else
            return false;
        
    }
}
