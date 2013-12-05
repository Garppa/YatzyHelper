/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.tulosruudut;

import Pelimoottori.Noppa;
import java.util.HashSet;
import java.util.Set;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author intoit
 */
public class SuoraTest extends TyyppiTest {
    public SuoraTest(){
    
    }
    
    @Test
    public void pieniSuoraKelpaa(){
        Set<Noppa> pienisuora = new HashSet<Noppa>(luoNopat(1,2,3,4,5));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.Suora(12, 1, 5);
        
        Assert.assertEquals(true, joo.tayttyykoEhto(pienisuora));
    }
    
    @Test
    public void pieniSuoraehtoeiKelpaa(){
        Set<Noppa> pienisuora = new HashSet<Noppa>(luoNopat(1,1,3,4,5));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.Suora(12, 1, 5);
        
        Assert.assertEquals(true, joo.tayttyykoEhto(pienisuora));
    }
    
    @Test
    public void isoSuoraKelpaa(){
        Set<Noppa> isosuora = new HashSet<Noppa>(luoNopat(2,3,4,5,6));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.Suora(13, 2, 6);
        
        Assert.assertEquals(true, joo.tayttyykoEhto(isosuora));
    }
    
     @Test
    public void isoSuoraKaksiKymmentaPistetta(){
        Set<Noppa>isosuora = new HashSet<Noppa>(luoNopat(2,3,4,5,6));
        backend.Tulosruudut.Tyyppi joo = new backend.Tulosruudut.Suora(13, 2, 6);
        int summa = 0;
        for (Noppa noppa: joo.sopivatNopat(isosuora)) {
            summa = summa + noppa.annaSilmaluku();
        }
        
        Assert.assertEquals(20, summa);
    }
}
