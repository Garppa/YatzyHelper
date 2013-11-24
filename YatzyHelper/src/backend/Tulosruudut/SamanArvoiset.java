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

/**
 *
 * @author intoit
 */
public class SamanArvoiset extends Tyyppi {
    private int minimimaara;
    private int maksimimaara;
    Set<Noppa> kelpaavanopat;
    
    public SamanArvoiset(Set<Noppa> nopat, int tyyppi, int maks, int min) {
        super.tyyppi = tyyppi;
        this.maksimimaara = maks;
        this.minimimaara = min;
        this.kelpaavanopat = new HashSet<Noppa>(nopat);
    }
    
    //@Override 
    public boolean tayttyykoEhto(List<backend.Noppa> nopat) {
        for ( backend.Noppa nopsuli : nopat) {
            if (nopsuli.annaSilmaluku() == this.noppa.annaSilmaluku() ) {
                return true;
            }
        }
        return false;
        }
    
    public int palautaArvo(List<backend.Noppa> nopat) {
        if(!this.tayttyykoEhto(nopat)) {
            return 0;
        }
        int summa = 0;
        List<backend.Noppa> nopsut = this.sopivatNopat(nopat);
        for(backend.Noppa nopsuli : nopsut) {
            
            summa = summa + nopsuli.annaSilmaluku();
        }
        
        return summa;
    }
    
    public List<backend.Noppa> sopivatNopat(List<backend.Noppa> nopat) {
        List<backend.Noppa> nopsut = new ArrayList<backend.Noppa>();
        
        for (backend.Noppa nopeli : nopat) {
            if (nopeli.annaSilmaluku() == this.noppa.annaSilmaluku()) {
                nopsut.add(nopeli);
            }
        }
        return nopsut;
    }
}
