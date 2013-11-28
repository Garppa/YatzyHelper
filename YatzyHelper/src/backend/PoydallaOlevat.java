/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Pelimoottori.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author intoit
 */
public class PoydallaOlevat {
    private Map<Noppa, Boolean> nopat;
    private Arpoja arpoja;
    
    public PoydallaOlevat() {
        this.nopat = new HashMap<Noppa, Boolean>();
        this.arpoja = new Arpoja();
    }
    
    public boolean lisaaNoppa(Noppa noppa) {
        if(voikoLisata()) {
            this.nopat.put(noppa, false);
            return true;
        }
        return false;
    }
    
    public void poistaNoppa(Noppa noppa) {
        this.nopat.remove(noppa);
    }
    
    public void valitseNoppa(Noppa noppa) {
        this.nopat.put(noppa, true);
    }
    
    public boolean onPoydalla(Noppa noppa){
        return this.nopat.containsKey(noppa);
    }
    
    @Override
    public String toString(){
        String palautus = "";
        int i = 0;
        for (Noppa noppa : nopat.keySet() ) {
            palautus = palautus + noppa.annaSilmaluku();
        
            if(i<4) {
                palautus = palautus + ", ";
            }
            
            i++;
        }    
            
        return palautus;
    }
    
    
    public Set<Noppa> annaNopat(){
        return this.nopat.keySet();
    }
    
    private boolean voikoLisata() {
        if (this.nopat.size()<5) {
            return true;
        }
        return false;
    }
    
    public void heitaNopat(){
        if (nopat.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                this.lisaaNoppa(new Noppa(arpoja.annaArvo()));
            }
        } else {
            Set<Noppa> nopsut = new HashSet<Noppa>(nopat.keySet());
            for (Noppa noppa : nopsut) {
                if (!nopat.get(noppa)) {
                    this.poistaNoppa(noppa);
                    this.lisaaNoppa(new Noppa(arpoja.annaArvo()));
                }
            }
        }
    }
}

