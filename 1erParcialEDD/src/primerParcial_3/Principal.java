package primerParcial_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		Matriz nuevaMatriz =null;
		while(true) {
			System.out.println("MENU: \nOPCION 1: crear la matriz de tamaÃ±o mxm"
					+ "\nOPCION 2: mostrar la matriz mxn" + "\nOPCION 3:terminar el programa"+
					"\nOPCION 4: suma de los no numeros diagonal"+ "\nOPCION 5: La suma de los elementos de cada fila"+
					"\nOPCION 6: encontrar minimo");
			int opcion = Integer.parseInt(scanner.nextLine());
			//System.out.println("\n");
			switch(opcion) {
				case 1:
					nuevaMatriz = Matriz.crearMatriz();
					nuevaMatriz.llenarMatrizConsecutivos();
					break;
				case 2:
					nuevaMatriz.imprimirMatriz();
					break;
				case 3:
					System.out.println("PROGRAMA TERMINADO");
					break;
				case 4:
					nuevaMatriz.sumaNumerosNoMatrizDiagonal();
					break;
				case 5:
					// Mostrar los elementos del ArrayList
					ArrayList<Integer> lista = nuevaMatriz.sumaElementosFila();
			        for (int i=0; i<lista.size();i++) {
			            System.out.println("Suma de la fila "+ i + ":" +lista.get(i));
			        }
			        break;
				case 6:
					ArrayList<Integer> lista2 = nuevaMatriz.obtenerMinimosColumnas();
					for (int i=0; i<lista2.size();i++) {
			            System.out.println("El elemento minimo de la columna: "+ i + ":" +lista2.get(i));
			        }
			        break;
				default:
					System.out.println("ERROR: REVISE EL VALOR INGRESADO");
			}
		}
	}

}