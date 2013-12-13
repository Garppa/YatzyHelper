/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;

import Pelimoottori.Noppa;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Laajentaa tyyppiä, testaa löytyykö kädestä pari ja kolme samaa eri silmäluvuista
 * @author intoit
 */
public class Mokki extends Tyyppi {
    public Mokki(int tyyppi) {
        super.tyyppi=tyyppi;
}
    
    /**
     *
     * @param nopat
     * @return
     */
    @Override
    public boolean tayttyykoEhto(Set<Noppa> nopat){
        Map<Noppa, Integer> nopatlistalla = super.laskeNopittain(nopat);
        
        return nopatlistalla.containsValue(2)&&nopatlistalla.containsValue(3);
    }
    
    @Override
    public Set<Noppa> sopivatNopat(Set<Noppa> nopat) {
         Set<Noppa> palautettavat = new HashSet<Noppa>();
        if(this.tayttyykoEhto(nopat)) {
            palautettavat.addAll(nopat);
        }
        
        return palautettavat;
        
    }
    
}
