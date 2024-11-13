package orgiesalandalusprogramaciomdamasmodelo;

import java.util.Random;
import javax.naming.OperationNotSupportedException;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    // Constructor por defecto
    public Dama() {
        this.color = Color.BLANCO;
        this.posicion = crearPosicionInicial(Color.BLANCO);
        this.esDamaEspecial = false;
    }

    // Constructor con parámetro de color
    public Dama(Color color) {
        if (color == null) {
            throw new NullPointerException("El color no puede ser nulo.");
        }
        this.color = color;
        this.posicion = crearPosicionInicial(color);
        this.esDamaEspecial = false;
    }

    // Métodos get y set
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("El color no puede ser nulo.");
        }
        this.color = color;
    }

    public Posicion getPosicion() {
        return new Posicion(posicion); // Devuelve una copia de la posición
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("La posición no puede ser nula.");
        }
        this.posicion = new Posicion(posicion); // Asigna una copia de la posición
    }

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }

    // Método para crear una posición inicial aleatoria
    private Posicion crearPosicionInicial(Color color) {
        Random rand = new Random();
        int fila;
        char columna;

        do {
            if (color == Color.BLANCO) {
                fila = rand.nextInt(3) + 1; // Fila aleatoria en 1, 2 o 3
            } else {
                fila = rand.nextInt(3) + 6; // Fila aleatoria en 6, 7 o 8
            }
            columna = (char) ('a' + rand.nextInt(8)); // Columna aleatoria de 'a' a 'h'
        } while ((fila + columna) % 2 == 0); // Repetir si la casilla no es negra

        return new Posicion(fila, columna);
    }

    // Método para mover la dama
    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("La dirección no puede ser nula.");
        }
        if (pasos <= 0) {
            throw new IllegalArgumentException("El número de pasos debe ser un entero positivo.");
        }
        if (!esDamaEspecial && pasos > 1) {
            pasos = 1; // Restricción para damas no especiales
        }

        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();

        switch (direccion) {
            case NORESTE:
                if (color == Color.NEGRO && !esDamaEspecial) {
                    throw new OperationNotSupportedException("La dama negra no puede moverse hacia el noreste.");
                }
                nuevaFila += pasos;
                nuevaColumna += pasos;
                break;
            case SURESTE:
                if (color == Color.BLANCO && !esDamaEspecial) {
                    throw new OperationNotSupportedException("La dama blanca no puede moverse hacia el sureste.");
                }
                nuevaFila -= pasos;
                nuevaColumna += pasos;
                break;
            case SUROESTE:
                if (color == Color.BLANCO && !esDamaEspecial) {
                    throw new OperationNotSupportedException("La dama blanca no puede moverse hacia el suroeste.");
                }
                nuevaFila -= pasos;
                nuevaColumna -= pasos;
                break;
            case NOROESTE:
                if (color == Color.NEGRO && !esDamaEspecial) {
                    throw new OperationNotSupportedException("La dama negra no puede moverse hacia el noroeste.");
                }
                nuevaFila += pasos;
                nuevaColumna -= pasos;
                break;
        }

        if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
            throw new OperationNotSupportedException("El movimiento sale del tablero.");
        }

        posicion = new Posicion(nuevaFila, nuevaColumna);

        // Convertir en dama especial si llega al borde
        if ((color == Color.BLANCO && nuevaFila == 8) || (color == Color.NEGRO && nuevaFila == 1)) {
            esDamaEspecial = true;
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Dama{" +
                "color=" + color +
                ", posicion=" + posicion +
                ", esDamaEspecial=" + esDamaEspecial +
                '}';
    }
}
