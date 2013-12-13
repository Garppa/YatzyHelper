/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;
import java.util.Random;

/** 
 * Arpoo nopalle arvon 1-6
 * @author intoit
 */
public class Arpoja {
    Random arpa;
    public Arpoja() {
        this.arpa = new Random();
    }
    
    /**
     * Kysytaan nopalle silmalukujen arvoja
     * @return palauttaa arvon 1-6
     */
    public int annaArvo(){
        int arvo = 0;
        while (arvo==0){
            arvo = arpa.nextInt(7);
        }
        return arvo;
    }
}
