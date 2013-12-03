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
    private Map<Noppa, Integer> nopat;
    private Arpoja arpoja;
    private Map<Integer, Boolean> valitut;
    
    public PoydallaOlevat() {
        this.nopat = new HashMap<Noppa, Integer>();
        this.arpoja = new Arpoja();
        this.valitut = new HashMap<Integer, Boolean>();
    }
    
    public boolean lisaaNoppa(Noppa noppa) {
        if(voikoLisata()) {
            int paikka = this.annaVapaa();
            this.nopat.put(noppa, paikka);
            this.valitut.put(paikka, false);
            return true;
        }
        return false;
    }
    
    public int annaVapaa(){
        for(int i = 1; i < 6; i++ ) {
            if(!nopat.containsValue(i)){
                return i;
            }
        }
        return 0;
    }
    
    public void poistaNoppa(Noppa noppa) {
        int paikka = nopat.get(noppa);
        this.nopat.remove(noppa);
        this.valitut.remove(paikka);
    }
    
    public void valitseNoppa(int valinta) {
        
        if (!this.onValittu(valinta)) {
        valitut.put(valinta, true);
        } else {
            valitut.put(valinta, false);
        }
        
    }
    
    public boolean onPoydalla(Noppa noppa){
        return this.nopat.containsKey(noppa);
    }
    
    public boolean onValittu(int valittu) {
        return (this.valitut.get(valittu)==true);
    }
    
    @Override
    public String toString(){
        String palautus = "";
        for (Noppa noppa : nopat.keySet() ) {
            palautus = palautus + nopat.get(noppa) + noppa.annaSilmaluku() + "\n";
        
        }    
            
        return palautus;
    }
    
    
    public Set<Noppa> annaNopat(){
        return this.nopat.keySet();
    }
    
    public Map<Noppa,Integer> annaNoppaPaikat(){
        return this.nopat;
    }
    
    private boolean voikoLisata() {
        return this.nopat.size()<5;
    }
   
    
    public void heitaNopat(){
        if (nopat.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                this.lisaaNoppa(new Noppa(arpoja.annaArvo()));
            }
        } else {
            Set<Noppa> nopsut = new HashSet<Noppa>(nopat.keySet());
            for (Noppa noppa : nopsut) {
                if (!valitut.get(nopat.get(noppa))) {
                    this.poistaNoppa(noppa);
                    this.lisaaNoppa(new Noppa(arpoja.annaArvo()));
                }
            }
        }
    }
}

