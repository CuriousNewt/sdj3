
import java.io.Serializable;

public class ConveyorQueue<T> implements QueueADT<T>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int front;
	private int count;
	private T[] queue;

	public ConveyorQueue(int capacity) {
		this.front = 0;
		this.count = 0;
		this.queue = (T[]) new Object[capacity];
	}

	public ConveyorQueue() {
		this.front = 0;
		this.count = 0;
		this.queue = (T[]) new Object[10];
	}

	public void enqueue(T element) throws IllegalStateException, IllegalArgumentException {
		if (this.count == this.queue.length)
			throw new IllegalStateException("The queue is full");
		if (element == null)
			throw new IllegalArgumentException("Null elements are not allowed in the queue");
		int rear = (front + count) % queue.length;
		queue[rear] = element;
		count++;
	}

	public T dequeue() throws IllegalStateException {
		if (this.count == 0)
			throw new IllegalStateException("The queue is empty");
		T temp = this.queue[this.front];
		this.queue[this.front] = null;
		this.count--;

		if (this.front == this.queue.length - 1) {
			this.front = 0;
		} else {
			this.front++;
		}
		return temp;
	}

	public T first() throws IllegalStateException {
		if (this.count == 0)
			throw new IllegalStateException("The queue is empty");
		return this.queue[this.front];
	}

	public int indexOf(T element) {
		for (int i = this.front; i < this.count; i++) {
			if (this.queue[i].equals(element))
				return i;
		}
		return -1;
	}

	public boolean isEmpty() {
		return this.count == 0;
	}

	public int size() {
		return this.count;
	}

	public String toString() {
		String s = "{";
		for (int i = 0; i < this.size(); i++) {
			s += this.queue[i];
			if (i != this.size() - 1)
				s += ", ";
		}
		s += "}";
		return s;
	}
}
