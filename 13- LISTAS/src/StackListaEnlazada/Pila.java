package StackListaEnlazada; // En el TP5 tengo la pila generica

public class Pila {
	private NodoPila cima;
	int count;
	
	public Pila() {
		this.cima = null;
		this.count = 0;
	}
	
	// CLASE
	public class NodoPila {
		NodoPila siguiente;
		int dato;
		
		public NodoPila(int dato) {
			this.siguiente  = null;
			this.dato = dato;
		}
	}
	
	// Metodo para saber cuando la pila está vacia
	public boolean empty() {
		return cima == null;
	}
	
	// Metodo para saber el tamaño de la pìla (size)
	public int size() {
		return count;
	}
	
	// Metodo para apilar (push) un elemento en la Pila
	public int push(int element) {
		NodoPila nuevo = new NodoPila(element);
		nuevo.siguiente = cima;
		cima = nuevo;
		count++;
		return element;
	}
	
	// Metodo para sacar (pop) un elemento de la pila
	public int pop() {
		if(this.count <= 0) {
			throw new RuntimeException("La pila está vacia");
		}
		int auxiliar = cima.dato;
		cima = cima.siguiente;
		count--;
		return auxiliar;
	}
	
	// Metodo para saber quien está en la  cima de la pila (peek)
	public int peek() {
		if(this.count <= 0) {
			throw new RuntimeException("La pila está vacia");
		}
		return cima.dato;
	}
	
	// Metodo para vaciar la pila
	public void clear() {
		while(!empty()) {
			this.pop();
		}
	}
}
