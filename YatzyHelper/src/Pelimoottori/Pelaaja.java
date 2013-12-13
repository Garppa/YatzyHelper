/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;

/**
 *Pelaaja
 * @author intoit
 */
public class Pelaaja {
    String nimi;
    TulosSarake tulosrivi;
    
    public Pelaaja(String nimi) {
        
        this.nimi = nimi;
    }
    
    public String annaNimi() {
        return this.nimi;
    }
    
    public TulosSarake annaTulosrivi() {
        return this.tulosrivi;
    }
    
    /**
     *Liitetään pelaajaan oikea tulosrivi
     * @param tulosrivi
     */
    public void liitaTulosrivi(TulosSarake tulosrivi){
        this.tulosrivi = tulosrivi;
    }
    
    public String toString(){
        return this.nimi;
    }
    
}

