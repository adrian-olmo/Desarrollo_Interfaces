/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasodatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Usuario DAM 2
 */
public class PanelUno extends JPanel implements ActionListener{
    
    JButton boton;

    public PanelUno() {
        
        intiGUI();
        
    }

    private void intiGUI() {
        
        instancias();
        acciones();
        configurarpanel();
    }

    private void instancias() {
        
        boton = new JButton("BOTON");
    }

    private void configurarpanel() {
        this.add(boton);
    }
    private void acciones() {
       boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
       
        
    }

    
    
}
