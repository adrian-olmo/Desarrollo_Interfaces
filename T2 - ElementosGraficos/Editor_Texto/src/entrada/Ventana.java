/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

/**
 *
 * @author Adri
 */
public class Ventana extends JFrame{

    Container container;
    JMenuBar barraMenu;
    JMenu menuArchivo, menuEdicion, menuEstilo;
    JMenuItem itemNuevo, itemAbrir, itemCerrar, itemGuardar,
            itemGuardarcomo, itemImprimir, itemCopiar, itemCortar, itemPegar,
            itemBold, itemNormal, itemCursiva;

    public void initGUI() {
        instancias();
        configmenu();
        this.setSize(new Dimension(700,250));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void instancias() {

        container = this.getContentPane();
        barraMenu = new JMenuBar();
        /*---------------------------------------------------------------------*/
        
        menuArchivo = new JMenu("Archivo");
       
        itemNuevo = new JMenuItem("Nuevo");
        itemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        itemNuevo.setToolTipText("Ctrl + N");

        itemAbrir = new JMenuItem("Abrir");
        itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        itemAbrir.setToolTipText("Ctrl + A");

        itemCerrar = new JMenuItem("Cerrar");
        itemCerrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.ALT_DOWN_MASK));
        itemCerrar.setToolTipText("Alt + F4");

        itemGuardar = new JMenuItem("Guardar");
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
        itemGuardar.setToolTipText("Ctrl + G");

        itemGuardarcomo = new JMenuItem("Guardar como...");
        itemImprimir = new JMenuItem("Imprimir");

        /*---------------------------------------------------------------------*/
        menuEdicion = new JMenu("Edicion");
        
        itemCopiar = new JMenuItem("Copiar");
        itemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        itemCopiar.setToolTipText("Ctrl + C");
        
        itemCortar = new JMenuItem("Cortar");
        itemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        itemCopiar.setToolTipText("Ctrl + X");
        
        itemPegar = new JMenuItem("Pegar");
        itemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        itemCopiar.setToolTipText("Ctrl + V");

        /*---------------------------------------------------------------------*/
        menuEstilo = new JMenu("Estilo de la fuente");
        itemBold = new JMenuItem("Negrita");
        itemNormal = new JMenuItem("Normal");
        itemCursiva = new JMenuItem("Cursiva");

    }

    private void configmenu() {
        barraMenu.add(menuArchivo);
        
        itemNuevo.add(menuArchivo);
        itemAbrir.add(menuArchivo);
        itemCerrar.add(menuArchivo);
        itemGuardar.add(menuArchivo);
        itemGuardarcomo.add(menuArchivo);
        itemImprimir.add(menuArchivo);
        
        barraMenu.add(menuEdicion);
        itemCopiar.add(menuEdicion);
        itemCortar.add(menuEdicion);
        itemPegar.add(menuEdicion);
        
        menuEstilo.add(menuEdicion);
        itemBold.add(menuEstilo);
        itemNormal.add(menuEstilo);
        itemCursiva.add(menuEstilo);
        
        this.setJMenuBar(barraMenu);
    }
}
