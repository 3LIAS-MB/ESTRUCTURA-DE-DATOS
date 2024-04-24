/*Ejercicio 5: Realizar un juego para adivinar un número. Para ello generar un número aleatorio entre 0-100, y luego ir pidiendo números indicando
 * "es mavor" o " "es menor" según sea mayor o menor con respecto a N. El proceso termina cuando el usuario acierta y mostrar el número de intentos.*/

package EJERCICIOS;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		int numero, suma = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("ingrese el numero para sumarlo (0 para salir): ");
		numero = entrada.nextInt();
		
		while (numero != 0) {
			suma += numero;
			
			System.out.print("ingrese otro numero (0 para salir): ");
			numero = entrada.nextInt();
		}
		
		System.out.print("La suma total es: "+suma);
		
		entrada.close();
	}

}
	