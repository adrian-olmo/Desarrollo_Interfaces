/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_clases02;

import java.util.Enumeration;
import java.util.Hashtable;

public class Garaje {
Coche coche = new Coche();
    private Hashtable<String, Coche> listadoCoches;

    public Garaje() {
        listadoCoches = new Hashtable();
    }

    public void agregarCoche(Coche coche) {
        listadoCoches.put(coche.getMatricula(), coche);
        System.out.println("Coche agregado correctamente");
    }

    public void eliminarCoche(String matricula) {
        listadoCoches.remove(matricula);

    }
    
    public void listarCoches(){
        Enumeration<Coche> elementos = listadoCoches.elements();
        while (elementos.hasMoreElements()){
        Coche c = elementos.nextElement();
            System.out.println(c);
        }
    }
    
    public void sacarCoches(String matricula){}

    public boolean comprobarCoche(String matricula) {
        return listadoCoches.contains(matricula);
    }

}
