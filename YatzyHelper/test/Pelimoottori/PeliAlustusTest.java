/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pelimoottori;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author intoit
 */
public class PeliAlustusTest extends PerustaTest{
    public void PelialustusTest(){
        
    }
    
    @Test
    public void testaaTyyppienlkm(){
        PeliAlustus alustus = new PeliAlustus();
        
        Assert.assertEquals(18, alustus.annaTyypit().size());
    }
    
    @Test
    public void testaaRuutujenLkmPelaajalle(){
        PeliAlustus alustus = new PeliAlustus();
       
        alustus.alustaPelaaja("Ossi");
        
        Pelaaja p = alustus.annaPelaajat().get(0);
        
        Assert.assertEquals(18, p.annaTulosrivi().annaTulosruudut().size());
        
    }
}