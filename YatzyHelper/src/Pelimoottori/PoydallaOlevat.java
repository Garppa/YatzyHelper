/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Pelimoottori.*;
import java.util.HashSet;
import java.util.Set;

/**
 *Hallitsee pöydällä olevia noppia
 * @author intoit
 */
public class PoydallaOlevat {
    /**
     * Taulu pöydällä olevista nopista, jokaisella oma "paikka".
     */
    private Map<Noppa, Integer> nopat;
    /**
     * arpoja, jolta saadaan nopille silmäluvut
     */
    private Arpoja arpoja;
    /**
     * Taulu paikoista ja niiden valittuna olemisen tilasta
     */
    private Map<Integer, Boolean> valitut;
    
    public PoydallaOlevat() {
        this.nopat = new HashMap<Noppa, Integer>();
        this.arpoja = new Arpoja();
        this.valitut = new HashMap<Integer, Boolean>();
    }
    
    /**
     * Nopan lisäys pöydälle
     * @param noppa noppa joka lisätään pöydälle
     * @return palauttaa true, mikäli onnistui
     */
    public boolean lisaaNoppa(Noppa noppa) {
        if(voikoLisata()) {
            int paikka = this.annaVapaa();
            this.nopat.put(noppa, paikka);
            this.valitut.put(paikka, false);
            return true;
        }
        return false;
    }
    
    /**
     *Antaa ensimmäisen tyhjän paikan pöydältä
     * @return palauttaa 0 mikäli ei vapaita paikkoja, oletuksena joku on.
     */
    public int annaVapaa(){
        for(int i = 1; i < 6; i++ ) {
            if(!nopat.containsValue(i)){
                return i;
            }
        }
        return 0;
    }
    
    /**
     *poistaa nopan pöydältä
     * @param noppa
     */
    public void poistaNoppa(Noppa noppa) {
        int paikka = nopat.get(noppa);
        this.nopat.remove(noppa);
        this.valitut.remove(paikka);
    }
    
    /**
     *paikka ja sitä myöten sillä oleva noppa valitaan valituksi
     * @param valinta arvo 1-6
     */
    public void valitsePaikka(int valinta) {
        
        if (!this.onValittu(valinta)) {
        valitut.put(valinta, true);
        } else {
            valitut.put(valinta, false);
        }
        
    }
    
    /**
     *Palauttaa tiedon onko noppa pöydällä
     * @param noppa Noppa jonka tila halutaan tietää
     * @return Tosi jos noppa on pöydällä
     */
    public boolean onPoydalla(Noppa noppa){
        return this.nopat.containsKey(noppa);
    }
    
    /**
     *Palauttaa tiedon onko paikka valittuna
     * @param valittu paikka jonka tila halutaan tietää
     * @return tosi jos paikka on valittuna.
     */
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

    /**
     *Heittää kaikki nopat joita ei ole valittuna
     */
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

    /**
     *Palauttaa nopan tietylle paikalle
     * @param paikka minkä paikan noppa halutaan
     * @return Noppa joka sijaitsi parametrin paikalla.
     */
    public Noppa annaNoppaPaikkaan(int paikka) {
        for (Noppa noppa : nopat.keySet()) {
            if(nopat.get(noppa)==paikka){
                return noppa;
            }
        }
        return null;
    }
}

