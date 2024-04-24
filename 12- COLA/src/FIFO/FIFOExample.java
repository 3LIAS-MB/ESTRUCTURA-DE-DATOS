// Queue es una interfaz en Java que representa una estructura de datos tipo cola.
// Una cola es una colección de elementos donde el elemento que se agrega primero 
// es el primero en ser eliminado (técnica conocida como FIFO).

// → FIFO - "First-In, First-Out”: El primero en entrar es el primero en salir

package FIFO;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FIFOExample {
    public static void main(String[] args) {
    	
    	// Se utilizar una de las clases que implementan la interfaz Queue,
    	// como LinkedList o ArrayDeque, para crear una instancia de una cola. 
    	
        Queue<String> fifoQueue = new LinkedList<>(); // Queue -> Cola
        Queue<String> cola = new PriorityQueue<>(); // No conozco aun
        
        //Queue<String> cola = new ArrayList<>(); -> NO EXISTE
        	

        // Agregamos elementos a la cola
        fifoQueue.add("A");
        fifoQueue.add("B");
        fifoQueue.add("C");

        // Mostramos los elementos en orden de entrada (FIFO)
        System.out.println("Elementos en la cola (FIFO):");
        while (!fifoQueue.isEmpty()) {
            System.out.println(fifoQueue.poll());
        }
    }	
}


//Puedes implementar una cola utilizando clases como LinkedList o ArrayDeque.

// FIFO - "First-In, First-Out". "Primero en Entrar, Primero en Salir".

//offer(elemento) Agrega el elemento especificado al final de la cola. Devuelve verdadero si el elemento se agregó a esta cola; de lo contrario, falso
//poll(): Elimina y devuelve el elemento en la parte frontal de la cola. Si la cola esta vacia devuelve null, no genera exception, este metodo es más seguro
//peek(): Devuelve el elemento en la parte frontal de la cola sin eliminarlo. Devuelve null si la cola está vacía.

//add(elemento): Agrega un elemento al final de la cola. Devuelve verdadero en caso de éxito y arroja una "IllegalStateException" si no hay espacio disponible
//remove(): Elimina y devuelve el elemento en la parte frontal (cabeza) de la cola. Si la cola esta vacia devuelve una exception "NoSuchElementException"
//element(): Devuelve el elemento en la parte frontal de la cola sin eliminarlo. Si no, Lanza una excepción 'NoSuchElementException'

//isEmpty(): Verifica si la colección está vacía. -> Devuelve booleano
//size(): Devuelve el número de elementos real en la colección.
//------------------------------------------------------------------------------------------------------------------------------------------

// Métodos heredados de la interfaz java.util.Collection -> Los comparte con LIFO

//clear(): Elimina todos los elementos de la colección.
//toArray(): Convierte la colección en un arreglo de objetos.
//contains(Object elemento): Verifica si la colección contiene el elemento especificado.
//remove(Object elemento): Elimina la primera instancia del elemento especificado de la colección.

//addAll
//containsAll
//equals
//hashCode
//iterator
//removeAll
//retainAll
//toArray