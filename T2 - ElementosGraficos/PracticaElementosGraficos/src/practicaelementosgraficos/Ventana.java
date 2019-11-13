/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaelementosgraficos;

import paneles.PanelBuscar;
import paneles.PanelRegistro;
import utils.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Usuario DAM 2
 */
public class Ventana extends JFrame implements ActionListener {

    Container container;
    JButton irRegistro, irBuscar, salir;
    JPanel pSuperior, pInferior, pCentral;
    CardLayout cardLayout;
    PanelRegistro panelRegistro;
    PanelBuscar panelBuscar;

    JMenuBar barraMenu;
    JMenu menuUno;
    JMenuItem itemBuscar, itemRegistro;

    final String TAG_PBUSCAR = "buscar";
    final String TAG_PREGISTRO = "registrar";

    public Ventana() throws HeadlessException {

        initGUI();
    }

    private void initGUI() {

        instancias();
        configurarMenu();
        configurarVentana();
        acciones();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(400, 300));
        setVisible(true);
    }

    private void acciones() {
        irBuscar.addActionListener(this);
        irRegistro.addActionListener(this);
        salir.addActionListener(this);
        itemBuscar.addActionListener(this);
        itemRegistro.addActionListener(this);
    }

    private void configurarMenu() {
        barraMenu.add(menuUno);
        menuUno.add(itemBuscar);
        menuUno.add(itemRegistro);
        this.setJMenuBar(barraMenu);
    }

    private void configurarVentana() {
        container.add(configurarPanelSuperior(), BorderLayout.NORTH);
        container.add(configurarPanelInferior(), BorderLayout.SOUTH);
        container.add(configurarPanelCentral(), BorderLayout.CENTER);
    }

    private JPanel configurarPanelCentral() {
        pCentral.setLayout(cardLayout);
        pCentral.add(panelRegistro, TAG_PREGISTRO);
        pCentral.add(panelBuscar, TAG_PBUSCAR);
        return pCentral;
    }

    private JPanel configurarPanelSuperior() {
        pSuperior.add(irRegistro);
        pSuperior.add(irBuscar);
        return pSuperior;
    }

    private JPanel configurarPanelInferior() {
        pInferior.add(salir);
        return pInferior;
    }

    private void instancias() {
        container = this.getContentPane();
        pSuperior = new JPanel();
        pCentral = new JPanel();
        pInferior = new JPanel();
        irRegistro = new JButton("Ir a registro");
        irBuscar = new JButton("Ir a buscar");
        salir = new JButton("Salir");
        panelBuscar = new PanelBuscar();
        panelRegistro = new PanelRegistro();
        cardLayout = new CardLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == irRegistro) {
            cardLayout.show(pCentral, TAG_PREGISTRO);
            salir.setEnabled(true);
        } else if (e.getSource() == irBuscar) {
            cardLayout.show(pCentral, TAG_PBUSCAR);
            salir.setEnabled(true);
        } else if (e.getSource() == salir) {
            System.exit(0);
        }
    }

}
