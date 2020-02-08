package controladoras;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
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

    }
}
