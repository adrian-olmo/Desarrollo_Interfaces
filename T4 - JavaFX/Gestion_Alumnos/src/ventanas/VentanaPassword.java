package ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class VentanaPassword extends Stage {

    private String titulopassword = "He olvidado mi contraseña";

    public VentanaPassword(String titulo) {
        this.titulopassword = titulo;
        initGUI();
    }

    private void initGUI() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../layouts/layout_ventana_password.fxml"));
            Scene scene = new Scene(root, 600, 500);
            this.setScene(scene);
            this.setTitle(titulopassword);
            this.initStyle(StageStyle.DECORATED);
            this.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}