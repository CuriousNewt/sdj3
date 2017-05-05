import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Crane extends UnicastRemoteObject implements IRmiClient,Runnable{
 
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private IRmiServer databaseAdapter;
	private IConveyorQueue<Box> queue;
	private ICraneController controller;
	private Thread thread;

	protected Crane(IConveyorQueue<Box> queue) throws RemoteException {
		super();
		try {
			//UnicastRemoteObject.exportObject(this,0);
			databaseAdapter = (IRmiServer) Naming.lookup("rmi://localhost:1099/RMI");
			databaseAdapter.registerClient(this);
			this.queue = queue;
			this.controller = new CraneController(this.queue);
			this.thread = new Thread(this,"Crane");
			this.thread.start();
		
		} catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	/*private Box createBox(String itemName, String itemType)
			throws RemoteException {

		return new Box(itemName, itemType);
	}
*/
	//actual method that sends a box to server side and the server stores into database
	@Override
	public Box sendOrderToWarehouse(Box box) throws RemoteException {
		
		databaseAdapter.handleClientRequestAndSaveIntoDatabase(box);
		return box;
	}
	
	public static void main(String[] args) {
		try {
			IRmiClient crane = new Crane(new ConveyorQueue<Box>());
			//crane.sendOrderToWarehouse();
			
			Box wantedBox = crane.requestOrderFromWarehouse(new Box("Sausages", "Meat"));
			System.out.println(wantedBox);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	// this method tests whether callback works 
	@Override
	public void succesfulDelivery(Box box) throws RemoteException {
		System.out.println("The order has been succesfully delivered and stored into the warehouse.");
	}


	//this methods accepts a box from the server side
	@Override
	public Box requestOrderFromWarehouse(Box box) throws RemoteException {
		this.databaseAdapter.handleClientRequestAndSendBackABox(box);
		//queue.enqueue(box);
		return box;
	}

	//callback method that returns a box from the server
	@Override
	public Box acceptOrderFromServer(Box box) throws RemoteException {
		return box;
	}



	@Override
	public void run() {
	System.out.println("IT WORKS");
		while(true){
			if(this.queue.first().arrivingBox){
				try {
					this.sendOrderToWarehouse(this.controller.getBoxFromBelt());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				//client request
			}
		}
		
	}

	
	
}
