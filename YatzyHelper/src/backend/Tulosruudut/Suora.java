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

    
    List<Noppa> sortataan = new ArrayList<Noppa>();
            sortataan.addAll(nopat);
    Collections.sort(sortataan);
    int i=this.minimimaara;
    for ( Noppa nopsuli : sortataan) {
        if (nopsuli.annaSilmaluku()==i){
            i++;
        } else {
            break;
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
         
}
    