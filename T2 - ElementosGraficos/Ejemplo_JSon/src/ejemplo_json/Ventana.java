/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo_json;

import com.google.gson.Gson;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Usuario DAM 2
 */
public class Ventana extends JFrame {

    Container container;
    JButton boton;
    JList lista;
    JLabel poster;
    DefaultListModel modelolista;
    JPanel pCentro;

    public Ventana() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        configContainer();
        configCentro();
        acciones();
        this.setSize(new Dimension(700, 400));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void instancias() {
        container = this.getContentPane();
        boton = new JButton("EJECUTAR");
        modelolista = new DefaultListModel();
        lista = new JList(modelolista);
        poster = new JLabel();
        pCentro = new JPanel();

    }

    private void configContainer() {
        container.add(configCentro(), BorderLayout.CENTER);
        container.add(boton, BorderLayout.SOUTH);
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
               Pelicula peliculaseleccionada = (Pelicula) modelolista.getElementAt(lista.getSelectedIndex());
               String ruta = String.format("%s%s","https://image.tmdb.org/t/p/w500/");
                System.out.println(peliculaseleccionada.getPoster_path());
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
            System.out.println("ejecutado");

            try {
                url = new URL("https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1");
                connection = (HttpURLConnection) url.openConnection();
                lector = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String linea;
            while ((linea = lector.readLine())!=null){
                builder.append(linea);
            }


            JSONObject jsonEntero = new JSONObject(builder.toString());
            JSONArray jsonArrayResultados = jsonEntero.getJSONArray("results");
            for (int i=0;i<jsonArrayResultados.length();i++){
               
                JSONObject objeto = jsonArrayResultados.getJSONObject(i);
                Gson gson = new Gson();
                Pelicula pelicula = gson.fromJson(objeto.toString(),Pelicula.class);
                modelolista.addElement(pelicula);
                Thread.sleep(100);
            }



            return true;
        }
    }
}

