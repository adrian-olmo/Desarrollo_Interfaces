/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Adri
 */
public class PestaniaResumen extends JPanel {

    JLabel clave, nombre, apellidos, edad, calle, numero, CP;
    JTextField txtclave, txtnombre, txtapellidos, txtedad, txtcalle,
            txtnumero, txtCP;

    JButton btnAlta, btnBaja;
    JPanel pCentro, pInferior, pSuperior;

    Border bordeDatos;
    JTable tabla;

    public PestaniaResumen() {
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

        return pSuperior;
    }

    private JPanel configCentro() {
        pCentro.setLayout(new GridLayout(3, 2));
        pCentro.setBorder(bordeDatos);
        pCentro.add(clave);
        pCentro.add(txtclave);
        pCentro.add(nombre);
        pCentro.add(txtnombre);
        pCentro.add(apellidos);
        pCentro.add(txtapellidos);
        pCentro.add(edad);
        pCentro.add(txtedad);
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

    private void instancias() {

        clave = new JLabel("Clave");
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
        
        String columnas[] = {"Nombre","Apellido","Telefono"};
        

    }

}
