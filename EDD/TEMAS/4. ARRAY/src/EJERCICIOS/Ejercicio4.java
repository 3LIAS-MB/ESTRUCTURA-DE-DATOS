package EJERCICIOS; // Mezclar 2 arrays en uno solo

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner entrada= new Scanner(System.in);
		int a[], b[], c[]; // Creando 3 arreglos
		//float d[] = new float[5];
		
		a = new int[10]; // Arreglo a con 10 elementos -> Definiendo el tamaño
		b = new int[10]; // Arreglo b con 10 elementos
		c = new int[20]; // Arreglo c con 20 elementos
		
		//Pedimos el arreglo a
		System.out.println("Digite el primer arreglo: ");
		for (int i =0;i<10;i++) {
			System.out.print((i+1) + ". Digite un numero: ");
			a[i] = entrada.nextInt();
		}
		//Pedimos el arreglo c
		System.out.println("\nDigite el segundo arreglo:: ");
		for (int i=0;i<10;i++) {
			System.out.print((i+1) + ". Digite un numero: ");
			b[i] = entrada.nextInt();
		}
		
		//Ahora, vamos a mezclar los 2 arreglos en el arreglo c
		//vamos a utilizar el iterador i para a y b
		//y el iterador j para el arreglo c
		
		int j=0;
		for(int i=0;i<10;i++) {
			c[j] = a[i]; //1ro A
			j++;
			c[j] = b[i]; //1ro B
			j++;
		}
		
		System.out.print("\nEl tercer arreglo es: ");
		for (int i=0;i<20;i++) {
			System.out.print(c[i]+" ");
		}
		System.out.println();
		
		entrada.close();
	}
}
