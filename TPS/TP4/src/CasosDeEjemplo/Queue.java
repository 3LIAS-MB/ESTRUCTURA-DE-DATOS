package CasosDeEjemplo;

//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

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


import java.util.Arrays;

public class Queue<ELEMENT> {

 //region Constants

 private final static Integer defaulDimension = 10;

 //endregion

 //region Attributes

 private ELEMENT [] data;
 private int head;
 private int tail;
 private int count;

 //endregion

 //region Constructors

 public Queue() {
     this(Queue.defaulDimension);
 }
 public Queue(int dimension) {
     this.data = (ELEMENT[]) new Object[dimension];
     this.head = 0;
     this.tail = 0;
     this.count = 0;
 }
 //endregion

 //region Queue Internal Methods
 private int next(int pos) {
     if (++pos >= this.data.length) {
         pos = 0;
     }
     return pos;
 }
 //endregion


 //region Queue Methods

 // Operacion EnQueue en la teoría de Estructura de Datos
 //
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

 // Operacion peek en la teoría de Estructura de Datos
 //
 // Retrieves, but does not remove, the head of this queue. This method differs
 // from peek only in that it throws an exception if this queue is empty.
 public ELEMENT element() {

     if (this.size() <= 0) {
         throw new IllegalStateException("Cola vacía ...");
     }

     return this.data[this.head];
 }

 // Operacion EnQueue en la teoría de Estructura de Datos
 //
 // Inserts the specified element into this queue if it is possible to do so
 // immediately without violating capacity restrictions. When using a
 // capacity-restricted queue, this method is generally preferable to add(E),
 // which can fail to insert an element only by throwing an exception.
 public boolean offer(ELEMENT element) {

     if (this.size() >= this.data.length) {
         return false;
     }

     this.data[this.tail] = element;
     this.tail = this.next(this.tail);
     ++this.count;

     return true;
 }

 // Retrieves, but does not remove, the head of this queue, or returns null if
 // this queue is empty.
 public ELEMENT peek() {
     if (this.size() <= 0) {
         return null;
     }

     return this.data[this.head];
 }

 // Operacion DeQueue en la teoría de Estructura de Datos
 //
 // Retrieves and removes the head of this queue, or returns null if this queue
 // is empty.
 public ELEMENT pool() {
     if (this.size() <= 0) {
         return null;
     }

     ELEMENT result = this.data[this.head];
     this.head = this.next(this.head);
     --this.count;

     return result;
 }

 // Operacion DeQueue en la teoría de Estructura de Datos
 //
 // Retrieves and removes the head of this queue. This method differs from poll()
 // only in that it throws an exception if this queue is empty.
 public ELEMENT remove() {
     if (this.size() <= 0) {
         throw new IllegalStateException("Cola vacía ...");
     }

     ELEMENT result = this.data[this.head];
     this.head = this.next(this.head);
     --this.count;

     return result;
 }
 //endregion


 //region Override Object basic methods

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
 //endregion


 //region Collection Methods

 public boolean isEmpty() {
     return this.count <= 0;
 }

 public int size() {
     return this.count;
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

 public static Queue<Object> union(Queue<?> stack1, Queue<?> stack2) {

     Queue<Object> result = new Queue<Object>(stack1.size() + stack2.size());

     for(int pos = stack1.head, cta = stack1.size(); cta > 0; pos = stack1.next(pos), --cta) {
         result.offer( stack1.data[pos] );
     }
     for(int pos = stack2.head, cta = stack2.size(); cta > 0; pos = stack2.next(pos), --cta) {
         result.offer( stack2.data[pos] );
     }

     return result;
 }

 public Queue<Object> union(Queue<?> stack2) {
     return Queue.union(this, stack2);
 }
 //endregion

}
