/*Pedir un numero y calcular su factorial*/

package EJERCICIOS;

import java.util.Scanner;

public class Ejercicio3 {	 
	public static void main(String[] args) {
		int numero, factorial = 1;
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Ingrese un numero para calcular su factorial: ");
		numero = entrada.nextInt();
		
		for (int i = 2; i <= numero; i++) {
			
			factorial *= i;
		}
		
		System.out.print("Su factorial es: "+factorial);
		
		entrada.close();
	}
}