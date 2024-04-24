/*La expresión "variable = (variable + 1) % size" se utiliza comúnmente en estructuras
 * de datos como colas y buffers circulares para avanzar un índice en un arreglo y
 * asegurarse de que el índice se mantenga dentro de los límites del arreglo.*/

package ColaCircular;

public class ColaCircularVelocidad {
    private int[] data;
    private int head;
    private int tail;
    private int size; // capacidad

    public ColaCircularVelocidad(int size) {
        this.size = size + 1;
        this.data = new int[this.size];
        this.head = 0;
        this.tail = 0;
    }
    
    private int next(int pos) {
      if (++pos >= this.size) {
          pos = 0;
      }
      return pos;
  }

//    private int next(int pos) {
//        return (pos + 1) % size;
//    }

    public boolean isFull() {
        return next(tail) == head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(int item) { // encolar
        if (!isFull()) {
            tail = next(tail);
            data[tail] = item;
        } else {
            System.out.println("Queue is full. Cannot enqueue.");
        }
    }

    public int dequeue() { // desencolar
        if (!isEmpty()) {
            head = next(head);
	        return data[head];
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Asume que -1 no es un valor válido en la cola.
        }
    }

    public void displayQueue() {
        int index = next(head);
        while (index != next(tail)) {
            System.out.print(data[index] + " ");
            index = next(index);
        }
        System.out.println();
    }
}
