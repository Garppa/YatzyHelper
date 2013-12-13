/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author intoit
 */
public class LisaaPelaajaNaytonKomponentit {
    
    private List<JTextField> pelaajat;
  
    
    public LisaaPelaajaNaytonKomponentit(){
        pelaajat = new ArrayList<JTextField>();
    }
    
    public JPanel annaPaneeli(int lkm){
        
        JTextField tf = new JTextField();
        JLabel jL = new javax.swing.JLabel();
        JPanel jp = new JPanel();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jp);
        
        
        
        for(int i = 0; i<lkm;i++){
        tf.setText("");
        jL.setText("Pelaaja "+i);
        jp.add(tf);
        jp.add(jL);
        pelaajat.add(tf);
            
        }
        return jp;
    }
    
       public JPanel lisaaPelaajatNaytto(int pelaajatlkm) {
        JPanel painikkeet = new JPanel(new GridLayout(2,1));
        
        JPanel tekstijee = annaPaneeli(pelaajatlkm);
        JButton tallenna = new JButton("Tallenna");

        TokaNayttoKuuntelija kuuntelija = new TokaNayttoKuuntelija(annaPelaajat());
        
        tallenna.addActionListener(kuuntelija);
        
        
        painikkeet.add(tekstijee);   
        painikkeet.add(tallenna);
 
        return painikkeet;    
    }
    
    public List<JTextField> annaPelaajat(){
        return this.pelaajat;
    }
}
