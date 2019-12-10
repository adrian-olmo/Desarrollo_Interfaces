/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3_worker;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

/**
 *
 * @author Usuario DAM 2
 */
public class Ventana extends JFrame{  
    
    Container container;
    JButton btn1, btn2;
    JProgressBar barraprogreso;
    JPanel panel;
    
    public void initGUI(){
        instancias();
        configPanel();
        this.setSize(new Dimension(600,400));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    private void instancias() {
        container = this.getContentPane();
        panel = new JPanel();
        btn1 = new JButton("Boton 1");
        btn2 = new JButton("Boton 2");
        barraprogreso = new JProgressBar();
    }

    private void configPanel() {
        panel.add(btn1);
        panel.add(btn2);
        panel.add(barraprogreso);
    }
}
