/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario DAM 2
 */
public class PestaniaOcho extends JPanel{
    
    JLabel letras, tamanio, tipo, estilo;
    JComboBox letrasComb, tamanioComb, tipoComb, estiloComb;
    
    public PestaniaOcho(){
        initGUI();
    }

    public void initGUI() {
        instancias();
        configVentana();
    }

    private void instancias() {
        letras = new JLabel("Letras");
        tamanio = new JLabel("Tamaño");
        tipo = new JLabel("Tipo");
        estilo = new JLabel("Estilo");
        letrasComb = new JComboBox();
        tamanioComb = new JComboBox();
        tipoComb = new JComboBox();
        estiloComb = new JComboBox();
    }

    private void configVentana() {
        this.setLayout(new GridLayout(2,2));
        this.add(letrasComb);
        this.add(letras);
        this.add(tamanioComb);
        this.add(tamanio);
        this.add(tipoComb);
        this.add(tipo);
        this.add(estiloComb);
        this.add(estilo);
    }
    
}
