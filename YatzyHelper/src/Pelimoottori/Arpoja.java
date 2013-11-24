/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelimoottori;
import java.util.Random;

/**
 *
 * @author intoit
 */
public class Arpoja {
    Random arpa;
    public Arpoja() {
        this.arpa = new Random();
    }
    
    public int annaArvo(){
        int arvo = 0;
        while (arvo==0){
            arvo = arpa.nextInt(7);
        }
        return arvo;
    }
}
