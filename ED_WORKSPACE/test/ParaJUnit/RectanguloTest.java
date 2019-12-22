
package ParaJUnit;

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
public class RectanguloTest {
    
    public RectanguloTest() {
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

    @Test
    public void testSomeMethod() {
        
    }

    /**
     * Test of calculaArea method, of class Rectangulo.
     */
    @Test
    public void testCalculaArea() {
        System.out.println("calculaArea");
        Rectangulo instance = new Rectangulo(4,2);
        double expResult = 8.0;
        double result = instance.calculaArea();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculaPerimetro method, of class Rectangulo.
     */
    @Test
    public void testCalculaPerimetro() {
        System.out.println("calculaPerimetro");
        Rectangulo instance = new Rectangulo(4,2);
        double expResult = 12.0;
        double result = instance.calculaPerimetro();
        assertEquals(expResult, result, 0.0);
    }
    
}
