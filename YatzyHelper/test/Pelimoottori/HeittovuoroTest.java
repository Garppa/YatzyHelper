/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pelimoottori;

import backend.Tulosruudut.Tulosruutu;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author intoit
 */
public class HeittovuoroTest extends PerustaTest {
    public HeittovuoroTest(){
        
    }
    
    
    @Test
    public void testaaToimiikoYlakerta(){
      Peli p = laskeTulosruutuja(0,1,2,3,4,5);
      
      Tulosruutu ylakerta = p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get(16);
      
      Assert.assertEquals(true, ylakerta.onkoAsetettu());
    }
    
    @Test
    public void testaaToimiikoBonus(){
      Peli p = laskeTulosruutuja(0,1,2,3,4,5);
      
      Tulosruutu bonus = p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get(6);
      
      Assert.assertEquals(true, bonus.onkoAsetettu());
    }
    
    @Test
    public void testaaToimiikoLoppuSummaAsettaminenLasketuksi(){
        Peli p = laskeTulosruutuja(0,1,2,3,4,5,7,8,9,10,11,12,13,14,15);
        
        Tulosruutu loppusumma = p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get(17);
        
        Assert.assertEquals(true, loppusumma.onkoAsetettu());
    }
    
    @Test
    public void testaaToimiikoLoppuSummanLaskeminen(){
        Peli p = laskeTulosruutuja(0,1,2,3,4,5,7,8,9,10,11,12,13,14,15);
        
        int summa = 0;
        for (Tulosruutu ruutu : p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut()){
            if(ruutu.annaTyyppi().tyyppi!=17&&ruutu.annaTyyppi().tyyppi!=18){
                summa = summa + ruutu.annaPisteet();
            }
        }
        
        Tulosruutu loppusumma = p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get(17);
        
        Assert.assertEquals(summa, loppusumma.annaPisteet());
    }
    
    public Peli laskeTulosruutuja(int... ruudut){
      Peli p = luoPeli("Ossi");
      
      for (int i : ruudut) {
          p.tallennaPisteet(p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get(i));
      }
      
      return p;
    }
}
