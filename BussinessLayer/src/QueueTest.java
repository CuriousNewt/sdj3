
public class QueueTest {
	
	public static void main(String[] args) {
		IConveyorQueue<String> q = new ConveyorQueue<>();
		
		q.enqueue("pica");
		q.enqueue("kunda");
		q.enqueue("wtf");
		q.enqueue("suck my dick");
		q.enqueue("trolol");
		
		System.out.println(q.toString());
		String returned = q.dequeue();
		System.out.println("Returned: " + returned + "\n" + q.toString());
		System.out.println(q.size());
		q.enqueue("pica");
		System.out.println(q.toString());
		System.out.println(q.size());
		System.out.println("First is: " + q.first());
	}

}
