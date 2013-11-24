/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.Tulosruudut.Tulosruutu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intoit
 */
public class Tulosrivi {
    private List<Tulosruutu> ruudut;
    
    public Tulosrivi(){
         this.ruudut = new ArrayList<Tulosruutu>();
    }
    
    public void lisaaTulosrivi(Tulosruutu tulosruutu){
        this.ruudut.add(tulosruutu);
    }
}
