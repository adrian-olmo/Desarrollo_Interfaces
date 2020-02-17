/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraSwing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Adri
 */
public class Calculadora extends JFrame{
    
    JPanel panel_principal;
    JPanel panel_botones;
    JTextField caja;
    JButton boton[];
    JButton btnCientif1, btnCientif2, btnCientif9, btnCientif3, btnCientif4, btncientif5, btnCientif6, btnCientif7, btnCientif8, btnCientif10;
    Container container;
    GridLayout gridLayout;
    JPanel panelDer;

    double op1 = 0, op2 = 0;
    String operacion = "";
    boolean nueva = true;
    int i;
    
    public Calculadora() {
        setTitle("Calculadora Ivan");
        setSize(250, 300);
        //setResizable(false); Hacer reAjustable la ventana
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI();
        setVisible(true);
    }
    
    public void initGUI() {
        panel_principal = new JPanel();
        panel_principal.setLayout(new BorderLayout());
        caja = new JTextField();
        panel_principal.add("North", caja);
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridLayout(5, 4, 8, 8));
        agregarBotones();
        acciones();
        instancias();
        containerConfig();
        panel_principal.add("Center", panel_botones);
        getContentPane().add(panel_principal);
    }
    
    private void agregarBotones() {
        boton = new JButton[20];
        //Creamos los botones por cada una de las teclas que necesitemos
        boton[0] = new JButton("CE");
        boton[1] = new JButton("");
        boton[2] = new JButton("");
        boton[3] = new JButton("Basica/Compleja");
        boton[4] = new JButton("7");
        boton[5] = new JButton("8");
        boton[6] = new JButton("9");
        boton[7] = new JButton("/");
        boton[8] = new JButton("4");
        boton[9] = new JButton("5");
        boton[10] = new JButton("6");
        boton[11] = new JButton("*");
        boton[12] = new JButton("1");
        boton[13] = new JButton("2");
        boton[14] = new JButton("3");
        boton[15] = new JButton("-");
        boton[16] = new JButton("0");
        boton[17] = new JButton(".");
        boton[18] = new JButton("=");
        boton[19] = new JButton("+");
        for (int i = 0; i < 20; i++) {
            panel_botones.add(boton[i]);
        }
}

    private void acciones() {
        boton[19].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (op1 != 0) {
                        op1 = op1 + Double.parseDouble(caja.getText());
                    } else {
                        op1 = Double.parseDouble(caja.getText());
                    }
                    operacion = "suma";
                    caja.setText("");
                } catch (Exception err) {
                }
            }
        });
        boton[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (op1 != 0) {
                        op1 = op1 - Double.parseDouble(caja.getText());
                    } else {
                        op1 = Double.parseDouble(caja.getText());
                    }
                    operacion = "resta";
                    caja.setText("");
                } catch (Exception err) {
                }
            }
        });
        boton[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (op1 != 0) {
                        op1 = op1 * Double.parseDouble(caja.getText());
                    } else {
                        op1 = Double.parseDouble(caja.getText());
                    }
                    operacion = "multiplicacion";
                    caja.setText("");
                } catch (Exception err) {
                }
            }
        });
        boton[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (op1 != 0) {
                        op1 = op1 / Double.parseDouble(caja.getText());
                    } else {
                        op1 = Double.parseDouble(caja.getText());
                    }
                    operacion = "division";
                    caja.setText("");
                } catch (Exception err) {
                }
            }
        });
        //NUMEROS Y PUNTO DECIMAL
        boton[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "7");
            }
        });
        boton[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "8");
            }
        });
        boton[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "9");
            }
        });
        boton[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "4");
            }
        });
        boton[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "5");
            }
        });
        boton[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "6");
            }
        });
        boton[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "1");
            }
        });
        boton[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "2");
            }
        });
        boton[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "3");
            }
        });
        boton[16].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + "0");
            }
        });
        boton[17].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (nueva) {
                    caja.setText("");
                    nueva = false;
                }
                caja.setText(caja.getText() + ".");
            }
        });
        //IGUAL
        boton[18].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    op2 = Double.parseDouble(caja.getText());
                } catch (Exception err) {
                }
                if (operacion.equals("suma")) {
                    double res = op1 + op2;
                    caja.setText(String.valueOf(res));
                    op1 = op2 = 0;
                    operacion = "";
                } else if (operacion.equals("resta")) {
                    double res = op1 - op2;
                    caja.setText(String.valueOf(res));
                    op1 = op2 = 0;
                    operacion = "";
                } else if (operacion.equals("multiplicacion")) {
                    double res = op1 * op2;
                    caja.setText(String.valueOf(res));
                    op1 = op2 = 0;
                    operacion = "";
                } else if (operacion.equals("division")) {
                    double res = op1 / op2;
                    caja.setText(String.valueOf(res));
                    op1 = op2 = 0;
                    operacion = "";
                }
                nueva = true;
            }
        });
        //CE
        boton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                caja.setText("");
                op1 = op2 = 0;
                operacion = "";
            }
        });
    }

    private void instancias() {
        boton[3] = new JButton("Básica/Cientifica");
        boton[3].setActionCommand(Constantes.ACC_AG);

        container = this.getContentPane();
        panelDer = new JPanel();
    }

    private void containerConfig() {
        container.setLayout(new BorderLayout());
        //container.add(configDerecha(), BorderLayout.EAST);
    }

    /*public JPanel configDerecha() {
        panelDer.setPreferredSize(new Dimension(200, 400));
        panelDer.setLayout(new GridLayout(10, 8, 16, 16));
        panelDer.add(btnCientif1);
        panelDer.add(btnCientif2);
        panelDer.add(btnCientif3);
        panelDer.add(btnCientif4);
        panelDer.add(btncientif5);
        panelDer.add(btnCientif6);
        panelDer.add(btnCientif7);
        panelDer.add(btnCientif8);
        panelDer.add(btnCientif9);
        panelDer.add(btnCientif10);
        //panelDer.add(btnCientif5);

        return panelDer;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Constantes.ACC_AG:
                if (panelDer.isShowing()) {
                    container.remove(panelDer);
                } else {
                    container.add(panelDer, BorderLayout.WEST);
                }
                pack();
                break;
        }*/

    }


