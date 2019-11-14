/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcv;

import paneles.PestaniaUno;
import paneles.PestaniaDos;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import utils.Persona;

/**
 *
 * @author Adri
 */
public class Ventana extends JFrame {

    Container container;
    public static ArrayList<Persona> listadoPersonas;
    PestaniaUno pestaniaEntrega;
    PestaniaDos pestaniaBuscador;
    JTabbedPane panelPestanias;

    public void initGUI() {

        instancias();
        configurarContainer();
        this.setSize(new Dimension(700, 250));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
    }

    private void configurarContainer() {
        container.add(panelPestanias);
        panelPestanias.addTab("Datos", pestaniaEntrega);
        panelPestanias.addTab("Buscador", pestaniaBuscador);
    }

    private void instancias() {

        container = this.getContentPane();
        panelPestanias = new JTabbedPane(SwingConstants.TOP);
        pestaniaEntrega = new PestaniaUno();
        pestaniaBuscador = new PestaniaDos();
        listadoPersonas = new ArrayList<>();
    }
}