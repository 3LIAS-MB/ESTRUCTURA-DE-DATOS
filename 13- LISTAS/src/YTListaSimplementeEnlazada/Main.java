package YTListaSimplementeEnlazada;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Lista list = new Lista();
		int opcion = 0;
		int element;
		
		do {
			 try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"\t**MENÚ**"
						+ "\n1. Agregar un elemento al inicio de la lista"
						+ "\n2. Agregar un elemento al final de la lista"
						+ "\n3. Eliminar un elemento del inicio de la lista"
						+ "\n4. Eliminar un elemento del final de la lista"
						+ "\n5. Eliminar un elemento en especifico"
						+ "\n6. Buscar un elemento en especifico"
						+ "\n7. Mostrar los datos de la lista"                          
						+ "\n8. Salir"));
				
				switch(opcion) {
				case 1:
					element = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento: "));
					list.agregarInicio(element);
					break;
				case 2:
					element = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento: "));
					list.agregarFinal(element);
					break;
				case 3:
					element = list.borrarInicio();
					System.out.print("\nElemento eliminado del inicio: " + element);
					break;
				case 4:
					element = list.borrarFinal();
					System.out.print("\nElemento eliminado del final: " + element);
					break;
				case 5:
					element = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento: "));
					if(list.borrarEspecifico(element)) {
						System.out.println("\nElemento eliminado: " + element);
					} else {
						System.out.println("No sé encontró el elemento");
					}
					break;
				case 6:
					element = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento: "));
					if(list.buscarElemento(element)) {
						System.out.println("\nElemento encontrado: " + element);
					} else {
						System.out.println("No sé encontró el elemento");
					}
					break;
				case 7:
					list.mostrarLista();
					break;
				case 8:
					System.out.println("\nGracias!");
					break;
				default:
					System.out.println("Opcion incorrecta...");	
					break;
				}
			} 	catch (Exception e) {
				System.out.println("Algo salió mal");
			}
		} while(opcion != 8);
	}

}
