/*Guillermo tiene N dolares. Luis tiene la mitad de lo que posee Guillermo. Juan tiene la mitad de
 * lo que posee Luis y Guillermo juntos. Hacer un programa que calcule e imprima la cantidad de
 * dinero que tienen los tres*/
package EJERCICIOS;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		float guillermo, juan, luis, total;
		
		System.out.print("¿Cuánto dinero tiene Guillermo?: ");
		guillermo = entrada.nextFloat();
		
		juan = guillermo/2;
		
		luis = (guillermo + juan)/2;
		
		total = guillermo + juan + luis;
		
		System.out.println("La cantidad de dinero de los tres juntos es de: " + total);
		
		entrada.close();

	}

}
