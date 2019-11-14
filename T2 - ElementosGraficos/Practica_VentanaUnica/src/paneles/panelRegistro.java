/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import utils.Persona;

/**
 *
 * @author irone
 */
public class panelRegistro extends JPanel {

    JLabel nombre, apell, dni, edad;
    JTextField txtNombre, txtApell, txtDni;
    JSpinner edades;
    SpinnerNumberModel modeloEdades;
    
    public panelRegistro() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        configPanel();
        acciones();
    }

    private void instancias() {

        nombre = new JLabel("Nombre");
        apell = new JLabel("Apellido");
        dni = new JLabel("DNI");
        edad = new JLabel("Edad");
        txtApell = new JTextField();
        txtNombre = new JTextField();
        txtDni = new JTextField();
        modeloEdades = new SpinnerNumberModel(0, 0, 100, 1);
        edades = new JSpinner(modeloEdades);

    }

    private void configurarConstrait(int x, int y, int tx, int ty, double px, double py, int anchor, int fill, Component c) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = tx;
        constraints.gridheight = ty;
        constraints.weightx = px;
        constraints.weighty = py;
        constraints.anchor = anchor;
        constraints.fill = fill;
        this.add(c, constraints);
    }

    private void configPanel() {
        this.setLayout(new GridBagLayout());
        configurarConstrait(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, nombre);
        configurarConstrait(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, txtNombre);
        configurarConstrait(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, apell);
        configurarConstrait(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, txtApell);
        configurarConstrait(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, dni);
        configurarConstrait(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, txtDni);
        configurarConstrait(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, edad);
        configurarConstrait(1, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, edades);

    }

    public SpinnerNumberModel getEdad() {
        return modeloEdades;
    }

    public JTextField gettNombre() {
        return txtNombre;
    }

    public JTextField getApell() {
        return txtApell;
    }

    public JTextField gettDni() {
        return txtDni;
    }

    public Persona devolPersona() {
        Persona per = new Persona(txtNombre.getText(), txtApell.getText(), txtDni.getText(), Integer.valueOf(edades.getValue().toString()));
        vaciarCampos();
        return per;
    }

    private void vaciarCampos() {
        txtNombre.setText("");
        txtApell.setText("");
        txtDni.setText("");
        edades.setValue(0);
    }

    private void acciones() {
        txtNombre.addKeyListener(new ManejoTeclas());
        txtApell.addKeyListener(new ManejoTeclas());
        txtDni.addKeyListener(new ManejoTeclas());
    }

    class ManejoTeclas extends KeyAdapter {

        public void keyTyped(KeyEvent e) {
            char cadena = e.getKeyChar();
            if (e.getSource() == txtNombre) {
                if (Character.isDigit(cadena)) {
                    e.consume();
                }
            } else if (e.getSource() == txtApell) {
                if (Character.isDigit(cadena)) {
                    e.consume();
                }
            } else if (e.getSource() == txtDni) {
                if (txtDni.getText().length() > 10) {
                    e.consume();
                }
            }
        }
    }
}
