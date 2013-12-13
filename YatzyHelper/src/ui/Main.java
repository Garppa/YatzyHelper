/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Pelimoottori.Peli;
import Pelimoottori.Arpoja;
import javax.swing.SwingUtilities;
/**
 *
 * @author intoit
 */
public class Main {

    public static void main(String[] args) {
        
        PeliClient peli = new PeliClient();
        //peli.kaynnista();

        //
        GraafinenUi totteroi = new GraafinenUi();
        SwingUtilities.invokeLater(totteroi);
    }
    
}
