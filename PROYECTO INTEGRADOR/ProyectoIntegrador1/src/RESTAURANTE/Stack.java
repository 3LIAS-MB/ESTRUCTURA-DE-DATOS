package RESTAURANTE;

public class Stack<ELEMENT> {

//region Constants
	private final static Integer defaulDimension = 10;
//region Attributes
	private ELEMENT[] data;
	private Integer count;

//region Constructors

	public Stack() {
		this(Stack.defaulDimension);
	}

	public Stack(Integer dimension) {
		if (dimension <= 0) {
			throw new RuntimeException("La cantidad de elementos en la  pila debe ser positiva");
		}
		this.data = (ELEMENT[]) new Object[dimension];
		this.count = 0;
	}

	public boolean isEmpty() {
		return this.count <= 0;
	}

	public ELEMENT peek() {
		if (this.isEmpty()) {
			return null;
		}
		return this.data[this.count - 1];
	}

	public ELEMENT pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("La pila está vacía...");
		}
		--this.count;
		return this.data[this.count];
	}

	public ELEMENT push(ELEMENT element) {
		if (this.size() >= this.data.length) {

			ELEMENT[] temp = (ELEMENT[]) new Object[this.data.length * 2];
			for (int i = 0; i < this.data.length; ++i) {
				temp[i] = this.data[i];
			}
			this.data = temp;
		}
		this.data[this.count] = element;
		++this.count;
		return element;
	}

	public int search(Object object) {
		for (int pos = this.count - 1; pos >= 0; --pos) {
			if (this.data[pos].equals(object)) {
				return this.count - pos;
			}
		}
		return -1;
	}

	public int size() {
		return this.count;
	}

	@Override
	public String toString() {

		if (this.size() <= 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[" + this.data[0].toString());
		for (int i = 1; i < this.size(); ++i) {
			sb.append(", " + this.data[i].toString());
		}
		sb.append("]");
		return sb.toString();
	}
}