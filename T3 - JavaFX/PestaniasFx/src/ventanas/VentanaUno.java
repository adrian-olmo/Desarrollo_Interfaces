package ventanas;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaUno extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../layout/LayoutVentanaUno.fxml"));
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Pestañas JavaFx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void lanzarVentana(){
        launch();
    }
}
