/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Usuario DAM 2
 */
public class Persona {
    
    Integer clave, edad, numero, CP;
    String nombre, apellidos, calle;

    public Persona(Integer clave, Integer edad, Integer numero, Integer CP, String nombre, String apellidos, String calle) {
        this.clave = clave;
        this.edad = edad;
        this.numero = numero;
        this.CP = CP;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.calle = calle;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCP() {
        return CP;
    }

    public void setCP(Integer CP) {
        this.CP = CP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    
    
    
}
