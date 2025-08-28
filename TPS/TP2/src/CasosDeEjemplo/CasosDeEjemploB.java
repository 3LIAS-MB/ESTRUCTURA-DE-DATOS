/*Escribir un programa que permita ingresar los valores de una matriz cuadrada (arreglo de dos
dimensiones), mostrar la matriz en la consola y calcular la suma de los elementos que no pertenezcan a
la diagonal principal. Además, informar la cantidad de números positivos, negativos y ceros que
contiene la matriz.*/

package CasosDeEjemplo;

import java.util.Scanner;

public class CasosDeEjemploB {
	public static void  main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int value = 0, matriz[][];
		int negativos = 0, positivos = 0, ceros = 0, suma = 0;
		
		System.out.print("¿De cuanto quiere su matriz cuadrada?: ");
		int entrada = scanner.nextInt();
		matriz = new int[entrada][entrada];
		
		for(int i=0; i<entrada; i++) {
			for(int j=0; j<entrada; j++) {
				System.out.print("Ingrese valores para la matriz: ");
				value = scanner.nextInt();
				matriz[i][j] = value;
				
				if (matriz[i][j] < 0) {
					negativos ++;
				}
				else if(matriz[i][j] > 0) {
					positivos ++;
				}
				else if(matriz[i][j] == 0) {
					ceros ++;
				}
				
				if(i != j) {
					suma += matriz[i][j];
				}
				
			}
		}
		
		System.out.println("MATRIZ CUADRADA: ");
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz.length; j++) {
				System.out.print(matriz[i][j] + "-");
			}
			System.out.print("\n");
		}

		System.out.print("\nSuma de los elementos que no pertenecen a la diagonal: " + suma);
		System.out.print("\nCantidad de numeros positivos: " + positivos);
		System.out.print("\nCantidad de numeros negativos: " + negativos);
		System.out.print("\nCantidad de ceros de la matriz: " + ceros);
		
		scanner.close();
	}
}
