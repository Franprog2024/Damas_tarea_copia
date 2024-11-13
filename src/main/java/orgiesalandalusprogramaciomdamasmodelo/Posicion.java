package orgiesalandalusprogramaciomdamasmodelo;

public class Posicion {
    private int fila;
    private char columna;

    // Constructor que acepta fila y columna
    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    // Constructor copia
    public Posicion(Posicion otraPosicion) {
        if (otraPosicion == null) {
            throw new IllegalArgumentException("La posición no puede ser nula.");
        }
        this.fila = otraPosicion.fila;
        this.columna = otraPosicion.columna;
    }

    // Metodos get
    public int getFila() {
        return fila;
    }

    public char getColumna() {
        return columna;
    }

    // Metodos set con validaciones
    public void setFila(int fila) {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("La fila debe estar entre 1 y 8.");
        }
        this.fila = fila;
    }

    public void setColumna(char columna) {
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("La columna debe estar entre 'a' y 'h'.");
        }
        this.columna = columna;
    }

    // Metodos equals y hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Posicion posicion = (Posicion) obj;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(fila);
        result = 31 * result + Character.hashCode(columna);
        return result;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }
}
