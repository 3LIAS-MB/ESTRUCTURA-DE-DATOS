/*Descomponer un número de cuatro cifras en los dígitos que lo componen. Usar una pila durante el
proceso de descomposición para almacenar los dígitos correspondientes, luego desapilarlos e indicar el
valor y peso correspondiente a cada uno. */

// STACK O FILA -> LIFO = Last In First Out -> El Último en entrar es el primero en salir	

package CasosDeEjemplo;

import java.util.Scanner;
import java.util.Stack;

public class CasoDeEjemploA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese un número de cuatro cifras: ");
        int numero = scanner.nextInt();
        
        if (numero < 1000 || numero > 9999) {
            System.out.println("El número ingresado no tiene cuatro cifras.");
        } else {
            Stack<Integer> pila = new Stack<>();
            
            // Descomponer el número en dígitos y apilarlos
            int valor = numero;
            while (valor > 0) {
                int digito = valor % 10; // -> primero toma el valor de 3, 2, 0, 2
                pila.push(digito); // [3, 2, 0, 2] 
                valor /= 10;
            }
            
            // Desapilar y mostrar los dígitos con su valor y peso
            int peso = 1000;
            System.out.println("Descomposición del número " + numero + ":");
            while (!pila.isEmpty()) { // ¿La pila está vacia? False. Lo cambia a true
                int digito = pila.pop(); //[3, 2, 0, 2] -> devuelve el elemento en la parte superior, 1ro: 2, 0, 2, 3
                int valorDigito = digito * peso;
                System.out.println("Dígito: " + digito + ", Valor: " + valorDigito);
                peso /= 10;
            }
        }
        
        scanner.close();
    }		
}	
