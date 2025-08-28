package CasosDeEjemplo;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
 
/*
 
Encolar números en una cola hasta que se ingrese el número 99;
luego desencolarlos y hacer lo siguiente: calcular el factorial
de los números positivos, sumar los negativos y contar los ceros.
 
 */
 
import java.util.Random;
 
public class CasosDeEjemplo_A {
 
    private static Random random = new Random();
 
    public void Run() {
 
        System.out.println("Trabajo Práctico Nº 3 - Caso Ejemplo a)\n");
 
        Queue<Integer> numbers1 = new Queue<Integer>(10);
        Queue<Integer> numbers2 = new Queue<Integer>(10);
 
        int number = 0;
 
        StringBuilder sb = new StringBuilder();
        for (int count = random.nextInt(20) + 1; count > 0; --count) {
 
            number = random.nextInt(50) - 25;
            if (number == 99) {
                break;
            }
            sb.append(number +" ");
 
            try {
                numbers1.add(number);
            } catch (Exception exception) {
                System.out.println("Excepción atrapada para numbers1 " + exception.getMessage() );
            }
 
            try {
                numbers2.offer(number);
            } catch (Exception exception) {
                System.out.println("Excepción atrapada para numbers2 " + exception.getMessage() );
            }
        }
        System.out.println("\nGenerados: " + sb.toString());
 
        System.out.println("Cola numbers1 (" + numbers1.size() +") " + numbers1.toString());
        System.out.println("Cola numbers2 (" + numbers2.size() +") " + numbers2.toString());
 
        int negativeSum = 0;
        int zeroCount = 0;
 
        while (!numbers1.isEmpty()) {
            number = numbers1.remove();
            System.out.print("\nNúmero: " + number);
            if (number == 0) {
                ++zeroCount;
                continue;
            }
            if (number > 0) {
                System.out.print(" Factorial: " + Factorial(number));
            } else {
                negativeSum += number;
            }
        }
        System.out.println("\n\nSuma de los negativos: " + negativeSum);
        System.out.println("Cuenta de los ceros..: " + zeroCount);
 
    }
 
    private long Factorial(int number) {
        long result = 1;
        for( ; number > 1; --number ) {
            result *= number;
        }
        return result;
    }
}
 
