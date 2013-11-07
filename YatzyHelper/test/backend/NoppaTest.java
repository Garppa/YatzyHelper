/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;


import static org.junit.Assert.*;

/**
 *
 * @author intoit
 */
public class NoppaTest {

    
  
    public void testNoppaSilmaluku() {
        System.out.println("annaSilmaluku");
        Noppa noppa = new Noppa(1);        
        assertEquals(1, noppa.annaSilmaluku());

    }

}

