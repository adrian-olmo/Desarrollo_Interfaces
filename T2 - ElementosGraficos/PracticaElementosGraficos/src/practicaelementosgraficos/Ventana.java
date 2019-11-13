/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaelementosgraficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Usuario DAM 2
 */
public class Ventana extends JFrame implements ActionListener {

    Container container;
    JPanel anadir, buscar, panelCard;
    JLabel mostrarDatos;
    JButton btnaddnombre, btnaddapellido, btnaddnota, btnaddfct, btnvalidar, abripersona;
    CardLayout cardLayout;

    JMenuBar barraMenu;
    JMenu menuUno;
    JMenuItem itemBuscar, itemRegistro;

    public void initGUI() {
        intancias();
        configurarMenu();
        panelCard();
        acciones();
        this.setSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void acciones() {
        btnaddnombre.addActionListener(this);
        btnaddapellido.addActionListener(this);
        btnaddnota.addActionListener(this);
        btnaddfct.addActionListener(this);
        btnvalidar.addActionListener(this);
        abripersona.addActionListener(this);
    }

    private void configurarMenu() {

        barraMenu.add(menuUno);
        menuUno.add(itemBuscar);
        menuUno.add(itemRegistro);
        this.setJMenuBar(barraMenu);
    }

    private JPanel panelCard() {
        cardLayout = new CardLayout();
        container.setLayout(cardLayout);
        container.add(panelAñadir(), "añadir");
        container.add(panelBuscar(), "buscar");
        return panelCard;
    }

    private JPanel panelAñadir() {
        anadir.setLayout(new GridLayout(5, 1));
        anadir.add(btnaddnombre);
        anadir.add(btnaddapellido);
        anadir.add(btnaddnota);
        anadir.add(btnaddfct);
        anadir.add(btnvalidar);
        return anadir;
    }

    private JPanel panelBuscar() {
        buscar.setLayout(new GridBagLayout());
        buscar.add(abripersona);
        buscar.add(mostrarDatos);

        return buscar;
    }

    private void intancias() {
        container = this.getContentPane();
        anadir = new JPanel();
        buscar = new JPanel();
        panelCard = new JPanel();
        mostrarDatos = new JLabel("prueba");
        barraMenu = new JMenuBar();
        menuUno = new JMenu("Opciones");
        itemBuscar = new JMenuItem("Buscar");
        itemRegistro = new JMenuItem("Registrar");
        btnaddnombre = new JButton("ADD NOMBRE");
        btnaddapellido = new JButton("ADD APELLIDO");
        btnaddnota = new JButton("ADD NOTA");
        btnaddfct = new JButton("ADD FCT");
        btnvalidar = new JButton("VALIDAR");
        abripersona = new JButton("ABRIR");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == itemBuscar){
            cardLayout.show(container, "Buscar");
        }

        if (e.getSource() == btnaddnombre) {
            String datoIntro = JOptionPane.showInputDialog(Ventana.this, "Introduce Nombre",
                    "Introduce datos", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);

        } else if (e.getSource() == btnaddapellido) {
            String datoIntro = JOptionPane.showInputDialog(Ventana.this, "Introduce Apellidos",
                    "Introduce datos", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);

        } else if (e.getSource() == btnaddnota) {
            JOptionPane.showInputDialog(null, "Selecciona una nota", "Introduce Datos", JOptionPane.QUESTION_MESSAGE, null,
                    new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0);

        } else if (e.getSource() == btnaddfct) {
            JOptionPane.showConfirmDialog(Ventana.this, "FCTs Realizadas", "Introduce Datos", JOptionPane.YES_NO_OPTION);

        }

    }

}
