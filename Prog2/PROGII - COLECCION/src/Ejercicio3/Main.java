/*

- Una carta tiene un número entre 1 y 12 (el 8 y el 9 no se cuentan)
y un palo (oro, basto, espada, copa).
- La baraja está compuesta por un conjunto de cartas (40 cartas).
- Deberá crear un método que permita crear la baraja española (ver figura 1).
Las operaciones que podrá realizar la Baraja son:

• Barajar(): cambia de posición las cartas aleatoriamente.
• CartasDisponibles(): muestra la cantidad de cartas disponibles en la baraja.
• ExtraerCarta(): extrae aleatoriamente una carta de la baraja.
• DarCartas():devolverá un número determinado de cartas. En caso de que haya menos
cartas de las pedidas, no devolverá nada, pero se lo informaremos al usuario.
• MostrarBaraja(): muestra todas las cartas hasta el final.
• CartasMonton(): muestra las cartas que ya han salido.
• RestablecerBaraja(): vuelve a crear la baraja. */

package Ejercicio3;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BarajaEspanola baraja = new BarajaEspanola();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Barajar la baraja.");
            System.out.println("2. Mostrar cartas disponibles.");
            System.out.println("3. Extraer una carta.");
            System.out.println("4. Dar cartas.");
            System.out.println("5. Mostrar baraja.");
            System.out.println("6. Mostrar montón.");
            System.out.println("7. Restablecer la baraja.");
            System.out.println("8. Salir.");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el salto de línea

            switch (opcion) {
                case 1:
                    baraja.barajar();
                    System.out.println("Baraja barajada.");
                    break;
                case 2:
                    System.out.println("Cartas disponibles: " + baraja.cartasDisponibles());
                    break;
                case 3:
                    Carta cartaExtraida = baraja.extraerCarta();
                    if (cartaExtraida != null) {
                        System.out.println("Carta extraída: " + cartaExtraida);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad de cartas que desea: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    List<Carta> cartas = baraja.darCartas(cantidad);
                    if (cartas != null) {
                        System.out.println("Cartas recibidas:");
                        for (Carta c : cartas) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Estado actual de la baraja:");
                    baraja.mostrarBaraja();
                    break;
                case 6:
                    System.out.println("Mostrando montón:");
                    baraja.cartasMonton();
                    break;
                case 7:
                    baraja.restablecerBaraja();
                    System.out.println("Baraja restablecida.");
                    break;
                case 8:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }
    }
}

