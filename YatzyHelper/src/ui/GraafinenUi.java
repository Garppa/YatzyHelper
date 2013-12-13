/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author intoit
 */
public class GraafinenUi implements Runnable {
    private static JFrame frame;
    private CardLayout korttileiska;
    public GraafinenUi(){
        korttileiska = new CardLayout();      
        
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("GUI");
        
        frame.setPreferredSize(new Dimension(600,600));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }

    private void luoKomponentit(Container container) {
        
        container.setLayout(korttileiska);
        JPanel pelnaytpain = pelaajaNaytonPainikkeet();
        container.add(pelnaytpain);

        
    }
    
    private JPanel pelaajaNaytonPainikkeet() {
        JPanel painikkeet = new JPanel(new GridLayout(1,2));
        JTextField tulos = new JTextField("fdsgf");
        JButton pelaajatlkm = new JButton("Tallenna");
        
        tulos.setEnabled(true);
        
        EkaNayttoKuuntelija kuuntelija = new EkaNayttoKuuntelija(tulos, this);
        
        pelaajatlkm.addActionListener(kuuntelija);
        
        
        painikkeet.add(tulos);   
        painikkeet.add(pelaajatlkm);
 
        return painikkeet;    
    }
    



    public JFrame getFrame() {
        return frame;
    }
    
    public CardLayout korttileiska(){
        return korttileiska;
    }
}
