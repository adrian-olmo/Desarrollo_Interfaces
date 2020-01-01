/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import paneles.*;
import util.Persona;

/**
 *
 * @author Adri
 */
public class Ventana extends JFrame {

    Container container;
    PestaniaAlta pestaniaAlta;
    PestaniaBaja pestaniaBaja;
    PestaniaModifi pestaniaModifi;
    PestaniaResumen pestaniaResumen;
    JTabbedPane panelPestanias;
    JComboBox comboClaves;
    DefaultComboBoxModel modeloClaves;
    ArrayList<Persona> listaPersonas;

    public void initGUI() {
        instancias();
        configurarContainer();
        //acciones();
        this.setSize(new Dimension(450, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    private void instancias() {
        container = this.getContentPane();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        pestaniaAlta = new PestaniaAlta();
        pestaniaBaja = new PestaniaBaja();
        pestaniaModifi = new PestaniaModifi();
        pestaniaResumen = new PestaniaResumen();
        modeloClaves = new DefaultComboBoxModel();
        comboClaves = new JComboBox();
        listaPersonas = new ArrayList();
        //pestaniaBaja.();
    }

    private void configurarContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Altas", pestaniaAlta);
        panelPestanias.addTab("Bajas", pestaniaBaja);
        panelPestanias.addTab("Modificaciones", pestaniaModifi);
        panelPestanias.addTab("Resumen", pestaniaResumen);
    }

    public DefaultComboBoxModel getModeloClaves() {
        return modeloClaves;
    }

    public void ModeloClaves(DefaultComboBoxModel modeloClaves) {
        this.modeloClaves = modeloClaves;
    }

    public JComboBox getComboClaves() {
        return comboClaves;
    }
    

    public ArrayList<Persona> getListaEmpleados() {
        return getListaEmpleados();
    }
}
