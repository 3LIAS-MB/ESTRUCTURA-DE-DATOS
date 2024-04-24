package ColaóQueue;

import java.util.NoSuchElementException;
//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>//

/*
public interface Queue<E>
extends Collection<E>

A collection designed for holding elements prior to processing.
Besides basic Collection operations, queues provide additional insertion,
extraction, and inspection operations. Each of these methods exists in
two forms: one throws an exception if the operation fails, the other
returns a special value (either null or false, depending on the operation).

The latter form of the insert operation is designed specifically for use
with capacity-restricted Queue implementations; in most implementations,
insert operations cannot fail.

Queues typically, but do not necessarily, order elements in a FIFO
(first-in-first-out) manner. Among the exceptions are priority queues,
which order elements according to a supplied comparator, or the elements'
natural ordering, and LIFO queues (or stacks) which order the elements
LIFO (last-in-first-out). Whatever the ordering used, the head of the
queue is that element which would be removed by a call to remove() or
poll(). In a FIFO queue, all new elements are inserted at the tail of
the queue. Other kinds of queues may use different placement rules.
Every Queue implementation must specify its ordering properties.

The offer method inserts an element if possible, otherwise returning
false. This differs from the Collection.add method, which can fail to
add an element only by throwing an unchecked exception. The offer
method is designed for use when failure is a normal, rather than
exceptional occurrence, for example, in fixed-capacity (or "bounded")
queues.

The remove() and poll() methods remove and return the head of the queue.
Exactly which element is removed from the queue is a function of the
queue's ordering policy, which differs from implementation to
implementation. The remove() and poll() methods differ only in their
behavior when the queue is empty: the remove() method throws an
exception, while the poll() method returns null.

The element() and peek() methods return, but do not remove, the head
of the queue.

The Queue interface does not define the blocking queue methods, which
are common in concurrent programming. These methods, which wait for
elements to appear or for space to become available, are defined in
the BlockingQueue interface, which extends this interface.

Queue implementations generally do not allow insertion of null elements,
although some implementations, such as LinkedList, do not prohibit
insertion of null. Even in the implementations that permit it, null
should not be inserted into a Queue, as null is also used as a special
return value by the poll method to indicate that the queue contains no
elements.

Queue implementations generally do not define element-based versions of
methods equals and hashCode but instead inherit the identity based
versions from class Object, because element-based equality is not
always well-defined for queues with the same elements but different
ordering properties.

This interface is a member of the Java Collections Framework.



from https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Queue.html
from https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Queue.html
from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Queue.html

*/


public class Queue<ELEMENT> {

 //region Constants
 private final static Integer defaulDimension = 3;	 // Me dice cual es el tamaño del vector
 //region Attributes
 private ELEMENT [] data; // Es un vector o array de enteros
 private int head; // Apunta a la posicion del valor que va a salir
 private int tail; // Apunta a la posicion donde se va a insetar un elemento
 private int count; // Me dice cuantos elementos tiene la cola

 //region Constructors

 public Queue() {
     this(Queue.defaulDimension);
 }
 
 public Queue(Integer dimension) {
	if(dimension <= 0) {
		throw new RuntimeException("La dimension de la cola debe ser positiva");
	}
     this.data = (ELEMENT[]) new Object[dimension];
     this.head = 0;
     this.tail = 0;
     this.count = 0;
 }
 
 //Se utiliza para calcular el índice del siguiente elemento en la cola circular
 private int next(int pos) { // posición actual en el arreglo
	 //++pos;
     if (++pos >= this.data.length) {
         pos = 0;
     }
     return pos;
 }
 
 public boolean empty() {
     return this.count <= 0;
 }

 public int size() {
     return this.count;	
 }
 
 // Inserts the specified element into this queue if it is possible to do so
 // immediately without violating capacity restrictions. When using a
 // capacity-restricted queue, this method is generally preferable to add(E),
 // which can fail to insert an element only by throwing an exception.
 public boolean offer(ELEMENT element) { // mejor que add

     if (this.size() >= this.data.length) {
         return false;
     }

     this.data[this.tail] = element;
     //this.tail = (this.tail + 1) % this.data.length;
     this.tail = this.next(this.tail);
     //++this.tail;
     ++this.count;		

     return true;
 }
 
 // Retrieves and removes the head of this queue, or returns null if this queue is empty.
 public ELEMENT poll() {
     if (this.size() <= 0) {
         return null;
     }

     ELEMENT result = this.data[this.head];
     this.head = this.next(this.head);
     //++this.head;
     --this.count;

     return result;
 }
 
 // Retrieves, but does not remove, the head of this queue, or returns null if
 // this queue is empty.
 public ELEMENT peek() {
     if (this.empty()) {
         return null;
     }
     return this.data[this.head]; // devuelve el elemento en laparte frontal sin, eliminarlo
     							  // devuelve true si lo elimino y null si no
 }
 
 // Inserts the specified element into this queue if it is possible to do so
 // immediately without violating capacity restrictions, returning true upon
 // success and throwing an IllegalStateException if no space is currently
 // available.
 public boolean add(ELEMENT element) {

     if (this.size() >= this.data.length) {
         throw new IllegalStateException("Cola llena ...");
     }

     this.data[this.tail] = element;
     this.tail = this.next(this.tail);
     ++this.count;

     return true;
 }
 
 // Retrieves and removes the head of this queue. This method differs from poll()
 // only in that it throws an exception if this queue is empty.
 
 public ELEMENT remove() {
     if (this.size() <= 0) {
         throw new NoSuchElementException("Cola vacía ...");
     }

     ELEMENT result = this.data[this.head];
     this.head = this.next(this.head);
     --this.count;

     return result;
 }

 // Retrieves, but does not remove, the head of this queue. This method differs
 // from peek only in that it throws an exception if this queue is empty.
 public ELEMENT element() {

     if (this.size() <= 0) {
         throw new NoSuchElementException("Cola vacía ...");
     }

     return this.data[this.head];
 }
 
 public void displayQueue() {
	    if (empty()) {
	        System.out.println("La cola está vacía.");
	        return;
	    }

	    int current = head;
	    for (int i = 0; i < count; i++) {
	        System.out.print(data[current] + " ");
	        current = next(current);
	    }
	    System.out.println();
	}
 
 @Override
 public String toString() {

     if (this.size() <=0) {
         return "";
     }

     // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
     StringBuilder sb = new StringBuilder();
     sb.append("[" + this.data[this.head].toString());

     for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
         sb.append(", " + this.data[pos].toString());
     }

     sb.append("]");
     return sb.toString();
 }

 public Object[] toArray() {
     Object[] result = new Object[this.count];
     for(int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
         result[i] = this.data[pos];
     }
     return result;
 }
 //endregion


 //region Caso Ejemplo b) Methods
 
 // Toma dos colas (stack1 y stack2) y devuelve una nueva cola que contiene todos los elementos de ambas colas.
 public static Queue<Object> union(Queue<?> queue1, Queue<?> queue2) {

     Queue<Object> result = new Queue<Object>(queue1.size() + queue2.size());

     for(int pos = queue1.head, cantElement = queue1.size(); cantElement > 0; pos = queue1.next(pos), --cantElement) {
         result.offer(queue1.data[pos]);
     }
     for(int pos = queue2.head, cantElement = queue2.size(); cantElement > 0; pos = queue2.next(pos), --cantElement) {
         result.offer(queue2.data[pos]);
     }
     return result;
 }

 public Queue<Object> union(Queue<?> queue2) {
     return Queue.union(this, queue2);
 }
}