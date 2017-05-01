import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IRmiClient extends Remote {
	//public Box createBox(String itemType, String itemName) throws RemoteException;
	public Box sendOrderToWarehouse() throws RemoteException;
	public void succesfulDelivery(Box box) throws RemoteException;
	public Box requestOrderFromWarehouse(Box box) throws RemoteException;
	public Box acceptOrderFromServer(Box box) throws RemoteException;
}
