package controladoras;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraRegistro implements Initializable {

    @FXML
    JFXButton btnregistrar;

    @FXML
    JFXTextField txtnombreregistro, txtapellidoregistro, txtcorreoregistro, txtconfirmarcorreo, txtpasswordregistro;

    @FXML
    JFXCheckBox checkregistro;

    @FXML
    ChoiceBox choiceregistro;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
        btnregistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Alumno Registrado");
            }
        });
    }
}
