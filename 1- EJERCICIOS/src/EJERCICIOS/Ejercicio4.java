/*Una compañia de venta de carros usados paga a su personal de ventas un salario de $1000 mensuales,
 * más una comisión de $150 por cada carro vendido, más el 5% del valor de la venta por carro.
 * Cada mes el capturista de la empresa ingresa en la computadora los datos pertienentes. Hacer
 * un programa que calcule e imprima el salario mensual del vendedor dado*/
package EJERCICIOS;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String nombre;
		int cantidad;
		float total;
		
		System.out.print("¿Cúal es el nombre del vendedor?: ");
		nombre = entrada.nextLine();
		
		System.out.print("\n¿Cúantos carros vendio este  mes?: ");
		cantidad = entrada.nextInt();
		
		total = 1000 + (150 * cantidad) + (50 * cantidad);
		
		System.out.println("El salario mensual de " + nombre + "es de: " + total);
		
		entrada.close();
	}
}
