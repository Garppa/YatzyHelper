/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author intoit
 */
public class Drawing extends JPanel {
    
 public Drawing() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        graphics.setColor(Color.BLACK);
        
        graphics.fillRect(100, 50, 50, 50);
        graphics.fillRect(250, 50, 50, 50);
        graphics.fillRect(50, 200, 50, 50);
        graphics.fillRect(300, 200, 50, 50);
        graphics.fillRect(100, 250, 200, 50);

    }