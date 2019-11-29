/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasodatos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Usuario DAM 2
 */
public class PanelDos extends JPanel {

    DefaultListModel modelo;
    JList lista;

    public PanelDos() {

        intiGUI();
    }
    
    private void configurarpanel() {
        this.setLayout(new BorderLayout());
        this.add(lista, BorderLayout.CENTER);
    }

    private void intiGUI() {
        instancias();
        configurarpanel();
    }

    private void instancias() {
        modelo = new DefaultListModel();
        lista = new JList(modelo);

    }
}
