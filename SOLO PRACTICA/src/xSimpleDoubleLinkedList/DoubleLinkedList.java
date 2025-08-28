package xSimpleDoubleLinkedList;

public class DoubleLinkedList<ELEMENT> {
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

 public int size() {
     return this.count;
 }

 public void addFirst(ELEMENT item) {
     Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head, null);
     if (this.size() <= 0) {
         this.tail = temp;
     } else {
         this.head.prev = temp;
     }

     this.head = temp;
     ++this.count;
 }

 public void addLast(ELEMENT item) {
     Node<ELEMENT> temp = new Node<ELEMENT>(item, null, this.tail);
     if (this.size() <= 0) {
         this.head = temp;
     } else {
         this.tail.next = temp;
     }
     this.tail = temp;
     ++this.count;
 }

 public ELEMENT removeFirst() {
     if (this.size() <= 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     ELEMENT item = this.head.item;
     this.head = this.head.next;
     if (this.head == null) {
         this.tail = null;
     } else {
         this.head.prev = null;
     }
     --this.count;
     return item;
 }

 public ELEMENT removeLast() {
     if (this.size() <= 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     ELEMENT item = this.tail.item;
     if (this.head.next == null) {
         this.head = this.tail = null;
     } else {
         this.tail = this.tail.prev;
         this.tail.next = null;
     }
     --this.count;
     return item;
 }
}