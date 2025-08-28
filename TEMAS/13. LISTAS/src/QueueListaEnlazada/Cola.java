package QueueListaEnlazada; // En el TP5 tengo la cola generica

public class Cola {
	//Nodocola inicio, fin;
	NodoCola head;
	NodoCola tail;
	int count;
	
	public Cola() {
		//this.inicio = this.fin = null;
		this.head = null;
		this.tail = null;
		//this.count = 0;
	}
	
	// CLASE
	public class NodoCola {
		int dato;
		NodoCola siguiente;
		
		public NodoCola(int dato) {
			this.dato = dato;
			this.siguiente = null;
		}
	}
	
	// Metodo para saber si está vacia la cola
	public boolean isEmpty() {
		return this.count <= 0; // head == null;
	}
	
	// Metodo para insertar al final de la cola
	public void offer(int element) {
		NodoCola nuevo = new NodoCola(element);
		if(isEmpty()) {
			this.head = nuevo;
		} else {
			tail.siguiente = nuevo;
		}
		tail = nuevo;
		count++;
	}
	
	// Eliminar un elemento de la cola
	public int poll() {
		int aux = head.dato;
		head = head.siguiente;
		count--;
		return aux;
	}
	
	// Metodo para saber quien  está al inicio de la  cola
	public int peek() {
		return head.dato;
	}
	
	// Metodo para saber el tamaño de la cola
	public int size() {
		return count;
	}
}
