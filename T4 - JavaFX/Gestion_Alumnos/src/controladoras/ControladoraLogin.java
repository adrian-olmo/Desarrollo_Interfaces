package controladoras;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraLogin implements Initializable {

    @FXML
    Button btnolvidado, btnInicioSesion, btnregistro;

    @FXML
    CheckBox checkRecordar;

    @FXML
    TextField txtnombre;

    @FXML
    PasswordField txtpassword;

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
                //VentanaRegistro ventanaRegistro = new VentanaRegistro();
                System.out.println("Accedes a la ventana de Registro");
            }
        });
    }
}
