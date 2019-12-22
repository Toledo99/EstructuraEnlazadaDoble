
package MEMOIZACION;

/*EJEMPLO DE MEMOIZACION CON FIBONACCII*/

public class EjemploMemoizacion {
    
    public static int fibonacci(int n){
        int [] fibo = new int [n+1] ;
        fibo[0]=0;
        fibo[1]=1;
        for(int i=2; i<fibo.length; i++)
            fibo[i]=-1;
        
        return fibonacci(fibo, n);
    }
    
    private static int fibonacci(int[] fibo, int n){
        if(n==0 || n==1)
            return n;
        else{
            if(fibo[n-1] == -1)
                fibo[n-1] = fibonacci(fibo, n-1);
            if(fibo[n-2] == -1)
                fibo[n-2] = fibonacci(fibo, n-2);
            fibo[n]= fibo[n-1] + fibo[n-2];
            return fibo[n];
        }
    }
    
    public static void main (String [] args){
        System.out.println("Fibonacci en la posicion 4 es el número: " + EjemploMemoizacion.fibonacci(4));
    }
}
