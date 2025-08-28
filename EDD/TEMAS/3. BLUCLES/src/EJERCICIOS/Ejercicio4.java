/*Dadas las edades У alturas de 5 alumnos, mostrar la edad y la estatura media, la
cantidad de alumnos mavores de 18 años, y la cantidad de alumnos que miden más de 1.75*/

package EJERCICIOS;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		int numero;
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite un numero entre [0, 10]: ");
		numero = entrada.nextInt();
		
		for (int i=1; i <= 10; i++) {
			
			System.out.println(numero +" * "+i +" = " +numero * i);
		}
		
		entrada.close();
	}

}
