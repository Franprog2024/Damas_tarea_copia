package orgiesalandalusprogramaciomdamasmodelo;

public enum Color {
    BLANCO("Blanco"),
    NEGRO("Negro");

    private final String cadenaAMostrar;

    // Constructor con la visibilidad adecuada (privada)
    private Color(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    // Metodo toString que devuelve la representación en forma de cadena
    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}