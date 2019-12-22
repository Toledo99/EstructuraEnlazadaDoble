/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OBJETOS_EN_ARCHIVOS;

import java.io.Serializable;

public class Verdura implements Serializable{
    private String tipo;
    private String color;
    
    public Verdura(){
    }
    
    public Verdura(String tipo, String color){
        this.tipo = tipo;
        this.color = color;
    }
    
    public String toString(){
        String res = "\nFruta: " + this.tipo + "\nColor: " + this.color + "\n";
        return res;
    }
    
}
