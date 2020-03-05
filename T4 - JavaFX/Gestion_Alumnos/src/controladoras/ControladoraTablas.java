package controladoras;

import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.Conexion;
import utils.Usuario;
import ventanas.VentanaRegistro;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraTablas implements Initializable {

    @FXML
    Button btnDesconocido, btnAgregar;

    @FXML
    TextField nombrealumno;

    @FXML
    TableView tabla;

    @FXML
    TableColumn <Usuario, String>tablaidAlu, tablanombreAlu, tablapellidoAlu, tablacorreoAlu, tablaModulo;

    ObservableList<Usuario> datosUsuario;
    FilteredList<Usuario> usuarioFiltrado;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Conexion conexion = new Conexion();
        try {
            Connection connection = Conexion.conexionBD();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rellenarDatos();
        cargarUsuarios();

        nombrealumno.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                usuarioFiltrado.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuariofiltro) {
                        return usuariofiltro.getNombre_usuario().contains(newValue);
                    }
                });
            }
        });

        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaRegistro ventanaRegistro = new VentanaRegistro("Ventana Registro");
                Stage stage = (Stage) btnAgregar.getScene().getWindow();
                stage.close();
            }
        });

        btnDesconocido.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tabla.refresh();

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

    private void cargarUsuarios() {

        Connection conexion = null;
        try {
            conexion = Conexion.conexionBD();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps;
        ResultSet rs;


        try {
            ps = conexion.prepareStatement("SELECT DNI_usuario, nombre_usuario, apellido_usuario, email_usuario, nombre_modulo FROM usuario");
            rs = ps.executeQuery();
            while(rs.next()){
                datosUsuario.add(new Usuario(rs.getString("DNI_usuario"),rs.getString("nombre_usuario"),rs.getString("apellido_usuario"), rs.getString("email_usuario"),rs.getString("nombre_modulo")));
            }
        }catch (SQLException ex) {
            Logger.getLogger(ControladoraTablas.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


}
