
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ventana extends JFrame {

    Container container;
    JButton btnequipos;
    JList lista;
    DefaultListModel modelolista;
    JPanel pSuperior, pCentro, pInf;
    JLabel imagenequipo;
    JLabel lider_asist, app, lider_punt, ppp, lider_reb, rpp; //Situados pSuperior

    JComboBox combo_liderA, combo_app, combo_liderP, combo_ppp, combo_liderR, combo_rpp;
    DefaultComboBoxModel modelo_liderA, modelo_app, modelo_liderP, modelo_ppp, modelo_liderR, modelo_rpp;


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
        this.setTitle("Estadisticas de la NBA");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Image icon = new ImageIcon(getClass().getResource("recursos/nba.png")).getImage();
        setIconImage(icon);
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
        pCentro.add(lista);
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
                System.out.println(equiposeleccionado.getLogo());
            }
        });
    }

    class MiWorker extends SwingWorker<Boolean, Void> {

        //https://adridominio.000webhostapp.com/nba.json
        URL url;
        HttpURLConnection connection;
        BufferedReader lector;
        StringBuilder builder = new StringBuilder();

        @Override
        protected Boolean doInBackground() throws Exception {

            // TODO para leer la url
            System.out.println("ejecutado");

            try {
                url = new URL("https://adridominio.000webhostapp.com/nba.json");
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

}
