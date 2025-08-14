package Ejercicio3;

import java.util.Scanner;

public class Main {
	
	public static double mayorArea(Triangulo_Isoseles triangulos[]) { // (Tipo dato[])
		double area;
		
		area = triangulos[0].obtenerArea();
		for(int i=1; i<triangulos.length; i++) {
			if(triangulos[i].obtenerArea()>area) {
				area = triangulos[i].obtenerArea();
			}
		}
		
		return area;
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		double base, lado;
		int nTriangulos;
		
		System.out.print("Digite los numeros de triangulos a ingresar: ");
		nTriangulos = entrada.nextInt();
			
		Triangulo_Isoseles triangulos[] = new Triangulo_Isoseles[nTriangulos]; // Triangulo_Isoseles: Esto declara una variable llamada triangulos[] que es un arreglo de objetos de la 
															 				   // clase Triangulo_Isoseles. En otras palabras, triangulos puede contener múltiples objetos Triangulo_Isoseles.
		for(int i=0; i<triangulos.length; i++) {
			System.out.println("\nDigite los valores para el triangulo " + (i+1)+": ");
			System.out.print("Introduzca la base: ");
			base = entrada.nextDouble();
			System.out.print("Introduzca el lado: ");
			lado = entrada.nextDouble();
			
			triangulos[i] = new Triangulo_Isoseles(base, lado); // Se crean instancias individuales de la clase Triangulo_Isoseles y se almacenan en cada posición del arreglo triangulos
				
			System.out.println("\nEl primetro del triangulo es: "+triangulos[i].obtenerPerimetro());
			System.out.println("El area del triangulos es: "+triangulos[i].obtenerArea());
		}
		
		System.out.println("El area del triangulo de mayor superficie es: "+mayorArea(triangulos));
		
		entrada.close();	
	}
}
