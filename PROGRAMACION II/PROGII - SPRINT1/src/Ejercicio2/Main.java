package Ejercicio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Zona nuevaZona1 = new Zona("Palpala", 10);
		
		while(true) {
			System.out.print("\nMENU: \n OPCION 1: Mostrar las entradas disponibles y zona"
					+"\n OPCION 2: Comprar entradas"
					+ "\n OPCION 3: Salir");
			
			//scanner.nextLine(); consume salto de linea
			System.out.print("\nSelección: ");
			int elegir = scanner.nextInt();
			
			
			if (elegir==1) {
			System.out.println("\nNumero de Entradas disponibles: " + nuevaZona1.getEntradasDisponibles() + "\nNombre de la zona: " + nuevaZona1.getNombreZona());
			
			} else if (elegir==2) {
			System.out.print("Ingrese la cantidad de entradas a comprar: ");
			int input = scanner.nextInt();
			nuevaZona1.venderEntradas(input);
			} else if (elegir==3) {
			System.out.println("\nPrograma terminado");
			break;
			}
		}
		
		scanner.close();
	}

}