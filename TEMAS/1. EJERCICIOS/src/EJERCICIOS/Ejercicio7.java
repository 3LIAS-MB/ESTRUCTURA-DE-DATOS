/*Ejercicio 7: Construir un programa que, dado
un número total de horas, devuelve el número
de semanas, días y horas equivalentes. Por
ejemplo, dado un total de 1000 horas debe
mostrar 5 semanas, 6 días y 16 horas.*/
package EJERCICIOS;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		int semanas, dias, horas, horastotales;
		
		System.out.print("Ingrese una cantidad de horas: ");
		horastotales = entrada.nextInt();
		
		semanas = horastotales/168;
		dias = horastotales % 168 / 24;
		horas = horastotales % 24;
		
		System.out.println("El equivalente es: ");
		System.out.println("Semanas: " + semanas);
		System.out.println("Dias: " + dias);
		System.out.println("Horas: " + horas);
		
		entrada.close();
	}
}
	