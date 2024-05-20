package pharmacy.addPatient;

import pharmacy.DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class PatientUtil {
	public static List<Patient> searchPatientsByNIC(String nicNumber) {
		List<Patient> patients = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getconnection(); // Replace with your DB connection method

			String query = "SELECT * FROM patient where nic = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, nicNumber);

			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("patientId");
				String name = rs.getString("name");
				String nic = rs.getString("nic");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
				int status = rs.getInt("status");
			

				patients.add(new Patient(id, name, nic, email, phone,  status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patients;
	}

	

	public static boolean isDuplicateNIC(String nic) {
		System.out.println(nic);
		try (Connection conn = DBConnection.getconnection();
				PreparedStatement stmt = conn
						.prepareStatement("SELECT COUNT(*) FROM patient WHERE nic = ? and status = 2")) {
			stmt.setString(1, nic);
			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count>1; // Returns true if a record with this NIC exists
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // Default to false if there's an error
	}

	public static boolean addPatient(Patient patient) {
		
		int status =2;
		try (Connection conn = DBConnection.getconnection();
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO patient (name, nic, email, phone,status) VALUES (?, ?, ?, ?, ?)")) {
			stmt.setString(1, patient.getName());
			stmt.setString(2, patient.getNic());
			stmt.setString(3, patient.getEmail());
			stmt.setString(4, patient.getPhone());
			stmt.setInt(5, status);
			

			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
