/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;

import Pelimoottori.Noppa;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author intoit
 */
public abstract class Tyyppi {
    public static final int YKKOSET = 1;
    public static final int KAKKOSET = 2;
    public static final int KOLMOSET = 3;
    public static final int NELOSET = 4;
    public static final int VITOSET = 5;
    public static final int KUTOSET = 6;
    public static final int BONUS = 7;
    public static final int PARI = 8;
    public static final int KAKSI_PARIA = 9;
    public static final int KOLME_SAMAA = 10;
    public static final int NELJA_SAMAA = 11;
    public static final int PIENI_SUORA = 12;
    public static final int ISO_SUORA = 13;
    public static final int MOKKI = 14;
    public static final int SATTUMA = 15;
    public static final int YATZY = 16;
    public static final int VALISUMMA = 17;
    public static final int SUMMA = 18;
    
   public static final String[] SILMALUVUT = {"", "YKKOSET", "KAKKOSET", "KOLMOSET", "NELOSET", "VITOSET", "KUTOSET", "BONUS", 
            "PARI", "KAKSI_PARIA", "KOLME_SAMAA", "NELJA_SAMAA", "PIENI_SUORA", "ISO_SUORA", "MOKKI", "SATTUMA", "YATZY"
            , "VALISUMMA", "SUMMA"} ;

    /**
     *
     */
        public int tyyppi;
    
    public Tyyppi(){
        
    }
    
    public Map<Noppa, Integer> laskeNopittain(Set<Noppa> nopat){
        Map<Noppa, Integer> lasketutnopat = new HashMap<Noppa, Integer>();
        
        for (int i = 1; i<7 ; i++) {
            lasketutnopat.put(new Noppa(i), 0);
        }
           
        for (Noppa nopsu : nopat) {
            for (Noppa nopsuverrattava : lasketutnopat.keySet()){
                if (nopsuverrattava.annaSilmaluku()==nopsu.annaSilmaluku()) {
                    lasketutnopat.put(nopsuverrattava, (lasketutnopat.get(nopsuverrattava)+1));
                }
            
        }
                 
    }
        return lasketutnopat;
    }
    
    public boolean tayttyykoEhto(Set<Noppa> nopat){
        return false;
    }
    
        
    
    public int palautaArvo(Set<Noppa> nopat) {
        if(!this.tayttyykoEhto(nopat)) {
            return 0;
        }
        int summa = 0;
       
        for(Noppa nopsuli : nopat) {
            
            summa = summa + nopsuli.annaSilmaluku();
        }
        
        return summa;
    }
    
    public Set<Noppa> sopivatNopat(Set<Noppa> nopat) {
        return nopat;
    }
    
    public int annaTyyppi(){
        return this.tyyppi;
    }
    
    @Override
    public String toString() {
        return SILMALUVUT[tyyppi];
    }
    
}


