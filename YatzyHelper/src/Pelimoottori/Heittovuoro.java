/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;
import backend.Tulosruudut.*;
/**
 *
 * @author intoit
 */
public class Heittovuoro {
    private int heitto;
    private PoydallaOlevat poydalla;
    private Pelaaja pelaaja;
    
    public Heittovuoro(Pelaaja pelaaja) {
        this.heitto=0;
        this.poydalla = new PoydallaOlevat();
        this.pelaaja = pelaaja;
        heita();
                                                                                                                                   
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
        if(too.annaTyyppi().tayttyykoEhto(poydalla.annaNopat())){
            for(Noppa noppa : too.annaTyyppi().sopivatNopat(this.poydalla.annaNopat())){
                summa = summa + noppa.annaSilmaluku();
            }
            
        }
        too.asetaPisteet(summa);
    }
    
    public void tarkistaBonus(){
        Tulosruutu bonus = pelaaja.annaTulosrivi().annaTulosruudut().get(6);
        int ylakerta = 0;
        if(bonus.annaPisteet()==0) {
            for(int i = 0; i < 6; i++) {
                ylakerta = ylakerta + pelaaja.annaTulosrivi().annaTulosruudut().get(i).annaPisteet();
            }
        }
        
        if (ylakerta>62){
            pelaaja.annaTulosrivi().annaTulosruudut().get(6).asetaPisteet(50);
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
        pelaaja.annaTulosrivi().annaTulosruudut().get(17).asetaPisteet(valisumma);
        return true;
    }
    
    public boolean onJaljella(){
        return this.heitto<3;
    }
    
    public PoydallaOlevat annaPoyta(){
        return this.poydalla;
    }
}
