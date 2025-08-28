package Ejercicio1;

import java.util.Scanner;

/*Modificar la implementación del tipo Libro del caso ejemplo a, de manera que los libros cuenten también
con la información de la cantidad de hojas que tiene y su código ISBN. Escribir un programa que permita
crear tres libros, mostrar la información del libro de mayor precio y la información del libro de menor
cantidad de hojas. Además, dado un código ISBN, mostrar el titulo, autor y editorial del libro
correspondiente, en caso de no encontrarlo entre los disponibles informar del error.

Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear tres libros
        ModificacionCE libro1 = new ModificacionCE("Libro 1", "Autor 1", "Editorial 1", 20.99, 300, "ISBN123");
        ModificacionCE libro2 = new ModificacionCE("Libro 2", "Autor 2", "Editorial 2", 15.50, 250, "ISBN456");
        ModificacionCE libro3 = new ModificacionCE("Libro 3", "Autor 3", "Editorial 3", 25.75, 400, "ISBN789");
                                
        // Encontrar el libro de mayor precio     // La sintaxis general para declarar una variable de referencia a un objeto es la siguiente:
        ModificacionCE libroMayorPrecio = libro1; // TipoDeClase nombreDeVariable = objetoExistente;
        if (libro2.getPrecio() > libroMayorPrecio.getPrecio()) {
            libroMayorPrecio = libro2;
        }
        if (libro3.getPrecio() > libroMayorPrecio.getPrecio()) {
            libroMayorPrecio = libro3;
        }

        // Encontrar el libro de menor cantidad de hojas
        ModificacionCE libroMenorHojas = libro1;
        if (libro2.getCantidadHojas() < libroMenorHojas.getCantidadHojas()) {
            libroMenorHojas = libro2;
        }
        if (libro3.getCantidadHojas() < libroMenorHojas.getCantidadHojas()) {
            libroMenorHojas = libro3;
        }

        System.out.println("Información del libro de mayor precio:");
        System.out.println(libroMayorPrecio.getInfoLibro());

        System.out.println("\nInformación del libro de menor cantidad de hojas:");
        System.out.println(libroMenorHojas.getInfoLibro());

        // Buscar un libro por código ISBN
        System.out.print("\nIngrese un código ISBN para buscar un libro: ");
        String isbnBuscado = scanner.nextLine();

        if (isbnBuscado.equals(libro1.getIsbn())) {
            System.out.println("\nLibro encontrado:\n" + libro1.getInfoLibro());
        } else if (isbnBuscado.equals(libro2.getIsbn())) {
            System.out.println("\nLibro encontrado:\n" + libro2.getInfoLibro());
        } else if (isbnBuscado.equals(libro3.getIsbn())) {
            System.out.println("\nLibro encontrado:\n" + libro3.getInfoLibro());
        } else {
            System.out.println("\nLibro con ISBN " + isbnBuscado + " no encontrado.");
        }

        scanner.close();
    }
}
    	
    	
    	
    	

