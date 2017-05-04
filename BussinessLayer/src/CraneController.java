


public  class CraneController implements ICraneController{
	
	private IConveyorQueue<Box> queue;
	
	public CraneController(IConveyorQueue<Box> queue){
		this.queue = queue;
	}

	@Override
	public synchronized Box getBoxFromBelt() {
		if(this.queue.isEmpty()){
			try {
				System.out.println("Waiting because queue is empty.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " grabbed a box from the belt.");
		notifyAll();
		return this.queue.dequeue();
		
	}

	@Override
	public synchronized void putABoxOnBelt(Box element) {
		if(this.queue.isFull()){
			try {
				System.out.println("Waiting because queue is full.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " put a box on the belt." + "--- Box: " + element.toString());
		this.queue.enqueue(element);
		notifyAll();
		
	}
	
	


}
