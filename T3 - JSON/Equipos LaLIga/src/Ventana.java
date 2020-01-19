import com.google.gson.Gson;
import com.google.gson.JsonSerializer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame {

    Container container;
    JButton boton;
    JList lista;
    JLabel poster, equipo;
    DefaultListModel modelolista;
    JPanel pCentro, pSuperior, pInf;
    JLabel key, nombre, codAbre;

    JLabel cmbKey, cmbNombre, cmbAbre;
    //Te he hecho los mismos ajustes que me hizo a mi Romi
    //He cambiado los ComboBox por JLabel ya que son mas sencillos para este ejercicio

    public Ventana() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        configContainer();
        configSup();
        configCentro();
        acciones();
        this.setTitle("Equipos La Liga BBVA Ivan RO");
        this.setSize(new Dimension(700, 680));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Image icon = new ImageIcon(getClass().getResource("recursos/logoLiga.jpg")).getImage();
        this.setIconImage(icon);

    }

    private void instancias() {
        container = this.getContentPane();
        boton = new JButton("VER EQUIPOS");
        modelolista = new DefaultListModel();
        lista = new JList(modelolista);
        poster = new JLabel();
        pCentro = new JPanel();
        pSuperior = new JPanel();
        pInf = new JPanel();

        key = new JLabel("Key Equipo");
        nombre = new JLabel("Nombre Equipo");
        codAbre = new JLabel("Abreviatura Equipo");

        cmbKey = new JLabel();
        cmbNombre = new JLabel();
        cmbAbre = new JLabel();
    }

    private void configContainer() {
        container.add(configSup(), BorderLayout.NORTH);
        container.add(configCentro(), BorderLayout.CENTER);
        container.add(boton, BorderLayout.SOUTH);
    }

    private JPanel configSup() {
        pSuperior.setLayout(new GridLayout(3, 6));
        pSuperior.add(key);
        pSuperior.add(cmbKey);

        pSuperior.add(nombre);
        pSuperior.add(cmbNombre);

        pSuperior.add(codAbre);
        pSuperior.add(cmbAbre);

        return pSuperior;

    }

    private JPanel configCentro() {
        //JPanel panel = new JPanel();
        pCentro.setLayout(new GridLayout(1, 2));
        pCentro.add(lista);
        pCentro.add(poster);
        return pCentro;
    }

    private void acciones() {
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelolista.clear();
                new MiWorker().execute();
            }
        });
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Equipo equipoSelecc = (Equipo) modelolista.getElementAt(lista.getSelectedIndex());

                // declaras una variable y se la pasas el texto al JLabel para
                //que te coja el valor asociado al JSON

                String cod_equipo = equipoSelecc.getKey();
                cmbKey.setText(cod_equipo);

                String nom_equipo = equipoSelecc.getName();
                cmbNombre.setText(nom_equipo);

                String abrev_equipo = equipoSelecc.getCode();
                cmbAbre.setText(abrev_equipo);

                String link = String.format("%s", equipoSelecc.getLogo());
                URL urlImagen;
                try {
                    urlImagen = new URL(link);
                    BufferedImage imagenInternet = ImageIO.read(urlImagen);
                    BufferedImage resized = resize(imagenInternet, 300, 300);
                    poster.setIcon(new ImageIcon(resized));
                    pack();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    class MiWorker extends SwingWorker<Boolean, Void> {

        URL url;
        HttpURLConnection connection;
        BufferedReader lector;
        StringBuilder builder = new StringBuilder();

        @Override
        protected Boolean doInBackground() throws Exception {

            // TODO para leer la url
            System.out.println("Listando Equipos...");

            try {
                url = new URL("https://adridominio.000webhostapp.com/Equipos.json");
                connection = (HttpURLConnection) url.openConnection();
                lector = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String linea;
            while ((linea = lector.readLine()) != null) {
                builder.append(linea);
            }

            JSONObject jsonEntero = new JSONObject(builder.toString());
            JSONArray jsonArrayResultados = jsonEntero.getJSONArray("results");
            for (int i = 0; i < jsonArrayResultados.length(); i++) {

                JSONObject objeto = jsonArrayResultados.getJSONObject(i);
                Gson gson = new Gson();
                Equipo equipo = gson.fromJson(objeto.toString(), Equipo.class);
                modelolista.addElement(equipo);
                Thread.sleep(100);
            }

            return true;
        }


    }

    private BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}