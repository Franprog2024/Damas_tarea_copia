package orgalandalusprogramaciondamas;

import java.util.Scanner;
import orgiesalandalusprogramaciomdamasmodelo.Color;
import orgiesalandalusprogramaciomdamasmodelo.Direccion;

public class consola {

    private static final Scanner scanner = new Scanner(System.in);

    // Constructor privado para que no se puedan crear instancias de Consola
    private consola() {}

    // Metodo para mostrar el menú de opciones
    public static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Crea una dama por defecto");
        System.out.println("2. Crea una dama eligiendo el color");
        System.out.println("3. Mover la dama");
        System.out.println("4. Salir");
    }

    // Metodo para elegir una opción del menú
    public static int elegirOpcionMenu() {
        int opcion;
        do {
            System.out.print("Elige una opción del menú (1-4): ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    // Metodo para elegir un color
    public static Color elegirColor() {
        int opcion;
        do {
            System.out.println("Elige un color:");
            System.out.println("1. Blanco");
            System.out.println("2. Negro");
            System.out.print("Introduce la opción (1 o 2): ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        } while (opcion != 1 && opcion != 2);

        return (opcion == 1) ? Color.BLANCO : Color.NEGRO;
    }

    // Metodo para mostrar el menú de direcciones
    public static void mostrarMenuDirecciones() {
        System.out.println("Direcciones:");
        System.out.println("1. Noreste");
        System.out.println("2. Sureste");
        System.out.println("3. Suroeste");
        System.out.println("4. Noroeste");
    }

    // Metodo para elegir una dirección
    public static Direccion elegirDireccion() {
        int opcion;
        do {
            System.out.print("Elige una dirección del menú (1-4): ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1: return Direccion.NORESTE;
            case 2: return Direccion.SURESTE;
            case 3: return Direccion.SUROESTE;
            case 4: return Direccion.NOROESTE;
            default: return null;
        }
    }

    // Metodo para elegir el número de pasos
    public static int elegirPasos() {
        int pasos = 0;
        boolean valido = false;
        do {
            System.out.print("Introduce el número de casillas a mover (1 o más): ");
            try {
                pasos = scanner.nextInt();
                scanner.nextLine();
                if (pasos < 1) {
                    System.out.println("El número de pasos debe ser 1 o más.");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
            }
        } while (!valido);
        return pasos;
    }

    // Metodo para mostrar mensaje de despedida
    public static void hastaluego() {
        System.out.println("Gracias por jugar. ¡Vuelve pronto para afrontar un nuevo desafío a las damas!");
    }
}