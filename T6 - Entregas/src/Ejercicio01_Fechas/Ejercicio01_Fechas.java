/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio01_Fechas;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Usuario DAM 2
 */
public class Ejercicio01_Fechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
       
        System.out.println("Introduce tu nombre: ");
        String nombre = sc.next();
        System.out.println("Introduce la hora del dia: ");
        int hora = sc.nextInt();
        
        if ((hora >= 6) && (hora <= 12)){
        System.out.printf("Buenos dias ");
            
        }
        if ((hora >= 13) && (hora <=20)){
            System.out.printf("Buenas tardes ");
        }
        if ((hora >= 21) && (hora < 24)){
            System.out.printf("Buenas noches ");
        }
        if ((hora >= 24) || (hora < 0)){
            System.out.printf("La hora no es correcta ");
            System.out.printf("");
        }
        
        System.out.println( nombre + " Son las " +Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + " del " +Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"/" +Calendar.getInstance().get(Calendar.MONTH)+"/"+Calendar.getInstance().get(Calendar.YEAR));
                
    }
    
}

