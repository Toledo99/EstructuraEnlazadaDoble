
package PRACTICA_1ER_PARCIAL;


public class PrimerParcialEDfebrero2015 <T>{
    
    //1) MÉTODO SON CASI IGUALES:
    public static boolean sonCasiIguales (PilaADT p1, PilaADT p2, int n){
        //Variable de return:
        boolean resp=false;
        
        //Si alguna pila viene vacía, se arrojoa el error "Colección vacía":
        if(p1.isEmpty() || p2.isEmpty() || n-1>p1.getTope() || n-1>p2.getTope() )
            throw new EmptyCollectionException();
        
        //Pilas auxiliares:
        PilaADT aux1= new PilaA<>();
        PilaADT aux2= new PilaA<>();
        
        //Llenar las pilas auxiliares con los datos de las pilas originales
        //para que estén en orden inverso:
        while( !p1.isEmpty() || !p2.isEmpty() ){
            aux1.push( p1.pop() );
            aux2.push( p2.pop() );
        }
        while( !p2.isEmpty() )
            aux2.push( p2.pop() );
        
        while( !p1.isEmpty() )
            aux1.push( p1.pop() );
        
        //Contar si hay n datos iguales y rellenar las pilas originales:
        int cont = 0; 
        while( cont < n && !aux1.isEmpty() && !aux2.isEmpty() && aux1.peek().equals(aux2.peek())) {
            cont++;
            p1.push(aux1.pop());
            p2.push(aux2.pop());
        }
        
        if(cont == n)
            resp=true;
        
        //Acabar de regresar los valores a las pilas originales:
        while(!aux1.isEmpty() && !aux2.isEmpty()){
            p1.push(aux1.pop());
            p2.push(aux2.pop());
        }
        while( !aux1.isEmpty() ){
            p1.push(aux1.pop());
        }
        while( !aux2.isEmpty() ){
            p1.push(aux2.pop());
        }
        
        return resp;
    }
    
    //MAIN:
    public static void main (String [] args){
        
        //1) PRUEBA PARA MÉTODO SON CASI IGUALES:
        PilaADT p1 = new PilaA();
        PilaADT p2 = new PilaA();
        
        p1.push("Hola");
        p1.push("Bye");
        p1.push("Hallo");
        
        p2.push("Hola");
        p2.push("Bye");
        p2.push("Perro");
        
        System.out.println("Son casi iguales: " + PrimerParcialEDfebrero2015.sonCasiIguales(p1, p2, 2));
        System.out.println("Son casi iguales: " + PrimerParcialEDfebrero2015.sonCasiIguales(p1, p2, 3));
        
        
    }
}
