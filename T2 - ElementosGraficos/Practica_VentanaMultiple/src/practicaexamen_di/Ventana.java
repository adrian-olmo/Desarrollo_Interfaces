/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaexamen_di;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import paneles.panelBuscar;
import paneles.panelRegistro;
import utils.Persona;

/**
 *
 * @author irone
 */
public class Ventana extends JFrame implements ActionListener {

    Container contenedor;
    JMenuBar barraMenu;
    JMenu menu1;
    JMenuItem itemReg, itemBus;
    CardLayout cardLayout;
    JButton bRegistro, bSalir;
    JPanel pInf;
    JTabbedPane pCentro;
    panelRegistro pRegistro;
    panelBuscar pBuscar;
    //JTabbedPane panelPestanias;

    public Ventana() throws HeadlessException {

        initGUI();
    }

    public void initGUI() {
        instancias();
        configVentana();
        acciones();
        configMenu();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(450, 350));
    }

    private void instancias() {

        contenedor = this.getContentPane();
        barraMenu = new JMenuBar();
        menu1 = new JMenu("Menu Princ");
        itemReg = new JMenuItem("Registro");
        itemBus = new JMenuItem("Buscar");
        cardLayout = new CardLayout();
        bRegistro = new JButton(new ImageIcon("src/recursos/follow.png"));
        bSalir = new JButton("SALIR");
        pCentro = new JTabbedPane();
        pInf = new JPanel();
        pRegistro = new panelRegistro();
        pBuscar = new panelBuscar();
    }

    private void configMenu() {
        barraMenu.add(menu1);
        menu1.add(itemReg);
        menu1.add(itemBus);
        this.setJMenuBar(barraMenu);
    }

    private void configVentana() {

        contenedor.add(configpCentro(), BorderLayout.CENTER);
        contenedor.add(configpInf(), BorderLayout.SOUTH);
    }

    private JTabbedPane configpCentro() {
        pCentro.setLayout(cardLayout);
        pCentro.add(pRegistro, "Registro");
        pCentro.add(pBuscar, "Buscar");
        return pCentro;
    }

    private JPanel configpInf() {
        pInf.add(bRegistro);
        pInf.add(bSalir);
        return pInf;
    }

    private void acciones() {

        bRegistro.addActionListener(this);
        bSalir.addActionListener(this);
        itemBus.addActionListener(this);
        itemReg.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bRegistro) {
            if (!pRegistro.gettNombre().getText().isEmpty() && !pRegistro.gettDni().getText().isEmpty()) {
                Persona p = pRegistro.devolPersona();
                pBuscar.getModeloCombo().addElement(p);
            }

        } else if (e.getSource() == bSalir) {
            System.exit(0);
        }
        else if (e.getSource() == itemReg) {
            pCentro.setSelectedIndex(0);
        } else if (e.getSource() == itemBus) {
            pCentro.setSelectedIndex(1);

        }

    }
}
