/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atoledog
 */
public class RevPar {
    private String expresion;

    public RevPar(String expresion) {
        this.expresion = expresion;
    }
    
    public boolean revisaParentesis(){
        boolean res=true;
        PilaA<Character> pila= new PilaA();
        int i=0;
        char car;
        
        while(i<expresion.length() && res){
            car=expresion.charAt(i);
            if(car=='(')
                pila.push(car);
            else
                if(car==')'){
                    if(pila.isEmpty())
                        res=false;
                    else
                        pila.pop();
                }
            i++;
        }
        if(!pila.isEmpty())
            res=false;
        return res; 
    }
    
    public boolean revisaParentesisyMas(){
        boolean res=true;
        PilaA<Character> pila= new PilaA();
        int i=0;
        char car;
        
        while(i<expresion.length() && res){
            car=expresion.charAt(i);
            if(car=='(' || car=='[' || car=='{')
                pila.push(car);
            else
                if(car==')'|| car==']' || car=='}'){
                    if(pila.isEmpty())
                        res=false;
                    else
                        switch(car){
                            case ')':
                                if(pila.pop()!='(')
                                    res=false;
                                break;
                            case ']':
                                if(pila.pop()!='[')
                                    res=false;
                                break;
                            case '}':
                                if(pila.pop()!='{')
                                    res=false;
                                break;
                        }
                        
                }
            i++;
        }
        if(!pila.isEmpty())
            res=false;
        return res; 
    }
    
    public static void main(String[] args){
        RevPar r=new RevPar("{}{}[(lele]");
        
        System.out.println(r.revisaParentesisyMas());
    }
}
