package ColaCircular;

import java.util.Scanner;

public class ColaCircularMemoria {
    private Integer[] data;
    private int head;
    private int tail;
    private int size;
    private int count; /**/

    public ColaCircularMemoria(int size) {
        this.size = size;
        this.data = new Integer[size];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
 
// -> ES LO MISMO QUE EL NEXT DE ABAJO 
//  private int next(int pos) {
//      if (++pos >= this.size) {
//          pos = 0;
//      }
//      return pos;
//  }

    private int next(int pos) {
        return (pos + 1) % this.size;
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(int item) {
        if (!isFull()) {
            data[tail] = item;
            tail = next(tail);
            count++;
        } else {
            System.out.println("Queue is full. Cannot enqueue.");
        }
    }

    public Integer dequeue() {
        if (!isEmpty()) {
            Integer item = data[head];
            data[head] = null;  // Marcar la posición como nula
            head = next(head);
            count--;
            return item;
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null; // Retorna null si la cola está vacía
        }
    }

    public void displayQueue() {
        if (!isEmpty()) {
            int index = head;
            for (int i = 0; i < count; i++) {
                System.out.print(data[index] + " ");
                index = next(index);
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ColaCircularMemoria queue = new ColaCircularMemoria(5);
        int choice;
        int item;

        do {
            System.out.println("\nCircular Queue (Memory) Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = entrada.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an element to enqueue: ");
                    item = entrada.nextInt();
                    queue.enqueue(item);
                    break;
                case 2:
                    Integer dequeuedItem = queue.dequeue();
                    if (dequeuedItem != null) {
                        System.out.println("Dequeued item: " + dequeuedItem);
                    }
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }
}

