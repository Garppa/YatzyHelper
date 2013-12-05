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
        int i = 0;
        for (Noppa noppa : nopatlistalla.keySet()) {
            if (nopatlistalla.get(noppa)>i){
                i=nopatlistalla.get(noppa);
            }
        
        }
        return (i>=minimimaara);
    
    }
        

    @Override
    public Set<Noppa> sopivatNopat(Set<Noppa> nopat) {
        Set<Noppa> kelpoisatnopat = new HashSet<Noppa>(poistaKelpaamattomatSetista(nopat)); 
        Map<Noppa, Integer> nopatlistalla = super.laskeNopittain(kelpoisatnopat);
        Set<Noppa> palautettavat = new HashSet<Noppa>(); 
         for (Noppa noppa : nopatlistalla.keySet()) {
             if(nopatlistalla.get(noppa)>=minimimaara){
                 if(minimimaara==maksimimaara){
                     for(int k = 0; k<minimimaara; k++) {
                         palautettavat.add(new Noppa(noppa.annaSilmaluku()));
                     }
                 } else {
                     for(int k = 0; k<nopatlistalla.get(noppa); k++) {
                         palautettavat.add(new Noppa(noppa.annaSilmaluku()));
                 }
             }
         }
        }
         return palautettavat;
    }
    
    public Set<Noppa> poistaKelpaamattomatSetista(Set<Noppa> nopat){
        Set<Noppa> kelpoisat = new HashSet<Noppa>();
        for(Noppa noppa: nopat){
            for(Noppa noppakelpaa:kelpaavatnopat){
                if(noppakelpaa.annaSilmaluku()==noppa.annaSilmaluku()){
                    kelpoisat.add(noppa);
                }
            }
        }
        return kelpoisat;
    }

}