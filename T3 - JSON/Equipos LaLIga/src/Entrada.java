import org.json.JSONException;

import javax.swing.*;
import java.io.IOException;

public class Entrada {
    public static void main(String[] args) throws IOException, JSONException {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v = new Ventana();
            }
        });

    }
}
