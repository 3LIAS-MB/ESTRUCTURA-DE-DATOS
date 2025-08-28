/*Escribir una función, método o subprograma que reciba como parámetros una pila y un valor; debe
devolver una pila en la que se eliminan todas las apariciones del valor.*/

package CasosDeEjemplo;

import java.util.Scanner;
import java.util.Stack;

public class CasosDeEjemploC {
	
	final static Scanner entrada = new Scanner(System.in);
	static Stack<Integer> pila2 = new Stack<>(); // pila2 es accesible directamente desde el método main sin
												 // necesidad de crear una instancia de la clase que la contiene.
	public static void main(String[] args) {
		Stack<Integer> pila = new Stack<>();
		
		while(true) {
			System.out.println("\tMENU \n1. Generar pila \n2. Mostrar pila \n3. Eliminar duplicados");
			System.out.print("OPCION: ");
			int opcion = entrada.nextInt();
			
			switch(opcion){ // Estructura de control switch
			case 1:
				generarPila(pila);
				break;
			case 2:
				mostrarPila(pila);
				break;
			case 3:
				System.out.print("Ingrese el valor de la pila a eliminar: ");
				int delete = entrada.nextInt();
				
				eliminarDuplicados(pila, delete);
				mostrarPila(pila);
				break;
			default:
				System.out.println("XD"); // la palabra clave default se utiliza como una opción 
			}							  // predeterminada en caso de que ninguna de las expresiones 
		}								  // de case coincida con el valor de la expresión que se está evaluando
	}
		
	public static void generarPila(Stack<Integer> pila){
		int valores;
		
		do {
			System.out.print("Ingrese los valores de su pila (0 para salir): ");
			valores = entrada.nextInt();
			
			if(valores != 0) {
				pila.push(valores);
			}
		} while(valores != 0);
	}
	
	public static void mostrarPila(Stack<Integer> pila) {
		if(!pila.isEmpty()) {
			for(Integer valor : pila) {
				System.out.println("Pila: " + valor);
			}
		} else {
			System.out.println("La pila está vacia\n");
		}
	}
	
    public static void eliminarDuplicados(Stack<Integer> pila, int delete) {
        Stack<Integer> nuevaPila = new Stack<>(); // Creo una nueva pila para almacenar 
        										  // los valores NO duplicados
        while (!pila.isEmpty()) {
            int elemento = pila.pop(); // -> Se elimina directamente si la condicion
            if (elemento != delete) {  // no se cumple
                nuevaPila.push(elemento);
            }
        }

        // Volvemos a agregar los elementos a la pila original
        while (!nuevaPila.isEmpty()) { // -> Sigue hasta que la lista "nuevaPila" este vacia
            pila.push(nuevaPila.pop());
        }
    }
}