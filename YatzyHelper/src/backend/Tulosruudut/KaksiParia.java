/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;

import backend.Noppa;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author intoit
 */
public class KaksiParia extends Tyyppi {
    public KaksiParia(int tyyppi) {
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
        
        return (nopatlistalla.containsValue(2)&&nopatlistalla.containsValue(3))||(nopatlistalla.containsValue(2)&&nopatlistalla.containsValue(2));
    }
    
    @Override
    public Set<Noppa> sopivatNopat(Set<Noppa> nopat) {
        Map<Noppa, Integer> nopatlistalla = super.laskeNopittain(nopat);
        Set<Noppa> noppaset = nopatlistalla.keySet();
        Set<Noppa> palautettavat = new HashSet<Noppa>();
        if(this.tayttyykoEhto(nopat)) {
            for(Noppa noppa: noppaset) {
                if (nopatlistalla.get(noppa)>1) {
                    palautettavat.add(noppa);
                    palautettavat.add(noppa);
                }
            }
        }
        
        return palautettavat;
        
    }
    
}