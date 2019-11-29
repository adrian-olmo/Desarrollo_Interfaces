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
public class PanelUno extends JPanel implements ActionListener {

    JButton boton;
    PanelDos pDos;

    public PanelUno(Ventana v) {
        this.pDos = pDos;
        intiGUI();
        acciones();
        configurarpanel();
    }

    private void intiGUI() {
        instancias();

    }

    private void instancias() {
        boton = new JButton("AGREGAR");
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
