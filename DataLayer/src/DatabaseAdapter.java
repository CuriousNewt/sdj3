import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatabaseAdapter extends UnicastRemoteObject implements IDatabaseAdapter,IRmiServer{
	

	private static final long serialVersionUID = 1L;
	private Database db;
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "dendo1643";
	private IRmiClient crane;
	
	
	public DatabaseAdapter() throws RemoteException {
		try {
			this.db = new Database(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}


	@Override
	public void storeBox(Box box) {
		
		String sql = "INSERT INTO public.warehouse(itemName,itemType)" + "VALUES(?,?);";
		
		try {
			db.update(sql, box.getItemName(),box.getItemType());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void removeBox(Box box) {
		
		String sql = "DELETE FROM public.warehouse WHERE itemName = ?;";
		try {
			db.update(sql, box.getItemName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void viewAllBoxes(String itemName) {
		
		String sql = "SELECT * FROM public.warehouse WHERE itemName = ?;";
		ArrayList<Object[]> results;
		try {
			results = db.query(sql, itemName);
			
			for(int i = 0; i < results.size(); i++){
				Object[] row = results.get(i);
				System.out.println("Box's name: " + row[0] + "/Box's type: " + row[1]);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void remoteStoreBox(Box box) throws RemoteException {
		this.storeBox(box);
	}


	@Override
	public void remoteRemoveBox(Box box) throws RemoteException {
		this.removeBox(box);
		
	}


	@Override
	public void remoteViewAllBoxes(String itemName) throws RemoteException {
		this.viewAllBoxes(itemName);
		
	}


	@Override
	public void registerClient(IRmiClient client) throws RemoteException {
		this.crane = client;
	}

	
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			IRmiServer server = new DatabaseAdapter();
			Naming.rebind("RMI", server);
			System.out.println("Starting server...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	/*	try {
			IRmiServer s = new DatabaseAdapter();
			Box box = new Box("Sausages","Meat");
			Box box2 = s.findBox(box);
			System.out.println(box2 + "Je to spravne.");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	//called on clients side, stores the sent object to database
	@Override
	public Box handleClientRequestAndSaveIntoDatabase(Box box) throws RemoteException {
		System.out.println("Here.");
		crane.succesfulDelivery(box);
		this.remoteStoreBox(box);
		return box;
	}


	@Override
	public Box findBox(Box box) throws RemoteException {
		
		String sql = "SELECT * FROM public.warehouse WHERE itemName = ? AND itemType = ?;";
		ArrayList<Object[]> results;
		try {
			results = db.query(sql, box.getItemName(),box.getItemType());
			
			for(int i = 0; i < results.size();){
				Object[] row = results.get(i);
				Box boxToReturn = new Box(row[0].toString(),row[1].toString());
				return boxToReturn;
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//the box doesn't exist
		return null;
	}


	@Override
	public Box handleClientRequestAndSendBackABox(Box box) throws RemoteException {
		Box toSendBack = this.findBox(box);
		this.crane.acceptOrderFromServer(toSendBack);
		return toSendBack;
	}

	
	
	//other methods that specifically return desired items
	
}
