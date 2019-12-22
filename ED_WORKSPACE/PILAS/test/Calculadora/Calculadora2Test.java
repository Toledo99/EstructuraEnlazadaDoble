/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tonotoledo
 */
public class Calculadora2Test {
    
    public Calculadora2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of revisaTodo method, of class Calculadora2.
     */
    @Test
    public void testRevisaTodo() {
        System.out.println("revisaTodo");
        Calculadora2 calculadora=new Calculadora2();
        String infijo = "55*69.6)+6";
        boolean expResult = false;
        boolean result = calculadora.revisaTodo(infijo);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of eliminarExcesos method, of class Calculadora2.
     */
    @Test
    public void testEliminarExcesos() {
        System.out.println("eliminarExcesos");
        Calculadora2 calculadora=new Calculadora2();
        String oper = "6+-8";
        String expResult = "6-8";
        String result = calculadora.eliminarExcesos(oper);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of convertirPostfijo method, of class Calculadora2.
     */
    @Test
    public void testConvertirPostfijo() {
        System.out.println("convertirPostfijo");
        String exp = "5+6*8";
        String expResult = "5+68*";
        String result = Calculadora2.convertirPostfijo(exp);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of evaluarPostfijo method, of class Calculadora2.
     */
    @Test
    public void testEvaluarPostfijo() {
        System.out.println("evaluarPostfijo");
        String postfijo = "5*5*(6+3)";
        double expResult = 225;
        double result = Calculadora2.evaluarPostfijo(postfijo);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of resolver method, of class Calculadora2.
     */
    @Test
    public void testResolver() {
        System.out.println("resolver");
        String exp = "5*5*(6+3)";
        double expResult = 225;
        double result = Calculadora2.resolver(exp);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of main method, of class Calculadora2.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Calculadora2.main(args);
    }
    
}
