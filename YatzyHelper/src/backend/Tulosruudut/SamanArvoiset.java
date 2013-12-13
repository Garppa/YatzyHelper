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
 * Laajentaa tyypin kaikille tulosruuduille jossa etsitään yhtä samaa silmälukua n kappaletta
 * 
 * @author intoit
 */
public class SamanArvoiset extends Tyyppi {
    /**
     * pienin määrä joka riittää täyttämään ehdon
     */
    private int minimimaara;
    /**
     * suurin määrä joka täyttää ehdon
     */
    private int maksimimaara;
    /**
     * minkälaiset nopat kelpaavat
     */
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
        
        //poistetaan paria varten pienempi silmaluku
        nopatlistalla = poistaPienempiPari(nopatlistalla);
        
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
    
    /**
     * Poistaa setistä attribuutin ehtoihin sopimattomat
     * @param nopat nopat joista halutaan poistaa ylimääräiset
     * @return palauttaa setin jotka toteuttavat attribuutin
     */
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
    
    @Override
    public Map<Noppa, Integer> poistaPienempiPari(Map<Noppa, Integer> kelpoisatnopat){
        Map<Noppa, Integer> nopatlistalla = kelpoisatnopat;
        if(super.tyyppi==8) {
            Noppa poistettavanoppa = null;
            for(Noppa noppa : nopatlistalla.keySet()) {
                poistettavanoppa = noppa;
                if(nopatlistalla.get(noppa)>1){
                    if(poistettavanoppa.annaSilmaluku()>noppa.annaSilmaluku()){
                        poistettavanoppa=noppa;
                    }
                }
            }
            nopatlistalla.remove(poistettavanoppa);
        }
        return nopatlistalla;
    }

}