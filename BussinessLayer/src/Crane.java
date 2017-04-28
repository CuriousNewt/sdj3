import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Crane extends UnicastRemoteObject implements ICrane{
 
	private static final long serialVersionUID = 1L;

	protected Crane() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello(String msg) throws RemoteException{
		return "From server: " + msg;
		
	}
	

}