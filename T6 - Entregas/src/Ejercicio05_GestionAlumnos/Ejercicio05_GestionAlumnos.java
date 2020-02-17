/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio05_GestionAlumnos;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Usuario DAM 2
 */
public class Ejercicio05_GestionAlumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        Hashtable<String, Alumno> listaHash = new Hashtable();

        while (salir) {
            System.out.println("1. Agregar alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Borrar alumno");
            System.out.println("4. Listar alumnos");
            System.out.println("5. Listar dnis");
            System.out.println("6. Salir");
            System.out.println("Elige una opcion: ");

            int opcionmenu = sc.nextInt();

            switch (opcionmenu) {
                case 1:
                    System.out.println("Introduce el DNI de un alumno: ");
                    String dni = sc.next();
                    if (!listaHash.containsKey(dni)) {

                        System.out.println("Introduce el nombre de un alumno: ");
                        String nombre = sc.next();
                        System.out.println("Introduce el apellido de un alumno: ");
                        String apellido = sc.next();

                        int matricula = (int) (Math.random() * 10000);
                        System.out.println("Matricula " + matricula);
                        Alumno alumno = new Alumno(nombre, apellido, dni, matricula);
                        listaHash.put(alumno.getDni(), alumno);
                    } else {
                        System.out.println("El alumno ya esta registrado");
                    }
                    break;

                case 2:
                    System.out.println("Introduce DNI que quieres buscar: ");
                    String dnibuscado = sc.next();
                    if (listaHash.containsKey(dnibuscado)) {
                        Alumno encontrado = listaHash.get(dnibuscado);
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    ;
                    break;
                case 3:
                    System.out.println("Introduce el DNI para eliminar: ");
                    dnibuscado = sc.next();
                    if (listaHash.containsKey(dnibuscado)) {
                        Alumno encontrado = listaHash.get(dnibuscado);
                        listaHash.remove(encontrado.getDni());
                        System.out.println("Eliminado");
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;
                case 4:
                    Enumeration<Alumno> elementos = listaHash.elements();
                    while (elementos.hasMoreElements()) {
                        Alumno alumno1 = elementos.nextElement();
                        System.out.println(alumno1.toString());
                    }
                    break;
                case 5:
                    Enumeration<String> claves = listaHash.keys();
                    while (claves.hasMoreElements()) {
                        String clave = claves.nextElement();
                        Alumno encontradoKey = listaHash.get(clave);
                        System.out.println(encontradoKey.getDni());

                    }
                    break;
                case 6:
                    salir = false;
                    break;
            }
        }
    }

}
