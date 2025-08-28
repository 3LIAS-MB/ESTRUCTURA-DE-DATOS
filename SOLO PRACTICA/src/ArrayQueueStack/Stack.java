package ArrayQueueStack;

import java.util.EmptyStackException;

public class Stack<ELEMENT> {
	private final static Integer defaultDimension = 3;
	private ELEMENT[] data;
	private Integer count;
	
	public Stack() {
		this(Stack.defaultDimension);
	}
	
	public Stack(Integer dimension) {
		if(dimension <= 0) {
			throw new RuntimeException("La longitud debe ser positiva");
		}
		
		this.data = (ELEMENT[]) new Object[dimension];
		this.count = 0;
	}
	
	public int size() {
		return this.count;
	}
	
	public boolean empty() {
		return this.count <= 0;
	}
	
	public ELEMENT push(ELEMENT element) {
		if(this.size() >= this.data.length) {
			//throw new IllegalStateException("La pila está llena");
			
			ELEMENT[] temp = (ELEMENT[]) new Object[this.data.length * 2];
			for(int i = 0; i <= data.length; ++i) {
				temp[i] = this.data[i];
			}
			this.data = temp;
		}
		this.data[this.count] = element;
		++this.count;
		return element;
	}
	
	public ELEMENT pop() {
		if(this.empty()) {
			throw new EmptyStackException();
		}
		--this.count;
		//ELEMENT result = this.data[this.count];
		//this.data[this.count] = null;
		//return result;
		return this.data[this.count];
	}
	
	public ELEMENT peek() {
		if(this.empty()) {
			throw new EmptyStackException();
		}
		return this.data[this.count-1];
	}
	
	public int search(Object element) {
		for(int pos = 0; pos <= this.count-1 ; ++pos) {
			if(this.data[pos].equals(element)) {
				return pos;
			}
		}
		return -1;
	}
	
	public void mostrarStack() { // displayStack
		if(this.empty()) {
			System.out.println("La pila está vacia");
			return;
		}
		for(ELEMENT element : this.data) {
			if(element != null) {
				System.out.println(element.toString() + "-");
			}
		}
	}
}
