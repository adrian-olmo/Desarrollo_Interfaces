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

public class Ventana extends JFrame implements ListSelectionListener{

    Container container;
    JButton btnequipos;
    JList lista;
    static DefaultListModel modelolista;
    static JLabel imagenequipo;
    JPanel pSuperior, pCentro, pInf;
    JLabel lider_asist, app, lider_punt, ppp, lider_reb, rpp; //Situados pSuperior
    JLabel combo_app, combo_liderP, combo_ppp, combo_liderR, combo_rpp, combo_liderA; //Rellenado por las estadisticas


    /*-----------------------------------------------------------------------------------------------------*/
    public Ventana() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configContainer();
        configSup();
        configCentro();
        acciones();
        this.setSize(760, 660);
        //this.pack();
        this.setTitle("Estadisticas de la NBA");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Image nba = new ImageIcon(getClass().getResource("../recursos/nba.png")).getImage();
        setIconImage(nba);
    }


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
                btnequipos.setEnabled(false);
                modelolista.clear();
                new MiWorker(btnequipos).execute();
            }
        });
        lista.addListSelectionListener(this);
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
        lider_asist = new JLabel("Lider en Asistencias: ");
        app = new JLabel("Numero Asistencias: ");
        lider_punt = new JLabel(" Lider en Anotacion: ");
        ppp = new JLabel(" Numeros Anotacion: ");
        lider_reb = new JLabel(" Lider en Rebotes: ");
        rpp = new JLabel(" Rebotes por partido: ");
        /*----------------------------------------------------------------------*/
        combo_liderA = new JLabel();
        combo_app = new JLabel();
        combo_liderP = new JLabel();
        combo_ppp = new JLabel();
        combo_liderR = new JLabel();
        combo_rpp = new JLabel();

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


    @Override
    public void valueChanged(ListSelectionEvent e) {
        Equipo equiposeleccionado = (Equipo) modelolista.getElementAt(lista.getSelectedIndex());

        String liderA = equiposeleccionado.getLider_Asistencias();
        double App = equiposeleccionado.getAPP_Lider();
        combo_liderA.setText(liderA);
        combo_app.setText(String.valueOf(App));

        String LiderP = equiposeleccionado.getLider_Puntos();
        double Ppp = equiposeleccionado.getPPP_Lider();
        combo_liderP.setText(LiderP);
        combo_ppp.setText(String.valueOf(Ppp));

        String LiderR = equiposeleccionado.getLider_Puntos();
        double Rpp = equiposeleccionado.getPPP_Lider();
        combo_liderR.setText(LiderR);
        combo_rpp.setText(String.valueOf(Rpp));

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
}
