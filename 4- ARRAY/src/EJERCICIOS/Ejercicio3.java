package EJERCICIOS; //Bucle for y for each

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		float numeros[] = new float[5];
		
		System.out.println("Guardando los datos en un arreglo");
		for (int i=0; i<5; i++) {
			System.out.print((i+1)+ ". Digite un numero: ");
			numeros[i] = entrada.nextFloat();
		}
		System.out.println("\nImprimir los elementos del arreglo: ");
		for(float i:numeros) {
			System.out.println(i);
		}
		
		entrada.close();
		
	}

}
