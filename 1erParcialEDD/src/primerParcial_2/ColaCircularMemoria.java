package primerParcial_2;

public class ColaCircularMemoria<E> {
    private E[] data;
    private int head;
    private int tail;
    private int size;
    private int count;

    public ColaCircularMemoria(int size) {
        this.size = size; //dado por el usuario
        this.data = (E[]) new Object[size]; //inicializa el array donde se guardara los datos
        this.head = 0; 
        this.tail = 0; 
        this.count = 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }
    
    private int next(int pos) {
        if (++pos >= this.data.length) {
            pos =  0;
        }
        return pos;
    }

    public void enqueue(E item) {
        if (isFull()) {
        	throw new IllegalStateException("Error la cola está llena");
        } 
        this.data[this.tail] = item;
        this.tail=this.next(this.tail);
        count++;
    }
    public E dequeue() {
        if (isEmpty()) {
        	throw new IllegalStateException("Error la cola está vacia");
        } 
        E item = this.data[this.head];
        this.head=this.next(this.head);
        count--;
        return item;
    }
    
    public boolean existeEnCola(E item) {
        if (!isEmpty()) {
            int index = head;
            for (int i = 0; i < count; i++) {
                if (data[index].equals(item)) { // Usar equals para comparar objetos
                    return true;
                }

                if (index == size - 1) {
                    index = 0;
                } else {
                    index++;
                }
            }
        } else {
            throw new IllegalStateException("Queue is empty.");
        }
        return false;
    }
    
    public int size() {
        return this.count;
    }
    
    public boolean offer(E element) {
    	 
        if (this.size() >= this.data.length) {
            return false;
        }
 
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;
 
        return true;
    }
    
    public static <E> ColaCircularMemoria<E> eliminarElemento(ColaCircularMemoria<E> queue, E item) {
        ColaCircularMemoria<E> result = new ColaCircularMemoria<>(queue.size());

        // Copiar elementos de la cola original a la nueva cola
        // excepto aquellos que coincidan con el elemento a eliminar
        int index = queue.head;
        for (int i = 0; i < queue.count; i++) {
            if (!queue.data[index].equals(item)) {
                result.offer(queue.data[index]);
            }
            index = queue.next(index);
        }

        return result;
    }


    public void displayQueue() {
        if (!isEmpty()) {
            int index = head;
            for (int i = 0; i < count; i++) {
                System.out.print(data[index] + " ");
                if (index == size - 1) {////si se cumple significa que hemos llegado al final del arreglo
                    index = 0;// y tenemos qu eempezar desde el principio
                } else {
                    index++;
                }
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty.");
        }
    }
}