/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import Pelimoottori.Noppa;
import Pelimoottori.Pelaaja;
import Pelimoottori.Peli;
import Pelimoottori.YatzyException;
import backend.Tulosruudut.Tulosruutu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kari_000
 */
public class PeliClient {
    private Scanner lukija;
    public PeliClient(){
        lukija = new Scanner(System.in);
    }
    
    public void kaynnista(){
        
        System.out.println("Anna pelaajien lukumaara");
        int pelaajia = Integer.parseInt(lukija.nextLine());
        
        
        
        List<String> pelaajat = new ArrayList<String>();
        
        int k = 1;
        System.out.println("Anna nimet");
        
        while (k<pelaajia+1){
            System.out.println("Pelaaja " + k);
            pelaajat.add(lukija.nextLine());
            k++;
        
        }
        
        Peli p = new Peli(pelaajat);
        int valinta = 0;
        int tyyppi = 0;
        while(p.annaKierros()<16) {
            
                System.out.println("Kierros: " + p.annaKierros());
                System.out.println(p.annaVuorossaOleva().annaNimi() + " vuorossa");
                System.out.println("Heitto:" + p.annaHeitto());
                System.out.println("Nopat:");
                for(int i = 1; i<6; i++) {
                    System.out.println(i+": "+ p.annaNoppa(i).annaSilmaluku()+" "+ tulostaV(i,p));
                }
                System.out.println("Mitä teet?");
                System.out.println("1-5 lukitsee");
                System.out.println("6 heittää uudestaan");
                System.out.println("99 tallentaa");
                valinta = Integer.parseInt(lukija.nextLine());
                if (valinta==99) {
                    System.out.println("Mikä ruutu:");
                    int k2=1;
                    for(Tulosruutu ruutu: p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut()) {
                        System.out.println(k2+": " +ruutu.toString());
                        k2++;
                    }
                    tyyppi = Integer.parseInt(lukija.nextLine());
                    p.tallennaPisteet(p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get((tyyppi-1)));
                    System.out.println(p.annaVuorossaOleva().annaTulosrivi().annaTulosruudut().get((tyyppi-1)).toString());
                    
                } else if (valinta>0&&valinta<6){
                        p.muutaPaikanTila(valinta);
                        
                } else if (valinta==6){
                    try {
                        p.heita();
                    } catch (YatzyException ex) {
                        System.out.println("ei voi enää heittää, kaikki on mennyt");
                    }
                }
        }
        
        for (Pelaaja pelaaja: p.annaPelaajat()) {
            System.out.println(pelaaja.annaNimi()+": "+ pelaaja.annaTulosrivi().annaTulosruudut().get(17));
        }
        }
    
       public String tulostaV(int i,Peli p){
           if(p.annaPaikanTila(i)) {
               return "v";
           }
           return "";
       }     
           
}
