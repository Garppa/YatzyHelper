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
public class PoydallaOlevat {
    private List<Noppa> nopat;
    
    public PoydallaOlevat() {
        this.nopat = new ArrayList<Noppa>();
    }
    
    public boolean lisaaNoppa(Noppa noppa) {
        if(voikoLisata()) {
            this.nopat.add(noppa);
            return true;
        }
        return false;
    }
    
    public void poistaNoppa(Noppa noppa) {
        this.nopat.remove(noppa);
    }
    
    public void valitseNoppa(Noppa noppa) {
        
    }
    
    public boolean onPoydalla(Noppa noppa){
        if(this.nopat.contains(noppa)) {
            return true;
        }
        return false;
    }
    
    public String toString(){
        String pulautus = "" + nopat.get(0).annaSilmaluku();
            
            for(int i = 1; i < nopat.size(); i++) {
            pulautus = pulautus + ", " + nopat.get(i).annaSilmaluku();
        }   
        return pulautus;
    }
    
    public List<Noppa> annaNopat(){
        return this.nopat;
    }
    
    private boolean voikoLisata() {
        if (this.nopat.size()<5) {
            return true;
        }
        return false;
    }
}

