/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio06_GestionMultimedia;

import java.io.Serializable;

/**
 *
 * @author Usuario DAM 2
 */
public abstract class Multimedia implements Serializable{

    String titulo;
    String autor;
    int anio;
    int codigo;

    public Multimedia(String titulo, String autor, int anio, int codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", autor: " + autor + ", año: " + anio + ", codigo: " + codigo;
    }
}
