/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;
import backend.Tulosruudut.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author intoit
 */
public class Heittovuoro {
    private int heitto;
    private PoydallaOlevat poydalla;
    private Pelaaja pelaaja;
    
    public Heittovuoro(Pelaaja pelaaja){
        this.heitto=0;
        this.poydalla = new PoydallaOlevat();
        this.pelaaja = pelaaja;
        try {
            heita();
        } catch (YatzyException ex) {
            Logger.getLogger(Heittovuoro.class.getName()).log(Level.SEVERE, null, ex);
        }
                                                                                                                                   
    }
    
    public int annaHeitto(){
        return this.heitto;
    }
    
    public void heita() throws YatzyException{
        if(this.onJaljella()) {
            poydalla.heitaNopat();
            heitto++;
        } else {
            throw new YatzyException();
        }
    }
    
    public Pelaaja annaPelaaja(){
        return this.pelaaja;
    }
    
    public void tallennaPisteet(Tulosruutu joo){
        Tulosruutu too = joo;
        int summa = 0;
        //if(too.annaTyyppi().tayttyykoEhto(poydalla.annaNopat())){
            for(Noppa noppa : too.annaTyyppi().sopivatNopat(this.poydalla.annaNopat())){
                summa = summa + noppa.annaSilmaluku();
            }
            if(too.annaTyyppi().annaTyyppi()==15&&too.annaTyyppi().sopivatNopat(this.poydalla.annaNopat()).size()==5){
                summa = 50;
            }
        //}
        too.asetaPisteet(summa);
        tarkistaYlakerta();
        tarkistaLoppusumma();
        
    }
    
    public void tarkistaBonus(){
        Tulosruutu bonus = pelaaja.annaTulosrivi().annaTulosruudut().get(6);
        
        if(pelaaja.annaTulosrivi().annaTulosruudut().get(16).annaPisteet()>62) {
                
            bonus.asetaPisteet(50);
        } else {
            bonus.asetaPisteet(0);  
        }

    }
    
    public boolean tarkistaYlakerta(){
        int valisumma = 0;
        for (int i = 0; i < 6 ; i++) {
            if(!pelaaja.annaTulosrivi().annaTulosruudut().get(i).onkoAsetettu()) {
                return false;
            }
            valisumma = valisumma + pelaaja.annaTulosrivi().annaTulosruudut().get(i).annaPisteet();
        }
        pelaaja.annaTulosrivi().annaTulosruudut().get(16).asetaPisteet(valisumma);
        tarkistaBonus();
        return true;
    }
    
    public boolean tarkistaLoppusumma(){
        for (int i = 7; i < 17 ; i++) {
            if(!pelaaja.annaTulosrivi().annaTulosruudut().get(i).onkoAsetettu()) {
                return false;
            }
            
        
        }
        int summa = 0;
        for (Tulosruutu ruutu : pelaaja.annaTulosrivi().annaTulosruudut()){
            if(ruutu.annaTyyppi().tyyppi!=17&&ruutu.annaTyyppi().tyyppi!=18){
                summa = summa + ruutu.annaPisteet();
            }
        }    
        pelaaja.annaTulosrivi().annaTulosruudut().get(17).asetaPisteet(summa);
        return true;
    }
    
    public boolean onJaljella(){
        return this.heitto<3;
    }
    
    public PoydallaOlevat annaPoyta(){
        return this.poydalla;
    }
}
