package Ejercicio5;

public interface ILinkedList<ELEMENT> extends Iterable<ELEMENT> {
	 public int size();
	 
	    // Inserts the specified element at the beginning of this list.
	    public void addFirst(ELEMENT item);
	    // Appends the specified element to the end of this list.
	    public void addLast(ELEMENT item);
	    // Removes and returns the first element from this list.
	    public ELEMENT removeFirst();
	    // Removes and returns the last element from this list.
	    public ELEMENT removeLast();
	    
	    public void addInOrden(ELEMENT item);
}
