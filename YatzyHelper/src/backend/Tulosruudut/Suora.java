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

    Map<Noppa, Integer> nopatlistalla = super.laskeNopittain(nopat);
    Set<Noppa> sortataan = nopatlistalla.keySet();
    sortataan.
    for ( Noppa nopsuli : nopatlistalla.keySet()) {
        

        }
    return false;
    }
         
}
    