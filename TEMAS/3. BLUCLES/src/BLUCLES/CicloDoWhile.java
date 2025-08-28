package BLUCLES;

import java.util.Scanner;

public class CicloDoWhile {
		public static void main(String [] args) {
		Scanner entrada = new Scanner (System.in);
		int i=1, contador;
		
		System.out.print("Digite la cantidad de terminos: ");
		contador = entrada.nextInt();
		
		do {
			System.out.println(i);
			i += 3;
		} while (i<=contador);
		
		entrada.close();
	}
}