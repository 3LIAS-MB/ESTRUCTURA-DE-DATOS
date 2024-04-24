package QueueStack;

import java.util.NoSuchElementException;

public class PruebaQueue<ELEMENT> {
	private static final Integer defaultDimension = 3;
	private ELEMENT data[];
	private int head;
	private int tail;
	private int count;
	
	public PruebaQueue() {
		this(PruebaQueue.defaultDimension);
	}
	
	public PruebaQueue(Integer dimension) {
		if(dimension <= 0) {
			throw new RuntimeException("La dimension de la pila debe ser positiva");
		}
		this.data = (ELEMENT[]) new Object[dimension];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
	}
	
	public int next(int pos) {
		if(++pos >= data.length) {
			pos = 0;
		}
		return pos;
	}
	
	public int size() {
		return this.count;
	}
	
	public boolean empty() {
		return this.count <= 0;
	}
	
	public boolean offer(ELEMENT element) {
		if(this.size() >= data.length) {	
			return false;
		}
		this.data[tail] = element;
		this.tail = this.next(this.tail);
		++this.count;
		return true;
	}
	
	public ELEMENT poll() {
		if(this.empty()) {
			return null;
		}
		ELEMENT result = this.data[this.head];
		this.head = this.next(this.head);
		--this.count;
		return result;
	}
	
	public ELEMENT peek() {
		if(this.empty()) {
			return null;
		}
		return this.data[this.head];
	}
	
	/*-------------*/
	
	public boolean add(ELEMENT element) {
		if(this.size() >= this.data.length) {
			throw new IllegalStateException("La cola está llena");
		}
		this.data[this.tail] = element;	
		this.tail = this.next(this.tail);
		++this.count;
		return true;	
	}
	
	public ELEMENT remove() {
		if(this.empty()) {
			throw new NoSuchElementException("La cola está vacia");
		}
		ELEMENT result = this.data[this.head];
		this.head = this.next(this.head);
		--this.count;
		return result;
	}
	
	public ELEMENT element() {
		if(this.empty()) {
			throw new NoSuchElementException("La cola está vaciad");
		}
		return this.data[this.head];
	}
	
	/*public void displayQueuee() {
	    if (empty()) {
	        System.out.println("La cola está vacía.");
	        return;
	    }

	    int current = head;
	    System.out.print("Cola: ");
	    for (int i = 0; i < count; i++) {
	        System.out.print(data[current] + " ");
	        current = next(current);
	    }
	    System.out.println();
	}*/
	
}

