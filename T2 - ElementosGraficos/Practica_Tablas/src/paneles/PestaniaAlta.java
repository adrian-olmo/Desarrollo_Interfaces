/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Adri
 */
public class PestaniaAlta extends JPanel implements ActionListener {

    JLabel clave, nombre, apellidos, edad, calle, numero, CP;
    JTextField txtclave, txtnombre, txtapellidos, txtedad, txtcalle,
            txtnumero, txtCP;

    JButton btnAlta;
    JPanel pCentro, pInferior, pSuperior;

    Border bordeDatos, bordeDireccion;

    public PestaniaAlta() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configSuperior(), BorderLayout.NORTH);
        this.add(configCentro(), BorderLayout.CENTER);
        this.add(configInferior(), BorderLayout.SOUTH);
    }

    private JPanel configSuperior() {
        pSuperior.setLayout(new GridLayout(4, 2));

        pSuperior.setBorder(bordeDatos);

        pSuperior.add(clave);
        pSuperior.add(txtclave);
        pSuperior.add(nombre);
        pSuperior.add(txtnombre);
        pSuperior.add(apellidos);
        pSuperior.add(txtapellidos);
        pSuperior.add(edad);
        pSuperior.add(txtedad);

        return pSuperior;
    }

    private JPanel configCentro() {
        pCentro.setLayout(new GridLayout(3, 2));
        pCentro.setBorder(bordeDireccion);
        pCentro.add(calle);
        pCentro.add(txtcalle);
        pCentro.add(numero);
        pCentro.add(txtnumero);
        pCentro.add(CP);
        pCentro.add(txtCP);

        return pCentro;

    }

    private JPanel configInferior() {
        pInferior.add(btnAlta);
        return pInferior;
    }

    private void acciones() {
        btnAlta.addActionListener(this);
        txtclave.addKeyListener(new ManejoTeclas());
        txtedad.addKeyListener(new ManejoTeclas());
        txtnumero.addKeyListener(new ManejoTeclas());
        txtCP.addKeyListener(new ManejoTeclas());
    }

    private void instancias() {

        clave = new JLabel("Clave:");
        nombre = new JLabel("Nombre:");
        apellidos = new JLabel("Apellidos:");
        edad = new JLabel("Edad:");
        calle = new JLabel("Calle:");
        numero = new JLabel("Número");
        CP = new JLabel("Código Postal:");

        txtclave = new JTextField();
        txtnombre = new JTextField();
        txtapellidos = new JTextField();
        txtedad = new JTextField();
        txtcalle = new JTextField();
        txtnumero = new JTextField();
        txtCP = new JTextField();

        btnAlta = new JButton("Dar de Alta");

        pCentro = new JPanel();
        pInferior = new JPanel();
        pSuperior = new JPanel();

        bordeDatos = new TitledBorder(new EtchedBorder(), "Datos Personales");
        bordeDireccion = new TitledBorder(new EtchedBorder(), "Direccion");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nombre_anadido, apellido_anadido;
        int clave_anadida, edad_anadida;

        if (e.getSource() == btnAlta) {
            if (txtclave.getText().isEmpty() || txtnombre.getText().isEmpty() || txtapellidos.getText().isEmpty() || txtedad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(PestaniaAlta.this, "Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE, null);
            } else {

            }
        }

    }

    class ManejoTeclas extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (e.getSource() == txtclave) {
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (txtclave.getText().length() > 4) {
                        e.consume();
                    }
                }
            } else if (e.getSource() == txtedad) {
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (txtedad.getText().length() > 2) {
                        e.consume();
                    }
                }
            } else if (e.getSource() == txtnumero){
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (txtnumero.getText().length() > 8) {
                        e.consume();
                    }
                }
            } else if (e.getSource() == txtCP){
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (txtCP.getText().length() > 4) {
                        e.consume();
                    }
                }
            }
        }
    }
}
