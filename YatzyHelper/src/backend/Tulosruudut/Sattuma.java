/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Tulosruudut;

import Pelimoottori.Noppa;
import java.util.Set;

/**
 * Laajentaa tyyppiä. Kaikki nopat käyvät.
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
