/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import utils.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelRegistro extends JPanel implements ActionListener {

    JButton btnaddnombre, btnaddapellido, btnaddnota, btnaddfct, btnvalidar;

    public PanelRegistro() {

        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void instancias() {
        btnaddnombre = new JButton("ADD NOMBRE");
        btnaddapellido = new JButton("ADD APELLIDO");
        btnaddnota = new JButton("ADD NOTA");
        btnaddfct = new JButton("ADD FCT");
        btnvalidar = new JButton("VALIDAR");
    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(5, 0));

        this.add(btnaddnombre);
        this.add(btnaddapellido);
        this.add(btnaddnota);
        this.add(btnaddfct);
        this.add(btnvalidar);
    }

    private void acciones() {
        btnaddnombre.addActionListener(this);
        btnaddapellido.addActionListener(this);
        btnaddnota.addActionListener(this);
        btnaddfct.addActionListener(this);
        btnvalidar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnaddnombre) {
            String datoIntro = JOptionPane.showInputDialog(PanelRegistro.this, "Introduce Nombre",
                    "Introduce datos", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);

        } else if (e.getSource() == btnaddapellido) {
             String datoIntro = JOptionPane.showInputDialog(PanelRegistro.this, "Introduce Apellidos",
                    "Introduce datos", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);

        } else if (e.getSource() == btnaddnota) {
             String datoIntro = JOptionPane.showInputDialog(PanelRegistro.this, "Introduce Apellidos",
                    "Introduce datos", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);

        } else if (e.getSource() == btnaddfct) {
             String datoIntro = JOptionPane.showInputDialog(PanelRegistro.this, "Introduce Apellidos",
                    "Introduce datos", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);
        }
    }
}
