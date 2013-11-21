/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author intoit
 */
public class Valitutnopat {
    private List<Noppa> valitut;
    private PoydallaOlevat poydalla;
	
	public Valitutnopat(PoydallaOlevat poydalla) {
		this.valitut = new ArrayList<Noppa>();
                this.poydalla = poydalla;
	}
	
	public void valitseNoppa(Noppa noppa) {
		if (poydalla.onPoydalla(noppa)) {
			this.valitut.add(noppa);
		}
	}
	
	public void poistaNoppa(Noppa noppa) {
		if (this.onValittu(noppa)) {
			this.valitut.remove(noppa);
		}
	}
	
	public List<Noppa> annaValitut() {
		return this.valitut;
	}
        
        public boolean onValittu(Noppa noppa) {
            if(this.valitut.contains(noppa)) {
                return true;
            }
            return false;
        }
	
}
    

