package EJERCICIO_PRUEBA;

public class PRUEBA<E> {
    private Object[] data;
    private int head;
    private int tail;
    private int count;
    private boolean Empty;

    public PRUEBA(int capacity) {
        data = new Object[capacity];
        head = 0;
        tail = 0;
        count = 0;
        Empty = true;
    }

    public void enqueue(E item) {
        if (count == data.length) {
            throw new IllegalStateException("Queue is full.");
        }

        data[tail] = item;
        tail = Next(tail);
        count++;
        Empty = false;
    }

    public E dequeue() {
        if (Empty) {
            throw new IllegalStateException("Queue is empty.");
        }

        E obj = (E) data[head];
        head = Next(head);
        count--;

        if (count == 0) {
            Empty = true;
        }

        return obj;
    }

    private int Next(int index) {
        return (index + 1) % data.length;
    }
}
