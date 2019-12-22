
package PROBLEMA_29;

public class AnalizaArreglo <T extends Comparable>{
    private int total;
    private T[] arreglo;
    int MAX = 20;
    
    public AnalizaArreglo(){
        total=0;
        arreglo= (T[]) new Comparable[MAX];
    }
    
    public AnalizaArreglo(int max){
        total=0;
        arreglo= (T[]) new Comparable[max];
    }
    
    public boolean alta(T dato){
        boolean resp=false;
        if( total < arreglo.length ){
            resp=true;
            arreglo[total]=dato;
            total++;
        }
        return resp;
    }
    
    //Para el usuario
    /*public int busquedaSecuencial(T dato){
        return busquedaSecuencial(dato, 0);
    }
    
    //private int busquedaSecuencial(T dato, int ind){
        if(ind == total)
            return -1;
        else
            if(arreglo[ind].equals(dato))
                return ind;
        else
                return busquedaSecuencial(dato, ind+1);
    }
    */
    
    //1)BUSQUEDA SECUENCIAL:
    public int busquedaSecuencial(T dato){
        return busquedaSecuencial(dato, total-1);
    }
    public int busquedaSecuencial(T dato, int pos){
        if(pos == -1 || arreglo[pos].equals(dato))
            return pos;
        else
            return busquedaSecuencial(dato, pos-1);
    }
    
    //BUSQUEDA BINARIA:
    /*
    public int busquedaBinaria(T dato){
        int inicio = 0;
        int fin = total-1;
        int mitad=(inicio+fin)/2;
        while( !arreglo[mitad].equals(dato) &&  inicio <= fin){
            if(arreglo[mitad].compareTo(dato) <  0)
                inicio=mitad+1;
            else
                fin=mitad-1;
            mitad=(inicio+fin)/2;
        }
        if(arreglo[mitad].equals(dato))
            return mitad;
        else
            return -1*(mitad+1);
    }
    */
    //2) BUSQUEDA BINARIA
    public int busquedaBinaria(T dato){
        return busquedaBinaria(dato, 0, total-1);
    }
    
    private int busquedaBinaria(T dato, int inicio, int fin){
        int mitad= (inicio+fin)/2;
        
        if(inicio > fin)
                return -1*(inicio);
        
        if(arreglo[mitad].equals(dato))
            return mitad;
        
        if(arreglo[mitad].compareTo(dato) < 0)
            return busquedaBinaria(dato, mitad+1, fin);
        else
            return busquedaBinaria(dato, inicio, mitad-1);
        
    }
    
    //3)TO_STRING_DIEGO
    public String toString(int ind){
        String resp="";
        if(ind == total)
            return resp;
        else
            return resp+=""+arreglo[ind]+" "+toString(ind+1);     
    }
    
    public String toStringA(){
        return toString(0);
    }
    
    //3)TO_STRING_GUARDATI
    public String toStringB(){
        return toString(0, new StringBuilder());
    }
    
    private String toString(int ind, StringBuilder res){
        if(ind == total)
            return res.toString();
        else{
            res.append(arreglo[ind]+" ");
            return toString(ind+1, res);
         
        }
    }
    //4)ENCUENTRA_MAYOR:
    private int encuentraMayor(int ind, int mayor){
        if(ind == total)
            return mayor;
        else{
            if(arreglo[mayor].compareTo(arreglo[ind]) < 0)
                mayor=ind;
            return encuentraMayor(ind+1, mayor);
        }
    }
    
    public int encuentraMayor(){
        if(total==0)
            throw new RuntimeException("Empty array");
        return encuentraMayor(0,0);
    }
    
    
             
    //5)ELIMINA OCURRENCIAS
    private boolean eliminaOcurrencias(T dato,int ind, boolean res){
        if(ind>=total)
            return res;
        else{
            if( arreglo[ind].equals(dato) ){
                res=true;
                recorreIzq(ind);
                total--;
            }
            else
                ind++;
            return eliminaOcurrencias(dato, ind, res);
        }
        
    }
    
    public boolean eliminaOcurrencias(T dato){
        boolean res=false;
        return eliminaOcurrencias(dato, 0, res);
    }
    
    private void recorreIzq(int pos){
        if(pos<total-1){
            arreglo[pos]=arreglo[pos+1];
            recorreIzq(pos+1);
        }
    }
    
    //6) ORDENACIÓN DIRECTA
    public void seleccionDirecta(){
        seleccionDirecta(0,1,0);
    }
    
    private void seleccionDirecta(int i, int j, int menor){
        if(i < total-1){
            if(j < total){
                if(arreglo[j].compareTo(arreglo[menor]) < 0)
                    menor = j;
                seleccionDirecta(i,j++, menor);
            }
            else{
                T temp = arreglo[i];
                arreglo[i] = arreglo[menor];
                arreglo[menor] = temp;
                seleccionDirecta(i+1, i+2, i+1);
            }
        }
    }
    
    public int indiceMayor(int r){
        return indiceMayor(1,0,r);
    }
    private int indiceMayor(int i, int mayor, int r){
        if(i==r)
            return mayor;
        else{
            if( arreglo[mayor].compareTo(arreglo[i]) < 0)
                mayor=i;
            return indiceMayor(i++, mayor, r);
        }
    }
    public void ordena(){
        int r = total, mayor;
        if(total>0){
            mayor = indiceMayor(r);
            r--;
            ordena(mayor, r);
        }
    }
    
    private void ordena ( int mayor, int r){
        if(r > 0){
            T aux;
            aux=arreglo[r];
            arreglo[mayor]=aux;
            mayor=indiceMayor(r);
            r--;
            ordena(mayor,r);
        }
    }
    
    //MAIN_FOR_TESTS:
    public static void main (String [] args){
       /*
        AnalizaArreglo ejemplo = new AnalizaArreglo();
        ejemplo.alta("Montse");
        ejemplo.alta("Rodrigo");
        ejemplo.alta("Tonio");
        ejemplo.alta("Diego");
        
        //1)Prueba búsqueda secuencial:
        System.out.println(ejemplo.busquedaSecuencial("Tonio"));
        
        //Prueba toString():
        System.out.println(ejemplo.toStringA());
        
        //Prueba encuentraMayor:
        AnalizaArreglo ejemplo2 = new AnalizaArreglo();
        ejemplo2.alta("a");
        ejemplo2.alta("b");
        ejemplo2.alta("o");
        ejemplo2.alta("d");
        ejemplo2.alta("e");
        System.out.println("El mayor es:" + ejemplo2.encuentraMayor());
        
        //Prueba busquedaBinaria normal:
        System.out.println("Busqueda binaria: "+ejemplo2.busquedaBinaria("c"));
        */
        //Prueba elimina ocurrencias.
        AnalizaArreglo ejemplo3 = new AnalizaArreglo();
        ejemplo3.alta(1);
        ejemplo3.alta("ato");
        ejemplo3.alta(4);
        ejemplo3.alta(4);
        ejemplo3.eliminaOcurrencias("String");
        
        System.out.println(ejemplo3.toStringB());
       
    }
}
