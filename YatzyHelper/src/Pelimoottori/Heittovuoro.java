/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;
import backend.Tulosruudut.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *Pelin avainluokkia. Yksittaisen heittovuoron hallinta
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
    
    /**
     *Palauttaa heittojen lukumäärän
     * @return heittojen lukumäärä
     */
    public int annaHeitto(){
        return this.heitto;
    }
    
    /**
     *Heittää lukitsemattomat nopat
     * @throws YatzyException mikäli heittoja ei ole jäljellä heitetään virhe
     */
    public void heita() throws YatzyException{
        if(this.onJaljella()) {
            poydalla.heitaNopat();
            heitto++;
        } else {
            throw new YatzyException();
        }
    }
    
    /**
     *Palauttaa vuorossa olevan pelaajan
     * @return vuorossa oleva pelaaja
     */
    public Pelaaja annaPelaaja(){
        return this.pelaaja;
    }
    
    /**
     *Tallentaa pisteet annettuun tulosruutuun. 0 mikäli arvo ei kelpaa.
     * @param tulosruutu    ruutu johon halutaan pisteet tallennettavan
     */
    public void tallennaPisteet(Tulosruutu tulosruutu){
        Tulosruutu tallennettava = tulosruutu;
        int summa = 0;
        //if(too.annaTyyppi().tayttyykoEhto(poydalla.annaNopat())){
            for(Noppa noppa : tallennettava.annaTyyppi().sopivatNopat(this.poydalla.annaNopat())){
                summa = summa + noppa.annaSilmaluku();
            }
            if(tallennettava.annaTyyppi().annaTyyppi()==16&&tallennettava.annaTyyppi().sopivatNopat(this.poydalla.annaNopat()).size()==5){
                summa = 50;
            }
        //}
        tallennettava.asetaPisteet(summa);
        tarkistaYlakerta();
        tarkistaLoppusumma();
        
    }
    
    /**
     * Tarkistetaan täyttyykö yläkerran 63 ja jos niin asetetaan bonusruudun arvoksi 50.
     */
    public void tarkistaBonus(){
        Tulosruutu bonus = pelaaja.annaTulosrivi().annaTulosruudut().get(6);
        
        if(pelaaja.annaTulosrivi().annaTulosruudut().get(16).annaPisteet()>62) {
                
            bonus.asetaPisteet(50);
        } else {
            bonus.asetaPisteet(0);  
        }

    }
    
    /**
     *Tarkistetaan onko yläkerta täynnä
     * @return palautuu tosi mikäli yläkerran kaikki ruudut täynnä
     */
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
    
    /**
     *Tarkistetaan josko ruudukko on täysi ja lasketaan loppusumma mikäli näin on.
     * @return
     */
    public boolean tarkistaLoppusumma(){
      
        int summa = 0;
        for (Tulosruutu ruutu : pelaaja.annaTulosrivi().annaTulosruudut()){
            if(ruutu.annaTyyppi().tyyppi!=17&&ruutu.annaTyyppi().tyyppi!=18){
                summa = summa + ruutu.annaPisteet();
            }
        }
     
        pelaaja.annaTulosrivi().annaTulosruudut().get(17).asetaPisteet(summa);
        return true;
    }
    
    /**
     *onko heittoja jäljellä
     * @return tosi, mikäli heittoja jäljellä
     */
    public boolean onJaljella(){
        return this.heitto<3;
    }
    
    /**
     *
     * @return heittovuoron pöytä
     */
    public PoydallaOlevat annaPoyta(){
        return this.poydalla;
    }
}
