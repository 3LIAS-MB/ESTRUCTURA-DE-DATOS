package Ejercicio3;

/*Una bicola también es conocida como una cola doble y es una variante de la estructura de datos cola
simple. La variante consiste en que los elementos van a poder ser insertados o eliminados por cualquiera
de los dos extremos de la cola. Por tanto, la entrada o salida de elementos podrá efectuarse tanto por el
principio como por el final de la misma, aunque la estructura seguirá comportándose como una cola en
cuanto al procesamiento de elementos.*/

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
    private int frente;
    private int fin;

    public Bicol4(int capacidad) { // Me dice cual es el tamaño del vector
        arreglo = new int[capacidad]; // Inicializo el arreglo
        tamaño = 0; // Me dice cuantos elementos tiene la cola
        frente = 0; // Apunta a la posicion del valor que va a salir
        fin = -1; // Apunta a la posicion donde se va a insetar un elemento
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == arreglo.length; // true o false
    }

    public void insertarAlFrente(int elemento) { //[3, 2, 1]
        if (!estaLlena()) {
            frente = (frente - 1 + arreglo.length) % arreglo.length; // -1, 2; 1; 0; 2; 1; 0... -> si es 3
            arreglo[frente] = elemento;								 // -1, 4; 3; 2; 1; 0; 4... -> si es 5
            tamaño++;
        } else {
            System.out.println("La bicola está llena. No se puede insertar al frente.");
        }
    }

    public void insertarAlFinal(int elemento) { //[1, 2, 3]
        if (!estaLlena()) {
            fin = (fin + 1) % arreglo.length; // -1, 0; 1; 2; 0... -> si es 3 
            arreglo[fin] = elemento;
            tamaño++;
        } else {
            System.out.println("La bicola está llena. No se puede insertar al final.");
        }
    }

    public int eliminarDelFrente() {
        if (!estaVacia()) {
            int elemento = arreglo[frente];
            frente = (frente + 1) % arreglo.length;
            tamaño--;
            return elemento;
        } else {
            System.out.println("La bicola está vacía. No se puede eliminar del frente.");
            return -1; // Valor predeterminado para indicar error
        }
    }

    public int eliminarDelFinal() {
        if (!estaVacia()) {
            int elemento = arreglo[fin];
            fin = (fin - 1 + arreglo.length) % arreglo.length;
            tamaño--;
            return elemento;
        } else {
            System.out.println("La bicola está vacía. No se puede eliminar del final.");
            return -1; // Valor predeterminado para indicar error
        }
    }

    public void mostrarBicola() {
        if (!estaVacia()) {
            System.out.print("Bicola: ");
            int indice = frente;
            for (int i = 0; i < tamaño; i++) {
                System.out.print(arreglo[indice] + " ");
                indice = (indice + 1) % arreglo.length;
            }
            System.out.println();
        } else {
            System.out.println("La bicola está vacía.");
        }
    }
}
