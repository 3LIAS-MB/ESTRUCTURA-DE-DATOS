package ColaCircular;

import java.util.Scanner;

public class MainVelocidad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int item;

        System.out.print("Enter the capacity of the circular queue: ");
        int capacity = scanner.nextInt();

        ColaCircularVelocidad circularQueue = new ColaCircularVelocidad(capacity);

        do {
            System.out.println("\nCircular Queue (Speed) Menu:");
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
                    circularQueue.enqueue(item);
                    break;
                case 2:
                    item = circularQueue.dequeue();
                    if (item != -1) {
                        System.out.println("Dequeued item: " + item);
                    }
                    break;
                case 3:
                    circularQueue.displayQueue();
                    break;
                case 4:
                    System.out.println("Is Full? " + circularQueue.isFull());
                    break;
                case 5:
                    System.out.println("Is Empty? " + circularQueue.isEmpty());
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
