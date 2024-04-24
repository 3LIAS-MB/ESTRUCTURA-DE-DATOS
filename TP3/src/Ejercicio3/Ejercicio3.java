package Ejercicio3;

import java.util.Stack;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la expresión matemática: ");
        String expresion = scanner.nextLine();
        
        if (verificarParentizacion(expresion)) {
            System.out.println("La expresión está bien parentizada.");
        } else {
            System.out.println("La expresión no está bien parentizada.");
        }
        
        scanner.close();
    }
    
    public static boolean verificarParentizacion(String expresion) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : expresion.toCharArray()) { // Convierte una cadena (String) en un array de caracteres (char[]).
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {	
                    return false; // No hay símbolo de apertura correspondiente
                }
                
                char simboloApertura = stack.pop();
                
                if (!((c == ')' && simboloApertura == '(') ||
                      (c == ']' && simboloApertura == '[') ||
                      (c == '}' && simboloApertura == '{'))) {
                    return false; // Los símbolos no coinciden
                }
            }
        }
        
        return stack.isEmpty(); // La pila debe estar vacía si está bien parentizada
    }
}
