package persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class JDBCUtil {

	private static Connection con;
	
	public static Connection getConnection() throws Exception {
		if (con == null || con.isClosed()){
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection("jdc:mysql://localhost:3306/unibh","unibh","1234");
				}
		return con;
		
	}
	
	
	
	public static void main (String [] args) throws SQLException{
		if (con != null && con.isClosed()){
			con.close();
		}
	}
}
