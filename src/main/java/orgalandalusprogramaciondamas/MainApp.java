package orgalandalusprogramaciondamas;

import orgiesalandalusprogramaciomdamasmodelo.Color;
import orgiesalandalusprogramaciomdamasmodelo.Dama;
import orgiesalandalusprogramaciomdamasmodelo.Direccion;
import orgiesalandalusprogramaciomdamasmodelo.Posicion;

public class MainApp {
    private static Dama dama;

    // Utilizamos un switch para ejecutar la opción seleccionada en el menú
    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearDamaDefecto();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                consola.hastaluego();
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                break;
        }
    }

    // Metodo para crear una dama por defecto
    public static void crearDamaDefecto() {
        dama = new Dama();
        System.out.println("Dama creada por defecto: " + dama);
    }

    // Metodo para crear una dama con un color específico
    public static void crearDamaColor() {
        Color color = consola.elegirColor();
        dama = new Dama(color);
        System.out.println("Dama creada con color " + color + ": " + dama);
    }

    // Metodo para mover la dama
    public static void mover() {
        if (dama == null) {
            System.out.println("Primero debes crear una dama.");
            return;
        }

        consola.mostrarMenuDirecciones();
        Direccion direccion = consola.elegirDireccion();

        int pasos = 1;
        if (dama.isEsDamaEspecial()) {
            pasos = consola.elegirPasos();
        }

        try {
            dama.mover(direccion, pasos);
            System.out.println("Dama movida a: " + dama);
        } catch (Exception e) {
            System.out.println("No se pudo mover la dama: " + e.getMessage());
        }
    }

    // Metodo para mostrar la información de la dama
    public static void mostrarDama() {
        if (dama != null) {
            System.out.println("Dama actual: " + dama);
        } else {
            System.out.println("No se ha creado ninguna dama.");
        }
    }

    // Metodo principal
    public static void main(String[] args) {
        int opcion;
        do {
            consola.mostrarMenu();
            opcion = consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 4);
    }
}
