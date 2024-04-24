package UnionEntreColas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UnionEntreColas cola1 = new UnionEntreColas();
        UnionEntreColas cola2 = new UnionEntreColas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Encolar en Cola 1");
            System.out.println("2. Encolar en Cola 2");
            System.out.println("3. Desencolar de Cola 1");
            System.out.println("4. Desencolar de Cola 2");
            System.out.println("5. Mostrar si Cola 1 está vacía");
            System.out.println("6. Mostrar si Cola 2 está llena");
            System.out.println("7. Cantidad de elementos en Cola 1");
            System.out.println("8. Unir Cola 1 y Cola 2");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese un número para encolar en Cola 1: ");
                    int num1 = scanner.nextInt();
                    cola1.encolar(num1);
                    break;
                case 2:
                    System.out.print("Ingrese un número para encolar en Cola 2: ");
                    int num2 = scanner.nextInt();
                    cola2.encolar(num2);
                    break;
                case 3:
                    int deq1 = cola1.desencolar();
                    System.out.println("Elemento desencolado de Cola 1: " + deq1);
                    break;
                case 4:
                    int deq2 = cola2.desencolar();
                    System.out.println("Elemento desencolado de Cola 2: " + deq2);
                    break;
                case 5:
                    System.out.println("Cola 1 está vacía: " + cola1.estaVacia());
                    break;
                case 6:
                    System.out.println("Cola 2 está llena: " + cola2.estaLlena());
                    break;
                case 7:
                    System.out.println("Cantidad de elementos en Cola 1: " + cola1.cantidad());
                    break;
                case 8:
                    UnionEntreColas colaUnida = UnionEntreColas.unirColas(cola1, cola2);
                    System.out.println("Cola 1 y Cola 2 unidas en una nueva cola.");
                    break;
                case 9:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
