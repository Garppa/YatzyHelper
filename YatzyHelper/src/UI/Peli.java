/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import Pelimoottori.*;
import backend.*;
import backend.Tulosruudut.Tyyppi;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author intoit
 */
public class Peli {
    PeliAlustus alustus;
    
    
    public Peli(){
        this.alustus = new PeliAlustus();
        Scanner lukija = new Scanner(System.in);
        
        
        
        
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
    
    
}
}
