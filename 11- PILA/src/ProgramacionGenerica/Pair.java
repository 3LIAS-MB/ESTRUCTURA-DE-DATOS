package ProgramacionGenerica;

public class Pair<T, U> { // T, U, K -> Los más comunes
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first; // Integer
        this.second = second; // String
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(42, "Hola, mundo");
        Pair<Double, Character> pair2 = new Pair<>(3.14, 'A');

        System.out.println("Par 1: Primero = " + pair1.getFirst() + ", Segundo = " + pair1.getSecond());
        System.out.println("Par 2: Primero = " + pair2.getFirst() + ", Segundo = " + pair2.getSecond());
    }
}
 