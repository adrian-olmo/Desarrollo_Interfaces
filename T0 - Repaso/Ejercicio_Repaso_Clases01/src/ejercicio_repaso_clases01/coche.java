/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_clases01;

/**
 *
 * @author Usuario DAM 2
 */
public class coche {
    private String marca, matricula, modelo, cv;
    private int bastidor, velocidad;

    public coche(String marca, String matricula, String modelo, String cv, int bastidor) {
        this.marca = marca;
        this.matricula = matricula;
        this.modelo = modelo;
        this.cv = cv;
        this.bastidor = bastidor;
       
    }

    public coche(String marca, String matricula, String modelo, String cv, int bastidor, int velocidad) {
        this.marca = marca;
        this.matricula = matricula;
        this.modelo = modelo;
        this.cv = cv;
        this.bastidor = bastidor;
        this.velocidad = velocidad;
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

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public int getBastidor() {
        return bastidor;
    }

    public void setBastidor(int bastidor) {
        this.bastidor = bastidor;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public void acelerarCoche(){
    this.velocidad += 50;
    }
    
    public void acelerar(int velocidad){
    this.velocidad = velocidad;
    }
    
    public void decelerar(int velocidad){
         if (this.velocidad < velocidad){
         this.velocidad = 0;
         }
         else{
         this.velocidad -= velocidad;
         }
    }
    
    public boolean estaParado(){
        if(this.velocidad <= 0){
        return true;
        }
        else{
        return false;
        }
    
    }

    @Override
    public String toString() {
        return "coche{" + "marca=" + marca + ", matricula=" + matricula + ", modelo=" + modelo + ", cv=" + cv + ", bastidor=" + bastidor + ", velocidad=" + velocidad + '}';
    }
    
    

 
}
