/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo_json;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import javax.swing.SwingUtilities;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Entrada {

    public static void main(String[] args) throws IOException, JSONException {
        
//        String linkurl = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
//        URL url = new URL(linkurl);
//        HttpURLConnection httpurlConnection = (HttpURLConnection) url.openConnection();
//        
//        BufferedReader lector = new BufferedReader
//                (new InputStreamReader(httpurlConnection.getInputStream()));
//        
//        StringBuilder builder = new StringBuilder();
//        String linea;
//        
//        while((linea = lector.readLine()) != null){
//            builder.append(linea);
//        }
//        
//        JSONObject jsonObject = new JSONObject(builder.toString());
//        JSONArray jsonArray =  jsonObject.getJSONArray("results");
//        
//        for (int i = 0; i < jsonArray.length(); i++){
//            JSONObject object = (JSONObject) jsonArray.get(i);
//            Gson gson = new Gson();
//            Pelicula p = gson.fromJson(object.toString(), Pelicula.class);
//            System.out.println(p.getOriginal_title());
//        }

            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v = new Ventana();
               // v.initGUI();
            }
        });

    }
    
}
