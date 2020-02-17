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
public class Libro extends Multimedia {

    boolean soportedig;
    int numpaginas, edicion;

    public Libro(boolean soportedig, int numpaginas, int edicion, String titulo, String autor, int anio, int codigo) {
        super(titulo, autor, anio, codigo);
        this.soportedig = soportedig;
        this.numpaginas = numpaginas;
        this.edicion = edicion;
    }

    @Override
    public String toString() {
        return "Libro{" + super.toString() + " edicion: " + edicion + ", soporte digital: " + soportedig + ", numero de páginas: " + numpaginas + '}';
    }
    

}
