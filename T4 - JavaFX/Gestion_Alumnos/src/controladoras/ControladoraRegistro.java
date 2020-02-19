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
import javafx.scene.control.Alert;
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

    ObservableList<String> modulos = FXCollections.observableArrayList("1ºDAM", "2ºDAM");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboModulo.setItems(modulos);
        acciones();

    }

    private void acciones() {
        btnregistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String valorDNI, valorNombre, valorApellido, valorCorreo, valorPasswd,valoModulo;

                valorDNI = DNIRegistro.getText();
                valorNombre = txtnombreregistro.getText();
                valorApellido = txtapellidoregistro.getText();
                valorCorreo = txtcorreoregistro.getText();
                valorPasswd = passwordregistro.getText();
                valoModulo = (String) comboModulo.getValue();


                try {
                    Usuario usuarioRegistro = new Usuario(valorDNI, valorNombre, valorApellido, valorCorreo, valorPasswd,valoModulo);
                    SqlCLientes sqlCLientes = new SqlCLientes();
                    sqlCLientes.RegistroClientes(usuarioRegistro);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public class SqlCLientes extends Conexion {
        public boolean RegistroClientes(Usuario cliente) throws SQLException {
            PreparedStatement ps = null;
            Connection conexion = conexionBD();


            String query = "Insert into %s (%s,%s,%s,%s,%s, %s) VALUES ('%s','%s','%s','%s','%s','%s')";

            try {
                Statement statement = conexion.createStatement();
                statement.execute(String.format(query, "usuario", "DNI_usuario", "nombre_usuario", "apellido_usuario", "email_usuario", "password", "nombre_modulo",
                        cliente.getDNI_usuario(), cliente.getNombre_usuario(), cliente.getApellido_usuario(), cliente.getEmail_usuario(), cliente.getPassword(), cliente.getNombre_modulo())); //"" campos de la BBDD

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Usuario Dado de Alta");
                alert.setHeaderText("");
                alert.setContentText("../resourceso/okay.png");
                alert.showAndWait();

                return true;
            } catch (SQLException e) {
                SQLException ex;
                return false;
            }


        }
    }
}
