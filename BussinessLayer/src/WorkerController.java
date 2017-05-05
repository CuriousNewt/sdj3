
public class WorkerController implements IWorkerController{
	
	
	private IConveyorQueue<Box> queue;
	private String tag;
	
	
	public WorkerController(IConveyorQueue<Box> queue, String tag){
		this.queue = queue;
		this.tag = tag;
	}


	@Override
	public synchronized void putOnBelt(Box element) {
		if(this.queue.isFull()){
			try {
				System.out.println("Waiting because queue is full.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " put a box on the belt." + "---\nBox: " + element.toString());
		this.queue.enqueue(element);
		notifyAll();
		
	}


	@Override
	public synchronized Box takeFromBelt() {
		if(this.queue.isEmpty()){
			try {
				System.out.println("Waiting because queue is empty.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Box box = this.queue.dequeue();
	    System.out.println(Thread.currentThread().getName() + " grabbed a box from the belt ---\n" + box.toString());
		notifyAll();
		return box;
	}


	public synchronized IConveyorQueue<Box> getQueue() {
		return queue;
	}

	@Override
	public synchronized String getTag() {
		return tag;
	}



	
	
	
	
	
	

	

}
