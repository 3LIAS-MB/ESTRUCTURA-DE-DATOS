 //Stack es una clase en Java que representa una estructura de datos tipo pila. Una pila es una colección de
//elementos donde el último elemento que se agrega es el primero en ser eliminado
//(técnica conocida como LIFO - "Last-In, First-Out"). En otras palabras, el último
//elemento que se inserta en la pila es el primero en ser procesado o eliminado

//Los elementos se agregan y eliminan solo en la parte superior de la pila.
//Cuando agregas un nuevo elemento, este se convierte en el nuevo elemento superior de
//la pila, y cuando eliminas un elemento, siempre es el elemento superior el que se elimina.

// LIFO - "Last-In, First-Out". El ultimo  en entrar es el primero en salir

package LIFO;

import java.util.Stack;

public class LIFOExample {
    public static void main(String[] args) {
    	
        Stack<String> lifoStack = new Stack<String>(); // Stack -> (Pila):
        //List<String> stackList = new Stack<>(); // -> Uso como referencia la interfaz List. MALA PRACTICA
        
        // Agregamos elementos a la pila
        lifoStack.push("E");
        lifoStack.push("L");
        lifoStack.push("I");
        lifoStack.push("A");
        lifoStack.push("S");


        // Mostramos los elementos en orden de salida (LIFO)
        System.out.println("Elementos en la pila (LIFO):");
        while (!lifoStack.isEmpty()) {
            System.out.println(lifoStack.pop());
        }
    }
}

// LIFO - "Last-In, First-Out". "Último en Entrar, Primero en Salir".

//push(elemento): Agrega un elemento en la parte superior de la pila. Puede generar una excepcion si la pila es nula 'NullPointerException';
//o si intentamos agregar elementos que excedan la memoria 'OutOfMemoryError' 
//pop(): Elimina y devuelve el elemento en la parte superior de la pila. Si la pila está vacia genera una excepcion 'EmptyStackException'
//peek(): Devuelve el elemento en la parte superior de la pila sin eliminarlo. Devuelve 'null' si esta vacia

//isEmpty(): Verifica si la colección está vacía. -> Devuelve booleano
//size(): Devuelve el número de elementos en la colección. El tamaño REAL de la pila [1, 2, 3] -> devuelve 3
//search(elemento): Busca un elemento comenzando desde la parte superior de la pila (posicion 1) -> Devuelve -1 si no se encuentra
//---------------------------------------------------------------------------------------------------------------------------
// METODOS QUE COMPARTE CON FIFO

//clear(): Elimina todos los elementos de la colección.
//toArray(): Convierte la colección en un arreglo de objetos.
//contains(Object elemento): Verifica si la colección contiene el elemento especificado.
//remove(Object elemento): Elimina la primera instancia del elemento especificado de la colección.

// Estudiar si es necesario (algunos ya me lose sé)

//equals() Este método se utiliza para comparar la pila o el vector con otro objeto. Devuelve true si el objeto proporcionado
//es igual a la pila o el vector actual en términos de contenido y orden de los elementos. De lo contrario, devuelve false.

//trimToSize() -> Reduce la capacidad de almacenamiento de un vector al número de elementos que actualmente contiene. No devuelve nada
//set(int index, E element) -> Este método se utiliza para reemplazar el elemento en la posición especificada (index) con el nuevo
//elemento proporcionado. Devuelve el elemento previamente almacenado en la posición index antes de la actualización.

//iterator() -> se utiliza para obtener un iterador sobre los elementos en la pila o el vector. Un iterador es un objeto que
//permite recorrer los elementos de la colección uno por uno. Puedes utilizar este iterador para recorrer la pila o el vector en un bucle

//lastIndexOf(Object o) -> Este método se utiliza para encontrar la última aparición del objeto especificado en la pila o el vector
//Devuelve el índice de la última aparición del objeto o -1 si el objeto no se encuentra en la pila.

//hashCode(Object o9 ->utiliza para obtener el código hash de la pila o el vector. El código hash es un valor numérico que se utiliza
//en estructuras de datos basadas en hash y en comparaciones de objetos. Devuelve el código hash de la pila como un entero.
