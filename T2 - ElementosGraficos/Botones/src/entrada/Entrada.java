/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;

import javax.swing.SwingUtilities;

/**
 *
 * @author Usuario DAM 2
 */
public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v = new Ventana();
                v.initGUI();
            }
        });
    }
}
