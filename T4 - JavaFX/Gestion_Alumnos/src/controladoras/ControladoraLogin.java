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
import utils.Conexion;
import utils.Usuario;
import ventanas.VentanaPassword;
import ventanas.VentanaRegistro;
import ventanas.VentanaTablas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControladoraLogin implements Initializable {

    String tituloregistro = "Registro";
    String titulopassword = "He olvidado mi contraseña";

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
                Conexion conexion = null;
                Usuario alumno = null;

                try {
                    conexion = new Conexion();
                } catch (SQLException e) {
                    System.err.println("Error al abrir la base de datos " + e.getMessage());
                    System.exit(1);
                }


                if  ((txtnombre.getText() == alumno.getNombre_usuario())&& (txtpassword.getText()    == alumno.getPassword())){
                    System.out.println("Conexion Satisfactoria");
                    VentanaTablas ventanaTablas = new VentanaTablas();
                }



            }
        });

        btnregistro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaRegistro ventanaRegistro = new VentanaRegistro(tituloregistro);

            }
        });

        btnolvidado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaPassword ventanaPassword = new VentanaPassword(titulopassword);
            }
        });
    }
}
