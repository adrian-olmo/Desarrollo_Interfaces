/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_clases01;

/**
 *
 * @author Usuario DAM 2
 */
public class Ejercicio_Repaso_Clases01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        coche coche1 = new coche("Seat", "123F", "ibiza", "125 cv", 123, 123);
        coche coche2 = new coche("Ferrari", "234F", "F320", "230 cv", 234, 234);
        
        System.out.println(coche1.getCv());
        coche1.acelerar(50);
        coche1.acelerar(50);
        coche1.decelerar(100);
        System.out.println(coche1.getVelocidad());
        if (coche1.estaParado()){
            System.out.println("El coche esta parado");
        }
        else{
            System.out.println("El coche esta en marcha");
        }
    }
    
}
