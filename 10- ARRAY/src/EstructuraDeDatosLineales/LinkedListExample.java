// LinkedLists: Las LinkedLists son estructuras de datos en las que cada elemento contiene una referencia al
// siguiente elemento en la secuencia. Esto permite la inserción y eliminación eficiente de elementos en cualquier
// posición de la lista. Sin embargo, el acceso a elementos por índice puede ser menos eficiente que en los arrays,
// ya que es necesario recorrer la lista desde el principio o desde el final para encontrar un elemento específico.

// Las LinkedLists son adecuadas cuando se realizan operaciones frecuentes de inserción y eliminación en el medio de la lista.

// 1- Estructura de datos subyacente:

/*LinkedList se implementa como una lista doblemente enlazada. Esto significa que es más eficiente para insertar
o eliminar elementos en cualquier posición, pero puede ser más lento para acceder a elementos en posiciones aleatorias.*/

// 2- Acceso a elementos:

/*LinkedList requiere recorrer la lista desde el principio o el final para acceder a elementos
 * en posiciones específicas. El acceso a elementos es de tiempo lineal O(n) en el peor caso.*/

// 3- Inserciones y eliminaciones:

/*LinkedList es más eficiente para insertar o eliminar elementos
 * en cualquier posición, ya que solo necesita actualizar los enlaces.*/

// 4- Uso de memoria:

/*LinkedList consume más memoria debido a la necesidadç
 * de almacenar referencias a nodos enlazados.*/

// 5- Iteración:

/*LinkedList es menos eficiente para iteración debido a
 * la necesidad de seguir enlaces de nodo a nodo.*/

package EstructuraDeDatosLineales;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample { // -> LISTA ENCADENADA
    public static void main(String[] args) {
        // Crear una LinkedList de tipo Integer
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<String> arrayList = new ArrayList<>(); // -> Uso como referencia la interfaz List
        
        // Agregar elementos al final de la lista
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        
        // Agregar elementos en una posición específica -> Desplaza la posicion 1 al 2 para colocarlo
        linkedList.add(1, 15);

        // Acceder a elementos por índice
        int elemento = linkedList.get(2); // Devuelve el elemento en el índice 2
        int elemento2 = linkedList.getFirst(); // Acceder al primer elemento
        int elemento3 = linkedList.getLast(); // Acceder al último elemento

        // Modificar un elemento
        linkedList.set(3, 25); // Establece el valor en el índice 3 como 25

        // Eliminar elementos por índice y devuelve
        linkedList.remove(2); // Elimina el elemento en el índice 0
      

        // Iterar a través de la lista usando un bucle for-each
        System.out.println("Elementos de la LinkedList:");
        for (int num : linkedList) {
            System.out.println(num);
        }

        // Obtener el tamaño de la lista
        int tamaño = linkedList.size();

        // Comprobar si la lista está vacía
        boolean estaVacia = linkedList.isEmpty();

        // Eliminar todos los elementos de la lista
        linkedList.clear();

        // Comprobar si un elemento está en la lista
        boolean contiene = linkedList.contains(20); // Devuelve false, ya que se limpió la lista
    }
}

// METODOS
	
//add(E elemento): Agrega un elemento al final de la lista.
//add(int índice, E elemento): Inserta el elemento especificado en la posición indicada.
//addFirst(E elemento): Agrega un elemento al principio de la lista.
//addLast(E elemento): Agrega un elemento al final de la lista (equivalente a add).

//contains(Object objeto): Comprueba si la lista contiene el objeto especificado.
//lista1.equals(lista2) -> Compara si la lista es igual a otro objeto.
//get(int índice): Obtiene el elemento en la posición especificada.
//indexOf(Object objeto): Devuelve la primera posición del elemento puesto como parámetro. Devuelve -1 si no esta
//isEmpty(): Comprueba si la lista está vacía.
//lastIndexOf(Object objeto): Devuelve el índice de la última ocurrencia del objeto especificado en la lista.
//set(int índice, newElement): Reemplaza el elemento en la posición especificada con el nuevo elemento.
//size(): Devuelve el número de elementos en la lista.
//clear(): Elimina todos los elementos de la lista. No devuelve nada

//lista.remove(); -> Elimina el primer elemento en la lista. Devuelve un valor booleano
//lista.remove(1)); // Elimina el elemento en la posición 1 y lo devuelve
//lista.remove(Integer.valueOf(5))); // Elimina la primera ocurrencia de 5 en la lista. Devuelve true si lo elimino y false si no
//lista2.remove("xd"); -> Elimina la primera ocurrencia del String puesto. Devuelve true si lo elimino y false si no

//removeFirst(): Elimina y devuelve el primer elemento de la lista (equivalente a remove).
//removeLast(): Elimina y devuelve el último elemento de la lista.

//offer(E elemento): Agrega un elemento al final de la lista (equivalente a add).
//offerFirst(E elemento): Agrega un elemento al principio de la lista (equivalente a addFirst).
//offerLast(E elemento): Agrega un elemento al final de la lista (equivalente a addLast).

//poll(): Elimina y devuelve el primer elemento de la lista (equivalente a remove).
//pollFirst(): Elimina y devuelve el primer elemento de la lista (equivalente a removeFirst).
//pollLast(): Elimina y devuelve el último elemento de la lista (equivalente a removeLast).

//toArray(): Convierte la lista en un array.
//toArray(T[] array): Convierte la lista en un array del tipo especificado.

//iterator(): Devuelve un iterador sobre los elementos de la lista.
//listIterator(): Devuelve un iterador de lista sobre los elementos de la lista.



