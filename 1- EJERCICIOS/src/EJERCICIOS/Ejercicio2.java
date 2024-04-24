/*Ejercicio 2: Hacer un programa que calcule e imprima el salario semanal de un
 * empleado a partir de sus horas semanales trabajadas y su salario por hora*/
package EJERCICIOS;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		float horas, salario;
		
		System.out.print("¿Cuántas horas trabajaste este semana?: ");
		horas = entrada.nextFloat();
		
		System.out.print("¿Cuánto es tu salario por hora?: ");
		salario = entrada.nextFloat();
		
		System.out.println("\nTu salario semanal es de: " +  salario * 168);
		System.out.println("Esta semana tu salario es de: " +  horas * salario);
		
		entrada.close();
	}
}