/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA_2º_PARCIAL;

/**
 *
 * @author huesos
 */
public class SegundoParcialED_nov2018 {
    
    public static <T> boolean isSimetrica( T [][] matriz, int tot){
        if(matriz == null || tot==0 || matriz.length != matriz[0].length)
            throw new NullPointerException();
        return isSimetrica(matriz, tot, 0, 0);
    }
    
    private static <T> boolean isSimetrica( T [][] matriz, int tot, int i, int j){
        if( i == tot)
            return true;
        else{
            if( j< matriz.length)
                if( matriz[j][i].equals( matriz[i][j]))
                    return isSimetrica(matriz, tot, i, j+1);
                else
                    return false;
            else
                return isSimetrica(matriz, tot, i+1, i+1);
        }
    }
    
    public static void main (String [] args){
        String [][] m1 ={ {"A", "B", "C"} ,
                          {"B", "A", "Y"} ,
                          {"C", "Y", "A"} };
        
        String [][] m2 ={ {"A", "P", "C"} ,
                          {"B", "A", "Y"} ,
                          {"C", "Y", "A"} };
        
        System.out.println(SegundoParcialED_nov2018.isSimetrica(m1, 3));
        System.out.println(SegundoParcialED_nov2018.isSimetrica(m2, 3));
    }
}
