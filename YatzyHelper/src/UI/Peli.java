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
        
        for (int k = 0; k< lkm; k++) {
            System.out.println("Anna pelaajan "+ (k+1) + " nimi:");
            this.alustus.alustaPelaaja(lukija.nextLine());
            
        }
        

        
    }
    
    
}
