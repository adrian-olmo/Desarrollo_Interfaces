package entrada;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ventana extends JFrame implements ActionListener, ItemListener {

    Container container;
    JPanel pCentro, pSuperior;
    static JTextArea texto;
    JButton btnnuevo, btnabrir, btnguardar, btnimprimir, btncortar, btnpegar, btncopiar;
    JPopupMenu menuEmergente;
    JMenuBar menuEditor;
    JMenu menuArchivo, menuEdicion, menuEstilo;
    JMenuItem itemNuevo, itemAbrir, itemCerrar, itemGuardar, itemGuardarcomo,
            itemImprimir, itemBold, itemNormal, itemCursiva, itemCopiar, itemCortar, itemPegar;


    JComboBox comboLetra, comboTamanio, comboTipo;
    DefaultComboBoxModel modeloLetra, modeloTamanio, modeloTipo;

    Funciones funciones = new Funciones();


    public Ventana() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configmenu();
        configpopup();
        configVentana();
        rellenarLetras();
        rellenartamanio();
        rellenartipo();
        cambiarletras();
        acciones();
        this.setSize(new Dimension(700, 400));
        this.setTitle("Bloc de notas");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Image icon = new ImageIcon(getClass().getResource("../resources/notas.png")).getImage();
        setIconImage(icon);
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

    private void configpopup() {
        menuEmergente.add(itemCopiar);
        menuEmergente.add(itemCortar);
        menuEmergente.add(itemPegar);
        menuEmergente.addSeparator();
        menuEmergente.add(itemBold);
        menuEmergente.add(itemNormal);
        menuEmergente.add(itemCursiva);
    }

    private void configVentana() {
        container.add(configurarPanelSuperior(), BorderLayout.NORTH);
        container.add(texto, BorderLayout.CENTER);

    }

    private Component configurarPanelSuperior() {
        pSuperior.setLayout(new FlowLayout());
        pSuperior.add(btnnuevo);
        pSuperior.add(btnabrir);
        pSuperior.add(btnguardar);
        pSuperior.add(btnimprimir);
        pSuperior.add(btncopiar);
        pSuperior.add(btncortar);
        pSuperior.add(btnpegar);
        pSuperior.add(comboLetra);
        pSuperior.add(comboTamanio);
        pSuperior.add(comboTipo);
        return pSuperior;
    }

    private void cambiarletras() {
        Font fuente = new Font((String) modeloLetra.getSelectedItem(),
                comboTipo.getSelectedIndex(),
                (int) modeloTamanio.getSelectedItem());
        Component[] components = this.getComponents();
        texto.setFont(fuente);
    }

    private void rellenarLetras() {
        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        for (Font item : fuentes) {
            modeloLetra.addElement(item.getName());
        }
    }

    private void rellenartamanio() {
        for (int i = 12; i <= 80; i++) {
            modeloTamanio.addElement(i);
        }
    }

    private void rellenartipo() {
        modeloTipo.addElement("NORMAL");
        modeloTipo.addElement("BOLD");
        modeloTipo.addElement("ITALIC");
    }

    private void acciones() {
        /*---------------------ACCIONES TEXTO-----------------------*/
        texto.addMouseListener(new ManejoRaton());
        /*---------------------ACCIONES MENU-----------------------*/
        itemNuevo.addActionListener(this);
        itemCerrar.addActionListener(this);
        //itemAbrir.addActionListener(this);
        itemGuardar.addActionListener(this);
        itemCopiar.addActionListener(this);
        itemCortar.addActionListener(this);
        itemPegar.addActionListener(this);
        /*---------------------ACCIONES BOTONES-----------------------*/
        btnguardar.addActionListener(this);
        btnnuevo.addActionListener(this);
        //btnabrir.addActionListener(this);
        btncopiar.addActionListener(this);
        btncortar.addActionListener(this);
        btnpegar.addActionListener(this);
        /*---------------------ACCIONES COMBOS-----------------------*/
        comboLetra.addItemListener(this);
        comboTamanio.addItemListener(this);
        comboTipo.addItemListener(this);
    }

    private void instancias() {

        container = this.getContentPane();
        pCentro = new JPanel();
        pSuperior = new JPanel();
        texto = new JTextArea();
        menuEditor = new JMenuBar();
        menuEmergente = new JPopupMenu();
        /*---------------------------------------------------------------------*/

        menuArchivo = new JMenu("Archivo");

        itemNuevo = new JMenuItem("Nuevo");
        itemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        itemNuevo.setToolTipText("Ctrl + N");
        itemNuevo.setIcon(new ImageIcon(getClass().getResource("../resources/new-file.png")));

        itemAbrir = new JMenuItem("Abrir");
        itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        itemAbrir.setToolTipText("Ctrl + A");
        itemAbrir.setIcon(new ImageIcon(getClass().getResource("../resources/open-file.png")));

        itemCerrar = new JMenuItem("Cerrar");
        itemCerrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        itemCerrar.setToolTipText("Alt + F4");
        itemCerrar.setIcon(new ImageIcon(getClass().getResource("../resources/cerrar.png")));

        itemGuardar = new JMenuItem("Guardar");
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
        itemGuardar.setToolTipText("Ctrl + G");
        itemGuardar.setIcon(new ImageIcon(getClass().getResource("../resources/save.png")));

        itemGuardarcomo = new JMenuItem("Guardar como...");
        itemImprimir = new JMenuItem("Imprimir");
        itemImprimir.setIcon(new ImageIcon(getClass().getResource("../resources/imprimir.png")));

        /*---------------------------------------------------------------------*/
        menuEdicion = new JMenu("Edicion");

        itemCopiar = new JMenuItem("Copiar");
        itemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        itemCopiar.setToolTipText("Ctrl + C");
        itemCopiar.setIcon(new ImageIcon(getClass().getResource("../resources/copiar.png")));

        itemCortar = new JMenuItem("Cortar");
        itemCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        itemCortar.setToolTipText("Ctrl + X");
        itemCortar.setIcon(new ImageIcon(getClass().getResource("../resources/cortar.png")));

        itemPegar = new JMenuItem("Pegar");
        itemPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        itemPegar.setToolTipText("Ctrl + V");
        itemPegar.setIcon(new ImageIcon(getClass().getResource("../resources/pegar.png")));

        /*---------------------------------------------------------------------*/
        menuEstilo = new JMenu("Estilo de la fuente");
        itemBold = new JMenuItem("Negrita");
        itemBold.setIcon(new ImageIcon(getClass().getResource("../resources/negrita.png")));

        itemNormal = new JMenuItem("Normal");
        itemNormal.setIcon(new ImageIcon(getClass().getResource("../resources/normal.png")));

        itemCursiva = new JMenuItem("Cursiva");
        itemCursiva.setIcon(new ImageIcon(getClass().getResource("../resources/cursiva.png")));

        /*---------------------------------------------------------------------*/
        modeloLetra = new DefaultComboBoxModel();
        modeloTipo = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();

        comboLetra = new JComboBox(modeloLetra);
        comboTamanio = new JComboBox(modeloTamanio);
        comboTipo = new JComboBox(modeloTipo);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemNuevo || e.getSource() == btnnuevo) {
            Ventana v = new Ventana();
            v.initGUI();

        } else if (e.getSource() == itemAbrir || e.getSource() == btnabrir) {
            funciones.abrirArchivo();

        } else if (e.getSource() == itemGuardar || e.getSource() == btnguardar) {
            funciones.guardarArchivo();

        } else if (e.getSource() == itemCortar || e.getSource() == btncortar) {
            funciones.cortartexto();

        } else if (e.getSource() == itemCopiar || e.getSource() == btncopiar) {
            funciones.copiartexto();

        } else if (e.getSource() == itemPegar || e.getSource() == btnpegar) {
            funciones.pegartexto();

        } else if (e.getSource() == itemCerrar) {
            this.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboLetra) {
            cambiarletras();
        } else if (e.getSource() == comboTamanio) {
            cambiarletras();
        } else if (e.getSource() == comboTipo) {
            cambiarletras();
        }
    }

    class ManejoRaton extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (e.getButton() == MouseEvent.BUTTON3) {
                menuEmergente.show(texto, e.getX(), e.getY());
            }

        }
    }
}
