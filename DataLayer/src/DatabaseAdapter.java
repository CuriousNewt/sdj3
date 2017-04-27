import java.sql.SQLException;
import java.util.ArrayList;


public class DatabaseAdapter implements IDatabaseAdapter{
	
	
	private Database db;
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "dendo1643";
	
	
	public DatabaseAdapter() {
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
	
	
	
	//other methods that specifically return desired items
	
}
