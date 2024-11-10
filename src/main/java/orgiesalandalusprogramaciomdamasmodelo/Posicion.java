package orgiesalandalusprogramaciomdamasmodelo;

public class Posicion {
    private final int fila;
    private final char columna;

    public Posicion(int fila, char columna) {
        if (fila < 1 || fila > 8 || columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("Posición inválida");
        }
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public char getColumna() {
        return columna;
    }

    @Override
    public  
    boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return  
        31 * fila + columna;
    }

    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }
}