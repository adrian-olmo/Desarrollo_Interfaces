package controladoras;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utils.Conexion;
import utils.Usuario;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControladoraTablas implements Initializable {

    @FXML
    Button btnCalific, btnDesconocido, btnAgregar;

    @FXML
    JFXComboBox seleccionasignatura, seleccionmodulo;

    @FXML
    TableView tabla;

    @FXML
    TableColumn tablaidAlu, tablanombreAlu, tablapellidoAlu, tablacorreoAlu;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    private Usuario AgregarUsuario() throws SQLException {
        Usuario usuarioAgregado = new Usuario();
        Connection conexion = null;
        try {
            conexion = Conexion.conexionBD();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        int rs;
        String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?)";

        ps.setInt(1, usuarioAgregado.getId_usuario());
        ps.setString(2, usuarioAgregado.getNombre_usuario());
        ps.setString(3, usuarioAgregado.getApellido_usuario());
        ps.setString(4, usuarioAgregado.getEmail_usuario());
        ps.setInt(5, usuarioAgregado.getId_moduloUsu());

        rs = ps.executeUpdate();

        return null;
    }
}
