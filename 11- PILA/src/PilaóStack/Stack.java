package PilaóStack;

//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//


/*
The Stack class represents a last-in-first-out (LIFO) stack of objects.

The usual push and pop operations are provided, as well as a method to
peek at the top item on the stack, a method to test for whether the
stack is empty, and a method to search the stack for an item and discover
how far it is from the top.

When a stack is first created, it contains no items.

from https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Stack.html
from https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Stack.html
from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Stack.html

*/
public class Stack<ELEMENT> {

 private final static Integer defaulDimension = 3;
 private ELEMENT[] data;
 private Integer count;

 // Llamada al constructor -> sobrecarga de constructores	z
 // 'this' se refiere a la instancia actual de la clase Stack.
 public Stack() {
     this(Stack.defaulDimension);
 }
 
 public Stack(Integer dimension) {
     if (dimension <= 0) {
         throw new RuntimeException("La cantidad de elementos en la pila debe ser positiva");
     }
     /*La limitación principal que impide crear directamente un array genérico
      * en Java se debe a las limitaciones del sistema de tipos de Java y al
      * concepto de "type erasure" (borrado de tipo) en tiempo de ejecución.*/
     this.data = (ELEMENT []) new Object[dimension];
     this.count = 0;
 }
 
 //region Inherited Methods
 
 // from https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Vector.html
 // Returns the number of components in this vector.
 public int size() {
     return this.count;
 }

 // Test if this stack is empty.
 public boolean empty() {
     return this.count <= 0;
 }
 
 //region Stack Methods
 
 // Pushes an item onto the top of this stack.
 public ELEMENT push(ELEMENT element) {
     if (this.size() >= this.data.length) {
         throw new RuntimeException("La pila está llena...");

         /*ELEMENT [] temp = (ELEMENT []) new Object[this.data.length * 2];
         for (int i = 0; i < this.data.length; ++i) {
             temp[i] = this.data[i];
         }
         this.data = temp;*/
     }
     
     this.data[this.count] = element;
     ++this.count;
     return element;
 }
 
 // Removes the object at the top of this stack and returns that object as the value of this function.
 public ELEMENT pop() {
     if (this.empty()) {
         throw new RuntimeException("La pila está vacía...");
     }
//     this.data[this.count-1] = null; -> para borrar el elemento
     
     --this.count;
     return this.data[this.count];
 }

 // Looks at the object at the top of this stack without removing it from the stack.
 public ELEMENT peek() {
     if (this.empty()) {
         throw new RuntimeException("La pila está vacía...");
     }
     return this.data[this.count - 1];
 }


 // Returns the 1-based position where an object is on this stack.
 public int search(Object object) {
     for (int pos = this.count - 1; pos >= 0; --pos) {
         if (this.data[pos].equals(object)) {
             return this.count - pos;
         }
     }
     return -1;
 }
 
 /*public void showStack() {
     if (this.empty()) {
         System.out.println("La pila está vacía.");
         return;
     }

     System.out.println("Contenido de la pila:");

     for (int i = this.count - 1; i >= 0; i--) {
         System.out.println("| " + this.data[i].toString() + " |");
     }

     System.out.println("+-------------+");
 }*/
 
 public void showStack() {
     if (this.empty()) {
         System.out.println("La pila está vacía.");
         return;
     }
     
     for (ELEMENT element : this.data) {
         if (element != null) {
             System.out.print(element.toString() + "-");
         }
     }
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
     sb.append("[" + this.data[0].toString());
     for (int i = 1; i < this.size(); ++i) {
         sb.append(", " + this.data[i].toString());
     }
     sb.append("]");
     return sb.toString();
 }
 //endregion
}