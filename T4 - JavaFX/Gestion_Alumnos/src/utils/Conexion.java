package utils;

import java.sql.*;


public class Conexion{

    Connection conexion = null;

    public static Connection conexionBD() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_alumnos", "admin", "admin");
            return connection;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }



}
