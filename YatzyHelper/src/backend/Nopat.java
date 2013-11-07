/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intoit
 */
public class Nopat {
    private List<Noppa> nopat;
    
    public Nopat() {
        this.nopat = new ArrayList<Noppa>();
    }
    
    public void lisaaNoppa(Noppa noppa) {
        this.nopat.add(noppa);
    }
    
    public void poistaNoppa(Noppa noppa) {
        this.nopat.remove(noppa);
    }
    
    public void valitseNoppa(Noppa noppa) {
        
    }
    
    public String toString(){
        String pulautus = "" + nopat.get(0).annaSilmaluku();
            
            for(int i = 1; i < nopat.size(); i++) {
            pulautus = pulautus + ", " + nopat.get(i).annaSilmaluku();
        }   
        return pulautus;
    }
}

