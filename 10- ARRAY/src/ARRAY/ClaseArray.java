package ARRAY;

import java.util.Arrays;

public class ClaseArray {
    public static void main(String[] args) {
        // Crear un array de números enteros
        int[] miArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        System.out.println("Array original: " + Arrays.toString(miArray));

        // Ordenar el array en orden ascendente
        Arrays.sort(miArray);
        System.out.println("Array ordenado: " + Arrays.toString(miArray)); // devuelve un objeto por eso necesita
        																   // el "toString" para mostrarse
        																   // en todos los casos
        
        // Rellenar el array con un valor
        Arrays.fill(miArray, 9); // reeplaza todo del original
        System.out.println("Array rellenado: " + Arrays.toString(miArray));
        
        // Comparar arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        System.out.println("Arrays iguales: " + Arrays.equals(array1, array2));
        
        // Copiar parte del array
        int[] newArray = Arrays.copyOf(miArray, 2); // Copia hasta el indice 2
        System.out.println("Copia del array: " + Arrays.toString(newArray));
        
        // Buscar un elemento en el array (ejemplo: 5)
        int elementoBuscado = 5;
        // La búsqueda binaria es más eficiente que la búsqueda lineal, pero requiere que el array esté 
        // ordenado. Este método divide repetidamente el array en mitades para reducir el rango de búsqueda.
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
    }
}

// Arrays.length() -> Obtiene la longitud real (número de elementos) del array [1, 2, 3, 4] -> 4.
// Arrays.clone() -> Crear una copia superficial del array. Devuelve un nuevo array que es una copia del array original.
// Arrays.equals() -> Comparar dos arrays para verificar si son iguales en contenido. Devuelve un valor booleano (true si son iguales, false si no lo son).
// Arrays.toString(array) -> Convierte un array en una cadena de texto para facilitar la visualización del contenido. Devuelve cadena que representa el contenido del array.
// Arrays.sort(array) -> Ordena los elementos del array en orden ascendente.
// Arrays.fill(array, valor) -> Llena un array con un valor específico.

// System.arraycopy() -> Copiar elementos de un array a otro