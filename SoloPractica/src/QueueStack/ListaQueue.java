package QueueStack;

public class ListaQueue<ELEMENT> {
	//private static final Integer defaultDimension = 3;
	private NodoCola<ELEMENT> head;
	private NodoCola<ELEMENT> tail;
	private int count;
	private int capacity;
	
	public class NodoCola<ELEMENT> {
		private NodoCola<ELEMENT> siguiente;
		private ELEMENT dato;
		
		public NodoCola(ELEMENT element) {
			this.siguiente = null;
			this.dato = element;
		}
	}
	
	public ListaQueue(int capacity) {
		this.head = null;
		this.tail = null;
		this.count = 0;
		this.capacity = capacity;
	}
	
	public int size() {
		return this.count;
	}
	
	public boolean empty() {
		return this.count <= 0;
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
			this.tail = nuevo; 
			++this.count;
			return true;
		}
	}
	
	public ELEMENT poll() {
		if(this.size() <= 0) {
			return null;
		} else {
			ELEMENT result = this.head.dato;
			this.head = head.siguiente;
			++this.count;
			return result;
		}
	}

	public ELEMENT peek() {
		if(this.empty()) {
			return null;
		} else {
			return this.head.dato;
		}
	}
	
}
