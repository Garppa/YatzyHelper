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
 * Tyypin laajennos joka tarkastaa että suora on minimimäärästä  maksimimäärään eli 1-5 tai 2-6
 * @author intoit
 */
public class Suora extends Tyyppi {
    /**
     * mistä nopasta suora liikkeelle
     */
    private int minimimaara;
    /**
     * mihin noppaan suora päättyy
     */
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
        List<Noppa> testattavatnopat = new ArrayList<Noppa>();
        testattavatnopat.addAll(nopat);
        
        Collections.sort(testattavatnopat);
        
        for(Noppa noppasuorassa : suora) {
            if(noppasuorassa.annaSilmaluku()!=testattavatnopat.get(i).annaSilmaluku()){
                return false;
            }
            i++;
        }
        return true;
    }
    
    @Override
    public Set<Noppa> sopivatNopat(Set<Noppa> nopat) {
        Set<Noppa> palautettavat = new HashSet<Noppa>();
        
        if(this.tayttyykoEhto(nopat)) {
            palautettavat.addAll(nopat);
        }                
        
        return palautettavat;
        
    }
    
    /**
     * luo suoran minimin ja maksimin väliin.
     * @return
     */
    public List<Noppa> teeSuora(){
        List<Noppa> suora = new ArrayList<Noppa>();
        for(int k = minimimaara; k<minimimaara+5; k++){
            suora.add(new Noppa(k));
        }
        return suora;
    }
        
         
}
    