package clases;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static javax.swing.SwingConstants.CENTER;

class MiWorker extends SwingWorker<Boolean, Void> {
    JButton jButton;

    public MiWorker(JButton jButton) {
        this.jButton = jButton;
    }

    //https://adridominio.000webhostapp.com/nba.json
    URL url;
    HttpURLConnection connection;
    BufferedReader lector;
    StringBuilder builder = new StringBuilder();

    @Override
    protected Boolean doInBackground() throws Exception {

        // TODO para leer la url
        System.out.println("Listando Equipos...");

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
            Ventana.modelolista.addElement(equipo);
            Thread.sleep(100);
        }
        jButton.setEnabled(true);
        return true;
    }


}
