/*Escribir un programa que permita ingresar el tamaño de un arreglo de números enteros y luego ingresar los
elementos del mismo, los cuales deben ser números primos. El programa debe mostrar el arreglo original y
a partir de él generar dos arreglos más: uno que contendrá los valores mayores a X (dado por el usuario) y
el otro que guardará los menores a Y (también dado por el usuario). Luego debe mostrar los arreglos
generados y revertir (dar vuelta) los valores de los mismos para mostrarlos nuevamente.
El ejercicio debe realizarse mediante la codificación de un método, función o subprograma que permita
mostrar cualquier tipo de arreglo.

Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.*/

package Ejercicio2;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int arreglo[], arreglo2[], arreglo3[];
        int long_x = 0, long_y = 0;
        int cont_x = 0, cont_y = 0;

        System.out.println("Seleccione una opción para ingresar valores:");
        System.out.println("1. Ingresar valores manualmente");
        System.out.println("2. Generar valores aleatoriamente");
        int opcion = entrada.nextInt();

        if (opcion == 1) {
            System.out.print("Ingrese el tamaño del arreglo: ");
            int tamaño = entrada.nextInt();
            arreglo = new int[tamaño];

            for (int i = 0; i < tamaño; i++) {
                System.out.print("Ingrese el elemento " + (i + 1) + ": ");
                int elemento = entrada.nextInt();
                if (esPrimo(elemento)) {
                    arreglo[i] = elemento;
                } else {
                    System.out.println("Debe ingresar números primos.");
                    break;
                }
            }
        } else if (opcion == 2) {
            System.out.print("Ingrese el tamaño del arreglo: ");
            int tamaño = entrada.nextInt();
            arreglo = generarValoresAleatorios(tamaño);
        } else {
            System.out.println("Opción no válida.");
            entrada.close();
            return;
        }

        System.out.println("Arreglo original:");
        mostrarArreglo(arreglo);

        System.out.print("Valores mayores a X: ");
        int x = entrada.nextInt();
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > x) {
                long_x++;
            }
        }
        arreglo2 = new int[long_x];

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > x) {
                arreglo2[cont_x] = arreglo[i];
                System.out.print(arreglo2[cont_x] + " - ");
                cont_x++;
            }
        }

        System.out.print("\nValores menores a Y: ");
        int y = entrada.nextInt();
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] < y) {
                long_y++;
            }
        }
        arreglo3 = new int[long_y];

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] < y) {
                arreglo3[cont_y] = arreglo[i];
                System.out.print(arreglo3[cont_y] + " - ");
                cont_y++;
            }
        }

        entrada.close();
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] generarValoresAleatorios(int tamaño) {
        Random rand = new Random();
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
        	// Genera un núm aleatorio entre [0+1 y 100]
            int numeroAleatorio = rand.nextInt(100) + 1;
            arreglo[i] = numeroAleatorio;
        }
        return arreglo;
    }

    public static void mostrarArreglo(int[] arreglo) {
        for (int numero : arreglo) {
            System.out.print(numero + " - ");
        }
        System.out.println();
    }
}
