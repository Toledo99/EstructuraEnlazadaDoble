/**
 * Diego Hernández Delgado
 * (176262).
 * Fecha de examen: 26/27/2019
 * ¡Ya corregido!
 */
package primerparcialfebrero2019_g2;

public class PrimerParcialFebrero2019_G2 <T extends Comparable<T>>{

    
    /**
     * EJERCICIO 1 "ordenaPila"
     * @param PilaADT <T> (pila genérica)
     * @author Diego HD
     */
    
    public static <T extends Comparable<T>> void ordenaPila (PilaADT<T> pila){
        
        //ARROJA ERROR SI LA PILA ESTÁ VACÍA:
        if(pila.isEmpty())
            throw new EmptyCollectionException();
        //ARROJA ERROR SI LA PILA ES UN VAVIABLE DE OBJETO CON VALOR NULO:
        if(pila == null)
            throw new NullPointerException();
        
        //DECLARACIÓN DE VARIABLES:
        PilaADT<T> pAux = new Pila();
        T varAux;
        
        //ALGORITMO--> SE BUSCA ORDENARLOS 
        //PRIMERO LOS MÁS CHICOS Y LUEGO LOS MÁS GRANDES, PARA LUEGO REGRESARLOS EN ORDEN:
        while(!pila.isEmpty()){
            if(pAux.isEmpty()){
                pAux.push(pila.pop());
            }
            else
                if( pila.peek().compareTo( pAux.peek() ) >=0 ) 
                    pAux.push(pila.pop());
                
                else{
                        varAux=pila.pop();
                        while(!pAux.isEmpty() && pAux.peek().compareTo(varAux)>0)
                            pila.push(pAux.pop());
                        pAux.push(varAux);
                    }
        }
        //SE REGRESA LA PILA AUX A LA ORIGINAL PARA QUE QUEDE GUARDADA DE MAYOR A MENIOR:
        while(!pAux.isEmpty())
            pila.push(pAux.pop());
    }
    
    /**
     * EJERCICIO 3 "regresaCadenaMayorLongitud"
     * @param Object [] arreglo,  int numElem
     * @return String cadena meyor longitud o null
     * @author Diego HD
     */
    public static String regresaCadenaMayorLongitud(Object [] arreglo, int numElem){
        if(arreglo == null || numElem==0)
            throw new NullPointerException();
        String resp=null;
        
        for(int i=0; i<numElem; i++){
            if(arreglo[i] instanceof String)
                try{
                   Integer.parseInt((String)arreglo[i]);
                }catch(Exception e){
                    if(resp == null)
                        resp= ((String)arreglo[i]);
                    else
                        if( ((String)arreglo[i]).length() > resp.length() )
                            resp= ((String)arreglo[i]);
                }
        }
        return resp;
    }
    
    public static String regresaCadenaMayorLongitudGuardati(Object [] arreglo, int numElem){
        if(arreglo == null || numElem==0)
            throw new NullPointerException();

        String resultado, cadena;
        int max=-1;
        resultado=null;
        for(int i = 0 ; i < numElem ; i++){
            if(arreglo[i] instanceof String){
                cadena = (String) arreglo[i];
                try{
                    Double.parseDouble(cadena);
                }catch(Exception e){
                    if(cadena.length() > max){
                        max= cadena.length();
                        resultado=cadena;
                    }
                }
            }
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        
        
        //PRUEBA EJERCICIO 1:
        PilaADT pila = new Pila();
        pila.push(4);
        pila.push(2);
        pila.push(9);
        pila.push(5);
        pila.push(7);
        System.out.println("Pila original:\n"+pila.toString());
        PrimerParcialFebrero2019_G2.ordenaPila(pila);
        System.out.println("Pila ordenada:\n"+pila.toString());
        
        
        //PRUEBA EJERCICIO 2:
        //Con cadenas:
        Object [] arregloA = new Object[10];
        int numElemA=5;
        arregloA[1]="hola";
        arregloA[2]="560";
        arregloA[3]="Excelente clase maestra Guardati";
        arregloA[4]=345;
        arregloA[5]= 'f';
        System.out.println("La cadena más larga del arreglo A es:\n\t'" + PrimerParcialFebrero2019_G2.regresaCadenaMayorLongitud(arregloA, numElemA)+"'\n");
        //Sin cadenas:
        Object [] arregloB = new Object[10];
        int numElemB=5;
        arregloB[1]= 1234 ;
        arregloB[2]= 'g';
        arregloB[3]=  false;
        arregloB[4]=  34.89;
        arregloB[5]= 5L;
        System.out.println("La cadena más larga del arreglo B es:\n\t" + PrimerParcialFebrero2019_G2.regresaCadenaMayorLongitud(arregloB, numElemB)+"\n");
        //Arreglo vacío: (Lo comenté para que no meande el error acada vez que lo probaba)
        /*
        Object [] arregloC = new Object[10];
        int numElemC=0;
        System.out.println("La cadena más larga del arrego C es: " + PrimerParcialFebrero2019_G2.regresaCadenaMayorLongitud(arregloC, numElemC)+"\n");
        */
        
        
        
    }
    
}
