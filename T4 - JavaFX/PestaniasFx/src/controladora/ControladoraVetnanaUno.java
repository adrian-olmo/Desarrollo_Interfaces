package controladora;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVetnanaUno implements Initializable {

    DropShadow sombra = new DropShadow();
    ToggleGroup gruporadios;

    @FXML
    Button btnNormal, btnImagen, btnSiguiente;
    @FXML
    Tab tab_botones, tab_textos, tab_tablas;
    @FXML
    CheckBox checkBox;
    @FXML
    RadioButton radio1, radio2, radio3;
    @FXML
    JFXTextField textomaterial;
    @FXML
    TextArea textoarea;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //textomaterial.setPromptText("aaaaaaaaa");
        //textoarea.setWrapText(true);
        instancias();
        acciones();
        personalizarbotones();

    }

    private void instancias() {
        gruporadios = new ToggleGroup();
        radio1.setUserData(new Persona("Adrian", "Soltero"));
        radio2.setUserData(new Persona("Carlos", "Casado"));
        radio3.setUserData(new Persona("Esther", "Casada"));
        gruporadios.getToggles().addAll(radio1, radio2, radio3);
    }

    private void personalizarbotones() {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("../resources/button_ok.png")));
        btnImagen.setGraphic(imageView);
    }

    private void acciones() {

        btnNormal.setOnMouseEntered(new ManejoRaton());
        btnNormal.setOnMouseExited(new ManejoRaton());
        btnImagen.setOnMousePressed(new ManejoRaton());
        btnImagen.setOnMouseReleased(new ManejoRaton());
        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    btnNormal.setDisable(true);
                } else {
                    btnNormal.setDisable(false);
                }
            }
        });

        btnNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(checkBox.isSelected());
                //gruporadios.getSelectedToggle();
                gruporadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                        Persona seleccionado = (Persona) newValue.getUserData();
                        System.out.println(seleccionado.getEstado());
                    }
                });
            }
        });

    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (event.getSource() == btnNormal) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    btnNormal.setEffect(sombra);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    btnNormal.setEffect(null);
                }
            } else if (event.getSource() == btnImagen) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    btnImagen.setEffect(sombra);
                } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    btnImagen.setEffect(null);
                }

            }

        }
    }
}
