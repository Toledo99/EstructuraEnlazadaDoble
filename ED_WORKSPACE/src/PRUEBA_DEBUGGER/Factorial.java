
package PRUEBA_DEBUGGER;

public class Factorial {
    
    private int factorial;
    
    public void factorialN(int n){
        int aux = 1;
        for(int i=1; i<=n; i++ )
            aux=aux*i;
        
        factorial=aux;
    }
    
    public int getFactorial(){
        return this.factorial;
    }
    
    public static void main(String[]args){
        Factorial prueba = new Factorial();
        int n = 10;
        prueba.factorialN(n);
        System.out.println("El factorial de "+n+" es igual a "+ prueba.getFactorial());
    }
}
