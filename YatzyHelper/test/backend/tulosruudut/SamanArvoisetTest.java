/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.tulosruudut;

import Pelimoottori.Noppa;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;
import org.junit.Test;
import backend.Tulosruudut.*;
/**
 *
 * @author intoit
 */
public class SamanArvoisetTest extends TyyppiTest{
    public SamanArvoisetTest(){
        
    }
    
    @Test
    public void testaaKutosPariKelpaa(){
        Set<Noppa> lista = new HashSet<Noppa>(luoNopat(6,6,5,4,3));
        Set<Noppa> nopat = new HashSet<Noppa>(luoNopat(1,2,3,4,5,6));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.SamanArvoiset(nopat, 8, 2, 2);
        Assert.assertEquals(true, joo.tayttyykoEhto(lista));
    }
    
    @Test
    public void testaaEiPariaEiKelpaa(){
        Set<Noppa> lista = new HashSet<Noppa>(luoNopat(6,1,5,4,3));
        Set<Noppa> nopat = new HashSet<Noppa>(luoNopat(1,2,3,4,5,6));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.SamanArvoiset(nopat, 8, 2, 2);
        Assert.assertEquals(false, joo.tayttyykoEhto(lista));
    }
    
    @Test
    public void testaaKolmosetKelpaa(){
        Set<Noppa> lista = new HashSet<Noppa>(luoNopat(6,6,6,4,3));
        Set<Noppa> nopat = new HashSet<Noppa>(luoNopat(1,2,3,4,5,6));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.SamanArvoiset(nopat, 8, 3, 3);
        Assert.assertEquals(true, joo.tayttyykoEhto(lista));
    }
    
     @Test
    public void testaaPariEiKelpaaKolmosiin(){
        Set<Noppa> lista = new HashSet<Noppa>(luoNopat(6,6,5,4,3));
        Set<Noppa> nopat = new HashSet<Noppa>(luoNopat(1,2,3,4,5,6));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.SamanArvoiset(nopat, 8, 3, 3);
        Assert.assertEquals(false, joo.tayttyykoEhto(lista));
    }
    
    @Test
    public void testaaYkkonenPalautuuYkkosista(){
        Set<Noppa> lista = new HashSet<Noppa>(luoNopat(1,6,5,4,3));
        Set<Noppa> nopat = new HashSet<Noppa>(luoNopat(1));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.SamanArvoiset(nopat, 1, 1, 5);
        int summa = 0;
        for (Noppa noppa : joo.sopivatNopat(lista)){
            summa = summa + noppa.annaSilmaluku();
        }
        Assert.assertEquals(1, summa);
    }
    
    @Test
    public void testaaKakkonenPalautuuYkkosista(){
        Set<Noppa> lista = new HashSet<Noppa>(luoNopat(1,1,5,4,3));
        Set<Noppa> nopat = new HashSet<Noppa>(luoNopat(1));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.SamanArvoiset(nopat, 1, 1, 5);
        int summa = 0;
        for (Noppa noppa : joo.sopivatNopat(lista)){
            summa = summa + noppa.annaSilmaluku();
        }
        Assert.assertEquals(2, summa);
    }
    
    @Test
    public void testaaKolmeSamaaPalauttaaOikeanNoppamäärän(){
        Set<Noppa> lista = new HashSet<Noppa>(luoNopat(1,1,1,1,3));
        Set<Noppa> nopat = new HashSet<Noppa>(luoNopat(1,2,3,4,5,6));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.SamanArvoiset(nopat, 10, 3, 3);
        int summa = 0;
        for (Noppa noppa : joo.sopivatNopat(lista)){
            summa = summa + noppa.annaSilmaluku();
        }
        Assert.assertEquals(3, summa);
    }
    
            
   
}
