package Ejercicio1;

/*Codificar una implementación de la clase Queue<ELEMENT> (Cola genérica) utilizando en la estructura
interna una lista genérica. Usando dicha implementación, encolar números enteros en una cola hasta que
se ingrese el número 99; luego desencolarlos y hacer lo siguiente: calcular el factorial de los números
positivos, sumar los negativos y contar los ceros.
Para la implementación de la clase, tener en cuenta los diagramas presentados. En el primer diagrama se
muestra el campo interno “list” de la clase Queue<ELEMENT> y en el segundo se presenta los detalles de la
clase SimpleLinkedList<ELEMENT>.*/

/*Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.*/

import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la capacidad de la cola: ");
        int capacidad = scanner.nextInt();
        Cola<String> cola = new Cola<>(capacidad);

        int choice;
        do {
        	System.out.println();
            System.out.println("\tMenú de opciones:");
            System.out.println("1. Agregar elemento (offer)");
            System.out.println("2. Eliminar elemento (poll)");
            System.out.println("3. Consultar elemento al inicio (peek)\n");

            System.out.println("4. Agregar elemento (add)");
            System.out.println("5. Eliminar elemento (remove)");
            System.out.println("6. Consultar elemento (element)\n");

            System.out.println("7. Verificar si la cola está vacía (isEmpty)");
            System.out.println("8. Tamaño de la cola (size)\n");
            System.out.println("9. Mostrar elementos de la cola");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume new line
            String element;
            
            switch (choice) {
                case 1:
                    System.out.print("Ingrese el elemento a ofrecer: ");
                    String offered = scanner.nextLine();
                    boolean offeredSuccessfully = cola.offer(offered);
                    System.out.println(offeredSuccessfully ? "Elemento ofrecido." : "La cola está llena.");
                    break;
                case 2:
                     String polled = cola.poll();
                     if(polled != null) {
                    	 System.out.println("Elemento eliminado: " + polled);
                     } else {
                         System.out.println("Devuelvo null. No hay elementos en la lista");
                     }
                	break;
                case 3:
                    String peeked = cola.peek();
                    System.out.println("Elemento al inicio de la cola: " + peeked);
                    break;
                case 4:
                    System.out.print("Ingrese el elemento a agregar: ");
                    element = scanner.nextLine();
                    boolean added = cola.add(element);
                    System.out.println(added ? "Elemento agregado." : "La cola está llena.");
                    break;
                case 5:
                    try {
                        String removed = cola.remove();
                        System.out.println("Elemento eliminado: " + removed);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        String consulted = cola.element();
                        System.out.println("Elemento consultado: " + consulted);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    boolean empty = cola.empty();
                    System.out.println("La cola está vacía: " + empty);
                    break;
                case 8:
                    int size = cola.size();
                    System.out.println("Tamaño de la cola: " + size);
                    break;
                case 9:
                    System.out.println("Elementos en la cola:");
                    Iterator<String> iterator = cola.iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;
                case 10:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (choice != 9);
    }
}
