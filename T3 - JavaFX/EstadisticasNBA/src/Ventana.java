
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

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

public class Ventana extends JFrame {

    Container container;
    JButton btnequipos;
    JList lista;
    DefaultListModel modelolista;
    JLabel equipo, lider_asist, app, lider_punt, ppp, lider_reb, rpp;
    JPanel pSuperior, pCentro;

    public Ventana() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configContainer();
        configSup();
        configCentro();
        acciones();
        this.pack();
        //this.setSize(new Dimension(1000, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void configContainer() {
        container.add(configSup(), BorderLayout.NORTH);
        container.add(configCentro(), BorderLayout.CENTER);
        container.add(btnequipos, BorderLayout.SOUTH);
    }

    private JPanel configSup() {
        pSuperior.setLayout(new GridLayout(2, 3));
        pSuperior.add(lider_asist);
        pSuperior.add(app);
        pSuperior.add(lider_punt);
        pSuperior.add(ppp);
        pSuperior.add(lider_reb);
        pSuperior.add(rpp);
        return pSuperior;
    }

    private JPanel configCentro() {
        pCentro.setLayout(new GridLayout(1, 2));
        pCentro.add(lista);
        pCentro.add(equipo);
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
                //String ruta = String.format("%s%s", )
                System.out.println(equiposeleccionado.getLogo());
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
                url = new URL("\\recursos\\nba.json");
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


    private void instancias() {
        container = this.getContentPane();
        btnequipos = new JButton("Listar Equipos");
        modelolista = new DefaultListModel();
        lista = new JList(modelolista);
        equipo = new JLabel();
        pSuperior = new JPanel();
        pCentro = new JPanel();

        lider_asist = new JLabel("Lider en Asistencias");
        app = new JLabel("Asistencias por partido");

        lider_punt = new JLabel("Lider en Anotacion");
        ppp = new JLabel("Puntos por partido");

        lider_reb = new JLabel("Lider en Rebotes");
        rpp = new JLabel("Rebotes por partido");

    }

}
