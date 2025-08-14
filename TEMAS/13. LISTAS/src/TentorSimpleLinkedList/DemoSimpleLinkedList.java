package TentorSimpleLinkedList;

import java.util.Scanner;

public class DemoSimpleLinkedList {
    public static void main(String[] args) {
    	
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        Scanner scanner = new Scanner(System.in);
       
        int choice;	

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Agregar elemento al principio");
            System.out.println("2. Agregar elemento al final");
            System.out.println("3. Eliminar primer elemento");
            System.out.println("4. Eliminar último elemento");
            System.out.println("5. Mostrar lista");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar al principio: ");
                    int elementToAdd = scanner.nextInt();
                    list.addFirst(elementToAdd);
                    System.out.println("Elemento agregado al principio.");
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a agregar al final: ");
                    elementToAdd = scanner.nextInt();
                    list.addLast(elementToAdd);
                    System.out.println("Elemento agregado al final.");
                    break;	
                case 3:
                    if (!list.isEmpty()) {
                        int removedElement = list.removeFirst();
                        System.out.println("Elemento eliminado del principio: " + removedElement);
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;
                case 4:
                    if (!list.isEmpty()) {
                        int removedElement = list.removeLast();
	                        System.out.println("Elemento eliminado del final: " + removedElement);
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;
                case 5:
                	list.mostrar();
                    
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
