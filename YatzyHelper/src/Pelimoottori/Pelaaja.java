/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;
import backend.Tulosrivi;

/**
 *
 * @author intoit
 */
public class Pelaaja {
    String nimi;
    Tulosrivi tulosrivi;
    
    public Pelaaja(String nimi) {
        
        this.nimi = nimi;
    }
    
    public String annaNimi() {
        return this.nimi;
    }
    
    public Tulosrivi annaTulosrivi() {
        return this.tulosrivi;
    }
    
    public void liitaTulosrivi(Tulosrivi tulosrivi){
        this.tulosrivi = tulosrivi;
    }
    
}

