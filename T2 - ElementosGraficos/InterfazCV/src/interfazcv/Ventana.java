/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcv;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import paneles.*;
import utils.Persona;


public class Ventana extends JFrame implements ActionListener {

    Container container; //*
    JMenuBar barraMenu; //*
    JMenu menuprincipal; //*
    JMenuItem itemregistrar, itembuscar, itemadjuntar, itemsalir; //*
    CardLayout cardLayout; //*
    PanelBuscar pBuscar; //*
    PanelRegistro pRegistro; //*
    JTabbedPane panelPestanias; //*
    public static ArrayList<Persona> listadoPersonas; //*

    public void initGUI() {
        instancias();
        configMenu();
        configVentana();
        acciones();
        this.setTitle("Interfaz CV");
        //this.setIconImage(new ImageIcon("src/resources/cv.png"));
        this.setSize(new Dimension(600, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void instancias() {

        container = this.getContentPane();
        barraMenu = new JMenuBar();
        menuprincipal = new JMenu("Menu Empleados");
        
        itemregistrar = new JMenuItem("Registrar Empleado");
        itemregistrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
        itemregistrar.setToolTipText("Pulsar Ctl + 1");
        
        itembuscar = new JMenuItem("Buscar Empleado");
        itembuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
        itembuscar.setToolTipText("Pulsar Ctl + 2");
        
        itemadjuntar = new JMenuItem("Adjuntar Archivos");
        itemadjuntar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
        itemadjuntar.setToolTipText("Pulsar Ctl + 3");
        
        itemsalir = new JMenuItem("Salir");
        itemsalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_DOWN_MASK));
        itemsalir.setToolTipText("Pulsar Alt + 4");
        
        cardLayout = new CardLayout();
        pBuscar = new PanelBuscar();
        pRegistro = new PanelRegistro();
        panelPestanias = new JTabbedPane();
        listadoPersonas = new ArrayList<>();

    }

    private void configMenu() {

        barraMenu.add(menuprincipal);
        menuprincipal.add(itemregistrar);
        menuprincipal.add(itembuscar);
        menuprincipal.add(itemadjuntar);
        menuprincipal.add(itemsalir);
        this.setJMenuBar(barraMenu);
    }

    private void configVentana() {
        container.add(configCentro(), BorderLayout.CENTER);
    }

    private Component configCentro() {
        panelPestanias.setLayout(cardLayout);
        panelPestanias.add(pRegistro, "REGISTRO");
        panelPestanias.add(pBuscar, "BUSCAR");
        return panelPestanias;
    }

    private void acciones() {

        itembuscar.addActionListener(this);
        itemregistrar.addActionListener(this);
        itemadjuntar.addActionListener(this);
        itemsalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == itemregistrar) {
            panelPestanias.setSelectedIndex(0);

        } else if (e.getSource() == itembuscar) {
            panelPestanias.setSelectedIndex(1);

        } else if (e.getSource() == itemadjuntar) {
            JFileChooser fileChooser = new JFileChooser();
            int i = fileChooser.showSaveDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                String f = fileChooser.getSelectedFile().getName();
                String ex = f.substring(f.indexOf(".") + 1);
                System.out.println(ex);
            } else if (i == JFileChooser.CANCEL_OPTION) {
            }
        } else if (e.getSource() == itemsalir)
            System.exit(0);

    }
}
