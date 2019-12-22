/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;
import pilas.*;
/**
 *
 * @author atoledog
 */
public class Calculadora {

    public Calculadora() {
    }
    
    
    
    public boolean revisaParentesis(String infijo){
        boolean res=true;
        PilaA<Character> pila= new PilaA();
        int i=0;
        char car, next, before;
        
        while(i<infijo.length() && res){
            car=infijo.charAt(i);
            if(car=='('){
                pila.push(car);
                if(i<infijo.length()-1){
                    next=infijo.charAt(i+1);
                    if(next=='*'||next=='/'||next==')')
                        res=false;
                    if(i>0&&res){
                        before=infijo.charAt(i-1);
                        if(before!='*'&&before!='+'&&before!='-'&&before!='/')
                            res=false;
                    }
                }
            }
            else
                if(car==')'){
                    if(pila.isEmpty())
                        res=false;
                    else{
                        pila.pop();
                        if(i<infijo.length()-1){
                            next=infijo.charAt(i+1);
                            if(next!='*'&&next!='+'&&next!='-'&&next!='/')
                            res=false;
                        }
                    }
                    
                }
            i++;
        }
        if(!pila.isEmpty())
            res=false;
            //throw new SyntaxError();
            
        return res; 
    }
    
    public boolean revisaSignos(String infijo){
        boolean res=true, puntos=false;
        int i=0;
        char cero=infijo.charAt(0), ultimo=infijo.charAt(infijo.length()-1);
        
        if(cero=='*'||cero=='/' ){
                res=false;
        }
        if(cero=='+'||cero=='-')
            i++;
        if(ultimo=='*'||ultimo=='/' || ultimo=='+' || ultimo=='-' ){
            res=false;
        }
        i++;
        while(res && i<infijo.length()){
            char index=infijo.charAt(i);
            char unomenos=infijo.charAt(i-1);
            if(index=='*'||index=='/'){
                if(unomenos=='*'||unomenos=='/' || unomenos=='+' || unomenos=='-')
                    res=false;
            }
            if(index=='/' && res)
                if(infijo.charAt(i+1)=='0')
                    res=false;
            if(puntos && index=='.')
                res=false;
            if(index=='.'&& res){
                puntos=true;
            }
            else
                if(index=='+' || index=='-'||index=='*' || index=='/')
                    puntos=false;
            i++;
        }
        //if(!res)
            //throw new SyntaxError();
        return res;
    }
    
    public boolean revisaTodo2(String infijo){
        boolean res=true;
        PilaA<Character> pila= new PilaA();
        int j=0;
        char car, next, before;
        
        while(j<infijo.length() && res){
            car=infijo.charAt(j);
            if(car=='('){
                pila.push(car);
                if(j<infijo.length()-1){
                    next=infijo.charAt(j+1);
                    if(next=='*'||next=='/'||next==')')
                        res=false;
                    if(j>0&&res){
                        before=infijo.charAt(j-1);
                        if(before!='*'&&before!='+'&&before!='-'&&before!='/'&&before!='(')
                            res=false;
                    }
                }
            }
            else
                if(car==')'){
                    if(pila.isEmpty())
                        res=false;
                    else{
                        pila.pop();
                        if(j<infijo.length()-1){
                            next=infijo.charAt(j+1);
                            if(next!='*'&&next!='+'&&next!='-'&&next!='/'&&next!=')')
                            res=false;
                        }
                    }
                    
                }
            j++;
        }
        if(!pila.isEmpty())
            res=false;
        
        boolean puntos=false;
        int i=0;
        char cero=infijo.charAt(0), ultimo=infijo.charAt(infijo.length()-1);
        
        if(cero=='*'||cero=='/' ){
                res=false;
        }
        if(cero=='+'||cero=='-')
            i++;
        if(ultimo=='*'||ultimo=='/' || ultimo=='+' || ultimo=='-' ){
            res=false;
        }
        i++;
        while(res && i<infijo.length()){
            char index=infijo.charAt(i);
            char unomenos=infijo.charAt(i-1);
            if(index=='*'||index=='/'){
                if(unomenos=='*'||unomenos=='/' || unomenos=='+' || unomenos=='-')
                    res=false;
            }
            if(index=='/' && res)
                if(infijo.charAt(i+1)=='0')
                    res=false;
            if(puntos && index=='.')
                res=false;
            if(index=='.'&& res){
                puntos=true;
            }
            else
                if(index=='+' || index=='-'||index=='*' || index=='/')
                    puntos=false;
            i++;
        }
        //if(!res)
            //throw new SyntaxError();
        return res;
    }
    /**
     * Checa que la sintaxis de la expresión escrita en una calculadora sea correcta
     * @param infijo: cadena de la expresión recibida de la calculadora
     * @return <ul>
     * <li> true: Si no existen errores en la sintaxis
     * <li> false: existe algún error en la sintaxis
     * </ul>
     */
    public boolean revisaTodo(String infijo){
        boolean res=true, puntos=false;
        PilaA<Character> pila= new PilaA();
        //Pila utilizada como auxiliar para contener los parentesis abiertos
        int i=0;
        char car=infijo.charAt(0), next, before, ultimo=infijo.charAt(infijo.length()-1);
        //Se checa el primer y el último caracter del String porque solo.
        //se llama al metodo si el String no está vacío. Por eso es posible.
        
        //Este if marca error si el primer caracter es es simbolo de multiplicacion o division
        if(car=='*'||car=='/' ){
                res=false;
        }
        //Por otro lado que el primer caracter sea el simbolo de mas o de menos si es posible
        if(car=='+'||car=='-')
            i++;
        //Si el último caracter es un operador o un punto se marca error ya que es incongruente
        if(ultimo=='*'||ultimo=='/' || ultimo=='+' || ultimo=='-' || ultimo=='.'){
            res=false;
        }
        //ciclo para recorrer la cadena infija caracter por caracter
        while(i<infijo.length() && res){
            car=infijo.charAt(i);
            switch (car) {
                case '(':
                    pila.push(car);
                    //si hay un parentesis abierto se agrega a la pila
                    if(i<infijo.length()-1){
                        next=infijo.charAt(i+1);
                        if(next=='*'||next=='/'||next==')')
                            res=false;
                        if(i>0&&res){
                            before=infijo.charAt(i-1);
                            if(before!='*'&&before!='+'&&before!='-'&&before!='/'&&before!='(')
                                res=false;
                        }
                    }   break;
                case ')':
                    before = infijo.charAt(i-1);
                    if(pila.isEmpty())
                        res = false; //Si se encuentra un paréntesis para cerrar y no hay uno abierto en la pila, es porque están incorrectos; es incorrecta la expresión.
                    else if(before == '*' || before == '+' || before == '-' || before == '/' || before == '(')
                        res = false;
                    else{
                        pila.pop();
                        //Se elimina de la pila el parentesis que se cerro
                        if(i<infijo.length()-1){
                            next=infijo.charAt(i+1);
                            if(next!='*'&&next!='+'&&next!='-'&&next!='/'&&next!=')')
                                //No puede haber un digito o punto después de un parentesis ya que
                                //no aceptamos los parentesis como multiplicadores
                                res=false;
                        }
                    }
                    break;
                default:
                    if(car=='*'||car=='/'){
                        before=infijo.charAt(i-1);
                        if(before=='*'||before=='/' || before=='+' || before=='-')
                            //No se puede tener un operador y despues el simbolo de 
                            //multiplicación o division; es un error.
                            res=false;
                    }
                    //Este if funciona para mandar error si hay dos puntos en un mismo numero
                    //Si el boolean puntos es true es porque ya hay un punto y el numero no ha terminado
                    if(puntos && car=='.')
                        res=false;
                    if(car=='.'&& res){
                        puntos=true;
                        //Si encuentra un punto el boolean puntos se vuelve true
                        next=infijo.charAt(i+1);
                        if(!Character.isDigit(next)){
                            if(i>0){
                                before=infijo.charAt(i-1);
                                if(!Character.isDigit(before)){
                                    res=false;
                                    //Si un punto no tiene un número antes ni después está incorrecto.
                                }
                            }
                        }
            
                    }
                    else
                        if(car=='+' || car=='-'||car=='*' || car=='/'){
                            //Cada que encuentra un operador regresa puntos a false
                            //porque ya termino el numero
                            puntos=false;
                        }
                    break;
            }
            i++;
        }
        //Si la pila no esta vacia significa que un parentesis no se cerro por lo que está incorrecto
        if(!pila.isEmpty())
            res=false;
        
        return res;
    }
    
    public static void main(String[] args0){
        Calculadora c=new Calculadora();
        String ej="";
        System.out.println(c.revisaTodo2(ej));
        
    }
}
