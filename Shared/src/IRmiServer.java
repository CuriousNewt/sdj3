import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IRmiServer extends Remote{
	public void remoteStoreBox(Box box) throws RemoteException;
	public void remoteRemoveBox(Box box) throws RemoteException;
	public void remoteViewAllBoxes(String itemName) throws RemoteException;
	public void registerClient(IRmiClient client) throws RemoteException;
	public Box handleClientRequestAndSaveIntoDatabase(Box box) throws RemoteException;
	public Box findBox(Box box) throws RemoteException;
	public Box handleClientRequestAndSendBackABox(Box box) throws RemoteException;
}
