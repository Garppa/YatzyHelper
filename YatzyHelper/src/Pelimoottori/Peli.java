/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pelimoottori;
import java.util.List;
import java.util.ArrayList;
import backend.*;
import backend.Tulosruudut.*;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author kari_000
 */
public class Peli {
    List<Pelaaja> pelaajat;
    List<Tyyppi> tyypit;

    public Peli(){
        this.pelaajat = new ArrayList<Pelaaja>();
        this.tyypit = new ArrayList<Tyyppi>();
    }

    public boolean alustaPelaaja(String nimi) {
        if(!pelaajat.contains(nimi)) {
            Pelaaja pelaaja = new Pelaaja(nimi);
            pelaajat.add(pelaaja);
            this.alustaTulosrivi(pelaaja);
            return true;
        }
        return false;
    }
    
    public void alustaTulosrivi(Pelaaja pelaaja) {
        Tulosrivi tulosrivi = new Tulosrivi();
        for (int i=0;i<7;i++) {
            Tulosruutu
            tulosrivi.lisaaTulosrivi(new SamanArvoiset(int i, String jee));
        }
    }
    
    public void luoTyypit() {
        Set<Noppa> nopat = new HashSet<Noppa>();
        for (int i=1;i<7;i++) {
            nopat.add(new Noppa(i));
            tyypit.add(new SamanArvoiset(nopat, i, 1, 5));
            nopat.clear();
        }
        for (int i = 1; i<6; i++) {
            nopat.add(new Noppa(i));
        }
        tyypit.add(new Bonus(7));
        tyypit.add(new SamanArvoiset(nopat, 8, 2, 2));
        tyypit.add(new KaksiParia(9));
        tyypit.add(new SamanArvoiset(nopat, 10, 3,3));
        tyypit.add(new SamanArvoiset(nopat, 11, 4,4));
        tyypit.add(new Suora(12, 1, 5));
        tyypit.add(new Suora(13, 2, 6));
        tyypit.add(new Mokki(14));
        tyypit.add(new Sattuma(15));
        tyypit.add(new SamanArvoiset(nopat, 16, 5,5));
    }
}
