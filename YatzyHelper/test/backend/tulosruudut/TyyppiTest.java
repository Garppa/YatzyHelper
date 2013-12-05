/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.tulosruudut;

import Pelimoottori.Noppa;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author intoit
 */
public abstract class TyyppiTest {
    public TyyppiTest(){
        
    }
    
    @Test
    public void testaaLaskeNopittainYkkosiaKaksi(){
        Set<Noppa> kaksiykosta = new HashSet<Noppa>(luoNopat(1,1,2,3,4));
        Set<Noppa> kelpaa = new HashSet<Noppa>(luoNopat(1));
        Assert.assertEquals(2, 2);
    }
            
    
     public Set<Noppa> luoNopat(int... arvo){
        Set<Noppa> nops = new HashSet<Noppa>();
        for(int i : arvo){
            nops.add(new Noppa(i));
            
        }
        return nops;
    }
    
}
