	package MATRICES;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Matriz {
	public static void main(String[] args) {
		 //int matriz[][] = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		Scanner entrada = new Scanner(System.in);
		int matriz[][], nFilas, nColumnas;
		
		nFilas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas: "));
		nColumnas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de columnas: "));

		matriz = new int[nFilas][nColumnas]; 
		
		System.out.println("Digite la matriz: ");
		for(int i=0; i<nFilas;i++) {
			for(int j=0; j<nColumnas;j++) {
				System.out.print("Matriz ["+i+"] ["+j+"]: ");
				matriz[i][j] = entrada.nextInt();
			}
		}
		
		System.out.println("La matriz es:");
		for(int i=0; i<nFilas;i++) { // Filas
			 for(int j=0; j<nColumnas;j++) { // Columnas
				 System.out.print(matriz[i][j]);
			 }
			 System.out.print("\n");
		 }
		
		entrada.close();
	}
	
}