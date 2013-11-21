/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.Tulosruudut.Tulosruutu;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author intoit
 */
public class Tuloskortti {
    private List<Tulosruutu> ruudut;
    
    public Tuloskortti(){
        this.ruudut = new ArrayList<Tulosruutu>();
        
        ruudut.add(null);
    }
}
