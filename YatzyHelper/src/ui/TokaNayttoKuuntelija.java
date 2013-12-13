/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import Pelimoottori.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author intoit
 */
public class TokaNayttoKuuntelija implements ActionListener{
   private List<JTextField> lkm;
    
    public TokaNayttoKuuntelija(List<JTextField> pellkm){
        this.lkm = pellkm;
        
    }

    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        List<String> lista = new ArrayList<String>();
        
        for(JTextField teksti : lkm) {
            lista.add(teksti.getText());
        }
        
        Peli p = new Peli(lista);
        
    }
    
    
}