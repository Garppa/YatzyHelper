/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;

import backend.Noppa;
import java.util.Map;
import java.util.Set;

/**
 *
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
    public Set<Noppa> sopivatNopat(Set<Noppa> nopat, int arvo) {
        if(this.tayttyykoEhto(nopat)) {
            return nopat;
        }
        
        return null;
        
    }
    
}
