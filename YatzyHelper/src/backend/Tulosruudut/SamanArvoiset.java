/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;


import backend.Noppa;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author intoit
 */
public class SamanArvoiset extends Tyyppi {
    private int minimimaara;
    private int maksimimaara;
    Set<Noppa> kelpaavatnopat;
    
    public SamanArvoiset(Set<Noppa> nopat, int tyyppi, int min, int maks) {
        super.tyyppi = tyyppi;
        this.maksimimaara = maks;
        this.minimimaara = min;
        this.kelpaavatnopat = new HashSet<Noppa>(nopat);
    }
    
    //@Override

    /**
     *
     * @param nopat
     * @return
     */
    @Override
    public boolean tayttyykoEhto(Set<Noppa> nopat) {

    Map<Noppa, Integer> nopatlistalla = super.laskeNopittain(nopat);

    for ( Noppa nopsuli : nopatlistalla.keySet()) {
        if(nopatlistalla.get(nopsuli)>=this.minimimaara && kelpaavatnopat.contains(nopsuli)) {
            return true;
        }

        }
    return false;
    }
        

    @Override
    public Set<Noppa> sopivatNopat(Set<Noppa> nopat) {
        
        
        Set<Noppa> nopsut = new HashSet<Noppa>();
        
        Map<Noppa, Integer> nopatlistalla = super.laskeNopittain(nopat);
        //t'h'n pitää vielä huomioida pari ja jotenkin paremmin noi yläkerran arvot. Voi olla monta...
        
        for ( Noppa nopsuli : nopatlistalla.keySet()) {
            if(nopatlistalla.get(nopsuli)>=this.minimimaara && nopsuli.annaSilmaluku()==super.tyyppi) {
                if (this.minimimaara==this.maksimimaara) {
                    for (int i=0; i<this.minimimaara; i++) {
                        nopsut.add(nopsuli);
                    } 
        
                }else {
                    for (int i=0; i<nopatlistalla.get(nopsuli); i++) {
                        nopsut.add(nopsuli);
                    }
                    
                }
                            
                            
                return nopsut;
            }
        }   
        return nopsut;
    }
}