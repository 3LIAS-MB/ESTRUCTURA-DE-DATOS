package ColaCircular;

import java.util.Scanner;

public class MainMemoria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColaCircularMemoria cola = new ColaCircularMemoria(5);
        int choice;
        int item;

        do {
            System.out.println("\nCircular Queue (Memory) Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Check if Queue is Full");
            System.out.println("5. Check if Queue is Empty");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an element to enqueue: ");
                    item = scanner.nextInt();
                    cola.enqueue(item);
                    break;
                case 2:
                    item = cola.dequeue();
                    if (item != -1) {
                        System.out.println("Dequeued item: " + item);
                    }
                    break;
                case 3:
                    cola.displayQueue();
                    break;
                case 4:
                    System.out.println("Queue is Full: " + cola.isFull());
                    break;
                case 5:
                    System.out.println("Queue is Empty: " + cola.isEmpty());
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
