package edu.practice.sica.lector;


import java.util.Scanner;

public class LectorTest {
    public static void main(String[] args) {
        // Al declarar 'lector' dentro de los paréntesis del try, nos aseguramos
        // de que su método close() será llamado automáticamente al final.
        try (LectorZKTeco lector = new LectorZKTeco();
             Scanner scanner = new Scanner(System.in)) {

            if (!lector.conectar()) {
                // Si la conexión falla, el programa termina y 'close()' se llama igual.
                return;
            }

            int opcion;
            do {
                mostrarMenu();
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        lector.registrarHuella();
                        break;
                    case 2:
                        lector.identificarHuella();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

        } // El método lector.close() es llamado automáticamente aquí.
        // No es necesario llamar a sensor.destroy() manualmente.
        System.out.println("Aplicación cerrada.");
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Lector (AutoCloseable) ---");
        System.out.println("1. Registrar Huella");
        System.out.println("2. Identificar Huella");
        System.out.println("0. Salir");
        System.out.println("-----------------------------------");
    }
}
