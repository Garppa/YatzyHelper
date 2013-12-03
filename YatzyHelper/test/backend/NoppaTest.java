/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import Pelimoottori.Noppa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author intoit
 */
public class NoppaTest {
    
    public NoppaTest() {
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
     * Test of annaSilmaluku method, of class Noppa.
     */
    @Test
    public void testAnnaSilmaluku() {
        System.out.println("annaSilmaluku");
        Noppa instance = new Noppa(1);
        int expResult = 1;
        int result = instance.annaSilmaluku();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tulostaNoppa method, of class Noppa.
     */
    @Test
    public void testTulostaNoppa() {
        System.out.println("tulostaNoppa");
        Noppa instance = null;
        instance.tulostaNoppa();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Noppa.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Noppa noppa = null;
        Noppa instance = null;
        int expResult = 0;
        int result = instance.compareTo(noppa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
