package controladoras;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Conexion;
import utils.Usuario;
import ventanas.VentanaPassword;
import ventanas.VentanaRegistro;
import ventanas.VentanaTablas;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ControladoraLogin implements Initializable {

    String tituloregistro = "Registro";
    String titulopassword = "He olvidado mi contraseña";

    Usuario alumno = new Usuario();

    @FXML
    Button btnolvidado, btnInicioSesion, btnregistro;

    @FXML
    CheckBox checkRecordar;

    @FXML
    JFXTextField txtnombre;

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
                Usuario usuario = InicioSesion();

                if (txtnombre.getText().equals(usuario.getNombre_usuario()) && (txtpassword.getText().equals(usuario.getPassword()))) {
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

    private Usuario InicioSesion() {

        Connection conexion = null;
        try {
            conexion = Conexion.conexionBD();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps;
        ResultSet rs;

        String nombreUsuario = txtnombre.getText().toString();
        String passwordUsuario = txtpassword.getText().toString();
        Usuario usuarioInicio = null;

        //Sentencia
        String sql = "SELECT * FROM usuario WHERE nombre_usuario = ? AND password = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, passwordUsuario);
            rs = ps.executeQuery();

            while (rs.next()){
                String nombreInicio = rs.getString("nombre_usuario"); //Nombre de la columna de la BBDD
                String passwordInicio = rs.getString("password"); //Password de la columna de la BBDD
                usuarioInicio = new Usuario(nombreInicio, passwordInicio);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioInicio;
    }


}
