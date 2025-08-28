import java.util.Scanner;

import javax.swing.JOptionPane;

public class OrdenamientoMetodoBurbuja {
 public static void main(String[] args) {
		 Scanner entrada = new Scanner(System.in);
		 int arreglo[], nElementos, aux;
		 
		 nElementos = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de elementos del arreglo: "));
		 
		 arreglo = new int[nElementos]; // Le asignamos el numero de elementos al arreglo
		 
		 for(int i=0;i<nElementos;i++) {
			 System.out.print((i+1)+". Digite un numerio:  ");
			 arreglo[i] = entrada.nextInt();
		 }
		 
		 // Metodo Burbuja
		 for(int i=0;i<(nElementos-1);i++) { 
			 for(int j=0;j<(nElementos-1);j++) {
				 if(arreglo[j] > arreglo[j+1]) { // Si numeroActual > numeroSiguiente
					 aux = arreglo[j];
					 arreglo[j] = arreglo[j+1];
					 arreglo[j+1] = aux;
				 }
			 } 
		}
 	
		 // Mostrar el arreglo ordenado en forma creciente
		 System.out.println("\nArreglo ordenado en forma creciente: ");
		 for(int i=0;i<nElementos;i++) {
			 System.out.print(arreglo[i] + " - ");
		}
		 
		 System.out.println("\nArreglo ordenado en forma decreciente: ");
		 for(int i=(nElementos-1);i>=0;i--) { // Le agrego -1 si no me da error, tambien puede ser que baste. Revisar
			 System.out.print(arreglo[i] + " - ");
		}
		
		entrada.close();
 	}
 }
