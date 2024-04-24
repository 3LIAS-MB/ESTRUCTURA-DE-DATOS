 public class CircularQueue<T> {
	
    private Object[] array;
    private int capacity;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        capacity = size;
        array = new Object[capacity];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (isFull()) {
            return capacity;
        }
        if (rear > front) {
            return rear - front + 1;
        }
        return (capacity - front) + (rear + 1);
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        T item = (T) array[front];
        array[front] = null; // Clear the reference to the dequeued item
        if (front == rear) {
            // Reset the queue when the last item is dequeued
            front = 0;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return (T) array[front];
    }
}
