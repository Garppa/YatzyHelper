/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/**
 * Yksittäisen tulosruutuun liittyvä toiminnallisuus
 * @author Kari
 */

public class Tulosruutu {
    /**
     * Tulosruudun tyyppi
     */
    private Tyyppi tyyppi;
    /**
     * Tulosruutuun liittyvät pisteet
     */
    private int pisteet;
    /**
     * Tieto siitä, onko tulosruutuun asetettu pisteet
     */
    private boolean asetettu;
    
    public Tulosruutu(Tyyppi tyyppi){
        this.tyyppi = tyyppi;
        this.asetettu = false;
        this.pisteet = 0;
        
    }
    
    public Tyyppi annaTyyppi(){
        return this.tyyppi;
    }
    
    public void asetaPisteet(int pisteet){
        if (!this.asetettu||this.tyyppi.annaTyyppi()==18) {
            this.pisteet = pisteet;
            this.asetettu = true;
        }
    }
    
    public int annaPisteet(){
        return this.pisteet;
    }
    
    public boolean onkoAsetettu(){
        return this.asetettu;
    }
    
    @Override
    public String toString() {
        return tyyppi.toString() + ": " + pisteet;
    }
  
    

}
