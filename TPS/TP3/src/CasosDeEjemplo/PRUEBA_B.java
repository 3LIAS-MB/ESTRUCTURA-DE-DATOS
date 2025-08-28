package CasosDeEjemplo;

import java.util.Scanner;

public class PRUEBA_B {
	public static void main(String[] args) {
		
		PILA pila = new PILA();
		int numero;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Ingrese un numero de 4 digitos: "); // 2023
			numero = input.nextInt();
			if(contarCifras(numero) != 4) {
				System.out.println("Error al ingresar el numero");
			}
		} while(contarCifras(numero) != 4);
		
		int unidad = numero % 10;
		pila.push(unidad);
		numero /= 10;
		
		int decena = numero % 10;
		pila.push(decena);
		numero /= 10;
		
		int centena = numero % 10;
		pila.push(centena);
		numero /= 10;
		
		int unidadDeMil = numero % 10;
		pila.push(unidadDeMil);
		
		System.out.println("Unidad de mil: " + pila.pop()); // 2
		System.out.println("Centena: " + pila.pop()); // 0 
		System.out.println("Decena: " + pila.pop()); // 2
		System.out.println("Unidad: " + pila.pop()); // 3
	}
	
	public static int contarCifras(int numero) {
		int contadorDeCifras = 0;
		while(numero != 0) {
			numero = numero / 10;
			++contadorDeCifras;
		}
		return contadorDeCifras;
	}
}