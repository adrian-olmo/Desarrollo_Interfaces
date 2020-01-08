package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button botonNormal;

    @FXML
    JFXButton botonMaterial;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {

        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("Raton encima");
            }
        });



        botonNormal.addEventHandler(ActionEvent.ACTION, new ManejadoPulsaciones());
        botonMaterial.addEventHandler(ActionEvent.ACTION, new ManejadoPulsaciones());
    }
    class ManejadoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == botonNormal){
                System.out.println("Boton normal pulsado");

            } else if (event.getSource() == botonMaterial){
                System.out.println("Boton material pulsado");
            }
        }
    }
}
