import java.rmi.RemoteException;


public class FinalModelTest {
	
	static IConveyorQueue<Box> queue = new ConveyorQueue<>();

	public static void main(String[] args) {
		try {
			queue.enqueue(new Box("1","1"));
			queue.enqueue(new Box("2","2"));
			queue.enqueue(new Box("3","3"));
			queue.enqueue(new Box("4","4"));
			queue.enqueue(new Box("5","5"));
			IRmiClient crane = new Crane(queue);
			
			crane.sendOrderToWarehouse(new Box("first","first"));
			
			/*Box wantedBox = crane.requestOrderFromWarehouse(new Box("Sausages", "Meat"));
			System.out.println(wantedBox);*/
			
		
		
		
		
		
		
		
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
