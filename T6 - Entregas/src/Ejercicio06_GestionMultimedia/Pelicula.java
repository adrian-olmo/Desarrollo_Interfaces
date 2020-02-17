/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio06_GestionMultimedia;

/**
 *
 * @author Usuario DAM 2
 */
public class Pelicula extends Multimedia{
    
    String actor, pais, duracion;

    public Pelicula(String actores, String pais, String duracion, String titulo, String autor, int anio, int codigo) {
        super(titulo, autor, anio, codigo);
        this.actor = actores;
        this.pais = pais;
        this.duracion = duracion;
    }
    
    
    @Override
    public String toString() {
       return "Pelicula{" + super.toString() + ", pais: " + pais + ", duracioin: " + duracion + ", actores: " +actor;


    }
}
