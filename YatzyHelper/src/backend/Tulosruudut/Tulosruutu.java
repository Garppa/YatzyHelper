/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/* @author intoit
 */

public class Tulosruutu {
    private Tyyppi tyyppi;
    private int pisteet;
    private boolean asetettu;
    
    public Tulosruutu(Tyyppi tyyppi){
        this.tyyppi = tyyppi;
        this.asetettu = false;
        this.pisteet = 0;
        
    }
    
    public Tyyppi annaTyyppi(){
        return this.tyyppi;
    }
    
    public final void asetaPisteet(int pisteet){
        if (!this.asetettu) {
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
  
    

}
