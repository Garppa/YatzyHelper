/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pelimoottori;

import Pelimoottori.*;
import backend.Tulosruudut.Tulosruutu;
import backend.Tulosruudut.Tyyppi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *Hoidetaan pelin hallinta ja alustukset
 * @author intoit
 */
public class Peli {
    private final PeliAlustus alustus;
    private int kierros;
    private Heittovuoro vuoro;
    
    
    public Peli(List<String> pelaajat){
        this.alustus = new PeliAlustus();
        luoPelaajat(pelaajat);
        kierros = 1;
        vuoro = new Heittovuoro(alustus.annaPelaajat().get(0));
    }

    /**
     *Kutsutaan peliin liittyvän alustuksen pelaajien luontia
     * @param pelaajat
     */
    private void luoPelaajat(List<String> pelaajat) {
        for (String pelaaja : pelaajat) {
            
            this.alustus.alustaPelaaja(pelaaja);
        }
    }
    
    public List<Pelaaja> annaPelaajat(){
        return this.alustus.annaPelaajat();
    }
    
    
        
 /*       
        System.out.println("Anna pelaajien lukumäärä:");
        
        int lkm = Integer.parseInt(lukija.nextLine());
        
        for (int k = 0; k < lkm; k++) {
            System.out.println("Anna pelaajan "+ (k+1) + " nimi:");
            this.alustus.alustaPelaaja(lukija.nextLine());
        }
        
        int i = 1;
        HeittoKierros hk = null;
        //heittokierros
        while(true){
            System.out.println(i +". kierros");
            hk = new HeittoKierros();
            Heittovuoro hv = null;
            //heittovuoro
            while (hk.kukaVuorossa()<alustus.annaPelaajat().size()) {
                System.out.println(alustus.annaPelaajat().get(hk.kukaVuorossa()).annaNimi()+ " vuorossa:");
                hv = new Heittovuoro(alustus.annaPelaajat().get(hk.kukaVuorossa()));
                System.out.println("Nopat:");
                hv.heita();
                int syote = 0;
                int syote2 = 0;

                //heittovuoron yhden kierroksen looppi
                while(true) {
                    System.out.println(hv.annaPoyta().toString());
                    System.out.println("Valitse nopat (1-5), toinen kerta vapauttaa");
                    System.out.println("Heitä uudestaan 6");
                    System.out.println("Talleta 7");
                    System.out.println("Mitä teet:");
                    syote = Integer.parseInt(lukija.nextLine());
                    if(syote == 7) {
                        System.out.println("Mikä tulosruutu 1-16");
                        syote2 = Integer.parseInt(lukija.nextLine());
                        if (!hv.annaPelaaja().annaTulosrivi().annaTulosruudut().get((syote2-1)).onkoAsetettu()) {
                            hv.tallennaPisteet(hv.annaPelaaja().annaTulosrivi().annaTulosruudut().get((syote2-1)));
                            System.out.println("pisteitä tuli: " +hv.annaPelaaja().annaTulosrivi().annaTulosruudut().get((syote2-1)).annaPisteet());
                            break;
                        }
                        
                        
                    }
                    
                    else if (syote>0&&syote<6){
                        hv.annaPoyta().valitseNoppa(syote);
                    }
                    
                    else if (syote==6) {
                        if (hv.onJaljella()) {
                            hv.heita();
                           
                        }
                        else {
                            System.out.println("ei heittoja jaljella");
                        }
                }
                  //tästä pitäs jatkua sitten perjantaina  
                
            }
            
            
            
            
        }
        

        
    }
    
    
}*/

    public int annaKierros() {
        return kierros;
    }

    private void vaihdaKierros() {
        kierros++;
    }

    private void seuraavaPelaaja() {
        
        int seuraava = alustus.annaPelaajat().indexOf(vuoro.annaPelaaja())+1;
        if(seuraava==alustus.annaPelaajat().size()) {
            vaihdaKierros();
            seuraava = 0;
        }
        vuoro = new Heittovuoro(alustus.annaPelaajat().get(seuraava));
    }

    public Pelaaja annaVuorossaOleva() {
        return vuoro.annaPelaaja();
    }

    public int annaHeitto() {
        return vuoro.annaHeitto();
    }
    
    public Noppa annaNoppa(int paikka) {
        return vuoro.annaPoyta().annaNoppaPaikkaan(paikka);
    }

    /**
     *@see Heittovuoro.heita()
     * @throws YatzyException mikäli heittoja ei ole enää jäljellä niin poikkeus lentää
     */
    public void heita() throws YatzyException {
        vuoro.heita();
    }

    /**
     *tallentaa pisteet annettuun tulosruutuun kutsumalla vuoron metodia tallennaPisteet()
     * Tarkastaa myos onko ruutuun jo asetettu arvo. Mikali tallennus onnistuu on pelaaja vaihtuu.
     * 
     * @param tulosruutu
     */
    public void tallennaPisteet(Tulosruutu tulosruutu) {
        if(!tulosruutu.onkoAsetettu()) {
            vuoro.tallennaPisteet(tulosruutu);
            seuraavaPelaaja();
        }
    }
    
    /**
     *muuttaa nopan paikan tilaa
     * @param valinta
     */
    public void muutaPaikanTila(int valinta){
        vuoro.annaPoyta().valitsePaikka(valinta);
    }
    
    /**
     *Palauttaa nopan paikan tilan
     * @param paikka nopan paikka
     * @return palauttaa tiedon onko valittu vai vapaa (true on valittu)
     */
    public boolean annaPaikanTila(int paikka){
        return vuoro.annaPoyta().onValittu(paikka);
    }
    
    public void tallennaPisteet() {
    
    seuraavaPelaaja();
    }
    
    
}
