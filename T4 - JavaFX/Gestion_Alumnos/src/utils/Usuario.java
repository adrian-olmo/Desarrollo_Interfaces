package utils;

public class Usuario {

    int id_usuario, id_moduloUsu;
    String nombre_usuario, apellido_usuario, email_usuario, password;

    public Usuario() {
        this.id_usuario = id_usuario;
        this.id_moduloUsu = id_moduloUsu;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email_usuario = email_usuario;
        this.password = password;
    }

    public Usuario(String nombre_usuario, String password) {
        this.nombre_usuario = nombre_usuario;
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_moduloUsu() {
        return id_moduloUsu;
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
}