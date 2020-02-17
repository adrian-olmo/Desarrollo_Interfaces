/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio02_Array50nums;

import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Usuario DAM 2
 */
public class Ejercicio02_Array50nums {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[50];
        boolean salir = true;
        
        while (salir) {
            System.out.println("1. Rellenar");
            System.out.println("2. Listar");
            System.out.println("3. Ordenar");
            System.out.println("4. Vaciar");
            System.out.println("5. Salir");
            System.out.println("Elige una opcion del menú: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < numeros.length; i++) {
                        numeros[i] = (int) (Math.random() * 200) + 1;
                    }
                    break;
                case 2:
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.println("Elemento " + (i + 1) + ":" + numeros[i]);
                    }
                    break;
                case 3:
                    Arrays.sort(numeros);
                    break;
                case 4:
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.println(numeros[i] = 0);
                    }
                    break;
                case 5:
                    salir = false;
                default:
                    break;
                    
            }
        }

    }

}

