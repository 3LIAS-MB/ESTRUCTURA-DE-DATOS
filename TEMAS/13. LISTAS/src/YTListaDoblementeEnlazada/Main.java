package YTListaDoblementeEnlazada;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ListaDoble list = new ListaDoble();
		int opcion = 0, elemento;
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "\t**Menú**"
						+ "\n1. Agregar un nodo al inicio"
						+ "\n2. Agregar un nodo al final"
						+ "\n3. Eliminar un nodo del inicio" 
						+ "\n4. Eliminar un nodo del final"
						+ "\n5. Mostrar la lista de inicio a fin"
						+ "\n6. Mostrar la lista de fin a inicio"
						 
						+ "\n7. Salir"));
				switch(opcion) {
				case 1:
					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento: ", "Agregando al inicio", JOptionPane.INFORMATION_MESSAGE));
					list.agregarInicio(elemento);
					break;
				case 2:
					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento: ", "Agregando al inicio", JOptionPane.INFORMATION_MESSAGE));
					list.agregarFinal(elemento);
					break;
				case 3:
					if(!list.estaVacia()) {
						elemento = list.eliminarInicio();
						JOptionPane.showMessageDialog(null, "Elemento eliminado: " + elemento, "Lista vacia", JOptionPane.INFORMATION_MESSAGE);
					} else {
						System.out.println("No hay nodos en la lista...");
					}
					break;
				case 4:
					if(!list.estaVacia()) {
						elemento = list.eliminarFinal();
						JOptionPane.showMessageDialog(null, "Elemento eliminado: " + elemento, "Lista vacia", JOptionPane.INFORMATION_MESSAGE);
					} else {
						System.out.println("No hay nodos en la lista...");
					}
					break;
				case 5:
					if(!list.estaVacia()) {
						list.mostrarInicio4Fin();
					} else {
						System.out.println("No hay nodos en la lista...");
					}
					break;
				case 6:
					if(!list.estaVacia()) {
						list.mostrarFin4Inicio();
					} else {
						System.out.println("No hay nodos en la lista...");
					}
					break;
				case 7:
					System.out.println("Programa finallizado.");
					break;
				default:
					System.out.println("Opción incorrecta.");
				}
						
			} catch (NumberFormatException e) { // Exception
				System.out.println("Error no esperado...");
			}
		} while(opcion != 7);
	}
}
