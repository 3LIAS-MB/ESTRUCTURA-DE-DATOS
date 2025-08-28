package StackListaEnlazada; // En el TP5 tengo la pila generica

public class Pila {
	private NodoPila head;
	int count;
	
	public Pila() {
		this.head = null;
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
		return head == null;
	}
	
	// Metodo para saber el tamaño de la pìla (size)
	public int size() {
		return count;
	}
	
	// Metodo para apilar (push) un elemento en la Pila
	public int push(int element) {
		NodoPila nuevo = new NodoPila(element);
		nuevo.siguiente = head;
		head = nuevo;
		count++;
		return element;
	}
	
	// Metodo para sacar (pop) un elemento de la pila
	public int pop() {
		if(this.count <= 0) {
			throw new RuntimeException("La pila está vacia");
		}
		int auxiliar = head.dato;
		head = head.siguiente;
		count--;
		return auxiliar;
	}
	
	// Metodo para saber quien está en la  cima de la pila (peek)
	public int peek() {
		if(this.count <= 0) {
			throw new RuntimeException("La pila está vacia");
		}
		return head.dato;
	}
	
	// Metodo para vaciar la pila
	public void clear() {
		while(!empty()) {
			this.pop();
		}
	}
	
    public void mostrarPila() {
        if (empty()) {
            System.out.println("La pila está vacía");
            return;
        }

        NodoPila actual = head;
        StringBuilder sb = new StringBuilder();
        sb.append("Cima -> ");

        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(" -> ");
            }
            actual = actual.siguiente;
        }
        sb.append(" -> Fondo");

        System.out.println(sb.toString());
    }
}
