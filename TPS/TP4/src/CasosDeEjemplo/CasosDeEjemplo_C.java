package CasosDeEjemplo;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
 
/*
Dada una frase determinar si la misma es o no un palíndromo haciendo uso de
una pila y una cola. No se debe tener en cuenta los espacios en blanco.
 
 */
 
import java.util.Scanner;
import java.util.Stack;
 
public class CasosDeEjemplo_C {
 
    private static Scanner scanner = new Scanner(System.in);
 
    public void Run() {
 
        System.out.println("Trabajo Práctico Nº 3 - Caso Ejemplo c)\n");
 
        System.out.print("Ingrese un frase: ");
        String text = scanner.nextLine();
        test(text);
 
        // from https://es.wikipedia.org/wiki/Palíndromo
        test("Dábale arroz a la zorra el abad");
        test("¿Son mulas o cívicos alumnos?");
        test("Eva, can I stab bats in a cave?");
 
    }
 
    private void test(String text) {
        System.out.println("\"" + text + "\"" +  (isPalindrome(text) ? "" : " NO ") + " es un palíndromo" );
    }
 
    private boolean isPalindrome(String text) {
 
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new Queue<Character>(text.length());
 
        char ch;
        int count = 0;
        for(int pos = 0; pos < text.length(); ++pos) {
            ch = text.charAt(pos);
 
            if (Character.isAlphabetic(ch)) {
                ch = Character.toUpperCase( ignoreAccentuation(ch) );
                stack.push(ch);
                queue.offer(ch);
                ++count;
            }
        }
 
        count /= 2;
        while (count-- > 0) {
            if ( !stack.pop().equals(queue.remove()) ) {
                return false;
            }
        }
 
        return true;
    }
 
    private char ignoreAccentuation(char ch) {
 
        switch(ch) {
            case 'Á' :
            case 'Ä' :
            case 'À' :
                return 'A';
            case 'É' :
            case 'Ë' :
            case 'È' :
                return 'E';
            case 'Í' :
            case 'Ï' :
            case 'Ì' :
                return 'I';
            case 'Ó' :
            case 'Ö' :
            case 'Ò' :
                return 'O';
            case 'Ú' :
            case 'Ü' :
            case 'Ù' :
                return 'U';
 
            case 'á' :
            case 'ä' :
            case 'à' :
                return 'a';
            case 'é' :
            case 'ë' :
            case 'è' :
                return 'e';
            case 'í' :
            case 'ï' :
            case 'ì' :
                return 'i';
            case 'ó' :
            case 'ö' :
            case 'ò' :
                return 'o';
            case 'ú' :
            case 'ü' :
            case 'ù' :
                return 'u';
        }
        return ch;
    }
}
 