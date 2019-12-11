/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloSimple;
import util.Persona;

/**
 *
 * @author Adri
 */
public class PestaniaResumen extends JPanel {
    
    ArrayList<Persona> personas;
    
    

    JLabel clave, nombre, apellidos, edad, calle, numero, CP;
    JTextField txtclave, txtnombre, txtapellidos, txtedad, txtcalle,
            txtnumero, txtCP;

    JButton btnAlta, btnBaja;
    JPanel pCentro, pInferior, pSuperior;

    Border bordeDatos;
    JTable tabla;
    ModeloSimple modeloSimple;
    
    JScrollPane scroll;

    public PestaniaResumen() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(scroll, BorderLayout.NORTH);
        this.add(configCentro(), BorderLayout.CENTER);
        this.add(configInferior(), BorderLayout.SOUTH);
    }

    

    private JPanel configCentro() {
        pCentro.setLayout(new GridLayout(7, 2));
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
        
        ArrayList personas = new ArrayList();
        personas.add(new Persona(12,12,12,12,"a","a","a"));
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
        
        
        modeloSimple = new ModeloSimple(personas);
        tabla = new JTable(modeloSimple);
        
        scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(100,100));
        
        

    }

}
