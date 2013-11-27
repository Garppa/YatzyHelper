/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;

import backend.Noppa;
import java.util.Set;

/**
 *
 * @author intoit
 */
public class Sattuma extends Tyyppi {
    public Sattuma(int tyyppi){
        super.tyyppi = tyyppi;
    }
    
    @Override
    public boolean tayttyykoEhto(Set<Noppa> nopat){
        return true;
    }
}
