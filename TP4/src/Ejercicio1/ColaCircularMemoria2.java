package Ejercicio1; 

class ColaMemoria {
    private int[] arreglo;
    private int tamaño;
    private int frente;
    private int fin;

    public ColaMemoria(int capacidad) {
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
            System.out.println("La cola está llena. No se puede encolar.");
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

