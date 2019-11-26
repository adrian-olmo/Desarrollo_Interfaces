/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcv;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import paneles.*;
import utils.Persona;

/**
 *
 * @author Adri
 */
public class Ventana extends JFrame implements ActionListener{
    
    Container container; //*
    JMenuBar barraMenu; //*
    JMenu menuprincipal; //*
    JMenuItem itemregistrar, itembuscar, itemadjuntar; //*
    CardLayout cardLayout; //*
    PanelBuscar pBuscar; //*
    PanelRegistro pRegistro; //*
    JTabbedPane panelPestanias; //*
    public static ArrayList<Persona> listadoPersonas; //*
    
    
    public void initGUI(){
        instancias();
        configMenu();
        configVentana();
        acciones();
        this.setTitle("Interfaz CV");
        //this.setIconImage(new ImageIcon("src/resources/cv.png"));
        this.setSize(new Dimension(600, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    private void instancias() {
         
        container = this.getContentPane();
        barraMenu = new JMenuBar();
        menuprincipal = new JMenu("Menu Empleados");
        itemregistrar = new JMenuItem("Registrar Empleado");
        itembuscar = new JMenuItem("Buscar Empleado");
        itemadjuntar = new JMenuItem("Adjuntar Archivos");
        cardLayout = new CardLayout();
        pBuscar = new PanelBuscar();
        pRegistro = new PanelRegistro();
        panelPestanias = new JTabbedPane();
        listadoPersonas = new ArrayList<>();
        
    }

    private void configMenu() {
        
        barraMenu.add(menuprincipal);
        menuprincipal.add(itemregistrar);
        menuprincipal.add(itembuscar);
        menuprincipal.add(itemadjuntar);
        this.setJMenuBar(barraMenu);
    }

    private void configVentana() {
        container.add(configCentro(), BorderLayout.CENTER);
    }

    private Component configCentro() {
        panelPestanias.setLayout(cardLayout);
        panelPestanias.add(pRegistro, "REGISTRO");
        panelPestanias.add(pBuscar, "BUSCAR");
        return panelPestanias;
    }

    private void acciones() {
        
        itembuscar.addActionListener(this);
        itemregistrar.addActionListener(this);
        itemadjuntar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == itemregistrar){
            panelPestanias.setSelectedIndex(0);
            
        } else if (e.getSource() == itembuscar){
            panelPestanias.setSelectedIndex(1);
            
        } else if (e.getSource() == itemadjuntar){
            JOptionPane.showMessageDialog(this, "Busca CV en el PC", "Adjuntar", JOptionPane.INFORMATION_MESSAGE, null);
        }
    }
    
}
