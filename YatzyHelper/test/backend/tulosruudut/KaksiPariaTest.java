/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.tulosruudut;

import backend.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class KaksiPariaTest{
    
    public KaksiPariaTest() {
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
     * KaksiParia, kelpaako metodin testi
     */
    @Test
    public void testKelpaako() {
        
        Noppa instance1 = new Noppa(1);
        Noppa instance2 = new Noppa(1);
        Noppa instance3 = new Noppa(2);
        Noppa instance4 = new Noppa(2);
        Noppa instance5 = new Noppa(3);
        boolean expResult = true;
     
        Set<Noppa> nopat = new HashSet<Noppa>();
        nopat.add(instance5);
        nopat.add(instance4);
        nopat.add(instance3);
        nopat.add(instance2);
        nopat.add(instance1);

        assertEquals(expResult, new backend.Tulosruudut.KaksiParia(9).tayttyykoEhto(nopat));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
     @Test
    public void testEpaKelpo() {
        
        Noppa instance1 = new Noppa(1);
        Noppa instance2 = new Noppa(2);
        Noppa instance3 = new Noppa(3);
        Noppa instance4 = new Noppa(4);
        Noppa instance5 = new Noppa(5);
        boolean expResult = false;
     
        Set<Noppa> nopat = new HashSet<Noppa>();
        nopat.add(instance5);
        nopat.add(instance4);
        nopat.add(instance3);
        nopat.add(instance2);
        nopat.add(instance1);

        assertEquals(expResult, new backend.Tulosruudut.KaksiParia(9).tayttyykoEhto(nopat));
    }
    
         @Test
    public void testSumma() {
        
        Noppa instance1 = new Noppa(1);
        Noppa instance2 = new Noppa(1);
        Noppa instance3 = new Noppa(2);
        Noppa instance4 = new Noppa(2);
        Noppa instance5 = new Noppa(3);
        
     
        Set<Noppa> nopat = new HashSet<Noppa>();
        nopat.add(instance5);
        nopat.add(instance4);
        nopat.add(instance3);
        nopat.add(instance2);
        nopat.add(instance1);
        
        int expResult = 6;
        int result = 0;
        
        for (Noppa noppa : new backend.Tulosruudut.KaksiParia(9).sopivatNopat(nopat)) {
            result = result + noppa.annaSilmaluku();
        }


        assertEquals(expResult, result);
    }
        // TODO review the generated test code and remove the default call to fail.
    /**
     * Test of tulostaNoppa method, of class Noppa.
     
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
*/
}