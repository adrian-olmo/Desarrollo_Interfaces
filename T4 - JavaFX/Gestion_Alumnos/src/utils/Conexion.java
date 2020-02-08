package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conexion {

    private Connection conexion = null;
    public Conexion() throws SQLException {

        conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_gestion", "admin", "admin");

    }
}
