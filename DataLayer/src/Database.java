import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Database {
	
	
	private String user, password, url;
	private Connection connection;
	private org.postgresql.Driver driver;

	public Database(String url, String user, String password)
			throws ClassNotFoundException, SQLException {
		this.driver = new org.postgresql.Driver();
		DriverManager.registerDriver(this.driver);
		this.url = url;
		this.user = user;
		this.password = password;
		this.connection = null;
	}

	private void openConnection() throws SQLException {
		this.connection = DriverManager.getConnection(this.url, this.user,
				this.password);
	}


	private void closeConnection() throws SQLException {
		this.connection.close();
	}


	public ArrayList<Object[]> query(String sql, Object... statements)
			throws SQLException {
		openConnection();
		PreparedStatement statement = null;
		ArrayList<Object[]> list = null;
		ResultSet resultSet = null;
		if ((sql != null) && (statement == null)) {
			statement = this.connection.prepareStatement(sql);
			if (statements != null) {
				for (int i = 0; i < statements.length; i++) {
					statement.setObject(i + 1, statements[i]);
				}
			}
		}
		resultSet = statement.executeQuery();
		list = new ArrayList<>();
		while (resultSet.next()) {
			Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
			for (int i = 0; i < row.length; i++) {
				row[i] = resultSet.getObject(i + 1);
			}
			list.add(row);
		}
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		closeConnection();
		return list;
	}


	public int update(String sql, Object... statements)
			throws SQLException {
		openConnection();
		PreparedStatement statement = this.connection.prepareStatement(sql);
		if (statements != null) {
			for (int i = 0; i < statements.length; i++) {
				statement.setObject(i + 1, statements[i]);
			}
		}
		int result = statement.executeUpdate();

		closeConnection();
		return result;
	}

}
