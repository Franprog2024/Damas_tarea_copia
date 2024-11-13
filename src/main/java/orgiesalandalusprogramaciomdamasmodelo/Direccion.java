package orgiesalandalusprogramaciomdamasmodelo;

public enum Direccion {
    NORESTE("Noreste"),
    SURESTE("Sureste"),
    SUROESTE("Suroeste"),
    NOROESTE("Noroeste");

    private final String cadenaAMostrar;

    // Constructor con la visibilidad adecuada (privada)
    private Direccion(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    // Metodo toString que devuelve la representación en forma de cadena
    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}