package ClaseArreglo; // La memoria estatica es el espacio logico que se reserva al momento de desarrolarlla
			          // y que no se puede modificar en tiempo de ejecucion
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ClaseArregloyMemoriaEstatica {
	public static void  main(String[] args) {
		
		int[] numeros = new int[5]; // memoria estatica
		int[] numerotes = new int[numeros.length];
		String[] palabras = new String[5];
		
		int i;
		for(i=0;i<5;i++) {
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento del indice " + i));
		}
		
		// Mostrando los datos como los ingresamos
		System.out.println("Los datos sin ordenar son: ");
		for(i=0; i<5; i++) {
			System.out.print("[" + numeros[i] + "]");
		}
		
		System.out.println("\nLos datos ordenados son: ");
		Arrays.sort(numeros); // Aqui ordenamos al arreglo "numeros"
		for(i=0; i<5; i++) {
			System.out.print("[" + numeros[i] + "]");
		}
		
		// Rellenando al arreglo palabras
		Arrays.fill(palabras, 6); // (nombreDelObjeto, loQueQuieroRellenar) Rellena el arreglo
		System.out.println("\nElementos del arreglo palabras");
		for(i=0; i<5; i++) {
			System.out.print("[" + palabras[i] + "]");
		}
		
		// Copiando los elementos del arreglo numeros a numerotes
		System.arraycopy(numeros, 0, numerotes, 0, numeros.length); // (origen, )
		System.out.println("\nElementos del arreglo numerotes");
		for(i=0; i<5; i++) {
			System.out.print("[" + numerotes[i] + "]");
		}
	}
}