package controladoras;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import utils.Conexion;
import utils.Usuario;
import ventanas.VentanaPassword;
import ventanas.VentanaRegistro;
import ventanas.VentanaTablas;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ControladoraLogin implements Initializable {

    String tituloregistro = "Registro";
    String titulopassword = "He olvidado mi contraseña";
    String titulotablas = "Bienvenido";

    Usuario alumno = new Usuario();

    @FXML
    Button btnolvidado, btnInicioSesion, btnregistro;


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
                System.out.println(txtnombre.getText());
                if ((txtnombre.getText().isEmpty()) || (txtpassword.getText().isEmpty())) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Advertencia");
                    alert.setHeaderText("");
                    alert.setContentText("Campo Vacio");
                    alert.showAndWait();


                } else {
                    boolean nombre_correcto = false;

                    try {
                        if ((txtnombre.getText().equals(usuario.getNombre_usuario())) && (txtpassword.getText().equals(usuario.getPassword()))) {
                            nombre_correcto=false;
                        }
                    } catch (NullPointerException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("");
                        alert.setContentText("Campo Erroneo");
                        alert.showAndWait();
                        nombre_correcto = true;
                    }
                    if(!nombre_correcto){
                        VentanaTablas ventanaTablas = new VentanaTablas(titulotablas);
                    }
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

            while (rs.next()) {
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
