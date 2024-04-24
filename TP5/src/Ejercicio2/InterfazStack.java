package Ejercicio2;

public interface InterfazStack<ELEMENT> extends Iterable<ELEMENT> {
	
	// Agrega un elemento en la parte superior de la pila. Puede 
	// generar una excepcion si la pila es nula 'NullPointerException';
	public abstract void push();
	// Elimina y devuelve el elemento en la parte superior de la pila.
	// Si la pila está vacia genera una excepcion 'EmptyStackException'
	public abstract ELEMENT pop();
	// Devuelve el elemento en la parte superior de la pila sin eliminarlo.
	// Devuelve 'null' si esta vacia
	public abstract ELEMENT peek();
	
	// Verifica si la colección está vacía. -> Devuelve booleano
	public abstract boolean isEmpty();
	// Devuelve el número de elementos en la colección.
	// El tamaño REAL de la pila [1, 2, 3] -> devuelve 3
	public abstract int size();
	
	
	// Elimina todos los elementos de la colección.
	public abstract void clear();
    // Convierte la colección en un arreglo de objetos.
	public abstract void toArray();
}
