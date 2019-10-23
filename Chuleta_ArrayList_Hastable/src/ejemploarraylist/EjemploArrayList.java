/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploarraylist;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Usuario DAM 2
 */
public class EjemploArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //ArrayList
        ArrayList<Alumno> listaalumnos = new ArrayList();
        listaalumnos.add(new Alumno("Nombre1", "Apellido1", "00000001D", 123));
        listaalumnos.add(new Alumno("Nombre2", "Apellido2", "00000001D", 123));
        listaalumnos.add(new Alumno("Nombre3", "Apellido3", "00000001D", 234));

        //Recorre el ArrayList completo
        for (Alumno item : listaalumnos) {
            if (item.getMatricula() == 234) {
                System.out.println(item.getNombre());
            }

        }
        System.out.println(listaalumnos.size());

        // Listas Hashtable --> Pregunta por un dato concreto
        Hashtable<String, Alumno> listaHash = new Hashtable();
        //Añadir datos
        listaHash.put("123F", new Alumno("n1", "ap", "123F", 1234));
        Alumno a = new Alumno("n2", "ap", "123F", 1234);
        listaHash.put(a.getDni(), a);

        //borrar datos
        listaHash.remove("123F");

        //obtener datos
        Alumno encontrado = listaHash.get("234F");

        //tamaño
        listaHash.size();

        //está?
        listaHash.containsKey("234F");

        //listado
        Enumeration<Alumno> elementos = listaHash.elements();
        while (elementos.hasMoreElements()) {
            Alumno alumno = elementos.nextElement();
            System.out.println(alumno.getNombre());
        }

        Enumeration<String> claves = listaHash.keys();
        while(claves.hasMoreElements()){
            String clave = claves.nextElement();
            Alumno encontradoKey = listaHash.get(clave);
            
        }
    }

}
