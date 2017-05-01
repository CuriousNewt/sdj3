import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Crane extends UnicastRemoteObject implements IRmiClient{
 
	private static final long serialVersionUID = 1L;
	private IRmiServer databaseAdapter;

	protected Crane() throws RemoteException {
		super();
		try {
			databaseAdapter = (IRmiServer) Naming.lookup("rmi://localhost:1099/RMI");
			databaseAdapter.registerClient(this);
		} catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private Box createBox(String itemName, String itemType)
			throws RemoteException {

		return new Box(itemName, itemType);
	}

	//actual method that sends a box to server side and the server stores into database
	@Override
	public Box sendOrderToWarehouse() throws RemoteException {
		Box box = createBox("Sausages", "Meat");
		databaseAdapter.handleClientRequestAndSaveIntoDatabase(box);
		return box;
	}
	
	public static void main(String[] args) {
		try {
			IRmiClient crane = new Crane();
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
		return box;
	}

	//callback method that returns a box from the server
	@Override
	public Box acceptOrderFromServer(Box box) throws RemoteException {
		return box;
	}

	
	
}
