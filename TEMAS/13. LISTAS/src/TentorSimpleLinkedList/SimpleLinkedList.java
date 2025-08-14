 package TentorSimpleLinkedList;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
 
import java.util.Iterator;
import TentorDoubleLinkedList.ILinkedList;

public class SimpleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> { // Las clases genéricas en Java son flexibles y pueden                                                                
		protected Node<ELEMENT> head;									 // recibir tanto tipos de datos primitivos como objetos	
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
        //  Inicializa tanto el elemento como la referencia al siguiente nodo como nulos
        //  No se usa con frecuencia, pero es útil para crear un nodo vacío o inicializar una lista vacía.
        public Node() {
            this(null, null);
        }	
        // Inicializa el elemento con el valor proporcionado y la referencia al siguiente nodo como nula. En general no se va a usar
        // Puede utilizarse cuando se crea un nodo con un elemento específico
        // pero no se establece una referencia al siguiente nodo en ese momento.
        public Node(ELEMENT item) {
            this(item, null);
        }
        // inicializa tanto el elemento como la referencia al siguiente nodo con los valores proporcionados.
        // Este constructor se utiliza cuando se crea un nodo y se establece tanto 
        // el elemento como la referencia al siguiente nodo en una sola llamada.
        public Node(ELEMENT item, Node<ELEMENT> next) { //(item, this.head o null)
            this.item = item; // dato
            this.next = next; // siguiente (referencia)
	        }				  
	 
	        @Override
	        public String toString() {
	            return this.item.toString();
	        }
	    }
    
    // Returns the number of elements in this list.
    public int size() {
        return this.count;
    }
    
	/*public boolean isEmpty() {
		if(head == null) {
			return true; 
		} else {
			return false;
		}
	}*/
	
    // Método más conciso
	public boolean isEmpty() {
		return head == null;
	}
	
   /* public void addFirstRookieVersion(ELEMENT item) {
        if (this.count == 0) {
            this.head = this.tail = new Node<ELEMENT>(item, null);
            ++this.count;
        } else {
            Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
            temp.next = this.head;
            this.head = temp;
            ++this.count;
        }
    }*/
	
    // Inserts the specified element at the beginning of this list.
    public void addFirst(ELEMENT item) { 
    	// Esto declara una objeto llamado temp que almacena un nodo. El tipo genérico <ELEMENT> indica que 
    	// este nodo puede contener un tipo de elemento genérico, como se define en la clase SimpleLinkedList.
        Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head); // item, next	
        
        if (this.count == 0) {
            this.tail = temp;
        }
        this.head = temp;
        ++this.count;
    }
 
    /*public void addLastRookieVersion(ELEMENT item) {	
        if (this.count == 0) {
            this.head = this.tail = new Node<ELEMENT>(item, null);
            ++this.count;
        } else {
            Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
            this.tail.next = temp;
            this.tail = temp;
            ++this.count;
        }
    }*/
    
    // Appends the specified element to the end of this list.
    // Para agregar al ultimo más nada se trabaja con 'tail'
    public void addLast(ELEMENT item) {
    	// Crea un nuevo nodo
        Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
        if (this.count == 0) {
        	// Si no hay nodos 'head' apunta "temp" para ser el primero
            this.head = temp;
        } else {
            this.tail.next = temp; // Aquí 'next' de tail apunta al ultimo elemento y por ende, en head 
        }						   // tambien se añade este elemento porque apuntan al mismo nodo
         
        this.tail = temp;	// -> Aquí asignamos temp a tail para que apunte al ultimo elemento de la lista
        ++this.count;
    }
 
    // Removes and returns the first element from this list.
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
 
    // Removes and returns the last element from this list.
    public ELEMENT removeLast() {
        if (this.count == 0) {
            throw new RuntimeException("La lista está vacía...");
        }
        ELEMENT item = this.tail.item;
        // Caso especial: Si la lista tiene solo un elemento.
        if (this.head.next == null) {
            this.head = this.tail = null;
        } else {
            // Si hay más de un elemento en la lista, recorremos la lista
            // para encontrar el nodo anterior al último nodo (nodo cola).
            Node<ELEMENT> skip = this.head;
            while (skip.next.next != null) {
            	// -> Encuenta el penultimo
                skip = skip.next; 
            }
            // Establecemos la cola (tail) como el nodo anterior,
            // Hacemos que tail apunte al penultimo elemento, o sea, 'skip'
            // y asi eliminamos la referencia al último nodo
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
    //endregion
    
    //region Object Methods
	 
	    /*@Override	
	    public String toString() {
	 
	        if (this.size() <=0) {
	            return "";
	        }
	 
	        // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
	        StringBuilder sb = new StringBuilder();
	 
	        sb.append("[" + this.head.item.toString());
	        for (Node<ELEMENT> skip = this.head.next; skip != null; skip = skip.next) {
	            sb.append(", " + skip.item.toString());
	        }
	        sb.append("]");
	 
	        return sb.toString();
	    }*/
	    //endregion
	 
 
    //region Iterable Methods -> lo necesitamos para ejecutar el programa
	//   				      -> Cuando una clase implementa una interfaz que extiende la interfaz
	//    					  -> Iterable, debe proporcionar una implementación del método iterator()
    @Override
    public Iterator<ELEMENT> iterator() { 				// COMO ESTA CLASE (SimpleLinkedList) IMPLEMENTA LA INTERFAZ 'ILinkedList' Y ESTA INTEFRAZ EXTIENDE DE 
        return new SimpleLinkedListIterator(this.head); // 'ITERATOR<ELEMENT>' SE PUEDE USAR EL METODO 'ITERATOR()' PARA PODER RECORRER LA LISTA
    }
 
    private class SimpleLinkedListIterator implements Iterator<ELEMENT> {
        private Node<ELEMENT> current;
 
        // Constructor
        public SimpleLinkedListIterator(Node<ELEMENT> current) {
            this.current = current; // actual	
        }
 
        @Override
        public boolean hasNext() {
            return this.current != null;
        }
 
        @Override
        public ELEMENT next() {
            if (!this.hasNext()) {
                throw new RuntimeException("La lista está vacía...");
            }
            ELEMENT item = this.current.item;
            this.current = this.current.next;
            return item;
        }
 
    }
}