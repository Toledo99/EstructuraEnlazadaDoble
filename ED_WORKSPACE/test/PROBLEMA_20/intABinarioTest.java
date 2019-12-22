/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA_20;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author huesos
 */
public class intABinarioTest {
    
    public intABinarioTest() {
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
     * Test of toBinary method, of class intABinario.
     */
    @Test
    public void testToBinary() {
        System.out.println("toBinary");
        int num = 36;
        int expResult = 100100;
        int result = intABinario.toBinary(num);
        assertEquals(expResult, result, 0);
        
    }

    /**
     * Test of main method, of class intABinario.
     */
    /*
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        intABinario.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
