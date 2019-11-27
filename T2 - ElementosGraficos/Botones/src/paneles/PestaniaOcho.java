/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario DAM 2
 */
public class PestaniaOcho extends JPanel implements ItemListener{

    JLabel letras, tamanio, tipo, estilo;
    JComboBox letrasComb, tamanioComb, tipoComb, estiloComb;
    DefaultComboBoxModel modeloLetra, modeloTamanio, modeloTipo, modeloEstilo;

    public PestaniaOcho() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        configPanel();
        acciones();
        rellenarletras();
    }

    private void instancias() {
        letras = new JLabel("Letras");
        tamanio = new JLabel("Tamaño");
        tipo = new JLabel("Tipo");
        estilo = new JLabel("Estilo");

        modeloLetra = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();
        modeloTipo = new DefaultComboBoxModel();
        modeloEstilo = new DefaultComboBoxModel();

        letrasComb = new JComboBox(modeloLetra);
        tamanioComb = new JComboBox(modeloTamanio);
        tipoComb = new JComboBox(modeloTipo);
        estiloComb = new JComboBox(modeloEstilo);

    }

    private void configPanel() {
        this.setLayout(new GridLayout(4, 2));
        this.add(letras);
        this.add(letrasComb);
        this.add(tamanio);
        this.add(tamanioComb);
        this.add(tipo);
        this.add(tipoComb);
        this.add(estilo);
        this.add(estiloComb);

    }

    private void rellenarletras() {

        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts(); //coge todas las fuentes del equipo

        for (Font item : fuentes) {
            modeloLetra.addElement(item.getName());
        }
    }

    private void acciones() {
        letrasComb.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if (e.getSource() == letrasComb){
            String tipo = (String) modeloLetra.getSelectedItem();
            System.out.println(tipo);
            Font fuente = new Font(tipo, Font.BOLD, 13);
            letras.setFont(fuente);
        }
    }

}
