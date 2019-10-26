/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PestaniaTres extends JPanel implements ChangeListener, ActionListener, FocusListener{

    JTextField textoNormal, textoNormalDos;
    TextFieldNumeros textoNumeros, textoNumerosDos, textoNumerosTres;
    JButton bValidar;

    public PestaniaTres() {
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        acciones();
    }

    private void acciones() {
        bValidar.addActionListener(this);
        textoNormal.addFocusListener(this);
        textoNormalDos.addKeyListener(new ManejoKey());
        //textoNumerosTres.addMouseMotionListener();

    }

    private void configurarPanel() {
        this.add(textoNormal);
        this.add(textoNormalDos);
        this.add(textoNumeros);
        this.add(textoNumerosDos);
        this.add(textoNumerosTres);
        this.add(bValidar);
    }

    private void instancias() {

        textoNormal = new JTextField("Aviso", 20);
        textoNormalDos = new JTextField("", 20);
        textoNumeros = new TextFieldNumeros("Hint",20);
        textoNumerosDos = new TextFieldNumeros("qweqwe",20);
        textoNumerosTres = new TextFieldNumeros("Hiqweqeqweqwent",20);
        bValidar = new JButton("Validar");
    }

    @Override
    public void stateChanged(ChangeEvent e) {


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bValidar) {
            if (textoNormal.getText().length() >= 10) {
                System.out.println(textoNormal.getText());
            } else {
                System.out.println("No se puede validar");
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        System.out.println("foco ganado");
        if (textoNormal.getText().equals("Aviso")){
            textoNormal.setText("");
        }

    }
    @Override
    public void focusLost(FocusEvent e) {
        System.out.println("foco perdido");
        if (textoNormal.getText().length() == 0) {
            textoNormal.setText("Aviso");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    class ManejoKey extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            //System.out.println("pressed");
            //System.out.println(e.getKeyChar());
            if (Character.isDigit(e.getKeyChar())){
                System.out.println("es digito");
            }else {
                e.consume();
                System.out.println("no es digito");
            }

        }
    }


}

