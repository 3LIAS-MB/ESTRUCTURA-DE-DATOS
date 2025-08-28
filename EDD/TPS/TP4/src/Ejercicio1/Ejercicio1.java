/*Codificar una implementación del tipo de dato abstracto Queue o Cola que utilice un arreglo como
contenedor de elementos, e implemente los conceptos vistos como “Cola Circular” para el caso de una cola
que prioriza memoria. Incluir el método existeEnCola(elemento) que devuelve el valor lógico verdadero
cuando elemento se encuentra en el objeto cola que llama al método, o el valor lógico falso en caso
contrario. Comprobar el correcto funcionamiento de la implementación propuesta creando una instancia
de la cola y utilizando las operaciones de la misma a pedido del operador. Para ello, puede usar un menú
de opciones*/

package Ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la capacidad de la cola: ");	//La declaración ColaCircular<Integer> especifica que la cola está diseñada 
        int capacidad = scanner.nextInt();						//para contener elementos de tipo Integer, y el compilador garantizará que solo
        														// puedas agregar elementos de ese tipo a la cola.
        
        ColaCircularMemoria1<Integer> cola = new ColaCircularMemoria1<>(capacidad); // El tipo genérico T se ajusta al tipo especificado al crear la instancia.
        															// acepta diferentes tipos de datos según la instancia, pero el 
        int opcion;													// tipo genérico T se ajusta al tipo especificado al crear la instancia.
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Encolar elemento");
            System.out.println("2. Desencolar elemento");
            System.out.println("3. Verificar si un elemento existe en la cola");
            System.out.println("4. Tamaño de la cola");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un elemento a encolar: ");
                    int elementoEncolar = scanner.nextInt();
                    cola.encolar(elementoEncolar);
                    break;
                case 2:
                    cola.desencolar();
                    break;
                case 3:
                    System.out.print("Ingrese un elemento a verificar: ");
                    int elementoVerificar = scanner.nextInt();
                    if (cola.existeEnCola(elementoVerificar)) {
                        System.out.println("El elemento existe en la cola.");
                        //System.out.println("El elemento " + elementoVerificar + (existe ? " existe" : " no existe") + " en la cola.");

                    } else {
                        System.out.println("El elemento no existe en la cola.");
                    }
                    break;
                case 4:
                    System.out.println("Tamaño de la cola: " + cola.tamaño());
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
