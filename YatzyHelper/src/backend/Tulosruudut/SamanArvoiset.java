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

/**
 *
 * @author intoit
 */
public class SamanArvoiset extends Tyyppi {
    private int minimimaara;
    private int maksimimaara;
    Set<Noppa> kelpaavatnopat;
    
    public SamanArvoiset(Set<Noppa> nopat, int tyyppi, int maks, int min) {
        super.tyyppi = tyyppi;
        this.maksimimaara = maks;
        this.minimimaara = min;
        this.kelpaavatnopat = new HashSet<Noppa>(nopat);
    }
    
    //@Override 
    public boolean tayttyykoEhto(List<Noppa> nopat) {
        int laskuri = 0;
        for ( Noppa nopsuli : nopat) {
            for (Noppa noppavert : this.kelpaavatnopat) {
                if(nopsuli.compareTo(noppavert)==0) {
                    laskuri++;
                }
                
            }
  
        }
        
        if(laskuri>=minimimaara) { 
            return true;
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
    
    public List<Noppa> sopivatNopat(List<Noppa> nopat) {
        List<Noppa> nopsut = new ArrayList<Noppa>();
        
        for (Noppa nopeli : nopat) {
            if (this.kelpaavatnopat.equals(nopeli)) {
                nopsut.add(nopeli);
            }
        }
        return nopsut;
    }
}
