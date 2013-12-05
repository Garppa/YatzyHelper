package Pelimoottori;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Pelimoottori.Noppa;
import Pelimoottori.PoydallaOlevat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author intoit
 */
public class PoydallaOlevatTest {
    public PoydallaOlevatTest() {
        
    }
    
    @Test
    public void poydalleSaaNoppia() {
        Noppa noppa = new Noppa(1);
        PoydallaOlevat poydalla = new PoydallaOlevat();
        poydalla.lisaaNoppa(noppa);
        List<Noppa> nopsut = new ArrayList<Noppa>();
        nopsut.add(noppa);
        assertEquals(nopsut,poydalla.annaNopat() );        
    }
   
    @Test
    public void poydalleMaksViisi() {
        PoydallaOlevat poydalla = new PoydallaOlevat();
        Noppa noppa = new Noppa(1);
        for (int i = 0; i<5; i++) {
            poydalla.lisaaNoppa(noppa);
        }
        
        assertEquals(false, poydalla.lisaaNoppa(noppa));
    }
}
