/*Crear una clase Cafetera con atributos capacidadMaxima (la cantidad máxima de café que puede contener
la cafetera) y cantidadActual (la cantidad actual de café que hay en la cafetera). Implementar, al menos, los
siguientes métodos: a) Constructor predeterminado: establece la capacidad máxima en 1000 (c.c.) y la
actual en cero (cafetera vacía); b) Constructor con argumentos: si la cantidad actual es mayor que la
capacidad máxima de la cafetera, se debe ajustar al máximo; c) servirTaza(capacidad): simula la acción de
servir una taza con la capacidad indicada. Si la cantidad actual de café “no alcanza” para llenar la taza, se
sirve lo que quede; d) vaciarCafetera(): pone la cantidad de café actual en cero y e) agregarCafe(cantidad):
añade a la cafetera la cantidad de café indicada.

Escribir un programa que mediante un menú de opciones permita crear una cafetera y ejecutar las
diferentes operaciones que se pueden hacer sobre ella.*/

package Ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cafetera cafetera = null; // Inicializar la variable cafetera con null

        // Menú de opciones
        int opcion;
        do {
            System.out.println("\n*** Menú de Opciones ***");
            System.out.println("1. Crear una nueva cafetera");
            System.out.println("2. Servir una taza de café");
            System.out.println("3. Vaciar la cafetera");
            System.out.println("4. Agregar café a la cafetera");
            System.out.println("5. Mostrar estado de la cafetera");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear una nueva cafetera
                    System.out.print("Ingrese la capacidad máxima de la cafetera: ");
                    int capacidadMaxima = scanner.nextInt();
                    System.out.print("Ingrese la cantidad actual de café en la cafetera: ");
                    int cantidadActual = scanner.nextInt();
                    cafetera = new Cafetera(capacidadMaxima, cantidadActual);
                    break;
                case 2:
                    // Servir una taza de café
                    if (cafetera != null) {
                        System.out.print("Ingrese la capacidad de la taza a servir: ");
                        int capacidadTaza = scanner.nextInt();
                        cafetera.servirTaza(capacidadTaza);
                    } else {
                        System.out.println("Primero debe crear una cafetera.");
                    }
                    break;
                case 3:
                    // Vaciar la cafetera
                    if (cafetera != null) {
                        cafetera.vaciarCafetera();
                    } else {
                        System.out.println("Primero debe crear una cafetera.");
                    }
                    break;
                case 4:
                    // Agregar café a la cafetera
                    if (cafetera != null) {
                        System.out.print("Ingrese la cantidad de café a agregar: ");
                        int cantidadAgregar = scanner.nextInt();
                        cafetera.agregarCafe(cantidadAgregar);
                    } else {
                        System.out.println("Primero debe crear una cafetera.");
                    }
                    break;
                case 5:
                    // Mostrar estado de la cafetera
                    if (cafetera != null) {
                        cafetera.mostrarEstado();
                    } else {
                        System.out.println("Primero debe crear una cafetera.");
                    }
                    break;
                case 0:
                    System.out.println("Adiós.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}