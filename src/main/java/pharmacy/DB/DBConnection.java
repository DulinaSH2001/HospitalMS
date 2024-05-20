package pharmacy.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/hospital";
	private static String user = "root";
	private static String pass = "dulina2001";
	private static Connection con;
	
	public static Connection getconnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(url, user, pass);
			
		}
		catch (Exception e) {
			System.out.println("database connection is poor");
			e.printStackTrace();
			
			
		}
		return con;
	}



}
