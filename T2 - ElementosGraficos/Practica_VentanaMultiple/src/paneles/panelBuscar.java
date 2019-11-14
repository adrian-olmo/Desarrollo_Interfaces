/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import utils.Persona;

/**
 *
 * @author irone
 */
public class panelBuscar extends JPanel implements ActionListener {

    JLabel salidaPer, salidaDatos;
    JComboBox comboBox;
    DefaultComboBoxModel comboBakano;
    JProgressBar barraProgreso;
    JButton botonNormal, bDialogoInfo, bDialogoWarn, bDialogoError, bDialogoOpciones, bDialogoOpcionesPerso,
            bDialogoEntrada, bDialogoEntradaPersona;
    int opcion;

    public panelBuscar() {
        initGUI();
    }

    private void initGUI() {

        instancias();
        configPanel();
        acciones();
        configPB();
    }

    private void instancias() {
        salidaPer = new JLabel("Persona");
        comboBakano = new DefaultComboBoxModel();
        comboBakano.addElement("Selecciona una persona");
        comboBox = new JComboBox(comboBakano);
        salidaDatos = new JLabel("Datos");
        botonNormal = new JButton("Pulsar");
        barraProgreso = new JProgressBar();
        bDialogoError = new JButton("Error");
        bDialogoWarn = new JButton("Aviso");
        bDialogoInfo = new JButton("Info");
        bDialogoOpciones = new JButton("Pregunta");
        bDialogoOpcionesPerso = new JButton("Pregunta perso");
        bDialogoEntrada = new JButton("Entrada");
        bDialogoEntradaPersona = new JButton("Entrada persona");
    }

    private void configPanel() {

        this.setLayout(new GridLayout(13, 2));
        this.add(salidaPer);
        this.add(comboBox);
        this.add(botonNormal);
        this.add(barraProgreso);
        this.add(bDialogoInfo);
        this.add(bDialogoWarn);
        this.add(bDialogoError);
        this.add(bDialogoOpciones);
        this.add(bDialogoOpcionesPerso);
        this.add(bDialogoEntrada);
        this.add(bDialogoEntradaPersona);
    }

    private void configPB() {

        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);
        barraProgreso.setValue(0);
        //barraProgreso.getValue();
        barraProgreso.setStringPainted(true);
        barraProgreso.setBorderPainted(true);
    }

    private void acciones() {
        botonNormal.addActionListener(this);
        bDialogoInfo.addActionListener(this);
        bDialogoWarn.addActionListener(this);
        bDialogoError.addActionListener(this);
        bDialogoOpciones.addActionListener(this);
        bDialogoOpcionesPerso.addActionListener(this);
        bDialogoEntrada.addActionListener(this);
        bDialogoEntradaPersona.addActionListener(this);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (comboBox.getModel().getSelectedItem().getClass() == Persona.class) {
                    Persona entontrada = (Persona) comboBox.getModel().getSelectedItem();
                    salidaDatos.setText(String.format("La persona es:", entontrada.getNombre()));
                }
            }
        });
    }

    public DefaultComboBoxModel getModeloCombo() {
        return comboBakano;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonNormal) {
            barraProgreso.setValue(barraProgreso.getValue() + 25);
            if (barraProgreso.getValue() == 100) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(panelBuscar.this, "Proceso completo",
                        "Titulo del mensaje", JOptionPane.INFORMATION_MESSAGE, null);
            }
        } else if (e.getSource() == bDialogoInfo) {
            JOptionPane.showMessageDialog(panelBuscar.this, "ESte es un diálogo de información",
                    "Titulo del mensaje", JOptionPane.INFORMATION_MESSAGE, null);
            
        } else if (e.getSource() == bDialogoError) {

            JOptionPane.showMessageDialog(panelBuscar.this, "ESte es un diálogo de error",
                    "Titulo del mensaje", JOptionPane.ERROR_MESSAGE, null);

        } else if (e.getSource() == bDialogoWarn) {
            JOptionPane.showMessageDialog(panelBuscar.this, "ESte es un diálogo de warning",
                    "Titulo del mensaje", JOptionPane.WARNING_MESSAGE, null);
            
        } else if (e.getSource() == bDialogoOpciones) {
            opcion = JOptionPane.showConfirmDialog(panelBuscar.this,
                    "¿Segudo que quieres continuar?",
                    "Titulo del mensaje", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null);

            if (opcion == JOptionPane.YES_OPTION) {
                System.out.println("Pulsado si");
            } else if (opcion == JOptionPane.NO_OPTION) {
                System.out.println("Pulsado no");
            } else if (opcion == JOptionPane.CANCEL_OPTION) {
                System.out.println("Pulsado cancelar");
            }

        } else if (e.getSource() == bDialogoOpcionesPerso) {
            String[] opciones = {"Boton1", "Boton2", "Boton3"};
            Persona[] personas = {new Persona("Ivan", "Redondo", "326737364", 21),
                new Persona("Ivan", "Redondo", "326737364", 21),
                new Persona("Ivan", "Redondo", "326737364", 21)};
            int opcionPerso = JOptionPane.showOptionDialog(panelBuscar.this, "Selecciona una opción",
                    "Título del diálogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    personas, personas[0]);
            switch (opcionPerso) {
                case 0:
                    System.out.println("Boton 1 pulsado");
                    break;
                case 1:
                    System.out.println("Boton 2 pulsado");
                    break;
                case 2:
                    System.out.println("Boton 3 pulsado");
                    break;
            }
        } else if (e.getSource() == bDialogoEntrada) {
            String datoIntro = JOptionPane.showInputDialog(panelBuscar.this, "Introduce datos",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datoIntro);
        } else if (e.getSource() == bDialogoEntradaPersona) {
            Persona[] personas = {new Persona("Ivan", "Redondo", "326737364", 21),
                new Persona("Ivan", "Redondo", "326737364", 21),
                new Persona("Ivan", "Redondo", "326737364", 21)};

            Persona seleccionada = (Persona) JOptionPane.showInputDialog(panelBuscar.this, "Selecciona una persona",
                    "Titulo", JOptionPane.INFORMATION_MESSAGE, null, personas, personas[0]);
            System.out.println(seleccionada.getNombre());
        }
    }
}
