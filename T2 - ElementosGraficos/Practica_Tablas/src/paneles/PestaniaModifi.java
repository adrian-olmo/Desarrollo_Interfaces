/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Adri
 */
public class PestaniaModifi extends JPanel implements ActionListener{

    JLabel clave, nombre, apellidos, edad, calle, numero, CP;
    JTextField txtnombre, txtapellidos, txtedad, txtcalle,
            txtnumero, txtCP;

    JPanel pCentro, pInferior, pSuperior, pCentroDatos, pCentroDireccion;
    Border bordeDatos, bordeDireccion, bordeSeleccion;
    JComboBox<String> ComboClave;
    DefaultComboBoxModel modeloClaves;
    JButton btnmodificar, btnlimpiar;

    public PestaniaModifi() {
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
        pSuperior.setLayout(new GridLayout(1, 1));
        pSuperior.setBorder(bordeSeleccion);
        pSuperior.add(clave);
        pSuperior.add(ComboClave);
        return pSuperior;
    }

    private JPanel configCentro() {
        pCentro.setLayout(new GridLayout(2, 1));
        pCentro.add(configCentroDatos());
        pCentro.add(configCentroDireccion());
        return pCentro;
    }

    private JPanel configCentroDatos() {

        pCentroDatos.setLayout(new GridLayout(3, 2));
        pCentroDatos.setBorder(bordeDatos);
        pCentroDatos.add(nombre);
        pCentroDatos.add(txtnombre);
        pCentroDatos.add(apellidos);
        pCentroDatos.add(txtapellidos);
        pCentroDatos.add(edad);
        pCentroDatos.add(txtedad);

        return pCentroDatos;
    }

    private JPanel configCentroDireccion() {

        pCentroDireccion.setLayout(new GridLayout(3, 2));
        pCentroDireccion.setBorder(bordeDireccion);
        pCentroDireccion.add(calle);
        pCentroDireccion.add(txtcalle);
        pCentroDireccion.add(numero);
        pCentroDireccion.add(txtnumero);
        pCentroDireccion.add(CP);
        pCentroDireccion.add(txtCP);

        return pCentroDireccion;
    }

    private JPanel configInferior() {
        pInferior.add(btnmodificar);
        pInferior.add(btnlimpiar);
        return pInferior;
    }

    private void acciones() {
        btnlimpiar.addActionListener(this);
        txtedad.addKeyListener(new ManejoTeclas());
        txtnumero.addKeyListener(new ManejoTeclas());
        txtCP.addKeyListener(new ManejoTeclas());
    }

    private void instancias() {

        clave = new JLabel("Clave");
        nombre = new JLabel("Nombre:");
        apellidos = new JLabel("Apellidos:");
        edad = new JLabel("Edad:");
        calle = new JLabel("Calle:");
        numero = new JLabel("Número");
        CP = new JLabel("Código Postal:");

        txtnombre = new JTextField();
        txtapellidos = new JTextField();
        txtedad = new JTextField();
        txtcalle = new JTextField();
        txtnumero = new JTextField();
        txtCP = new JTextField();

        btnmodificar = new JButton("Modificar");
        btnlimpiar = new JButton("Limpiar");
        ComboClave = new JComboBox();
        modeloClaves = new DefaultComboBoxModel();

        pCentro = new JPanel();
        pCentroDatos = new JPanel();
        pCentroDireccion = new JPanel();
        pInferior = new JPanel();
        pSuperior = new JPanel();

        bordeDatos = new TitledBorder(new EtchedBorder(), "Datos Personales");
        bordeDireccion = new TitledBorder(new EtchedBorder(), "Direccion");
        bordeSeleccion = new TitledBorder(new EtchedBorder(), "Selección clave");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnlimpiar){
            txtnombre.setText("");
            txtapellidos.setText("");
            txtedad.setText("");
            txtcalle.setText("");
            txtnombre.setText("");
            txtnumero.setText("");
            txtCP.setText("");
        }
    }

    class ManejoTeclas extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (e.getSource() == txtedad) {
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (txtedad.getText().length() > 2) {
                        e.consume();
                    }
                }
            } else if (e.getSource() == txtnumero) {
                if (!Character.isDigit(tecla)) {
                    e.consume();
                } else {
                    if (txtnumero.getText().length() > 8) {
                        e.consume();
                    }
                }
            }else if (e.getSource() == txtCP) {
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
