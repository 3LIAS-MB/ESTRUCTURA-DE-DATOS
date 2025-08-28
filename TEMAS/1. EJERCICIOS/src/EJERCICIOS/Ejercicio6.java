/*El cuadrado de una suma*/
package EJERCICIOS;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		double a, b, igualdad;
		
		System.out.print("Ingrese a: ");
		a = entrada.nextInt();
		
		System.out.print("Ingrese b: ");
		b = entrada.nextInt();
		
		igualdad = Math.pow(a, 2) + Math.pow(b, 2) + 2 * a * b;

		System.out.println("El cuadrado de la suma es: " + igualdad);
		
		
		entrada.close();
	}
}
