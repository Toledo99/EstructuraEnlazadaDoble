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
 * @author atoledog
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
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
     * Test of revisaParentesis method, of class Calculadora.
     */
    @Test
    public void testRevisaParentesis() {
        System.out.println("revisaParentesis");
        String infijo = "";
        Calculadora instance = new Calculadora();
        boolean expResult = false;
        boolean result = instance.revisaParentesis(infijo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisaSignos method, of class Calculadora.
     */
    @Test
    public void testRevisaSignos() {
        System.out.println("revisaSignos");
        String infijo = "";
        Calculadora instance = new Calculadora();
        boolean expResult = false;
        boolean result = instance.revisaSignos(infijo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisaTodo method, of class Calculadora.
     */
    @Test
    public void testRevisaTodo() {
        System.out.println("revisaTodo");
        String infijo = "";
        Calculadora instance = new Calculadora();
        boolean expResult = false;
        boolean result = instance.revisaTodo(infijo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Calculadora.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args0 = null;
        Calculadora.main(args0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
