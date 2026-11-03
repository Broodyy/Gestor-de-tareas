package org.example;

import java.sql.*;

public class GestorTareas {
    private static final String URL = "jdbc:mysql://localhost:3306/estudio";
    private static final String USUARIO = "gabriel";
    private static final String CLAVE = "pon_una_contraseña";

    public static void insertarTarea(String titulo) {
        String sql = "INSERT INTO tareas (titulo) VALUES (?)";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, titulo);
            ps.executeUpdate();
            System.out.println("Tarea guardada: " + titulo);
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public static void listarTareas() {
        String sql = "SELECT id, titulo, completada FROM tareas";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean hayTareas = false;
            while (rs.next()) {
                hayTareas = true;
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                boolean completada = rs.getBoolean("completada");
                System.out.println(id + " | " + titulo + " | " + (completada ? "Hecha" : "Pendiente"));
            }

            if (!hayTareas) {
                System.out.println("No hay tareas registradas.");
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
    }

    public static void completarTarea(int id) {
        String sql = "UPDATE tareas SET completada = TRUE WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Tarea " + id + " marcada como completada.");
            } else {
                System.out.println("No existe la tarea con el ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la tarea: " + e.getMessage());
        }
    }

    public static void eliminarTarea(int id) {
        String sql = "DELETE FROM tareas WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Tarea " + id + " eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna tarea con el ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar tarea: " + e.getMessage());
        }
    }
}