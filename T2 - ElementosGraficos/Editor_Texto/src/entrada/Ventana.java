/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

/**
 *
 * @author Adri
 */
public class Ventana extends JFrame {

    Container container;
    JPanel panelSuperior, panelCentro;
    JTextPane texto;
    JMenuBar menuEditor;
    JMenu menuArchivo, menuEdicion, menuEstilo;
    JMenuItem itemNuevo, itemAbrir, itemCerrar, itemGuardar,
            itemGuardarcomo, itemImprimir, itemCopiar, itemCortar, itemPegar,
            itemBold, itemNormal, itemCursiva;

    JComboBox comboLetra, comboTamanio, comboTipo;
    DefaultComboBoxModel modeloLetra, modeloTamanio, modeloTipo;
    JLabel labelLetra, labelTamanio, labelTipo, labelEstilo;
    JButton btnpegar, btncopiar, btncortar, btnimprimir, btnnuevo, btnabrir, btnguardar;

    public void initGUI() {
        instancias();
        configmenu();
        configVentana();
        rellenarLetras();
        rellenartamanio();
        rellenartipo();
        cambiarletras();
        this.setSize(new Dimension(700, 400));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void configmenu() {
        menuEditor.add(menuArchivo);

        menuArchivo.add(itemNuevo); //*
        menuArchivo.add(itemAbrir); //*
        menuArchivo.add(itemCerrar);
        menuArchivo.add(itemGuardar); //*
        menuArchivo.add(itemGuardarcomo); //no lleva icono
        menuArchivo.add(itemImprimir); //*

        menuEditor.add(menuEdicion);

        menuEdicion.add(itemCopiar); //*
        menuEdicion.add(itemCortar); //*
        menuEdicion.add(itemPegar); //*

        menuEdicion.add(menuEstilo);
        menuEstilo.add(itemBold); //*
        menuEstilo.add(itemNormal); //*
        menuEstilo.add(itemCursiva); //*

        this.setJMenuBar(menuEditor);
    }

    private void configVentana() {
        container.add(configurarPanelSuperior(), BorderLayout.NORTH);
        container.add(configurarPanelCentro(), BorderLayout.CENTER);
    }

    private Component configurarPanelSuperior() {
        this.setLayout(new GridLayout(2, 1));
        panelSuperior.add(btnnuevo);
        panelSuperior.add(btnabrir);
        panelSuperior.add(btnguardar);
        panelSuperior.add(btnimprimir);
        panelSuperior.add(btncopiar);
        panelSuperior.add(btncortar);
        panelSuperior.add(btnpegar);
        panelSuperior.add(comboLetra);
        panelSuperior.add(comboTamanio);
        panelSuperior.add(comboTipo);
        return panelSuperior;
    }

    private Component configurarPanelCentro() {
        panelCentro.add(texto);
        return panelCentro;
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
        for (int i = 8; i <= 30; i++) {
            modeloTamanio.addElement(i);
        }
    }

    private void rellenartipo() {
        modeloTipo.addElement("NORMAL");
        modeloTipo.addElement("BOLD");
        modeloTipo.addElement("ITALIC");
    }

    private void instancias() {

        container = this.getContentPane();
        panelCentro = new JPanel();
        panelSuperior = new JPanel();
        texto = new JTextPane();
        //texto.setPreferredSize(new Dimension(700, 400));
        menuEditor = new JMenuBar();
        /*---------------------------------------------------------------------*/

        menuArchivo = new JMenu("Archivo");

        itemNuevo = new JMenuItem("Nuevo");
        itemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        itemNuevo.setToolTipText("Ctrl + N");

        itemAbrir = new JMenuItem("Abrir");
        itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        itemAbrir.setToolTipText("Ctrl + A");

        itemCerrar = new JMenuItem("Cerrar");
        itemCerrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        itemCerrar.setToolTipText("Alt + F4");

        itemGuardar = new JMenuItem("Guardar");
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
        itemGuardar.setToolTipText("Ctrl + G");

        itemGuardarcomo = new JMenuItem("Guardar como...");
        itemImprimir = new JMenuItem("Imprimir");

        /*---------------------------------------------------------------------*/
        menuEdicion = new JMenu("Edicion");

        itemCopiar = new JMenuItem("Copiar");
        itemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        itemCopiar.setToolTipText("Ctrl + C");

        itemCortar = new JMenuItem("Cortar");
        itemCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        itemCortar.setToolTipText("Ctrl + X");

        itemPegar = new JMenuItem("Pegar");
        itemPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        itemPegar.setToolTipText("Ctrl + V");

        /*---------------------------------------------------------------------*/
        menuEstilo = new JMenu("Estilo de la fuente");
        itemBold = new JMenuItem("Negrita");
        itemNormal = new JMenuItem("Normal");
        itemCursiva = new JMenuItem("Cursiva");

        /*---------------------------------------------------------------------*/
        modeloLetra = new DefaultComboBoxModel();
        modeloTipo = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();

        comboLetra = new JComboBox(modeloLetra);
        comboTamanio = new JComboBox(modeloTamanio);
        comboTipo = new JComboBox(modeloTipo);

        labelTipo = new JLabel("Tipo");
        labelTamanio = new JLabel("Tamaño");
        labelLetra = new JLabel("Letra");

        /*---------------------------------------------------------------------*/
        btnnuevo = new JButton();
        btnnuevo.setPreferredSize(new Dimension(24, 24));
        btnnuevo.setIcon(new ImageIcon(getClass().getResource("../resources/new-file.png")));

        btnabrir = new JButton();
        btnabrir.setPreferredSize(new Dimension(24, 24));
        btnabrir.setIcon(new ImageIcon(getClass().getResource("../resources/open-file.png")));

        btnguardar = new JButton();
        btnguardar.setPreferredSize(new Dimension(24, 24));
        btnguardar.setIcon(new ImageIcon(getClass().getResource("../resources/save.png")));

        btnimprimir = new JButton();
        btnimprimir.setPreferredSize(new Dimension(24, 24));
        btnimprimir.setIcon(new ImageIcon(getClass().getResource("../resources/imprimir.png")));

        btncopiar = new JButton();
        btncopiar.setPreferredSize(new Dimension(24, 24));
        btncopiar.setIcon(new ImageIcon(getClass().getResource("../resources/copiar.png")));

        btncortar = new JButton();
        btncortar.setPreferredSize(new Dimension(24, 24));
        btncortar.setIcon(new ImageIcon(getClass().getResource("../resources/cortar.png")));

        btnpegar = new JButton();
        btnpegar.setPreferredSize(new Dimension(24, 24));
        btnpegar.setIcon(new ImageIcon(getClass().getResource("../resources/pegar.png")));

    }

}
