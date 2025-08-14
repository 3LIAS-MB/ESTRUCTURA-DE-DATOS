import java.util.Scanner;

import javax.swing.JOptionPane;

public class OrdenamientoPorInsercion {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int arreglo[], nElementos, pos, aux;
		
		nElementos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de elementos: "));
		
		arreglo = new int[nElementos];
		
		System.out.println("Digite el arreglo: ");
		for(int i=0;i<nElementos;i++) {
			System.out.print((i+1)+". Digite un numero: ");
			arreglo[i] = entrada.nextInt();
		}
		
		// Ordenamiento por insercion
		for (int i=0;i<nElementos;i++) {
			pos = i; // Nuestra flechita
			aux = arreglo[i];
			
			while((pos > 0) && (arreglo[pos-1] > aux)) {
				arreglo[pos] = arreglo[pos-1];
				pos--;
			}
			arreglo[pos] = aux; // Refrescar el número actual
		}
		
		System.out.print("Orden ascendente: ");
		for(int i=0;i<nElementos;i++) {
			System.out.print(arreglo[i]+" - ");
		}
		System.out.println("");
		
		System.out.print("Orden descentente: ");
		for(int i=(nElementos-1);i>=0;i--) {
			System.out.print(arreglo[i]+" - ");
		}
		System.out.println("");
		
		entrada.close();
	}
}
