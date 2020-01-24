import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ventanas.Ventana;

public class Entrada {

    public static void main(String[] args) {

        Ventana pizzeria = new Ventana();
        Ventana.mostrar();

    }
}