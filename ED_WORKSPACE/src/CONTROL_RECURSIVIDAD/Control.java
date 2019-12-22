

package CONTROL_RECURSIVIDAD;



public class Control {
    
    public static int queHago(int num){
        System.out.println(num);
        
        if(num>100)
            return 1;
        else
            return queHago(num+10) + queHago(num+15) * 2 ;
    }
    
    
    public static void main( String [] args ){
        System.out.println(Control.queHago(75));
    }
}
