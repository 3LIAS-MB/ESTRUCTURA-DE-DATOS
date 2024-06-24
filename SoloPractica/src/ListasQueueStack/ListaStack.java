package ListasQueueStack;

public class ListaStack<ELEMENT> {
	private NodoCola<ELEMENT> cima; // head
	private int count;
	
	public ListaStack() {
		this.cima = null;
		this.count = 0;
	}
	
	public class NodoCola<ELEMENT> {
		private NodoCola<ELEMENT> siguiente;
		private ELEMENT dato;
		
		public NodoCola(ELEMENT dato) {
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
	
	public void push(ELEMENT element) {
		NodoCola<ELEMENT> nuevo = new NodoCola<ELEMENT>(element);
		nuevo.siguiente = cima;
		cima = nuevo;
		++this.count;
	}
	
	public ELEMENT pop() {
		if(this.empty()) {
			throw new RuntimeException("La pila està vacia");
		} else {
			ELEMENT aux = cima.dato;
			cima = cima.siguiente;
			--this.count;
			return aux;
		}
	}
	
	public ELEMENT peek() {
		if(this.empty()) {
			throw new RuntimeException("La pila està vacia");
		} else {
			return cima.dato;
		}
	}
	
}
