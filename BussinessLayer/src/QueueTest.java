public class QueueTest {

	public static void main(String[] args) {
		IConveyorQueue<Integer> q = new ConveyorQueue<>();

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);

		q.print();
		int returned = q.dequeue();
		System.out.println();
		System.out.println();

		q.print();
		
		System.out.println();
		
		q.dequeue();
		q.print();
		System.out.println(q.first());
		q.dequeue();
		q.print();
		System.out.println(q.first());
		q.dequeue();
		q.print();
		System.out.println(q.first());
		q.dequeue();
		q.print();
		System.out.println(q.first());
	}

}
