package primerParcial_1;
public class Stack<ELEMENT> {
	 //PUNTO 1
    //region Constants
    private final static Integer defaulDimension = 10;
 
    //region Attributes
    private ELEMENT [] data;
    private Integer count;
    private int cima; //índice cima de la pila
 
    //region Constructors
    public Stack() {
        this(Stack.defaulDimension);
    }
    public Stack(Integer dimension) {
        if (dimension <= 0) {
            throw new RuntimeException("La cantidad de elementos en la  pila debe ser positiva");
        }
        this.data = (ELEMENT []) new Object[dimension];
        this.cima = data.length - 1;
        this.count = 0;
    }
 
    public boolean empty() {
        return this.count <= 0;
    }
    
    /*----------------------------------------*/
    public ELEMENT peek() {
        if (this.empty()) {
            throw new RuntimeException("La pila está vacía...");
        }
        return this.data[cima];
    }
    
    public void push(ELEMENT elemento) {
        if (count >= defaulDimension) {
            throw new IllegalStateException("La pila está llena...");
        }
	    data[cima] = elemento;
	    --cima;
	    count++;
    }
    
    public boolean isFull() {
    	return this.size() >= this.data.length;
    }
    /*----------------------------------------*/

    public int size() {
        return this.count;
    }
 
}