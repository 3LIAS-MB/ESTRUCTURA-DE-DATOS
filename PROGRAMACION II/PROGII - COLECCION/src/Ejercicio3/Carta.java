package Ejercicio3;

class Carta { // Es accesible para las clases y subclases que esten en el mismo paquete
    private int numero;
    private String tipo;

    public Carta(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return numero + " de " + tipo;
    }
}