
package PROBLEMA_31;


public class OperacionesArregloBidimensional {
    
    public int [][]matrix;
    private int rows;
    private int columns;
    
    
    public OperacionesArregloBidimensional(int[][] matrix, int rows, int columns){
        this.matrix = matrix;
        this.rows = rows;
        this.columns = columns;
        
    }
    
    //1) Suma por renglones:
    private int sumaPorRenglon(int i, int j, int suma){
        if(j<columns)
            return sumaPorRenglon(i, j+1, suma+=matrix[i][j]);
        else
            return suma;
    }
    public int sumaPorRenglon(int i){
        if(i<0 || i>rows)
            throw new RuntimeException("Valio queso");
        
        return sumaPorRenglon(i, 0, 0);
    } 
    
    //2) Suma por columnas:
    private int sumaPorColumna(int i, int j, int suma){
        if(i<rows)
            return sumaPorColumna(i+1, j, suma+=matrix[i][j]);
        else
            return suma;
    }
    public int sumaPorColumna(int j){
        return sumaPorColumna(0, j, 0);
    } 
    
    
    //3)toStringMatriz
    public String toString(){
        return toString(new StringBuilder(), 0, 0);
    }
    private String toString(StringBuilder cad, int i, int j){
        if(i<rows){
            if(j<columns){
                cad.append(matrix[i][j]+" ");
                return toString(cad, i, j+1);
            }
            cad.append("\n");
            return toString(cad, i+1, 0);
        }
        else
            return cad.toString();
    }
    
    public static String toString(int[][] m){
        String res="";
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[0].length; j++)
                res+=" "+m[i][j];
            res+="\n";
        }
        return res;
    }
    //4) Suma diagonal principal:
    public int sumaDiagonalPrincipal(){
        return sumaDiagonalPrincipal(0,0,0);
    }
    private int sumaDiagonalPrincipal(int suma, int i, int j){
        if(i<rows && j<columns)
            return sumaDiagonalPrincipal(suma+=matrix[i][j], i+1, j+1);
        else 
            return suma;
    }
    
    //5) Suma matrices:
    public int[][] sumaMatrices(int[][]mS){
        if(mS == null || mS.length != rows || mS[0].length != columns)
            throw new RuntimeException("Noup");
        
        return sumaMatrices(mS, new int[rows][columns], 0, 0);
    } 
    private int[][] sumaMatrices(int[][] mS, int[][] res, int i, int j){
        if(i<rows){
            if(j<columns){
                res[i][j]= matrix[i][j] + mS[i][j];
                return sumaMatrices(mS, res, i, j+1);
            }
            return sumaMatrices(mS, res, i+1, 0);
        }
        return res;
    }
    
    //6) Multiplica matrices:
    // ¡No está bien!
    /*
    public int[][] multiplicaMatriz(int[][] b){
        if(this.columns == b.length){
            int [][] resp = new int [this.rows][b[0].length];
            return multiplicaMatriz(b, 0, 0, resp);
        }else{
            throw new RuntimeException("Error");
        }
    }
    
    private int[][] multiplicaMatriz(int [][] b, int row, int col, int [][] resp){
        for(int i=0; i<columns; i++){
            resp[row][col] += matrix[row][i] * b[i][col] ;
        }
        if(col<resp[0].length){
            col= col+1;
            return multiplicaMatriz(b, row, col, resp);
        }
        else
            if(row<resp.length)
                return multiplicaMatriz(b, row+1, 0, resp);
            else
                return resp;
    }
    ______________________
    */
    
    /*
    public int[][] multiplicaMatrices(int[][] mP){
        //if(mP==null || columns != mP.length)
          //    throw new RuntimeException("Es ist kaput");
        
        return multiplicaMatrices(mP, new int[rows][mP[0].length],0,0,0,0);
    }
    
    //private int[][] 
    
    private int[][] multiplicaMatrices(int [][] b, int [][] res, int posMat, int posB, int posRes, int suma){
        if(posMat < rows){
            if(posRes < res.length){
                if(posMat < b[0].length){
                    suma= suma+ matrix[posMat][posRes] * b[posRes][posB];
                    return multiplicaMatrices(b, res, posMat, posB+1, posRes, suma);
                }
                res[posMat][posB] = suma;
                suma=0;
                return multiplicaMatrices(b, res, posMat, 0, posRes+1, suma);
            }
            return multiplicaMatrices(b, res, posMat+1, posB, 0, suma);
        }
        return res;
    }
    
    public int multRenCol(int [][] m, int i, int j, int r){
        if(j < columns)
            return multRenCol(m, i, j+1, r+= matrix[i][j]*m[j][i]);
        else{
            System.out.println(r);
            return r;
        }
    }
    */
    public static void main (String [] agrs){
        /*int [][]  matrix = { {1,2,3,4,5} , 
                             {1,2,3,4,5} , 
                             {1,2,3,4,5} };*/
        int [][]  matrix = { {1,3} , 
                             {2,4} };
        
        OperacionesArregloBidimensional m= new OperacionesArregloBidimensional(matrix, 2, 2);
        /*
        System.out.println("Suma renglón: "+ m.sumaPorRenglon(2));
        System.out.println("Suma columna: "+ m.sumaPorColumna(1));
        System.out.println("\nImprimir matriz: \n"+ m.toString()+"\n");
        System.out.println("Suma diagonal principal: "+ m.sumaDiagonalPrincipal()+"\n");
        */
        int [][] mS = { {2,2,2,2,2} , 
                        {2,2,2,2,2} , 
                        {2,2,2,2,2} };
        /*
        int[][] res = m.sumaMatrices(mS);
        System.out.println("Suma matrices: \n"+  OperacionesArregloBidimensional.toString(res) );
        */
        
        int [][] mP = { {-1,2},
                        { 0,3} };
        
       
        //System.out.println("\nMultiplicación matrices: \n" + OperacionesArregloBidimensional.toString(m.multiplicaMatriz(mP)) );
    }
}
