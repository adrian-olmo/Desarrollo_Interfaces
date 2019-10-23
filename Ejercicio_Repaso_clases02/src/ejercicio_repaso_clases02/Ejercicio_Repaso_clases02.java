/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_clases02;

import java.util.Hashtable;
import java.util.Scanner;

/*
* 1- Registrar coche
* 2- Desregistrar coche
* 3- Listar registrados 
* 4- Mostrar coches en el garaje
* 5- Sacar coche del garaje
* 6- 1. Acelerar coche
* 6- 2. Decelerar coche 
* 7- Salir
 */
public class Ejercicio_Repaso_clases02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Garaje garaje = new Garaje();
        String opcion;
         while(true){
        System.out.println("* 1- Registrar coche\n"
                + "* 2- Desregistrar coche\n"
                + "* 3- Listar registrados \n"
                + "* 4- Meter coches en el garaje\n"
                + "* 5- Sacar coche del garaje\n"
                + "* 6- 1. Acelerar coche\n"
                + "* 6- 2. Decelerar coche \n"
                + "* 7- Salir");
        System.out.println("Introduce opcion a trabajar");
        opcion = sc.next();
       
        switch (opcion) {
            case "1":
                String marca, matricula, modelo;
                int cv, bastidor;
                
                System.out.println("Que matricula?");
                matricula = sc.next();
                if(!garaje.comprobarCoche(matricula)){
                // Solo lo hace si no esta la matricula del coche
                System.out.println("Que marca?");
                marca = sc.next();         
                System.out.println("Que modelo?");
                modelo = sc.next();
                System.out.println("Que cv?");
                cv = sc.nextInt();
                System.out.println("Que bastidor?");
                bastidor = sc.nextInt();
                Coche coche = new Coche(matricula, marca, modelo, cv, bastidor);
                garaje.agregarCoche(coche);
                
                }
                else{
                    System.out.println("No puedo porque existe");
                }
                break;
            
            case "2":
                String matriculaEliminar;
                System.out.println("Introduzca la matricula que desea eliminar");
                matriculaEliminar = sc.next();
                if (!garaje.comprobarCoche(matriculaEliminar)){
                    System.out.println("No se puede eliminar porque no existe");
                }
                else{
                garaje.eliminarCoche(matriculaEliminar);
                }
                
            case "3": 
                System.out.println("Lista de los coches:");
                garaje.listarCoches();
                break;
            case "4":
                System.out.println("Que coche quieres sacar: (Introduce la matricula)");
                matricula = sc.next();
                sc.nextLine();
            case "5":        
            case "7":
                System.out.println("Ha salido del programa. ");
                break;
            default:
        }
        }
    }     
}


