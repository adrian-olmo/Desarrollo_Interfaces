/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuario DAM 2
 */
public class PestaniaOcho extends JPanel implements ItemListener {
    
    JComboBox comboLetra, comboTamanio, comboTipo, comboEstilo;
    DefaultComboBoxModel modeloLetra, modeloTamanio, modeloTipo, modeloEstilo;
    JLabel labelLetra, labelTamanio, labelTipo, labelEstilo;
    
    public PestaniaOcho() throws ClassNotFoundException {
        initGUI();
    }
    
    public void initGUI() throws ClassNotFoundException {
        instancias();
        rellenarLetras();
        rellenartamanio();
        rellenartipo();
        rellenarestilo();
        cambiarletras();
        configurarPanel();
        acciones();
        
    }

    private void instancias() {
        
        modeloLetra = new DefaultComboBoxModel();
        modeloEstilo = new DefaultComboBoxModel();
        modeloTipo = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();
        
        comboLetra = new JComboBox(modeloLetra);
        comboTamanio = new JComboBox(modeloTamanio);
        comboEstilo = new JComboBox(modeloEstilo);
        comboTipo = new JComboBox(modeloTipo);
        
        labelEstilo = new JLabel("Estilo");
        labelTipo = new JLabel("Tipo");
        labelTamanio = new JLabel("Tamaño");
        labelLetra = new JLabel("Letra");
        
    }
    
    private void cambiarletras() {
        Font fuente = new Font((String) modeloLetra.getSelectedItem(),
                comboTipo.getSelectedIndex(),
                (int) modeloTamanio.getSelectedItem());
        Component[] components = this.getComponents();
        for (Component item : components) {
            item.setFont(fuente);
        }
    }
    
    private void rellenarLetras() {
        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        for (Font item : fuentes) {
            modeloLetra.addElement(item.getName());
        }
    }
    
    private void rellenartamanio() {
        for (int i = 8; i <= 50; i++) {
            modeloTamanio.addElement(i);
        }
    }
    
    private void rellenartipo() {
        modeloTipo.addElement("NORMAL");
        modeloTipo.addElement("BOLD");
        modeloTipo.addElement("ITALIC");
    }
    
    private void rellenarestilo() throws ClassNotFoundException {
        
        try {
            UIManager.LookAndFeelInfo[] estilo
                    = UIManager.getInstalledLookAndFeels();
            
            for (UIManager.LookAndFeelInfo item : estilo) {
                modeloEstilo.addElement(estilo);
                //System.out.println(item.getClassName());
            }
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (InstantiationException ex) {
            Logger.getLogger(PestaniaOcho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PestaniaOcho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PestaniaOcho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void acciones() {
        comboLetra.addItemListener(this);
        comboTamanio.addItemListener(this);
        comboTipo.addItemListener(this);
    }
    
    private void configurarPanel() {
        this.setLayout(new GridLayout(4, 2));
        this.add(labelLetra);
        this.add(comboLetra);
        this.add(labelTamanio);
        this.add(comboTamanio);
        this.add(labelTipo);
        this.add(comboTipo);
        this.add(labelEstilo);
        this.add(comboEstilo);
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboLetra) {
            cambiarletras();
        } else if (e.getSource() == comboTamanio) {
            cambiarletras();
        } else if (e.getSource() == comboTipo) {
            cambiarletras();
        } else if (e.getSource() == comboEstilo){
            
        }
    }
    
}
