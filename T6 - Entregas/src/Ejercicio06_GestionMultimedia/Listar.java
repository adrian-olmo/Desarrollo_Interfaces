/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio06_GestionMultimedia;

/**
 *
 * @author Adri
 */
import java.util.Enumeration;
import java.util.Hashtable;

public class Listar {

    private Hashtable<String, Multimedia> listado;

    public Listar() {
        listado = new Hashtable();
    }

    public void agregar(Multimedia elemento) {
        listado.put(elemento.getTitulo(), elemento);
    }

    public boolean comprobar(String titulo) {
        return listado.containsKey(titulo);
    }

    public void eliminar(String titulo) {
        listado.remove(titulo);
    }

    public void listado() {
        Enumeration<Multimedia> e = listado.elements();
        while (e.hasMoreElements()) {
            Multimedia elemento = e.nextElement();
            System.out.println(elemento);

        }

    }

}