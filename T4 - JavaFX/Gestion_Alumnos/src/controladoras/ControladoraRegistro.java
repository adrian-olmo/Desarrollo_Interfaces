package controladoras;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import utils.Conexion;
import utils.Usuario;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                try {
                    Usuario usuario = AgregarUsuario();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
        ResultSet rs;
        String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?)";

        ps.setString(1, usuarioAgregado.getDNI_usuario());
        ps.setString(2, usuarioAgregado.getNombre_usuario());
        ps.setString(3, usuarioAgregado.getApellido_usuario());
        ps.setString(4, usuarioAgregado.getEmail_usuario());
        ps.setString(5, usuarioAgregado.getPassword());
        ps.setString(6, usuarioAgregado.getNombre_modulo());

        rs = ps.executeQuery(sql);



        return usuarioAgregado;
    }
}
