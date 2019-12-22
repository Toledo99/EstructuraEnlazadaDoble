/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gauss_Jordan;

/**
 *
 * @author huesos
 */
public class Gauss_Jordan {
    //ATRIBUTO (LA MATRIZ)
    private double[][] matriz;
    
    //MÉTODO CONSTRUCTOR
    public Gauss_Jordan(double [][] matriz){
        this.matriz = matriz;
    }
    
    //MÉTODO GAUSS JORDAN
    public void gaussJordan(){
        this.gauss();
        this.jordan();
    }
    
    //MÉTODO DE ELIMINACIÓN GAUSSIANA:
    public void gauss(){
        
        //1)[Elegir un renglón pivote]
        int i=0;
        while(i<matriz.length && matriz[i][0] == 0)
            i++;
            
        
        //2) [Reordenación de la matriz]
        if(i!=0){
            double [] arrAux = matriz[0];
            matriz[0] = matriz [i];
            matriz[i] = arrAux;
        }
        
        //3)[Hacer un uno pivote]
        for(int j=0; j<matriz[0].length; j++)
            matriz[i][j] = matriz[i][j] / matriz[i][0];
        
        //4)[Anular los elementos situados por encima de los unos pivotes]
        for(int e=1; e<matriz.length; e++)
            for(int h=0; h<matriz[0].length; h++)
                matriz[e][h]= matriz[e][h] -  matriz[e][0] * matriz[0][h];
        
    }
    
    //MÉTODO DE ELIMINACIÓN JORDIANA:
    public void jordan(){
        
    }
    
    //TO_STRING MATRIZ:
    public String toString(){
        String resp="";
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++)
                resp+=matriz[i][j]+"  ";
            resp+="\n";
        }
        return resp;        
    }
    //PRUEBAS:
    public static void main (String [] args){
        double [][] m = {   { 2,-1, 1, 2} ,
                            { 3, 1,-2, 9} ,  
                            {-1, 2, 5,-5}
                                            };
        
        Gauss_Jordan matrizP = new Gauss_Jordan (m);
        
        matrizP.gaussJordan();
        
        System.out.println(matrizP.toString());
    }
}
