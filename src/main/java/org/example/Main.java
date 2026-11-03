package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- GESTOR DE TAREAS ---");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Listar todas las tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Escribe el título de la tarea: ");
                    String titulo = scanner.nextLine();
                    // Llamamos al método desde la otra clase
                    GestorTareas.insertarTarea(titulo);
                    break;
                case 2:
                    System.out.println("\n--- LISTA DE TAREAS ---");
                    // Llamamos al método desde la otra clase
                    GestorTareas.listarTareas();
                    break;
                case 3:
                    System.out.print("Escribe el ID de la tarea a completar: ");
                    try {
                        int idCompletar = Integer.parseInt(scanner.nextLine());
                        GestorTareas.completarTarea(idCompletar);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Por favor ingresa un número de ID válido.");
                    }
                    break;
                case 4:
                    System.out.print("Escribe el ID de la tarea a eliminar: ");
                    try {
                        int idEliminar = Integer.parseInt(scanner.nextLine());
                        GestorTareas.eliminarTarea(idEliminar);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Por favor ingresa un número de ID válido.");
                    }
                    break;
                case 5:
                    System.out.println("Cerrando el Gestor de Tareas. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige un número del 1 al 5.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}