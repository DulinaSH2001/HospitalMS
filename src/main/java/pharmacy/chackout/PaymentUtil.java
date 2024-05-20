package pharmacy.chackout;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pharmacy.DB.DBConnection;

public class PaymentUtil {
	 public static double calculateTotalCartPrice() {
		 double total=0.0;   
		 try {
	        	 
	        	    ResultSet rs = null;
	        	    

	        	    try {
	        	    	Connection conn = DBConnection.getconnection();
	        	    	Statement stmt = conn.createStatement();
	        	        String query = "SELECT sum(price) FROM cart";
	        	       rs = stmt.executeQuery(query);

	        	        if(rs.next()) {
	        	            total = rs.getDouble(1);
	        	            
	        	        }
	        	    } catch (SQLException e) {
	        	        e.printStackTrace();
	        	    }
	        	
	        	
	        	
	        }catch (Exception e) {
	        	
	        	
	        }
	        return total; // Replace with your logic
	    }

	    public static int createPayment(double totalPrice) {
	        try (Connection conn = DBConnection.getconnection();
	             PreparedStatement stmt = conn.prepareStatement("INSERT INTO phamacypayment (date, price) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
	            stmt.setTimestamp(1, new java.sql.Timestamp(new Date(0).getTime()));
	            stmt.setDouble(2, totalPrice);
	            stmt.executeUpdate();

	            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    return generatedKeys.getInt(1);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return -1;
	    }

	    public static void insertPaymentIntoTables(int paymentId, int patientId) {
	        try (Connection conn = DBConnection.getconnection();
	             PreparedStatement stmt1 = conn.prepareStatement("INSERT INTO pateint_has_phamacypayment (patient_patientId,phamacyPayment_phamacyPaymentID) VALUES (?, ?)");
	             PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO phamacypayment_has_medicine (phamacyPayment_phamacyPaymentID, medicine_medicineid, qty) SELECT ?, medicineid, qty FROM cart")) {
	        	stmt1.setInt(1, patientId);
	            stmt1.setInt(2, paymentId);
	            

	            stmt1.executeUpdate();

	            stmt2.setInt(1, paymentId);
	            stmt2.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void clearCart() {
	        try (Connection conn = DBConnection.getconnection();
	             PreparedStatement stmt = conn.prepareStatement("DELETE FROM cart")) {
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		public static int getPatientId() {
			int pid = 0;  
			 try {
		        	 
		        	    ResultSet rs = null;
		        	    

		        	    try {
		        	    	Connection conn = DBConnection.getconnection();
		        	    	Statement stmt = conn.createStatement();
		        	        String query = "SELECT TOP 1 patientid FROM cart where cid >0";
		        	       rs = stmt.executeQuery(query);

		        	        if(rs.next()) {
		        	            pid = rs.getInt(1);
		        	            
		        	        }
		        	    } catch (SQLException e) {
		        	        e.printStackTrace();
		        	    }
		        	
		        	
		        	
		        }catch (Exception e) {
		        	
		        	
		        }
		        return pid; // Replace with your logic
		    }
		}
	