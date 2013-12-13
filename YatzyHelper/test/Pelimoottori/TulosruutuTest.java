/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pelimoottori;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author intoit
 */
public class TulosruutuTest extends PerustaTest{
    public TulosruutuTest(){
        
    }
   @Test
   public void pisteidenJalkeenOnAsetettu(){
        Peli p = luoPeli("Ossi");

        p.tallennaPisteet(p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get(0));
        
        
        Assert.assertEquals(true, p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get(0).onkoAsetettu());
   }
   
      @Test
   public void josEiPisteitaEiAsetettu(){
        Peli p = luoPeli("Ossi");     
        
        Assert.assertEquals(false, p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get(0).onkoAsetettu());
   }
}
