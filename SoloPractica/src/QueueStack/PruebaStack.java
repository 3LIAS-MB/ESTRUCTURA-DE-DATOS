package QueueStack;

public class PruebaStack<ELEMENT> {
	private static final Integer defaultDimension = 2;
	private ELEMENT data[];
	private Integer count;
	
	public PruebaStack() {
		this(PruebaStack.defaultDimension);
	}
	
	public PruebaStack(Integer dimension) {
		if(dimension <= 0) {
	         throw new RuntimeException("La cantidad de elementos en la  pila debe ser positiva");
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
			throw new RuntimeException("La pila está llena");
		}

		this.data[this.count] = element;
		++this.count;
		return element;
	}
	
	public ELEMENT pop() {
		if(this.empty()) {
	         throw new RuntimeException("La pila está vacia");
		}
		--this.count;
		return this.data[count];
	}
	
	public ELEMENT peek() {
		if(this.empty()) {
	         throw new RuntimeException("La pila está vacia");
		}
		return this.data[this.count-1];
	}
	
	public int search(Object element) {
		for(int pos=this.count-1; pos >= 0; pos--) {
			if(this.data[pos].equals(element)) {
				return this.count - pos;
			}
		}
		return -1;
	}
	
	public void mostrarStacl() { // displayStack
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
