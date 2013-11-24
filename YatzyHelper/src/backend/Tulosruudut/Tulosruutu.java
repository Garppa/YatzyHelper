/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;

/**
 *
 * @author intoit
 */
public class Tulosruutu {
    private String nimi;    
    private Tyyppi tyyppi;
    private int pisteet;
    
    public Tulosruutu(String nimi, Tyyppi tyyppi){
        this.nimi = nimi;
        this.tyyppi = tyyppi;
        this.pisteet = 0;
    }
    
}
