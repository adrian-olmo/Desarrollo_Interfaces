/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario DAM 2
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    Container container;
    JButton boton, botonDos;
    JLabel etiqueta1, etiqueta2, etiqueta3, etiqueta4;
    JPanel panelsuperior, panelinferior, panelderecho, panelizquierdo;

    public void initGUI() {
        instancias();
        configurarcontainer();
        this.setTitle("Ejemplo principal de ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(300, 300, 500, 500);
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        //this.pack(); //Reduce al tamaño minimo
        this.setVisible(true);
    }

    public void acciones() {
        boton.addActionListener(this);
        botonDos.addActionListener(this);
    }

    private void instancias() {
        container = this.getContentPane();
        boton = new JButton("Pulsar");
        botonDos = new JButton("Pulsar Dos");
        //etiqueta1 = new JLabel("Posicion Uno");
        //etiqueta2 = new JLabel("Posicion Dos");
        //etiqueta3 = new JLabel("Posicion Tres");
        //etiqueta4 = new JLabel("Posicion Cuatro");
        panelsuperior = new JPanel();
        panelinferior = new JPanel();
        panelderecho = new JPanel();
        panelizquierdo = new JPanel();
    }

    private void configurarcontainer() {
        /*container.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
         *container.setLayout(new GridLayout(//Filas 2, //Columnas 3, 20, 20));
         *container.add(etiqueta1, BorderLayout.NORTH);
         *container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS ));
         */
        //        container.add(etiqueta1);
        //        container.add(etiqueta2);
        //        container.add(etiqueta3);
        //        container.add(etiqueta4);
        //        container.add(boton);
        //        container.add(botonDos);

        container.setLayout(new BorderLayout());
        container.add(configurarPanelSuperior(), BorderLayout.NORTH);
        container.add(configurarPanelInferior(), BorderLayout.SOUTH);
        container.add(configurarPanelDerecho(), BorderLayout.EAST);
        container.add(configurarPanelIzquierdo(), BorderLayout.WEST);
        //El contendos lo coloca de la manera que le digas, mientras que el panel de la manera indicada en el metodo
    }

    public JPanel configurarPanelSuperior() {
        panelsuperior.add(new JLabel("Superior 1"));
        panelsuperior.add(new JLabel("Superior 2"));
        panelsuperior.add(new JLabel("Superior 3"));

        return panelsuperior;
    }

    public JPanel configurarPanelInferior() {
        panelinferior.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelinferior.add(new JLabel("Inferior 1"));
        panelinferior.add(new JLabel("Inferior 2"));
        panelinferior.add(new JLabel("Inferior 3"));

        return panelinferior;
    }
    
    public JPanel configurarPanelDerecho(){
        panelderecho.setLayout(new GridLayout(3, 1));
        panelderecho.add(new JLabel("Derecha 1"));
        panelderecho.add(new JLabel("Derecha 2"));
        panelderecho.add(new JLabel("Derecha 3"));
        
        return panelderecho;
    }
    
    public JPanel configurarPanelIzquierdo() {
        panelizquierdo.setLayout(new GridLayout(3, 1));
        panelizquierdo.add(new JLabel("Izquierda 1"));
        panelizquierdo.add(new JLabel("Izquierda 2"));
        panelizquierdo.add(new JLabel("Izquierda 3"));
    
        return panelizquierdo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Boton Pulsado");
        if (e.getSource() == boton) {
            System.out.println("Boton uno pulsado");

        } else if (e.getSource() == botonDos) {
            System.out.println("Boton dos pulsado");
        }
    }

    
}
