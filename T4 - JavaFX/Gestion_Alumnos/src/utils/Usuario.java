package utils;

public class Usuario {

    int id_usuario, id_moduloUsu;
    String nombre_usuario, apellido_usuario, email_usuario, password;

    public Usuario(int id_usuario, int id_moduloUsu, String nombre_usuario, String apellido_usuario, String email_usuario, String password) {
        this.id_usuario = id_usuario;
        this.id_moduloUsu = id_moduloUsu;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email_usuario = email_usuario;
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_moduloUsu() {
        return id_moduloUsu;
    }

    public void setId_moduloUsu(int id_moduloUsu) {
        this.id_moduloUsu = id_moduloUsu;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
