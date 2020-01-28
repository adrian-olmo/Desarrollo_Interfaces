package ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class VentanaRegistro extends Stage {

    private String titulo;

    public VentanaRegistro(String titulo) {
        this.titulo = titulo;
        initGUI();
    }

    private void initGUI() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../layouts/layout_ventana_registro.fxml"));
            Scene scene = new Scene(root, 600, 500);
            this.setScene(scene);
            this.setTitle(titulo);
            this.initStyle(StageStyle.DECORATED);
            this.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}