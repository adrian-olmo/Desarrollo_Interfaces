package clases;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import static javax.swing.SwingConstants.*;

public class Ventana extends JFrame {

    Container container;
    JButton btnequipos;
    JList lista;
    static DefaultListModel modelolista;
    static JLabel imagenequipo;
    JPanel pSuperior, pCentro, pInf;
    JLabel lider_asist, app, lider_punt, ppp, lider_reb, rpp; //Situados pSuperior

    JComboBox combo_liderA, combo_app, combo_liderP, combo_ppp, combo_liderR, combo_rpp;
    DefaultComboBoxModel modelo_liderA, modelo_app, modelo_liderP, modelo_ppp, modelo_liderR, modelo_rpp;

    /*-----------------------------------------------------------------------------------------------------*/
    public Ventana() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configContainer();
        configSup();
        configCentro();
        //rellenarLiderA();
        acciones();
        this.setSize(750, 660);
        //this.pack();
        this.setTitle("Estadisticas de la NBA");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Image nba = new ImageIcon(getClass().getResource("../recursos/nba.png")).getImage();
        setIconImage(nba);
    }

    /*private void rellenarLiderA() {
        Equipo[] equiposnba =
    }*/

    private void configContainer() {
        container.add(configSup(), BorderLayout.NORTH);
        container.add(configCentro(), BorderLayout.CENTER);
        container.add(btnequipos, BorderLayout.SOUTH);
    }

    private JPanel configSup() {
        pSuperior.setLayout(new GridLayout(2, 7));
        pSuperior.add(lider_asist);
        pSuperior.add(combo_liderA);

        pSuperior.add(lider_punt);
        pSuperior.add(combo_liderP);

        pSuperior.add(lider_reb);
        pSuperior.add(combo_liderR);

        pSuperior.add(app);
        pSuperior.add(combo_app);

        pSuperior.add(ppp);
        pSuperior.add(combo_ppp);

        pSuperior.add(rpp);
        pSuperior.add(combo_rpp);
        return pSuperior;
    }

    private JPanel configCentro() {
        pCentro.setLayout(new GridLayout(1, 2));
        pCentro.add(new JScrollPane().add(lista));
        pCentro.add(imagenequipo);
        return pCentro;
    }

    private void acciones() {
        btnequipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelolista.clear();
                new MiWorker().execute();
            }
        });
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Equipo equiposeleccionado = (Equipo) modelolista.getElementAt(lista.getSelectedIndex());
                String link = String.format("%s", equiposeleccionado.getLogo());
                //System.out.println(link);
                URL urlImagen;
                try {
                    urlImagen = new URL(link);
                    BufferedImage imagenInternet = ImageIO.read(urlImagen);
                    BufferedImage resized = resize(imagenInternet, 300, 300);
                    imagenequipo.setIcon(new ImageIcon(resized));
                    pack();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    private void instancias() {
        container = this.getContentPane();
        btnequipos = new JButton("Listar Equipos");
        modelolista = new DefaultListModel();
        lista = new JList(modelolista);

        imagenequipo = new JLabel();

        pSuperior = new JPanel();
        pCentro = new JPanel();
        pInf = new JPanel();
        /*----------------------------------------------------------------------*/
        lider_asist = new JLabel("Lider en Asistencias ");
        app = new JLabel("Numero Asistencias ");
        lider_punt = new JLabel(" Lider en Anotacion ");
        ppp = new JLabel(" Numeros Anotacion ");
        lider_reb = new JLabel(" Lider en Rebotes ");
        rpp = new JLabel(" Rebotes por partido ");
        /*----------------------------------------------------------------------*/
        modelo_liderA = new DefaultComboBoxModel();
        modelo_app = new DefaultComboBoxModel();
        modelo_liderP = new DefaultComboBoxModel();
        modelo_ppp = new DefaultComboBoxModel();
        modelo_liderR = new DefaultComboBoxModel();
        modelo_rpp = new DefaultComboBoxModel();
        /*----------------------------------------------------------------------*/
        combo_liderA = new JComboBox(modelo_liderA);
        combo_app = new JComboBox(modelo_app);
        combo_liderP = new JComboBox(modelo_liderP);
        combo_ppp = new JComboBox(modelo_ppp);
        combo_liderR = new JComboBox(modelo_liderR);
        combo_rpp = new JComboBox(modelo_rpp);

    }

    private BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        imagenequipo.setHorizontalAlignment(CENTER);
        imagenequipo.setVerticalAlignment(CENTER);
        return resized;
    }


}
