public class QueueTest {

	public static void main(String[] args) {
		IConveyorQueue<Integer> q = new ConveyorQueue<>();

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		q.dequeue();
		System.out.println("After first dequeue: " + q.size());
		System.out.println();
		
	
		q.print();
		
		q.dequeue();
		System.out.println("\nAfter second dequeue: " +q.size());
		q.print();
		//System.out.println(q.first());
		
		q.dequeue();
		System.out.println("\nAfter third dequeue: " +q.size());
		q.print();
		//System.out.println(q.first());
		q.enqueue(9);
		System.out.println("\nAfter enquing 9: " +q.size());
	
		q.dequeue();
		System.out.println("\nAfter fourth dequeue: " +q.size());
		q.print();
		//System.out.println(q.first());
		q.dequeue();
		System.out.println("\nAfter fifth dequeue: " +q.size());
		
		q.print();
		//System.out.println(q.first());
	}

}
