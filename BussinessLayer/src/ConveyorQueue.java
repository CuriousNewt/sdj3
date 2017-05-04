import java.io.Serializable;

public class ConveyorQueue<T> implements IConveyorQueue<T>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private int front;
	private int count;
	private T[] queue;

	@SuppressWarnings("unchecked")
	public ConveyorQueue(int capacity) {
		this.front = 0;
		this.count = 0;
		this.queue = (T[]) new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	public ConveyorQueue() {
		this.front = 0;
		this.count = 0;
		this.queue = (T[]) new Object[10];
	}

	public void enqueue(T element) throws IllegalStateException,
			IllegalArgumentException {
		if (this.count == this.queue.length){
			throw new IllegalStateException("The queue is full");
		}
		if (element == null){
			throw new IllegalArgumentException(
					"Null elements are not allowed in the queue");
		}
		int rear = (front + count) % queue.length;
		queue[rear] = element;
		count++;
	}

	public T dequeue() throws IllegalStateException {
		if (this.count == 0){
			throw new IllegalStateException("The queue is empty");
		}
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
		if (this.count == 0){
			throw new IllegalStateException("The queue is empty");
		}
		return this.queue[this.front];
	}

	public int indexOf(T element) {
		for (int i = this.front; i < this.count; i++) {
			if (this.queue[i].equals(element)){
				return i;
			}
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
		for (int i = findFirstElement(); i < this.queue.length; i++) {
			if (this.queue[i] != null) {
				s += this.queue[i];
				if (i != findLastElement()) {
					s += ", ";
				}
			}
		}
		s += "}";
		return s;
	}
	
	private int findFirstElement(){
		for(int i = 0; i < this.queue.length; i++){ 
			if(this.queue[i] != null){
				return i;
			}
		}
		return -1;
	}
	
	private int findLastElement(){
		for (int i = this.queue.length-1; i >=  findFirstElement(); i--) {
			if(this.queue[i] != null){
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public boolean isFull() {
	
		return this.count >= this.queue.length;
	}
}
