/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pelimoottori;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author kari_000
 */
public class PeliTest extends PerustaTest{
    public PeliTest(){
        
    }
    
    @Test
    public void testaaLuoYksiPelaaja(){
        Peli p = luoPeli("Ossi");

        List<Pelaaja> pelurit = p.annaPelaajat();
        
        Assert.assertEquals(1, pelurit.size());
        
    }
    
    @Test
    public void testaaKierrosOnYksi(){
        Peli p = luoPeli("Ossi");
        
        int i = p.annaKierros();
        
        Assert.assertEquals(1, i);
               
    }
    
    @Test
    public void testaaKierrosVaihtuu(){
        Peli p = luoPeli("Ossi");
        p.tallennaPisteet();
        int i = p.annaKierros();
        
        Assert.assertEquals(2, i);
               
    }
    

    
    @Test
    public void testaaSeuraavaPelaaja(){
        
        Peli p = luoPeli("Ossi", "Kari");
        p.tallennaPisteet();
        Pelaaja pelaaja = p.annaVuorossaOleva();
        
        Assert.assertEquals("Kari", pelaaja.annaNimi());
    }
    
    @Test
    public void testaaEnsimmainenPelaaja(){
        
        Peli p = luoPeli("Ossi", "Kari");
        Pelaaja pelaaja = p.annaVuorossaOleva();
        
        Assert.assertEquals("Ossi", pelaaja.annaNimi());
    }
    
    @Test
    public void testaaVaihdaVuoroKaksiKertaa(){
        
        Peli p = luoPeli("Ossi", "Kari");
        p.tallennaPisteet();
        p.tallennaPisteet();
        Pelaaja pelaaja = p.annaVuorossaOleva();
        
        Assert.assertEquals("Ossi", pelaaja.annaNimi());
    }
    
    @Test
    public void testaaHeittoOnEnsimmainen(){
        Peli p = luoPeli("Ossi");
        
        Assert.assertEquals(1, p.annaHeitto());
    }
    
    @Test
    public void testaaHeittoOnToinen(){
        Peli p = luoPeli("Ossi");
        try {
            p.heita();
        } catch (YatzyException ex) {
            Logger.getLogger(PeliTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assert.assertEquals(2, p.annaHeitto());
    }
    
    @Test (expected=YatzyException.class)
    public void testaaToinenPelaajaHeittaaVainKolmesti() throws YatzyException{
        
            Peli p = luoPeli("Ossi", "Kari");
            p.tallennaPisteet();
            p.heita();
            p.heita();
            p.heita();   
    }
    
    @Test
    public void testaaTallennaPisteetVaihtaaPelaajan(){
        Peli p = luoPeli("Ossi", "Kari");
        p.tallennaPisteet();
        
        Assert.assertEquals("Kari", p.annaVuorossaOleva().annaNimi());
    }
    
    @Test
    public void testaaTallennaPisteetTallensi(){
        Peli p = luoPeli("Ossi");
        Pelaaja ossi = p.annaVuorossaOleva();
        
        p.tallennaPisteet(ossi.annaTulosrivi().annaTulosruudut().get(0));
        
        Assert.assertEquals(true, ossi.annaTulosrivi().annaTulosruudut().get(0).onkoAsetettu());
    }
    
 
}
