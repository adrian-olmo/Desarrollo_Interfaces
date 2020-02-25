package utils;

public class Usuario {

   String DNI_usuario, nombre_usuario, apellido_usuario, email_usuario, password, nombre_modulo;

    public Usuario(String DNI_usuario, String nombre_usuario, String apellido_usuario, String email_usuario, String password, String nombre_modulo) {
        this.DNI_usuario = DNI_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email_usuario = email_usuario;
        this.password = password;
        this.nombre_modulo = nombre_modulo;
    }

    public Usuario(String nombre_usuario, String password) {
        this.nombre_usuario = nombre_usuario;
        this.password = password;
    }

    public Usuario(String DNI_usuario, String nombre_usuario, String apellido_usuario, String email_usuario, String nombre_modulo) {
        this.DNI_usuario = DNI_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email_usuario = email_usuario;
        this.nombre_modulo = nombre_modulo;
    }

    public Usuario() {
    }

    public String getDNI_usuario() {
        return DNI_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre_modulo() {
        return nombre_modulo;
    }
}