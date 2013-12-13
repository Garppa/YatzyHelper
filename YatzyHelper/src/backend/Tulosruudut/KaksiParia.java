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

import Pelimoottori.Noppa;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *Kaksi paria, laajentaa tyyppiä. Tarkastaa onko annetussa setissä kahtaa erillistä paria.
 * @author kari
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
        int i = 0;
        for(Noppa noppa: nopatlistalla.keySet()) {
            if(nopatlistalla.get(noppa)>1) {
                i++;
            }
        }
            return i>1;
       }
    
    @Override
    public Set<Noppa> sopivatNopat(Set<Noppa> nopat) {
        Map<Noppa, Integer> nopatlistalla = super.laskeNopittain(nopat);
        Set<Noppa> noppaset = nopatlistalla.keySet();
        Set<Noppa> palautettavat = new HashSet<Noppa>();
        if(this.tayttyykoEhto(nopat)) {
            for(Noppa noppa: noppaset) {
                if (nopatlistalla.get(noppa)>1) {
                    palautettavat.add(new Noppa(noppa.annaSilmaluku()));
                    palautettavat.add(new Noppa(noppa.annaSilmaluku()));
                }
            }
        }
        
        return palautettavat;
        
    }
    
}