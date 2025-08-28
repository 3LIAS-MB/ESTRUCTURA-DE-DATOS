/*Escribir un programa que permita verificar la parentización simple de una expresión matemática.
 * Es sabido que los paréntesis “(” y “)” se utilizan para fijar la prioridad de las operaciones
 * matemáticas, de ese modo una expresión como ser: 4 * (5 – 2) se dice que está correctamente
 * parentizada porque se encuentra un paréntesis de apertura y uno de cierre.
 * 
 * El programa que se solicita debe permitir ingresar una cadena de texto que supuestamente contiene
 * una expresión matemática con paréntesis, la cual deberá verificarse. Una forma de resolver el
 * ejercicio es utilizar un contador que se incrementa cuando se encuentra la apertura de un paréntesis y se
 * decrementa cuando se encuentra el cierre de un paréntesis; otra forma de resolver el mismo
 * ejercicio es utilizar un objeto del tipo Stack, obviamente esta es la forma solicitada.*/

package CasosDeEjemplo;

import java.util.Scanner;
import java.util.Stack;

public class CasosDeEjemploB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una expresión matemática con paréntesis: ");
        String expresion = scanner.nextLine();

        if (verificarParentesis(expresion)) {
            System.out.println("La expresión está correctamente parentizada.");
        } else {
            System.out.println("La expresión NO está correctamente parentizada.");
        }

        scanner.close();
    }

    public static boolean verificarParentesis(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char caracter : expresion.toCharArray()) {
            if (caracter == '(') {
                pila.push(caracter);
            }
            else if (caracter == ')') {
               if (pila.isEmpty()) {
                   return false; // Hay un paréntesis cerrado sin su correspondiente apertura
               }
               pila.pop(); // Obtiene el parentesis para mantenerla vacia
            }
        }

        return pila.isEmpty(); // Si la pila está vacía al final, la expresión está correctamente parentizada
    }
}


