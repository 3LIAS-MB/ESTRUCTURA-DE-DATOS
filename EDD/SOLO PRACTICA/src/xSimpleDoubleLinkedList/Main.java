package xSimpleDoubleLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Agregar elemento al principio");
            System.out.println("2. Agregar elemento al final");
            System.out.println("3. Eliminar primer elemento");
            System.out.println("4. Eliminar último elemento");
            System.out.println("5. Mostrar la lista");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingresa un número para agregar al principio: ");
                    int numberToAddFirst = scanner.nextInt();
                    linkedList.addFirst(numberToAddFirst);
                    break;

                case 2:
                    System.out.print("Ingresa un número para agregar al final: ");
                    int numberToAddLast = scanner.nextInt();
                    linkedList.addLast(numberToAddLast);
                    break;

                case 3:
                    if (linkedList.size() > 0) {
                        int removedFirst = linkedList.removeFirst();
                        System.out.println("Se ha eliminado el primer elemento: " + removedFirst);
                    } else {
                        System.out.println("La lista está vacía, no se puede eliminar.");
                    }
                    break;

                case 4:
                    if (linkedList.size() > 0) {
                        int removedLast = linkedList.removeLast();
                        System.out.println("Se ha eliminado el último elemento: " + removedLast);
                    } else {
                        System.out.println("La lista está vacía, no se puede eliminar.");
                    }
                    break;

                case 5:
                    System.out.println("Lista actual: " + linkedList.toString());
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }

        } while (option != 0);

        scanner.close();
    }
}