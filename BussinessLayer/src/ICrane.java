import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ICrane extends Remote{

	public String sayHello(String msg) throws RemoteException;
	
}
