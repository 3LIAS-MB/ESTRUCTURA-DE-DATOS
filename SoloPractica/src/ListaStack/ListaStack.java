package ListaStack;

public class ListaStack {
	private NodoCola cima;
	private int count;
	
	public ListaStack() {
		this.cima = null;
		this.count = 0;
	}
	
	public class NodoCola {
		private NodoCola siguiente;
		private int dato;
		
		public NodoCola(int dato) {
			this.siguiente = null;
			this.dato = dato;
		}
	}
	
	public boolean empty() {
		return this.count <=  0;
	}
	
	public int size() {
		return this.count;
	}
	
	public int push(int element) {
		NodoCola nuevo = new NodoCola(element);
		nuevo.siguiente = cima;
		cima = nuevo;
		++this.count;
		return element;
	}
	
	public int pop() {
		if(this.empty()) {
			throw new RuntimeException("La pila està vacia");
		} else {
			int aux = cima.dato;
			cima = cima.siguiente;
			--this.count;
			return aux;
		}
	}
	
	public int peek() {
		if(this.empty()) {
			throw new RuntimeException("La pila està vacia");
		} else {
			return cima.dato;
		}
	}
	
}
