package Bicola;


/*Una bicola también es conocida como una cola doble y es una variante de la estructura de datos cola
simple. La variante consiste en que los elementos van a poder ser insertados o eliminados por cualquiera
de los dos extremos de la cola. Por tanto, la entrada o salida de elementos podrá efectuarse tanto por el
principio como por el final de la misma, aunque la estructura seguirá comportándose como una cola en
cuanto al procesamiento de elementos.

*Implementar una bicola conforme a lo comentado anteriormente. Comprobar el correcto funcionamiento
de la implementación propuesta creando una instancia de la cola y utilizando las operaciones de la misma a
pedido del operador. Para ello, puede usar un menú de opciones.*/

import java.util.Scanner;
public class Bicola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la capacidad de la bicola: ");
        int capacidad = scanner.nextInt();
        Bicol4 bicola = new Bicol4(capacidad);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Insertar al frente");
            System.out.println("2. Insertar al final");
            System.out.println("3. Eliminar del frente");
            System.out.println("4. Eliminar del final");
            System.out.println("5. Mostrar la bicola");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un elemento para insertar al frente: ");
                    int elemento = scanner.nextInt();
                    bicola.insertarAlFrente(elemento);
                    break;
                case 2:
                    System.out.print("Ingrese un elemento para insertar al final: ");
                    elemento = scanner.nextInt();
                    bicola.insertarAlFinal(elemento);
                    break;
                case 3:
                    int eliminadoFrente = bicola.eliminarDelFrente();
                    if (eliminadoFrente != -1) {
                        System.out.println("Elemento eliminado del frente: " + eliminadoFrente);
                    }
                    break;
                case 4:
                    int eliminadoFinal = bicola.eliminarDelFinal();
                    if (eliminadoFinal != -1) {
                        System.out.println("Elemento eliminado del final: " + eliminadoFinal);
                    }
                    break;
                case 5:
                    bicola.mostrarBicola();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
 class Bicol4 {
    private int[] arreglo;
    private int tamaño;
    private int head; // Anteriormente frente
    private int tail; // Anteriormente fin

    public Bicol4(int capacidad) {
        arreglo = new int[capacidad];
        tamaño = 0;
        head = 0;
        tail = -1;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == arreglo.length;
    }

    private int next(int pos) {
        if (++pos >= this.arreglo.length) {
            pos =  0;
        }
        return pos;
    }

    private int prev(int position) {		
        if (--position < 0) {
            position = arreglo.length - 1;
        }
        return position;
    }

    public void insertarAlFinal(int elemento) {
        if (!estaLlena()) {
            head = prev(head);
            arreglo[head] = elemento;
            tamaño++;
        } else {
            System.out.println("La bicola está llena. No se puede insertar al frente.");
        }
    }
    
    public int eliminarDelFinal() {
        if (!estaVacia()) {
            int elemento = arreglo[head];
            head = next(head);
            tamaño--;
            return elemento;
        } else {
            System.out.println("La bicola está vacía. No se puede eliminar del frente.");
            return -1;
        }
    }
    
    /**/
    
    public void insertarAlFrente(int elemento) {
        if (!estaLlena()) {
            tail = next(tail);
            arreglo[tail] = elemento;
            tamaño++;
        } else {
            System.out.println("La bicola está llena. No se puede insertar al final.");
        }
    }
    
    public int eliminarDelFrente() {
        if (!estaVacia()) {
            int elemento = arreglo[tail];
            tail = prev(tail);
            tamaño--;
            return elemento;
        } else {
            System.out.println("La bicola está vacía. No se puede eliminar del final.");
            return -1;
        }
    }

    public void mostrarBicola() {
        if (!estaVacia()) {
            System.out.print("Bicola: ");
            int indice = head;
            for (int i = 0; i < tamaño; i++) {
                System.out.print(arreglo[indice] + " ");
                indice = next(indice);
            }
            System.out.println();
        } else {
            System.out.println("La bicola está vacía.");
        }
    }
}