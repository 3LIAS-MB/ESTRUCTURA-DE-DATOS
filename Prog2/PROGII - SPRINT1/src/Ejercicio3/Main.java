package Ejercicio3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Autor autor1 = new Autor("Autor 1231231", 35);
        Autor autor2 = new Autor("Autor 2123213", 42);

        Libro libro1 = new Libro("Libro 1", "ISBN123", LocalDate.of(2020, 3, 15), autor1); // Puedo enviar como argumento una instacia de
        Libro libro2 = new Libro("Libro 2", "ISBN456", LocalDate.of(2018, 8, 20), autor2); // un objeto. Para seleccionar 1 atributo lo
        																				   // hago con los metodos Getters

        System.out.println("Información del Libro 1:");
        System.out.println(libro1.getInfoLibro());
        System.out.println("Es una publicación reciente: " + libro1.esPublicacionReciente());

        System.out.println("\nInformación del Libro 2:");
        System.out.println(libro2.getInfoLibro());
        System.out.println("Es una publicación reciente: " + libro2.esPublicacionReciente());
    }
}
