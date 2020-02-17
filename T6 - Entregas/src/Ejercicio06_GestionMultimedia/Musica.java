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
public class Musica extends Multimedia{

    String soporte, duracion;
    boolean directo;

    public Musica(String soporte, String duracion, boolean directo, String titulo, String autor, int anio, int codigo) {
        super(titulo, autor, anio, codigo);
        this.soporte = soporte;
        this.duracion = duracion;
        this.directo = directo;
    }

    @Override
    public String toString() {
        String grabadodirecto;
        if (directo == true){
        grabadodirecto = "en directo";
        } else {
        grabadodirecto = "no es en directo";
        }
        
        return "Musica{"+ super.toString() + " soporte: " + soporte + ", duracion: " + duracion + ", " + grabadodirecto + '}';
    }
    
   
    
}
