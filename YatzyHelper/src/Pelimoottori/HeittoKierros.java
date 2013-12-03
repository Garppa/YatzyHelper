/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pelimoottori;

/**
 *
 * @author intoit
 */
public class HeittoKierros {
    private int vuorossa;
    
    public HeittoKierros() {
        this.vuorossa = 0;
    }
    
    public void kasvataVuorossa(){
        this.vuorossa++;
    }
    
    public int kukaVuorossa(){
        return this.vuorossa;
    }
}
