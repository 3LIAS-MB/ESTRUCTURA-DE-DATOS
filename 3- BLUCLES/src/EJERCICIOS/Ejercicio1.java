package EJERCICIOS;

import javax.swing.JOptionPane;

public class Ejercicio1 {
	public static void main(String[] args) {
		int numero, aleatorio, contador = 0;
		
		aleatorio = (int)(Math.random() * 100); // Math es un dato de tipo dobule y te genera numeros aleatorios entre 0 y 1
		
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
			
			if (aleatorio > numero) {
				System.out.println("Digite un numero mayor");
			} else {
				System.out.println("Digite un numero menor");
			}
				
			contador++; // Aumentamos en 1 el contador
			
		} while(numero != aleatorio);
		
		System.out.print("\nGenial, adivinaste el numero en: "+contador+ " intentos.");

	}
}
