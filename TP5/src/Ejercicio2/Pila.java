package Ejercicio2;

import java.util.Iterator;

public class Pila<T> {
	private NodoPila<T> cima;
	int count;
	
	public Pila() {
		this.cima = null;
		this.count = 0;
	}
	
	// El sombreado de tipo ocurre cuando se define una clase interna
	// genérica con el mismo nombre de tipo que la clase externa.
	// Se utiliza en este contexto para suprimir una advertencia específica que se
	// relaciona con el sombreado de tipo ("type erasure") en clases genéricas.
	@SuppressWarnings("hiding")
	public class NodoPila<T> {
		T dato;
		NodoPila<T> siguiente;
		
		public NodoPila(T dato) {
			this.dato = dato;
			this.siguiente  = null;
		}
	}
	
	// Metodo para apilar (push) un elemento en la Pila
	public void push(T element) {
		NodoPila<T> nuevo = new NodoPila<T>(element);
		nuevo.siguiente = cima;
		cima = nuevo;
		count++;
	}
	
	// Metodo para sacar (pop) un elemento de la pila
	public T pop() {
		T auxiliar = cima.dato;
		cima = cima.siguiente;
		count--;
		return auxiliar;
	}
	
	// Metodo para saber quien está en la  cima de la pila (peek)
	public T peek() {
		return cima.dato;
	}
	
	// Metodo para saber el tamaño de la pìla (size)
	public int size() {
		return count;
	}
	
	// Metodo para saber cuando la pila está vacia
	public boolean isEmpty() {
		return cima == null;
	}
	
	// Metodo para vaciar la pila
	public void clear() {
		while(!isEmpty()) {
			this.pop();
		}
	}
	
    // Método para convertir los elementos de la pila en un arreglo
    public Object[] toArray() {
        Object[] array = new Object[count];
        NodoPila<T> actual = cima;
        int i = 0;

        while (actual != null) {
            array[i] = actual.dato;
            actual = actual.siguiente;
            i++;
        }

        return array;
    }
    
	// COMO ESTA CLASE IMPLEMENTA LA INTERFAZ 'InterfazQueue' Y ESTA INTERFAZ EXTIENDE DE 'ITERATOR<ELEMENT>'
	// SE TIENE QUE IMPLEMENTAR EL METODO 'ITERATOR()' PARA PODER RECORRER LA LISTA
	
    public Iterator<T> iterator() {			  
        return new SimpleLinkedListIterator(this.cima); 
    }
 
    private class SimpleLinkedListIterator implements Iterator<T> {
        private NodoPila<T> current;
 
        // Constructor
        public SimpleLinkedListIterator(NodoPila<T> current) { // heead por parametro
            this.current = current; // actual	
        }
 
        @Override
        public boolean hasNext() {
            return this.current != null;
        }
 
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new RuntimeException("La lista está vacía...");
            }
            T item = this.current.dato;
            this.current = this.current.siguiente;
            return item;
        }
    }
}
