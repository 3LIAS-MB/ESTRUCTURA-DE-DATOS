/*package ZPRUEBA;

import java.util.Stack;

public class queueInv<ELEMENT> {
    private ELEMENT[] datos;
    private int tail;
    private int head;
    private int count;
    
    public queueInv() {
    	this.datos = (ELEMENT[]) new Object[3];
    	this.head = this.datos.length -1;
    	this.tail = this.datos.length -1;
    	this.count = 0;
    }
    
    public int next(int pos) {
    	if(--pos < 0) {
    		pos = datos.length - 1;
    	}
    	return pos;
    }
     
    public boolean add(Char item) {
    	if(this.isFull()) {
    		return false;
    	}
    	this.datos[this.head] = item;
    	this.head = this.next(this.head);
    	++this.count;
    	return true;
    }
    
    public boolean isFull() {
    	return this.count >= this.datos.length;
    }
}*/