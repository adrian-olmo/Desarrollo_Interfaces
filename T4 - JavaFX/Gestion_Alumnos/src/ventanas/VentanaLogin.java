package ventanas;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class VentanaLogin extends Stage {

    public VentanaLogin() {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../layouts/layout_ventana_login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,600,400);
        this.setTitle("Gestion de Alumnos");
        this.setScene(scene);
        //this.getIcons().add(new Image("../resources/registro.png"));
        this.show();
    }

}