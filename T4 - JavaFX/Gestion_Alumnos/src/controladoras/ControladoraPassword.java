package controladoras;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import utils.Conexion;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPassword implements Initializable {

    @FXML
    JFXTextField txtemail, txtnewpasswd;
    @FXML
    JFXButton btnconfirmar;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
        btnconfirmar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actualizarPassword();

            }
        });


    }

    public void actualizarPassword(ActionEvent event) {

        Connection conexion = null;
        try {
            conexion = Conexion.conexionBD();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement ps;
        ResultSet rs;


    }


}
