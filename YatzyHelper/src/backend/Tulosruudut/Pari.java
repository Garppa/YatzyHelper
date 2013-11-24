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
    
    public Pari(int tyyppi) {
        super.tyyppi = tyyppi;
        this.maksimimaara = 2;
        this.minimimaara = 2;
        
    }
    
    
}
