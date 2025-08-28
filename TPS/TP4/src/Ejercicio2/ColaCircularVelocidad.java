package Ejercicio2;

/*Codificar una implementación del tipo de dato abstracto Queue o Cola que utilice un arreglo como
contenedor de elementos, e implemente los conceptos vistos como “Cola Circular” para el caso de una cola
que prioriza velocidad. Comprobar el correcto funcionamiento de la implementación propuesta creando
una instancia de la cola y utilizando las operaciones de la misma a pedido del operador. Para ello, puede
usar un menú de opciones.
Indicaciones:

Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente*/

import java.util.Scanner;

public class ColaCircularVelocidad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la capacidad de la cola: ");

        // Validación de la capacidad (número positivo)
        int capacidad;
        while (true) {
            capacidad = scanner.nextInt();
            if (capacidad > 0) {
                break;
            } else {
                System.out.println("La capacidad debe ser un número positivo. Ingrese nuevamente: ");
            }
        }

        ColaVelocidad cola = new ColaVelocidad(capacidad);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Encolar");
            System.out.println("2. Desencolar");
            System.out.println("3. Comprobar si un elemento existe");
            System.out.println("4. Mostrar la cola");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Control de entrada
            int opcion;
            while (true) {
                try {
                    opcion = scanner.nextInt();
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Ingrese un número válido. Intente nuevamente: ");
                    scanner.next(); // Limpiar el búfer del scanner
                }
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un elemento para encolar: ");
                    int elemento = scanner.nextInt();
                    cola.encolar(elemento);
                    break;
                case 2:
                    cola.desencolar();
                    break;
                case 3:
                    System.out.print("Ingrese un elemento a buscar: ");
                    elemento = scanner.nextInt();
                    boolean existe = cola.existeEnCola(elemento);
                    if (existe) {
                        System.out.println("El elemento existe en la cola.");
                    } else {
                        System.out.println("El elemento no existe en la cola.");
                    }
                    break;
                case 4:
                    cola.mostrarCola();
                    break;
                case 5:
                    scanner.close(); // Cerrar el scanner al finalizar
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

class ColaVelocidad {
    private int[] arreglo;
    private int tamaño;
    private int frente;
    private int fin;

    public ColaVelocidad(int capacidad) {
        arreglo = new int[capacidad];
        tamaño = 0;
        frente = 0;
        fin = -1;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == arreglo.length;
    }

    public void encolar(int elemento) {
        if (!estaLlena()) {
            fin = (fin + 1) % arreglo.length;
            arreglo[fin] = elemento;
            tamaño++;
        } else {
            frente = (frente + 1) % arreglo.length; // Desencolar el frente para dar paso a un nuevo elemento
            fin = (fin + 1) % arreglo.length;
            arreglo[fin] = elemento;
        }
    }

    public void desencolar() {
        if (!estaVacia()) {
            frente = (frente + 1) % arreglo.length;
            tamaño--;
        } else {
            System.out.println("La cola está vacía. No se puede desencolar.");
        }
    }

    public boolean existeEnCola(int elemento) {
        for (int i = 0; i < tamaño; i++) {
            int indice = (frente + i) % arreglo.length;
            if (arreglo[indice] == elemento) {
                return true;
            }
        }
        return false;
    }

    public void mostrarCola() {
        if (!estaVacia()) {
            System.out.print("Cola: ");
            for (int i = 0; i < tamaño; i++) {
                int indice = (frente + i) % arreglo.length;
                System.out.print(arreglo[indice] + " ");
            }
            System.out.println();
        } else {
            System.out.println("La cola está vacía.");
        }
    }
}

