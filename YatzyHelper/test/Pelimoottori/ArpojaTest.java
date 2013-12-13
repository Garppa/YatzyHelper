/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
/**
 *
 * @author intoit
 */
public class ArpojaTest {
    public ArpojaTest(){
        
    }
    
    @Test
    public void kutonentulostuuTest(){        
    Arpoja arpa = new Arpoja();
    int p = 0;
    for (int i=1; i<1000; i++) {
        if(arpa.annaArvo()==6){
            p++;
        }
    }
    
    assertEquals(true, (p>100));
    }
}

 
    