package clases;

public class Equipo {

    String Nombre_equipo;
    int Id_Equipo;
    int Num_titulos;
    String Lider_Puntos;
    double PPP_Lider;
    String Lider_Rebotes;
    double RPP_Lider;
    String Lider_Asistencias;
    double APP_Lider;
    String Entrenador;
    String Logo;

    public Equipo(String nombre_equipo, int id_Equipo, int num_titulos, String lider_Puntos, double PPP_Lider, String lider_Rebotes, double RPP_Lider, String lider_Asistencias, double APP_Lider, String logo) {
        Nombre_equipo = nombre_equipo;
        Id_Equipo = id_Equipo;
        Num_titulos = num_titulos;
        Lider_Puntos = lider_Puntos;
        this.PPP_Lider = PPP_Lider;
        Lider_Rebotes = lider_Rebotes;
        this.RPP_Lider = RPP_Lider;
        Lider_Asistencias = lider_Asistencias;
        this.APP_Lider = APP_Lider;
        Logo = logo;
    }

    public String getNombre_equipo() {
        return Nombre_equipo;
    }

    public int getId_Equipo() {
        return Id_Equipo;
    }

    public int getNum_titulos() {
        return Num_titulos;
    }

    public String getLider_Puntos() {
        return Lider_Puntos;
    }

    public double getPPP_Lider() {
        return PPP_Lider;
    }

    public String getLider_Rebotes() {
        return Lider_Rebotes;
    }

    public double getRPP_Lider() {
        return RPP_Lider;
    }

    public String getLider_Asistencias() {
        return Lider_Asistencias;
    }

    public double getAPP_Lider() {
        return APP_Lider;
    }

    public String getLogo() {
        return Logo;
    }

    @Override
    public String toString() {
        return getNombre_equipo();
    }
}
