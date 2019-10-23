/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_clases02;

public class Coche {

    private String marca, matricula, modelo;
    private int cv, bastidor;
    private boolean dentro = true;

    public Coche() {
    }

    public Coche(String marca, String matricula, String modelo, int cv, int bastidor) {
        this.marca = marca;
        this.matricula = matricula;
        this.modelo = modelo;
        this.cv = cv;
        this.bastidor = bastidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getBastidor() {
        return bastidor;
    }

    public void setBastidor(int bastidor) {
        this.bastidor = bastidor;
    }

    @Override
    public String toString() {
        return "Coche:\n" + "marca=" + marca + "\nmatricula=" + matricula + "\nmodelo=" + modelo + "\ncv=" + cv + "\nbastidor=" + bastidor;
    }
    
}
