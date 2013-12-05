/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;


import Pelimoottori.Noppa;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;
import java.util.Map;
import java.util.Collections;
/**
 *
 * @author intoit
 */
public class Suora extends Tyyppi {
    private int minimimaara;
    private int maksimimaara;
    
    
    public Suora(int tyyppi, int min, int maks) {
        super.tyyppi = tyyppi;
        this.maksimimaara = maks;
        this.minimimaara = min;
    }
    
    @Override
    public boolean tayttyykoEhto(Set<Noppa> nopat) {
        List<Noppa> suora = teeSuora();
        int i = 0;
        for(Noppa noppa : suora) {
            for (Noppa testattava : nopat) {
                if (noppa.annaSilmaluku()==testattava.annaSilmaluku()){
                    i++;
                }
            }
        }
        return i==5;
    }
    
    @Override
    public Set<Noppa> sopivatNopat(Set<Noppa> nopat) {
        if(this.tayttyykoEhto(nopat)) {
            return nopat;
        }                
        
        return null;
        
    }
    
    public List<Noppa> teeSuora(){
        List<Noppa> suora = new ArrayList<Noppa>();
        for(int k = minimimaara; k<minimimaara+5; k++){
            suora.add(new Noppa(k));
        }
        return suora;
    }
        
         
}
    