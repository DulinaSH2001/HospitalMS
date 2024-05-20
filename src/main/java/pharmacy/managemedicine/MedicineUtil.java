package pharmacy.managemedicine;

import java.util.ArrayList;

import pharmacy.DB.DBConnection;

import java.util.List;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class MedicineUtil {
	 


    // ...

    public static void addMedicine(medicine medicine) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnection.getconnection();
            String query = "INSERT INTO medicine (name, brand, code, qty, price) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, medicine.getName());
            stmt.setString(2, medicine.getBrand());
            stmt.setString(3, medicine.getCode());
            stmt.setInt(4, medicine.getQuantity());
            stmt.setDouble(5, medicine.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public static void updateMedicine(medicine medicine) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnection.getconnection();
            String query = "UPDATE medicine SET name=?, brand=?, qty=?, price=? WHERE medicineid=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, medicine.getName());
            stmt.setString(2, medicine.getBrand());
            stmt.setInt(3, medicine.getQuantity());
            stmt.setDouble(4, medicine.getPrice());
            stmt.setInt(5, medicine.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public static void deleteMedicine(int medicineId) {
    	 Connection conn = null;
         PreparedStatement stmt = null;
        try {
            conn = DBConnection.getconnection();
            String query = "DELETE FROM medicine WHERE medicineid='"+medicineId+"'";
            stmt = conn.prepareStatement(query);
         
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public static List<medicine> searchMedicineByCode(String code) {
        List<medicine> medicineList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getconnection();
            String query = "SELECT * FROM medicine WHERE code=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, code);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                medicine medicine = new medicine(id, name, brand, code, quantity, price);
                medicineList.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
           

        return medicineList;
    }
    public static medicine getMedicineById(int medicineId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        medicine medicine = null;

        try {
            conn = DBConnection.getconnection();
            String query = "SELECT * FROM medicine WHERE medicineid = '"+medicineId+"'";
            stmt = conn.prepareStatement(query);
           
            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String brand = rs.getString(3);
                String code = rs.getString(4);
                int quantity = rs.getInt(5);
                double price = rs.getDouble(6);

                medicine = new medicine(id, name, brand, code, quantity, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close database resources (Connection, PreparedStatement, ResultSet)
            // Handle exceptions and close resources in a try-catch-finally block
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return medicine;
    }
    public static List<medicine> medicodeSearch(String searchInput) {
        List<medicine> searchResults = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getconnection(); // Replace with your DB connection method
            String query = "SELECT * FROM medicine WHERE code LIKE ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + searchInput + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("medicineid");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                String code = rs.getString("code");
                int quantity = rs.getInt("qty");
                double price = rs.getDouble("price");

                medicine medicine = new medicine(id, name, brand, code, quantity, price);
                searchResults.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResults;
    }
    
}
