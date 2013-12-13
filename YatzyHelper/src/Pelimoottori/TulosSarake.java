/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;

import backend.Tulosruudut.Tulosruutu;
import java.util.ArrayList;
import java.util.List;

/**
 *Hallitsee yhden pelaajan tulosruutuja
 * @author intoit
 */
public class TulosSarake {
    /**
     * Tulossarakkeeseen liittyvien tulosruutujen lista
     */
    private List<Tulosruutu> ruudut;
    
    public TulosSarake(){
         this.ruudut = new ArrayList<Tulosruutu>();
    }
    
    public void lisaaTulosrivi(Tulosruutu tulosruutu){
        this.ruudut.add(tulosruutu);
    }
    
    public List<Tulosruutu> annaTulosruudut(){
        return ruudut;
    }
}
