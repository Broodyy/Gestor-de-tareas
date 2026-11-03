package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
    private static final String URL = "jdbc:mysql://localhost:3306/estudio";
    private static final String USUARIO = "gabriel";
    private static final String CLAVE = "pon_una_constraseña";

    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
            System.out.println("¡Conectado a MySQL!");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}