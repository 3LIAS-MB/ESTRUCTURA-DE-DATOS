package xSimpleDoubleLinkedList;

public class SimpleLinkedList<ELEMENT>  {                                           
		protected Node<ELEMENT> head;									
	    protected Node<ELEMENT> tail;
	    protected int count;
	    
	    //region Constructors
	    public SimpleLinkedList() {
	        this.head = null; // inicio
	        this.tail = null; // fin
	        this.count = 0; // contador

	    }

    // Literalmente esta clase crea el nodo
    private class Node<ELEMENT> {
        public ELEMENT item;
        public Node<ELEMENT> next; 

        public Node() {
            this(null, null);
        }	
        public Node(ELEMENT item) {
            this(item, null);
        }
        public Node(ELEMENT item, Node<ELEMENT> next) { //(item, this.head o null)
            this.item = item; // dato
            this.next = next; // siguiente (referencia)
	        }				  
	        @Override
	        public String toString() {
	            return this.item.toString();
	        }
	    }
    
    public int size() {
        return this.count;
    }
    
	public boolean isEmpty() {
		return head == null;
	}

    public void addFirst(ELEMENT item) {
        Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head); // item, next	
        if (this.isEmpty()) {
            this.tail = temp;
        }
        this.head = temp;
        ++this.count;
    }

    public void addLast(ELEMENT item) {
        Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
        if (this.isEmpty()) {
            this.head = temp;
        } else {
            this.tail.next = temp;
        }						  
        this.tail = temp;	
        ++this.count;
    }
 
    public ELEMENT removeFirst() {
        if (this.count == 0) {
            throw new RuntimeException("La lista está vacía...");
        }
        ELEMENT item = this.head.item;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        --this.count;
        return item;
    }
 
    public ELEMENT removeLast() {
        if (this.count == 0) {
            throw new RuntimeException("La lista está vacía...");
        }
        ELEMENT item = this.tail.item;
        if (this.head.next == null) {
            this.head = this.tail = null;
        } else {
            Node<ELEMENT> skip = this.head; // puntero
            while (skip.next.next != null) {
                skip = skip.next; 
            }
            this.tail = skip;
            this.tail.next = null;
        }
        --this.count;
        return item;
    }
    
    public void mostrar() {
    	for(Node<ELEMENT> skip = this.head; skip != null; skip = skip.next) {
    		System.out.printf("%s ", skip.toString());
    	}
    }
}