/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridlayout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

/**
 *
 * @author irone
 */
class Ventana extends JFrame implements ActionListener {

    JTextField nombre, apellido, dni;
    JButton ingresar, salir;
    JSpinner edad;
    SpinnerNumberModel medad;
    Container contenedor;
    JPanel pCentro, pInf;

    public Ventana() throws HeadlessException {

        initGUI();
    }

    public void initGUI() {

        instancias();
        configVentana();
        acciones();
        setVisible(true);
        setTitle("Grid Layout ERROR");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(400, 300));
    }

    private void instancias() {
        nombre = new JTextField();
        apellido = new JTextField();
        dni = new JTextField();
        ingresar = new JButton("Ingresar");
        salir = new JButton("Salir");
        medad = new SpinnerNumberModel(0, 0, 100, 1);
        edad = new JSpinner(medad);
        contenedor = getContentPane();
        pCentro = new JPanel();
        pInf = new JPanel();
    }

    private void acciones() {
        ingresar.addActionListener(this);
        salir.addActionListener(this);
    }

    public void configVentana() {

        contenedor.add(configurarPanelCentral(), BorderLayout.CENTER);
        contenedor.add(configurarPanelInf(), BorderLayout.SOUTH);

    }

    public JPanel configurarPanelCentral() {
        this.setLayout(new GridLayout(10, 3));
        this.add(new JLabel("Nombre"));
        this.add(nombre);
        this.add(new JLabel("Apellido"));
        this.add(apellido);
        this.add(new JLabel("DNI"));
        this.add(dni);
        this.add(new JLabel("Edad"));
        this.add(edad);
        return pCentro;
    }

    public JPanel configurarPanelInf() {
        //this.setLayout(new FlowLayout());
        pInf.add(ingresar);
        pInf.add(salir);
        return pInf;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            System.exit(0);
        }
    }
}
