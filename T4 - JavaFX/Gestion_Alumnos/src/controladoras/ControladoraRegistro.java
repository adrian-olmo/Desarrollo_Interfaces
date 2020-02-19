package controladoras;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import utils.Conexion;
import utils.Usuario;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ControladoraRegistro implements Initializable {

    @FXML
    JFXButton btnregistrar;

    @FXML
    JFXTextField DNIRegistro, txtnombreregistro, txtapellidoregistro, txtcorreoregistro, passwordregistro;


    @FXML
    ComboBox comboModulo;

    ObservableList <String> modulos = FXCollections.observableArrayList("1ºDAM", "2ºDAM");




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboModulo.setItems(modulos);
        acciones();

    }

    private void acciones() {
        btnregistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

   /* private Usuario AgregarUsuario() throws SQLException {
        Usuario usuarioAgregado = new Usuario();
        Connection conexion = null;
        try {
            conexion = Conexion.conexionBD();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "Insert into %s (%s,%s,%s,%s,%s) VALUES (%d,'%s','%s','%s','%s')";

        try {
            Statement statement = conexion.createStatement();
            statement.execute(String.format(query, "usuario", "Id", "Nombre", "Apellido", "Correo", "Password",
                    0, cliente.getNombre(), cliente.getApellido(), cliente.getCorreo(), cliente.getPassword()));
            System.out.println(query + "Los valores han sido agregados a la base de datos!");
            return true;
        } catch (SQLException e) {
            SQLException ex;
            return false;
        }*/

    }
