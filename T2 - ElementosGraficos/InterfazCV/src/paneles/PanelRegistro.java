/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import interfazcv.Ventana;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import utils.Persona;

public class PanelRegistro extends JPanel implements ActionListener {

    JLabel etiquetaPrincipal, etiquetaNombre, etiquetaDireccion, etiquetaTelefono, etiquetaDNI, seleccionEstudios, añosExperiencia;
    JTextField txtDireccion, txtNombre, txtTelefono, txtDNI;
    JButton botonInsertarDatos, botonSalir;
    JPanel panelCentro, panelTitulo;
    JSpinner aniosExperiencia;
    SpinnerModel modeloSpinner;
    JComboBox<String> trabajos;
    Container container;
    ButtonGroup grupo1;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    JRadioButton radioButton3;

    public PanelRegistro() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configGridBag();
        acciones();
    }

    private void instancias() {
        etiquetaPrincipal = new JLabel("Introduce tus Datos");
        etiquetaNombre = new JLabel("Nombre");
        etiquetaDireccion = new JLabel("Direccion");
        etiquetaTelefono = new JLabel("Telefono");
        etiquetaDNI = new JLabel("DNI");
        seleccionEstudios = new JLabel("Selecciona sus estudios");
        añosExperiencia = new JLabel("Años de experiencia");
        txtNombre = new JTextField();
        txtTelefono = new JTextField();
        txtDNI = new JTextField();
        txtDireccion = new JTextField();
        botonInsertarDatos = new JButton(new ImageIcon("src/resources/addpng.png"));
        botonSalir = new JButton(new ImageIcon("src/resources/salida.png"));
        panelCentro = new JPanel();
        panelTitulo = new JPanel();
        modeloSpinner = new SpinnerNumberModel(1, 1, 20, 1);
        aniosExperiencia = new JSpinner(modeloSpinner);
        grupo1 = new ButtonGroup();
        radioButton1 = new JRadioButton("Soltero", true);
        radioButton2 = new JRadioButton("Casado", false);
        radioButton3 = new JRadioButton("Divorciado", false);
        grupo1.add(radioButton1);
        grupo1.add(radioButton2);
        grupo1.add(radioButton3);
        trabajos = new JComboBox();
        trabajos.addItem("Ingenieria Informatica");
        trabajos.addItem("Ingenieria Industrial");
        trabajos.addItem("Ingenieria Telecomunicaciones");
        trabajos.addItem("Ingenieria Software");
        trabajos.addItem("Ingenieria Hardware");
        trabajos.addItem("Ingenieria Aeronautica");
        trabajos.addItem("Medicina");
        trabajos.addItem("Magisterio");
        trabajos.addItem("Arquitectura");
        trabajos.addItem("Derecho");
        trabajos.addItem("Administracion de Empresas");
        trabajos.addItem("Turismo y Hosteleria");
        trabajos.addItem("Psicologia");
    }

    private void configGridBag(int x, int y, int tx, int ty, double px, double py, int anchor, int fill, Component c) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = tx;
        constraints.gridheight = ty;
        constraints.weightx = px;
        constraints.weighty = py;
        constraints.anchor = anchor;
        constraints.fill = fill;
        panelCentro.add(c, constraints);
    }

    private void configGridBag() {
        this.setLayout(new BorderLayout());
        panelCentro.setLayout(new GridBagLayout());
        configGridBag(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaPrincipal);
        configGridBag(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaNombre);
        configGridBag(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, seleccionEstudios);
        configGridBag(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, txtNombre);
        configGridBag(1, 2, 3, 1, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, trabajos);
        configGridBag(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaTelefono);
        configGridBag(0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, txtTelefono);
        configGridBag(0, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaDNI);
        configGridBag(1, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, radioButton1);
        configGridBag(2, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, radioButton2);
        configGridBag(3, 5, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, radioButton3);
        configGridBag(0, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, txtDNI);
        configGridBag(1, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, añosExperiencia);
        configGridBag(2, 6, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, aniosExperiencia);
        configGridBag(0, 7, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, etiquetaDireccion);
        configGridBag(0, 8, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, txtDireccion);
        configGridBag(1, 8, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, botonInsertarDatos);
        configGridBag(2, 8, 2, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, botonSalir);
        this.add(panelCentro, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Salir":
                System.exit(0);
                break;
            case "Insertar":
                insertarPersonas();
                break;

        }
    }

    public void insertarPersonas() {
        String nombre = txtNombre.getText();
        String experiencia = aniosExperiencia.getModel().getValue().toString();
        String telefono = txtTelefono.getText();
        String DNI = txtDNI.getText();
        String direccion = txtDireccion.getText();
        String profesion = trabajos.getSelectedItem().toString();
        String estado = null;

        if (radioButton1.isSelected()) {
            estado = radioButton1.getText();
            
        } else if (radioButton2.isSelected()) {
            estado = radioButton2.getText();
            
        } else if (radioButton3.isSelected()) {
            estado = radioButton3.getText();
            
        }

        if (txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDNI.getText().isEmpty() || txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Faltan Datos", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
        } else if (!existePersona(DNI)) {
            Persona nuevaPersona = new Persona(nombre, telefono, DNI, direccion, estado, profesion, experiencia);
            Ventana.listadoPersonas.add(nuevaPersona);
            JOptionPane.showMessageDialog(this, "Persona agregada correctamente");
        }
    }

    public boolean existePersona(String DNI) {
        for (int i = 0; i < Ventana.listadoPersonas.size(); i++) {
            if (DNI.equalsIgnoreCase(Ventana.listadoPersonas.get(i).getDNI())) {
                JOptionPane.showMessageDialog(this, "El DNI ya esta registrado", "Fatal Error", JOptionPane.ERROR_MESSAGE, null);
                return true;
            }
        }

        return false;

    }

    private void acciones() {
        botonInsertarDatos.setActionCommand("Insertar");
        botonSalir.setActionCommand("Salir");
        botonInsertarDatos.addActionListener(this);
        botonSalir.addActionListener(this);
        txtDireccion.addActionListener(this);
        txtNombre.addActionListener(this);
        txtTelefono.addActionListener(this);
        txtDNI.addActionListener(this);

    }
}
