package primerParcial_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ColaCircularMemoria<Integer> queue = new ColaCircularMemoria<Integer>(3);
       
        int choice;
        int item = 0;

        do {
            System.out.println("\nCircular Queue (Memory) Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. existeEnCola");
            System.out.println("5. eliminarElemento");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = entrada.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an element to enqueue: ");
                    item = entrada.nextInt();

                    queue.enqueue(item);
                    break;
                case 2:
                    item = queue.dequeue();
                    System.out.println("Dequeued item: " + item);
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                	System.out.print("Enter an element to use method existeEnCola: ");
                    item = entrada.nextInt();
                    boolean valor = queue.existeEnCola(item);
                    if(valor) {
                    	System.out.println("Existe el valor: "+item);
                    }else {
                    	System.out.println("No existe...");
                    }
                    break;
                case 5:
                    System.out.print("Enter an element to remove: ");
                    item = entrada.nextInt();
                    queue = ColaCircularMemoria.eliminarElemento(queue, item);
                    System.out.println("Element " + item + " removed from the queue.");
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);
    }
}
