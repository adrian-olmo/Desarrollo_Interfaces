package controladora;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVetnanaUno implements Initializable {

    DropShadow sombra = new DropShadow();
    @FXML
    Button btnNormal, btnImagen;
    @FXML
    Tab tab_botones, tab_textos, tab_tablas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        acciones();

    }

    private void acciones() {

        btnNormal.setOnMouseEntered(new ManejoRaton());
        btnNormal.setOnMouseExited(new ManejoRaton());
    }

    class ManejoRaton implements EventHandler<MouseEvent> {


        @Override
        public void handle(MouseEvent event) {
            if(event.getSource() == btnNormal){
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    btnNormal.setEffect(sombra);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED){
                    btnNormal.setEffect(null);
                }
            }

        }
    }
}
