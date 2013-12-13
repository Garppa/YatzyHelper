/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author intoit
 */
public class EkaNayttoKuuntelija implements ActionListener{
   private JTextField lkm;
   private GraafinenUi frame;
    
    public EkaNayttoKuuntelija(JTextField pellkm, GraafinenUi frame){
        this.lkm = pellkm;
        this.frame = frame;
    }

    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Integer.parseInt(this.lkm.getText());
        
        LisaaPelaajaNaytonKomponentit lpnk = new LisaaPelaajaNaytonKomponentit();
        
        
        JPanel lisaapelaajat = lpnk.lisaaPelaajatNaytto(Integer.parseInt(this.lkm.getText()));
        //frame.getFrame().removeAll();
        frame.getFrame().add(lisaapelaajat);
        frame.korttileiska().next(frame.getFrame().getContentPane());
        
        
    }
    
    
}