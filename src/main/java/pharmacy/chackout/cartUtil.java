package pharmacy.chackout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pharmacy.DB.DBConnection;

public class cartUtil {
	
	
	 public static void addCart(cart cart) {
		    Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	            conn = DBConnection.getconnection();
	            String query = "INSERT INTO cart (patientid,medicineid,name, qty, price) VALUES (?, ?, ?, ?, ?)";
	            stmt = conn.prepareStatement(query);
	            stmt.setInt(1, cart.getPatientId());
	            stmt.setInt(2, cart.getMadicineId());
	            stmt.setString(3, cart.getMediname());
	            stmt.setInt(4, cart.getQty());
	            stmt.setDouble(5, cart.getTotalprice());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	    }
	  public static void deleteMedicine(int cartid) {
	    	 Connection conn = null;
	         PreparedStatement stmt = null;
	        try {
	            conn = DBConnection.getconnection();
	            String query = "DELETE FROM cart WHERE cartid='"+cartid+"'";
	            stmt = conn.prepareStatement(query);
	         
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	    }
	  


}


