package ARRAY;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // Crear un array de números enteros
        int[] miArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};

        // Imprimir el array original
        System.out.println("Array original: " + Arrays.toString(miArray));
        
        String arrayString = Arrays.toString(miArray);
        System.out.println("ARRAY XDDDDD: \"" + arrayString + "\"");

        // Ordenar el array en orden ascendente
        Arrays.sort(miArray);

        // Imprimir el array ordenado
        System.out.println("Array ordenado: " + Arrays.toString(miArray)); // devuelve un objeto por eso necesita
        																   // el "toString" para mostrarse
        // Buscar un elemento en el array (ejemplo: 5)					   // en todos los casos
        int elementoBuscado = 5;
        int indice = Arrays.binarySearch(miArray, elementoBuscado);
        if (indice >= 0) {
            System.out.println("El elemento " + elementoBuscado + " se encuentra en el índice " + indice);
        } else {
            System.out.println("El elemento " + elementoBuscado + " no se encuentra en el array");
        }

        // Clonar el array original
        int[] miArrayClonado = miArray.clone(); 

        // Imprimir el array clonado
        System.out.println("Array clonado: " + Arrays.toString(miArrayClonado));

        // Llenar el array clonado con un valor específico (ejemplo: 7)
        int valorLlenado = 7;
        Arrays.fill(miArrayClonado, valorLlenado); // reeplaza todo del original

        // Imprimir el array clonado después de llenarlo
        System.out.println("Array clonado después de llenarlo: " + Arrays.toString(miArrayClonado));
    }
}

// Arrays.length() -> Obtiene la longitud real (número de elementos) del array [1, 2, 3, 4] -> 4.
// Arrays.clone() -> Crear una copia superficial del array. Devuelve un nuevo array que es una copia del array original.
// Arrays.equals() -> Comparar dos arrays para verificar si son iguales en contenido. Devuelve un valor booleano (true si son iguales, false si no lo son).
// Arrays.toString(array) -> Convierte un array en una cadena de texto para facilitar la visualización del contenido. Devuelve cadena que representa el contenido del array.
// Arrays.sort(array) -> Ordena los elementos del array en orden ascendente.
// Arrays.fill(array, valor) -> Llena un array con un valor específico.

// System.arraycopy() -> Copiar elementos de un array a otro