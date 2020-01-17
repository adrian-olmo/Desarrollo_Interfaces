package controladoras;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVentanaDosSceneDos implements Initializable {

    @FXML
    Button botonUno;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        botonUno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = (Stage) botonUno.getScene().getWindow();
                Parent root = null;
                try{
                    root = FXMLLoader.load(getClass().getResource("/youts/layout_ventana_dos_scene_uno.fxml"));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                Scene scene =  new Scene(root,stage.getWidth(), stage.getHeight());
                stage.setScene(scene);
            }
        });
    }
}
