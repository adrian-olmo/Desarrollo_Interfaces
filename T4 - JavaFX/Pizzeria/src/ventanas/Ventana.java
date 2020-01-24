package ventanas;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Ventana  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../layouts/layout_ventana.fxml"));
        Scene scene = new Scene(root,600,700);
        primaryStage.setTitle("Pizzeria");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void mostrar(){
        launch();
    }
}