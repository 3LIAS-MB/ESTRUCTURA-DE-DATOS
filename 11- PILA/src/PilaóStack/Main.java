package PilaóStack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int option;

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Empty");
            System.out.println("5. Size");
            System.out.println("6. Search");
            System.out.println("7. Show stack");
            System.out.println("0. Salir");

            System.out.print("Ingrese la opción deseada: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el elemento para hacer push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    System.out.println("Elemento " + element + " agregado a la pila.");
                    break;
                case 2:
                    try {
                        System.out.println("Elemento pop: " + stack.pop());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Elemento en la cima de la pila: " + stack.peek());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("La pila está vacía: " + stack.empty());
                    break;
                case 5:
                    System.out.println("Tamaño de la pila: " + stack.size());
                    break;
                case 6:
                    System.out.print("Ingrese el elemento a buscar: ");
                    int searchElement = scanner.nextInt();
                    int position = stack.search(searchElement);
                    if (position != -1) {
                        System.out.println("Elemento encontrado en la posición " + position + " desde la cima.");
                    } else {
                        System.out.println("Elemento no encontrado en la pila.");
                    }
                    break;
                case 7:
                	stack.showStack();
                	break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo nuevamente.");
                    break;
            }
            	
            
        } while (option != 0);

        scanner.close();
    }
}
