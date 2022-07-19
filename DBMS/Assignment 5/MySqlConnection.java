package jdbc;
import java.sql.*;


public class MySqlConnection {

	private Connection conn;
	private Statement stm;

	/*
	 * This is a component class. This class provides connection from the
	 * database i.e MySQL.
	 */
	public MySqlConnection(String dbname, String root, String pass) {

		try {
			String url = "jdbc:mysql://localhost:3306/" + dbname;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, root, pass);

			stm = conn.createStatement();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method returns Connection class object.
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return conn;
	}

	/*
	 * This method return Statement class object.
	 * 
	 * @return
	 */
	public Statement getStatement() {
		return stm;
	}

}
