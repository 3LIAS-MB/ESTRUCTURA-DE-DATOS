package ColaóQueue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la capacidad de la cola: ");
        int capacidad = scanner.nextInt();
        Queue<Integer> cola = new Queue<>(capacidad);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Offer (Encolar)");
            System.out.println("2. Poll (Desencolar)");
            System.out.println("3. Peek (Ver el primer elemento)");
            System.out.println("4. Add (Encolar con excepción)");
            System.out.println("5. Remove (Desencolar con excepción)");
            System.out.println("6. Element (Ver el primer elemento con excepción)");
            System.out.println("7. Mostrar la cola");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un elemento para encolar: ");
                    int elementoOffer = scanner.nextInt();
                    if(cola.offer(elementoOffer)) {
                        System.out.println("Elemento agregado a la cola.");
                    } else {
                        System.out.println("La cola está llena. No se puede agregar el elemento.");
                    }
                    break;
                case 2:
                    Integer elementoPoll = cola.poll();
                    if (elementoPoll != null) {
                        System.out.println("Elemento desencolado: " + elementoPoll);
                    } else {
                        System.out.println("La cola está vacía. No se puede desencolar.");
                    }
                    break;
                case 3:
                    Integer elementoPeek = cola.peek();
                    if (elementoPeek != null) {
                        System.out.println("Primer elemento en la cola: " + elementoPeek);
                    } else {
                        System.out.println("La cola está vacía. No hay elementos para mostrar.");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Ingrese un elemento para encolar: ");
                        int elementoAdd = scanner.nextInt();
                        cola.add(elementoAdd);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        Integer elementoRemove = cola.remove();
                        System.out.println("Elemento desencolado: " + elementoRemove);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        Integer elementoElement = cola.element();
                        System.out.println("Primer elemento en la cola: " + elementoElement);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    //System.out.println("Cola: " + cola); // -> Salta el su toStrin()
                    cola.displayQueue();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

