/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;

/**
 *
 * @author intoit
 */
public class Pari extends Tyyppi{
    private int minimimaara;
    private int maksimimaara;
    private backend.Noppa noppa;
    
    public Pari(int silmaluku, String nimi) {
        super.nimi = nimi;
        this.maksimimaara = 2;
        this.minimimaara = 2;
        
    }
    
    
}
