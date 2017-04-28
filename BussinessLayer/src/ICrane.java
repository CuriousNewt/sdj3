import java.rmi.Remote;


public interface ICrane extends Remote{

	public void sayHello(String msg);
	
}
