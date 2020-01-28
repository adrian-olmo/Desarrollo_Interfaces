package controladoras;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import ventanas.VentanaRegistro;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraLogin implements Initializable {

    String titulo = "Registro";

    @FXML
    Button btnolvidado, btnInicioSesion, btnregistro;

    @FXML
    CheckBox checkRecordar;

    @FXML
    JFXTextField  txtnombre;

    @FXML
    JFXPasswordField txtpassword;

    @FXML
    ImageView imagenLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {

        btnInicioSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Has Iniciado Sesion");
                //VentanaInicio  ventanaInicio = new VentanaInicio();

            }
        });

        btnregistro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaRegistro ventanaRegistro = new VentanaRegistro(titulo);
                //System.out.println("Accedes a la ventana de Registro");
            }
        });
    }
}
