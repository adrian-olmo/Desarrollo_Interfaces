/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio03_AdivinaNum;

import java.util.Scanner;

/**
 *
 * @author Usuario DAM 2
 */
public class Ejercicio03_AdivinaNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int aleatorio = (int) (Math.random() * 100);
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        int intentos = 0;
        while (numero != aleatorio) {
            intentos++;
            System.out.println("Introduce un número");
            numero = entrada.nextInt();
            if (aleatorio < numero) {
                System.out.println("Mas bajo");
            } else if (aleatorio > numero) {
                System.out.println("Mas alto");
            }
        }
        System.out.println("Correcto. Lo has conseguido en " + intentos + " intentos");
    }
}
