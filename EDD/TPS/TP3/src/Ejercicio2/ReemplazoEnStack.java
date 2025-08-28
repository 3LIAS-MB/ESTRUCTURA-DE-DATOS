package Ejercicio2;

import java.util.Scanner;
import java.util.Stack;

public class ReemplazoEnStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> pila = new Stack<>();

        System.out.println("Ingrese la cadena de caracteres (o escriba 'aleatorio' para generar una cadena aleatoria):");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("aleatorio")) {
            // Generar cadena aleatoria de caracteres
            input = generateRandomString();
            System.out.println("Cadena generada aleatoriamente: " + input);
        }

        // Llenar la pila con caracteres de la cadena
        for (char c : input.toCharArray()) {
            pila.push(c);
        }

        System.out.println("Pila inicial: " + pila);

        // Pedir al operador que ingrese valores para reemplazo
        while (true) {
            System.out.println("Ingrese el valor actual a reemplazar (o 'fin' para salir): ");
            String valorActual = scanner.nextLine();

            if (valorActual.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.println("Ingrese el nuevo valor: ");
            char nuevoValor = scanner.nextLine().charAt(0);

            int reemplazos = reemplazarEnStack(pila, valorActual.charAt(0), nuevoValor);
            System.out.println("Cantidad de reemplazos realizados: " + reemplazos);
            System.out.println("Pila después del reemplazo: " + pila);
        }

        scanner.close();
    }

    // Método para realizar el reemplazo en la pila
    public static int reemplazarEnStack(Stack<Character> pila, char valorActual, char nuevoValor) {
        int reemplazos = 0;

        for (int i = 0; i < pila.size(); i++) {
            char elemento = pila.get(i);
            if (elemento == valorActual) {
                pila.set(i, nuevoValor);
                reemplazos++;
            }
        }

        return reemplazos;
    }

    // Método para generar una cadena aleatoria de caracteres
    public static String generateRandomString() {
        StringBuilder randomString = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for (int i = 0; i < 10; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }

        return randomString.toString();
    }
}
