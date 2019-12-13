/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
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
public class PestaniaBaja extends JPanel {

    JLabel clave, nombre, apellidos, edad, calle, numero, CP;
    JTextField txtnombre, txtapellidos, txtedad, txtcalle,
            txtnumero, txtCP;

    JPanel pCentro, pInferior, pSuperior, pCentroDatos, pCentroDireccion;
    Border bordeDatos, bordeDireccion, bordeSeleccion;
    JComboBox<String> ComboClave;
    DefaultComboBoxModel modeloClaves;
    JButton btnBaja;

    public PestaniaBaja() {
        initGUI();
    }

    private void initGUI() {

        instancias();
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
        txtcalle.setEditable(false);

        pCentroDireccion.add(numero);

        pCentroDireccion.add(txtnumero);
        txtnumero.setEditable(false);

        pCentroDireccion.add(CP);
        pCentroDireccion.add(txtCP);
        txtCP.setEditable(false);

        return pCentroDireccion;
    }

    private JPanel configInferior() {
        pInferior.add(btnBaja);
        return pInferior;
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

        btnBaja = new JButton("Dar de Baja");
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

}
