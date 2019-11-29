/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasodatos;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Usuario DAM 2
 */
public class Ventana extends JFrame implements ActionListener{

    PanelUno panelUno;
    PanelDos panelDos;
    
    JMenuBar barra;
    JMenu menu;
    JMenuItem item1, item2;
    
    Container container;
    CardLayout cardLayout;
    
    Ventana(){
        initGUI();
    }

    public void initGUI() {
        instancias();
        acciones();
        configurarmenu();
        configurarcontainer();
        this.setSize(new Dimension(600, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void instancias() {
        panelUno = new PanelUno();
        panelDos = new PanelDos();
        barra =  new JMenuBar();
        menu = new JMenu("Menu");
        item1 = new JMenuItem("Item1");
        item2 = new JMenuItem("Item2");
        container = this.getContentPane();
        cardLayout = new CardLayout();
    }


    private void configurarmenu() {
        barra.add(menu);
        menu.add(item1);
        menu.add(item2);
        this.setJMenuBar(barra);
    }

    private void configurarcontainer() {
        container.setLayout(cardLayout);
        container.add(panelUno, "pane1");
        container.add(panelDos, "pane2");
     
    }

    private void acciones() {
        item1.addActionListener(this);
        item2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == item1){
            cardLayout.show(container, "pane1");
        } else if (e.getSource() == item2){
            cardLayout.show(container, "pane2");
        }
        
    }
}
