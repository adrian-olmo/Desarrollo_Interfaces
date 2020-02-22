package controladoras;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.Conexion;
import utils.Usuario;
import ventanas.VentanaRegistro;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraTablas implements Initializable {

    @FXML
    Button btnCalific, btnDesconocido, btnAgregar;

    @FXML
    JFXComboBox seleccionasignatura, seleccionmodulo;

    @FXML
    TableView tabla;

    @FXML
    TableColumn <Usuario, String>tablaidAlu, tablanombreAlu, tablapellidoAlu, tablacorreoAlu, tablaModulo;




    ObservableList<Usuario> datosUsuario;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Conexion conexion = new Conexion();
        try {
            Connection connection = Conexion.conexionBD();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rellenarDatos();
        CargarUsuarios();

        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaRegistro ventanaRegistro = new VentanaRegistro("Ventana Registro");
            }
        });

        btnDesconocido.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    private void rellenarDatos(){
        datosUsuario = FXCollections.observableArrayList();

        tablaidAlu.setCellValueFactory(new PropertyValueFactory<>("DNI_usuario"));
        tablanombreAlu.setCellValueFactory(new PropertyValueFactory<>("nombre_usuario"));
        tablapellidoAlu.setCellValueFactory(new PropertyValueFactory<>("apellido_usuario"));
        tablacorreoAlu.setCellValueFactory(new PropertyValueFactory<>("email_usuario"));
        tablaModulo.setCellValueFactory(new PropertyValueFactory<>("nombre_modulo"));

        tabla.setItems(datosUsuario);
    }

    private void CargarUsuarios() {

        PreparedStatement pst = null;
        Connection connection = null;
        ResultSet rs;

        try {
            pst = connection.prepareStatement("Select * from alumnos");
            rs = pst.executeQuery();
            while(rs.next()){
                datosUsuario.add(new Usuario(rs.getString(1),rs.getString(2), rs.getString(3), ""+rs.getString(4), ""+rs.getString(5), ""+rs.getDate(6)));
            }
        }catch (SQLException ex) {
            Logger.getLogger(ControladoraTablas.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


}
