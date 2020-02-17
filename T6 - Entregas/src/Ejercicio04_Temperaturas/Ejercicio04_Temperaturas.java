/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio04_Temperaturas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Usuario DAM 2
 */
public class Ejercicio04_Temperaturas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salida = true;
        String opcionanadir;
        ArrayList<Double> temperaturas = new ArrayList<Double>();

        while (salida) {

            System.out.println("1. Introducir temperaturas");
            System.out.println("2. Mostrar temperaturas");
            System.out.println("3. Ordenar temperaturas");
            System.out.println("4. Mostrar extremos");
            System.out.println("5. Mostrar medidas");
            System.out.println("6. Salir");
            System.out.println("Elige una opción del menú");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("Introduzca la temperatura:");
                        temperaturas.add(sc.nextDouble());
                        System.out.println("¿Quieres seguir intoduciendo temperaturas?: (s/n)");
                        opcionanadir = sc.next();
                        opcionanadir = opcionanadir.toUpperCase();
                    } while (opcionanadir.equals("S"));
                    break;
                case 2:
                    if (temperaturas.size() == 0) {
                        System.out.println("No hay temperaturas disponibles");
                    } else {
                        for (Double valores : temperaturas) {
                            System.out.println("- " + valores);
                        }
                    }
                    break;
                case 3:
                    Collections.sort(temperaturas);
                    for (Double i : temperaturas) {
                        System.out.println("- " + i);
                    }
                    break;
                case 4:
                    Collections.sort(temperaturas);
                    double max = 0;
                    for (int i = 0; i < temperaturas.size(); i++) {
                        if (temperaturas.get(i) > max) {
                            max = temperaturas.get(i);
                        }
                    }
                    double min = max;
                    for (int i = 0; i < temperaturas.size(); i++) {
                        if (temperaturas.get(i) < min) {
                            min = temperaturas.get(i);
                        }
                    }
                    System.out.println("Máximo: " + max);
                    System.out.println("Mínimo: " + min);
                    break;
                case 5:
                    double media = 0.0;
                    for (int i = 0; i < temperaturas.size(); i++){
                        media = media + temperaturas.get(i);
                    }
                    System.out.println("La temperatura media es: " +media/temperaturas.size());
                    break;
                case 6:
                    salida = false;
                    break;
                default:
                    System.out.println("Escriba una opcion válida");
                    break;
            }
        }

    }

}
