	package TentorDoubleLinkedList;

//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

import java.util.Iterator;

public class DoubleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {
	 private Node<ELEMENT> head;
	 private Node<ELEMENT> tail;
	 private int count;
	 
	 public DoubleLinkedList() {
	     this.head = null;
	     this.tail = null;
	     this.count = 0;
	 }

 protected class Node<ELEMENT> {
     protected ELEMENT item;
     protected Node<ELEMENT> next;
     protected Node<ELEMENT> prev;

     protected Node() {
         this(null, null, null);
     }
     protected Node(ELEMENT item) {
         this(item, null, null);
     }
     protected Node(ELEMENT item, Node<ELEMENT> next) {
         this(item, next, null);
     }				    // item				// head				// null
     protected Node(ELEMENT item, Node<ELEMENT> next, Node<ELEMENT> prev) {
         this.item = item;
         this.next = next;
         this.prev = prev;
     }

     @Override
     public String toString() {
         return this.item.toString();
     }
 }

 //region Linked List Methods

 // Returns the number of elements in this list.
 public int size() {
     return this.count;
 }
/*
 public void addFirstRookieVersion(ELEMENT item) {
     if (this.size() <= 0) {
         this.head = this.tail = new Node<ELEMENT>(item, null, null);
         ++this.count;
     }
     else {
         Node<ELEMENT> temp = new Node<ELEMENT>(item, null, null);
         temp.next = this.head;
         this.head.prev = temp;
         this.head = temp;
         ++this.count;
     }
 }*/
 
 // Inserts the specified element at the beginning of this list.
 public void addFirst(ELEMENT item) {
	 // Se crea un nodo
     Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head, null);
     // Si está vacia
     if (this.size() <= 0) {
    	 // Si la lista está vacia 'tail' apunta al nuevo nodo
         this.tail = temp;
     } else {
    	 // Si no, el anterior del primer nodo apunta al nuevo nodo
    	 // pasando este pasa a ser el segundo de la lista
         this.head.prev = temp;
     }
     // la cabecera (head) siempre apuntará al nuevo nodo,
     // en este caso, temp por ser el recien creado
     this.head = temp;
     ++this.count;
 }

 /*public void addLastRookieVersion(ELEMENT item) {
     if (this.size() <= 0) {
         this.head = this.tail = new Node<ELEMENT>(item, null, null);
         ++this.count;
     }
     else {
         Node<ELEMENT> temp = new Node<ELEMENT>(item, null, null);
         temp.prev = this.tail;
         this.tail.next = temp;
         this.tail = temp;
         ++this.count;
     }
 }*/
 
 // Appends the specified element to the end of this list.
 public void addLast(ELEMENT item) {
	 // Crea un nuevo nodo
     Node<ELEMENT> temp = new Node<ELEMENT>(item, null, this.tail);
     // Si la  lista está vacia 
     if (this.size() <= 0) {
    	 // Si está vacia 'head' apunta al nuevo nodo'
         this.head = temp;
     }
     else {
    	 // Si no, 'siguiente' del ultimo nodo apunta a 'temp',
    	 // convirtiendo a 'temp' en el ultimo nodo de la lista
         this.tail.next = temp;
     }
     // Apuntamos 'tail' al ultimo elemento que seria 'temp'
     // Recordar que 'temp' es un auxiliar temporal
     this.tail = temp;
     ++this.count;
 }

 // Removes and returns the first element from this list.
 public ELEMENT removeFirst() {
     if (this.size() <= 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     // Almacenamos el dato del 1er nodo en la variable 'item'
     ELEMENT item = this.head.item;
     // Hacemos que 'head' apunte a su siguiente
     this.head = this.head.next;
     // Si 'head' es null es porque no quedan más nodos,
     // y por lo tanto, se limpia la referencia de 'tail'
     if (this.head == null) {
         this.tail = null;
     }
     else {
    	 // El anterior de 'head' siempre será null
    	 // cuando removemos el primer nodo de la lista
         this.head.prev = null;
     }
     // Se disminuye el contador
     --this.count;
     return item;
 }

 // Removes and returns the last element from this list.
 public ELEMENT removeLast() {
	 // Si la lista está vacia se lanza una exception
     if (this.size() <= 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     // Se guarda el dato del ultimo elemento en 'item'
     ELEMENT item = this.tail.item;
     // Si el siguiente del 1er elemento es 'null'
     // significa que  es el unico elemento
     if (this.head.next == null) {
    	 // Por lo tanto se asigna 'null a head y tail
         this.head = this.tail = null;
     } else {
    	 // Si no, el anterior al ultimo elemento se le asigna
    	 // a 'tail' eliminando el ultimo automaticamente
         this.tail = this.tail.prev;
         // Y al siguiente de este se le asigna 'null'
         // porque el ultimo elemento siempre apunta a 'null'
         this.tail.next = null;
     }
     // Se disminuye el contador y se retorna el elemento
     --this.count;
     return item;
 }
 //endregion

 
 
 /*public void addInOrder(ELEMENT item) {
	 if(this.count == 0) {
		 // Se crea un nuevo nodo con el elemento a agregar
		 // el ultimo nodo es el primero y el ultimo
		 this.head = this.tail = new Node<ELEMENT>(item, null, null);
		 ++this.count;
	 } else {
		 if(item.compareTo(this.head.item) <=0) {
			 // Es menor o igual que el primero
			 this.addFirst(item);
		 } else {
			 if(item.comprateTo(this.tail.item) > 0) {
				 // Es mayor que el ultimo
				 this.addLast(item);
			 } else {
				 Node skip = this.head;
				 for( ; (skip != null) && (item.compareTo(skip.item) > 0); skip = skip.next) { }
				 // skip es null o el nodo cuyo valor es más grande que el item
				 if(skip == null) {
					 // esto deberia ocurrir por las dudas hacemos programacion defensiva
					 throw new RuntimeException("Algo está mal en el orden de los elementos de la lista");
				 } else {
					 // se debe insertar antes de skip
					 Node<ELEMENT> temp = new Node<ELEMENT>(item, skip, skip.prev);
					 skip.prev.next = temp;
					 skip.prev = temp;
					 ++this.count;
				 }
			 }
		 }
	 }
 }*/
 
 //region Object Methods

 @Override
 public String toString() {

     if (this.size() <= 0) {
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
 }
 //endregion

 //region Iterable Methods
 @Override
 public Iterator<ELEMENT> iterator() {
     return new DoubleLinkedListIterator(this.head);
 }

 public class DoubleLinkedListIterator implements Iterator<ELEMENT> {
     private Node<ELEMENT> current;

     public DoubleLinkedListIterator(Node<ELEMENT> current) {
         this.current = current;
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

 public Iterator<ELEMENT> iteratorBack() {
     return new DoubleLinkedListIteratorBack(this.tail);
 }

 public class DoubleLinkedListIteratorBack implements Iterator<ELEMENT> {
     private Node<ELEMENT> current;

     public DoubleLinkedListIteratorBack(Node<ELEMENT> current) {
         this.current = current;
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
         this.current = this.current.prev;
         return item;
     }

 }
}
