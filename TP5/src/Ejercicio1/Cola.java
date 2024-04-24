package Ejercicio1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cola<ELEMENT> implements InterfazQueue<ELEMENT>{
	NodoCola<ELEMENT> head;
	NodoCola<ELEMENT> tail;
	int count;
	int capacity;
	
	public Cola(int capacidad) {
		this.head = null;
		this.tail = null;
		this.count = 0;
		this.capacity = capacidad;
	}
	
	public class NodoCola<ELEMENT> {	
		ELEMENT dato;
		NodoCola<ELEMENT> siguiente;
		
		public NodoCola(ELEMENT dato) {
			this.dato = dato;
			this.siguiente = null;
		} 
	}
	
	public boolean offer(ELEMENT element) {
		if(this.size() >= capacity) {
			return false;
		} else {
			NodoCola<ELEMENT> nuevo = new NodoCola<ELEMENT>(element);
			if(this.empty()) {
				this.head = nuevo;
			} else {
				tail.siguiente = nuevo;
			}
			tail = nuevo;
			count++;
			return true;
		}
	}
	
	public ELEMENT poll() {
		if(this.size() <= 0) {
			return null;
		} else {
			ELEMENT aux = head.dato;
			head = head.siguiente;
			count--;
			return aux;
		}
	}
	
	public ELEMENT peek() {
		if(this.empty()) {
			return null;
		} else {
			return head.dato;
		}
	}
	
	public boolean add(ELEMENT element) {
		if(this.count >= capacity) {
			// if the element cannot be added at this time due to capacity restrictions
			throw new IllegalStateException("La cola está llena...");
		} else {
			NodoCola<ELEMENT> nuevo = new NodoCola<ELEMENT>(element);
			if(this.empty()) {
				this.head = nuevo;
			} else {
				tail.siguiente = nuevo;
			}
			tail = nuevo;
			count++;
			return true;
		}
	}
	
	public ELEMENT remove() {
		if(this.size() <= 0) {
			// if this queue is empty
			throw new NoSuchElementException("La cola está vacia...");
		} else {
			ELEMENT item = head.dato;
			head = head.siguiente;
			count--;
			return item;
		}
	}
	
	public ELEMENT element() {
		if(this.empty()){
			throw new NoSuchElementException("La cola está vacia...");
		} else {
			return head.dato;
		}
	}
	
	// Metodo para saber si está vacia la cola
	public boolean empty() {
		return head == null;
	}	
	
	// Metodo para saber el tamaño de la cola
	public int size() {
		return count;
	}
	
	public void mostrarImplementacion() {
	    System.out.println("Implementación de la Cola:");
	    System.out.println("Tamaño de la cola: " + size());
	    
	    if (this.empty()) {
	        System.out.println("La cola está vacía.");
	    } else {
	        System.out.println("Elementos en la cola:");
	        NodoCola<ELEMENT> actual = head;
	        
	        while (actual != null) {
	            System.out.println(actual.dato);
	            actual = actual.siguiente;
	        }
	    }
	}
	
    // Método para convertir los elementos de la cola en un arreglo
	public Object[] toArray() {
	    Object[] array = new Object[count];
	    NodoCola<ELEMENT> actual = tail;
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
	
    @Override
    public Iterator<ELEMENT> iterator() {
        return new SimpleLinkedListIterator(this.tail); 
    }
 
    private class SimpleLinkedListIterator implements Iterator<ELEMENT> {
        private NodoCola<ELEMENT> current;
 
        // Constructor
        public SimpleLinkedListIterator(NodoCola<ELEMENT> current) { // head por parametro
	            this.current = current; // actual	
        }
 
        @Override
        public boolean hasNext() {
            return this.current != null;
        }
 
        @Override
        public ELEMENT next() {
            if (!this.hasNext()) {
                throw new RuntimeException("La lista está vacía...");
            }
            ELEMENT item = this.current.dato;
            this.current = this.current.siguiente;
            return item;
        }
    }
}
