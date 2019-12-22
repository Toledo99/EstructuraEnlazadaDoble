/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_38;

/**
 *
 * @author huesos
 */
public class Documento extends Archivo{
    
    private String tipoProcesador;
    
    public Documento(double tamanio, String nombre, String duenio, String fecha, String tipoProcesador) {
        super(tamanio, nombre, duenio, fecha);
        this.tipoProcesador = tipoProcesador;
    }
    
    public String getTipoProcesador(){
        return this.tipoProcesador;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\n Procesador: "+this.tipoProcesador;
    }
}
